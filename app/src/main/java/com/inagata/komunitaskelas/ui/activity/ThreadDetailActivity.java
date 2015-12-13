package com.inagata.komunitaskelas.ui.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.controller.ThreadController;
import com.inagata.komunitaskelas.data.model.DetailThread;
import com.inagata.komunitaskelas.ui.adapter.ThreadCommentarAdapter;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;
import id.zelory.benih.view.BenihRecyclerListener;
import id.zelory.benih.view.BenihRecyclerView;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ThreadDetailActivity extends BenihActivity implements ThreadController.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_tittle_thread)
    TextView tittleThread;
    @Bind(R.id.tv_detail_thread)
    TextView detailThread;
    @Bind(R.id.tv_date_activity)
    TextView dateActivity;
    @Bind(R.id.tv_user_full_name)
    TextView userFullName;
    @Bind(R.id.image_profile_thread)
    ImageView imageProfile;
    @Bind(R.id.button_vote)
    Button buttonVote;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.rc_list_comment)
    BenihRecyclerView rcListComment;

    private ThreadCommentarAdapter threadCommentarAdapter;
    private ThreadController threadController;

    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_thread_detail;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.activity_detail_qustion));

        setUpSwipeLayout();
        setUpAdapter();
        setUpRecyclerView();
        setUpController(savedInstanceState);
    }

    private void setUpController(Bundle bundle) {
        if (threadController == null) {
            threadController = new ThreadController(this);
        }

        if (bundle != null) {
            threadController.loadState(bundle);
        } else {
            threadController.loadDetailThread();
        }
    }

    protected void setUpDetail(String tittle, String detail, String date, String fullName, String linkImage, String status, String totalVote) {
        tittleThread.setText(tittle);
        detailThread.setText(detail);
        dateActivity.setText(date);
        userFullName.setText(fullName);
        setImage(linkImage, imageProfile, R.drawable.ic_placeholder);
        buttonVote.setBackground(setButtonVote(status));
        buttonVote.setText(totalVote + " Voted");
    }

    public void setImage(String url, ImageView targetImageView, int resource) {
        Glide.with(this)
                .load(url)
                .asBitmap()
                .placeholder(resource)
                .into(new BitmapImageViewTarget(targetImageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        targetImageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    public Drawable setButtonVote(String status) {
        Drawable resource;
        if (status.equals("true")) {
            resource = getResources().getDrawable(R.drawable.button_border_fill);
            buttonVote.setTextColor(getResources().getColor(R.color.white));
        } else {
            resource = getResources().getDrawable(R.drawable.button_border);
            buttonVote.setTextColor(getResources().getColor(R.color.green_vote));
        }
        return resource;
    }

    protected void setUpSwipeLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.accent);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public void setUpAdapter() {
        threadCommentarAdapter = new ThreadCommentarAdapter(getApplicationContext());
        threadCommentarAdapter.setOnItemClickListener((view, position) -> {
            //TODO klik komentar
        });
    }

    private void setUpRecyclerView() {
        rcListComment.clearOnScrollListeners();
        rcListComment.setUpAsList();
        rcListComment.addOnScrollListener(new BenihRecyclerListener((LinearLayoutManager) rcListComment.getLayoutManager()) {
            @Override
            public void onLoadMore(int i) {
                //TODO paging
            }
        });
        rcListComment.setAdapter(threadCommentarAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_forum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void getDetailThread(DetailThread detailThreads) {
        threadCommentarAdapter.add(detailThreads.getClass_comment());
        setUpDetail(detailThreads.getClass_title()
                , detailThreads.getClass_deskripsi()
                , detailThreads.getClass_timepost()
                , detailThreads.getDetail_fullname()
                , detailThreads.getUser_photos()
                , detailThreads.getStatus_voted()
                , detailThreads.getClass_jmlhvote());
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void onRefresh() {
        threadCommentarAdapter.clear();
        setUpRecyclerView();
        threadController.loadDetailThread();
    }
}
