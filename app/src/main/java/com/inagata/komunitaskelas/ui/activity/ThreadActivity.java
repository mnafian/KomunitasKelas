package com.inagata.komunitaskelas.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.controller.ListThreadController;
import com.inagata.komunitaskelas.data.ConstanClass;
import com.inagata.komunitaskelas.data.model.SubjectClass;
import com.inagata.komunitaskelas.ui.adapter.ThreadListAdapter;
import com.trello.rxlifecycle.ActivityEvent;

import java.util.List;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;
import id.zelory.benih.util.BenihBus;
import id.zelory.benih.view.BenihRecyclerListener;
import id.zelory.benih.view.BenihRecyclerView;
import timber.log.Timber;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ThreadActivity extends BenihActivity implements ListThreadController.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rc_listsubject)
    BenihRecyclerView rcListSubject;

    private ThreadListAdapter threadListAdapter;
    private ListThreadController listThreadController;

    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_thread;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        BenihBus.pluck()
                .receive()
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(o -> Timber.d(o.toString()), throwable -> Timber.d(throwable.getMessage()));

        Bundle dataBundle = getIntent().getExtras();

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(dataBundle.getString(ConstanClass.GET_NAME_TITTLE_THREAD) == null ? ConstanClass.GET_NAME_TITTLE_THREAD : "Kelas");

        setUpSwipeLayout();
        setUpAdapter();
        setUpRecyclerView();
        setUpController(savedInstanceState);
    }

    private void setUpController(Bundle bundle) {
        if (listThreadController == null) {
            listThreadController = new ListThreadController(this);
        }

        if (bundle != null) {
            listThreadController.loadState(bundle);
        } else {
            listThreadController.loadDataListSubject();
        }
    }

    protected void setUpSwipeLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.accent);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public void setUpAdapter() {
        threadListAdapter = new ThreadListAdapter(this);
        threadListAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this, ThreadDetailActivity.class);
            intent.putExtra("pos", position);
            startActivity(intent);
        });
    }

    private void setUpRecyclerView() {
        rcListSubject.clearOnScrollListeners();
        rcListSubject.setUpAsList();
        rcListSubject.addOnScrollListener(new BenihRecyclerListener((LinearLayoutManager) rcListSubject.getLayoutManager()) {
            @Override
            public void onLoadMore(int i) {
                //TODO paging
            }
        });
        rcListSubject.setAdapter(threadListAdapter);
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
    public void onRefresh() {
        threadListAdapter.clear();
        setUpRecyclerView();
        listThreadController.loadDataListSubject();
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
    public void getListSubject(List<SubjectClass> subjectClassList) {
        threadListAdapter.add(subjectClassList);
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
