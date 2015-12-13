package com.inagata.komunitaskelas.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.controller.LoginController;
import com.inagata.komunitaskelas.data.ConstanClass;
import com.inagata.komunitaskelas.data.model.LoginCredential;
import com.trello.rxlifecycle.ActivityEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;
import id.zelory.benih.util.BenihBus;
import timber.log.Timber;

/**
 * Created on : December 07, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class LoginActivity extends BenihActivity implements LoginController.Presenter
{
    @Bind(R.id.button_signin) Button signInButton;
    @Bind(R.id.link_register) TextView signUpButton;

    @Bind(R.id.input_username)
    EditText inputUsername;
    @Bind(R.id.input_password)
    EditText inputPassword;

    private LoginController loginController;
    private ProgressDialog progressDialog;

    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_sign_in;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        BenihBus.pluck()
                .receive()
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(o -> Timber.d(o.toString()), throwable -> Timber.d(throwable.getMessage()));

        signInButton.setOnClickListener(view -> doLogin(savedInstanceState));
        signUpButton.setOnClickListener(view -> doRegister());
        progressDialog = new ProgressDialog(this);
    }

    public boolean checkTextInput() {
        boolean check;
        if (inputUsername.getText().toString().isEmpty() || inputPassword.getText().toString().isEmpty()) {
            showMaterial(getResources().getString(R.string.error), getResources().getString(R.string.error_empty));
            check = false;
        } else {
            if (isValidEmail(inputUsername.getText().toString())) {
                check = true;
            } else {
                check = false;
                showMaterial(getResources().getString(R.string.error), getResources().getString(R.string.error_email));
            }
        }
        return check;
    }

    private boolean isValidEmail(String emailInput) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailInput);
        return matcher.matches();
    }

    private void showMaterial(String header, String message) {
        new MaterialDialog.Builder(this)
                .title(header)
                .content(message)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                    }
                })
                .positiveText(getResources().getString(R.string.ok))
                .show();
    }


    private void setUpController(Bundle bundle, String email, String password) {
        if (loginController == null) {
            loginController = new LoginController(this);
        }

        if (bundle != null) {
            loginController.loadState(bundle);
        } else {
            loginController.doLogin(email, password);
        }
    }

    public void doLogin(Bundle bundle) {
        if (checkTextInput()) {
            setUpController(bundle, inputUsername.getText().toString(), inputPassword.getText().toString());
        }
    }

    public void doRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void savePreferences(LoginCredential credential) {
        SharedPreferences email = getSharedPreferences(ConstanClass.PREFS_NAME_ID, MODE_PRIVATE);
        SharedPreferences idSchool = getSharedPreferences(ConstanClass.PREFS_NAME_SCHOOL, MODE_PRIVATE);
        SharedPreferences apiKey = getSharedPreferences(ConstanClass.PREFS_NAME_API_KEY, MODE_PRIVATE);

        SharedPreferences.Editor editorEmail = email.edit();
        SharedPreferences.Editor editorIdSchool = idSchool.edit();
        SharedPreferences.Editor editorApiKey = apiKey.edit();

        editorEmail.putString(ConstanClass.ID_EMAIL, credential.getEmail());
        editorApiKey.putString(ConstanClass.ID_API, credential.getApiKey());
        editorIdSchool.putString(ConstanClass.ID_SCHOOL, credential.getIdSchool());

        editorEmail.apply();
        editorIdSchool.apply();
        editorApiKey.apply();
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("Tunggu sebentar");
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void getListCredential(LoginCredential credential) {

        if (credential.getMessage().equals("Success")) {
            Timber.d(credential.getApiKey());
            Timber.d(credential.getEmail());
            savePreferences(credential);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Snackbar.make(getWindow().getDecorView(), credential.getMessage(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public void showError(Throwable throwable) {
        Snackbar.make(getWindow().getDecorView(), "Terjadi kesalahan pada server", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
