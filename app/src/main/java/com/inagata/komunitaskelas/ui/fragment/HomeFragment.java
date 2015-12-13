package com.inagata.komunitaskelas.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.controller.ListClassController;
import com.inagata.komunitaskelas.data.ConstanClass;
import com.inagata.komunitaskelas.data.model.SchoolClass;
import com.inagata.komunitaskelas.ui.activity.CreateClassActivity;
import com.inagata.komunitaskelas.ui.activity.ThreadActivity;
import com.inagata.komunitaskelas.ui.adapter.ClassListAdapter;
import com.trello.rxlifecycle.FragmentEvent;

import java.util.List;

import butterknife.Bind;
import id.zelory.benih.fragment.BenihFragment;
import id.zelory.benih.util.BenihBus;
import id.zelory.benih.view.BenihRecyclerListener;
import id.zelory.benih.view.BenihRecyclerView;
import timber.log.Timber;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class HomeFragment extends BenihFragment implements ListClassController.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.rc_listkelas)
    BenihRecyclerView rcListkelas;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ListClassController listClassController;
    private ClassListAdapter classListAdapter;

    @Override
    protected int getFragmentView() {
        return R.layout.kom_fragment_home;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        BenihBus.pluck()
                .receive()
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(o -> Timber.d(o.toString()), throwable -> Timber.d(throwable.getMessage()));
        setUpSwipeLayout();
        setUpAdapter();
        setUpRecyclerView();
        setUpController(savedInstanceState);
        fab.setOnClickListener(view -> addNewClass());
    }

    protected void setUpSwipeLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.accent);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void setUpController(Bundle bundle) {
        if (listClassController == null) {
            listClassController = new ListClassController(this);
        }

        if (bundle != null) {
            listClassController.loadState(bundle);
        } else {
            listClassController.loadDataListClass();
        }
    }

    public void setUpAdapter() {
        classListAdapter = new ClassListAdapter(getContext());
        classListAdapter.setOnItemClickListener((view, position) -> {
            String className = classListAdapter.getData().get(position).getClass_name() + " " + classListAdapter.getData().get(position).getClass_subject();

            Intent intent = new Intent(getContext(), ThreadActivity.class);
            intent.putExtra("pos", position);
            intent.putExtra(ConstanClass.GET_NAME_TITTLE_THREAD, className);
            startActivity(intent);
        });
    }

    private void setUpRecyclerView() {
        rcListkelas.clearOnScrollListeners();
        rcListkelas.setUpAsList();
        rcListkelas.addOnScrollListener(new BenihRecyclerListener((LinearLayoutManager) rcListkelas.getLayoutManager()) {
            @Override
            public void onLoadMore(int i) {
                //TODO paging
            }
        });
        rcListkelas.setAdapter(classListAdapter);
    }

    public void addNewClass(){
        Intent intent = new Intent(getActivity(), CreateClassActivity.class);
        startActivity(intent);
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
    public void getListClass(List<SchoolClass> schoolClassList) {
        classListAdapter.add(schoolClassList);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void onRefresh() {
        classListAdapter.clear();
        setUpRecyclerView();
        listClassController.loadDataListClass();
    }
}
