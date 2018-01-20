package xyz.winmyataung.news.fragments;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winmyataung.news.MMNewsApp;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.adapters.NewsAdapter;
import xyz.winmyataung.news.data.model.NewsModel;
import xyz.winmyataung.news.data.vo.NewsVO;
import xyz.winmyataung.news.delegates.NewsActionDelegates;
import xyz.winmyataung.news.events.LoadedNewsEvent;

/**
 * Created by DELL on 1/7/2018.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegates {


    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    private NewsAdapter mNewsByCategoryAdapter;

    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * attach loat pho inflate loat ya tal.
         * 1st layout file id
         * 2nd para = inflate lote loz htwat lar mae View Object yae parent a nay nae thet mhat
         * 3rd para = auto attach loat ma lote
         * Inflate loat yin View Object htwat tal.
         */
        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);

        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvNewsByCategory.setLayoutManager(linearLayoutManager);

        mNewsByCategoryAdapter = new NewsAdapter(this);
        rvNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        NewsModel.getObjInstance().loadNews();
        return view;


    }

    @Override
    public void onTapNewsItem(NewsVO tappedItem) {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded : " + event.getNewsList());
        mNewsByCategoryAdapter.setNews(event.getNewsList());
    }
}