package xyz.winmyataung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.winmyataung.news.R;
import xyz.winmyataung.news.data.vo.NewsVO;
import xyz.winmyataung.news.delegates.NewsActionDelegates;
import xyz.winmyataung.news.viewholders.ItemNewsViewHolder;

/**
 * Created by DELL on 12/3/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewHolder> {
    private NewsActionDelegates mNewsActionDelegates;
    private List<NewsVO> mNewsList;

    public NewsAdapter(NewsActionDelegates newsActionDelegates) {
        /**
         *
        constructor mhar parameter mhar implemented type ko htae pay
         */
        mNewsActionDelegates = newsActionDelegates;
        mNewsList = new ArrayList<>();
    }

    @Override
    public ItemNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View newsItemView=inflater.inflate(R.layout.item_news,parent,false);
        ItemNewsViewHolder itemNewsViewHolder=new ItemNewsViewHolder(newsItemView,mNewsActionDelegates);
        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewHolder holder, int position) {
        holder.setNews(mNewsList.get(position));

    }

    @Override
    public int getItemCount() {

        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList){
        mNewsList = newsList;
        notifyDataSetChanged();
    }
}
