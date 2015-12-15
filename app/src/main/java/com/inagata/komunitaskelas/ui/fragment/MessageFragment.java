package com.inagata.komunitaskelas.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.controller.ListMessageController;
import com.inagata.komunitaskelas.data.model.PrivateMessage;
import com.inagata.komunitaskelas.ui.adapter.MessageListAdapter;
import com.trello.rxlifecycle.FragmentEvent;

import java.util.List;

import butterknife.Bind;
import id.zelory.benih.fragment.BenihFragment;
import id.zelory.benih.util.BenihBus;
import id.zelory.benih.view.BenihRecyclerListener;
import id.zelory.benih.view.BenihRecyclerView;
import in.co.madhur.chatlib.MainActivity;
import timber.log.Timber;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class MessageFragment extends BenihFragment implements ListMessageController.Presenter, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.rc_list_message)
    BenihRecyclerView rcListMessage;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ListMessageController listMessageController;
    private MessageListAdapter messageListAdapter;

    @Override
    protected int getFragmentView() {
        return R.layout.kom_fragment_message;
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
    }

    private void doDetailMessage() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    protected void setUpSwipeLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.accent);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void setUpController(Bundle bundle) {
        if (listMessageController == null) {
            listMessageController = new ListMessageController(this);
        }

        if (bundle != null) {
            listMessageController.loadState(bundle);
        } else {
            listMessageController.getListMessage();
        }
    }

    public void setUpAdapter() {
        messageListAdapter = new MessageListAdapter(getContext());
        messageListAdapter.setOnItemClickListener((view, position) -> {
            doDetailMessage();
        });
    }

    private void setUpRecyclerView() {
        rcListMessage.clearOnScrollListeners();
        rcListMessage.setUpAsList();
        rcListMessage.addOnScrollListener(new BenihRecyclerListener((LinearLayoutManager) rcListMessage.getLayoutManager()) {
            @Override
            public void onLoadMore(int i) {
                //TODO paging
            }
        });
        rcListMessage.setAdapter(messageListAdapter);
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
    public void getListMessages(List<PrivateMessage> privateMessageList) {
        messageListAdapter.add(privateMessageList);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void onRefresh() {
        messageListAdapter.clear();
        setUpRecyclerView();
        listMessageController.getListMessage();
    }
}
