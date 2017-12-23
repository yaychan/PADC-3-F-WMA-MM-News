package xyz.winmyataung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.delegates.NewsActionDelegates;

/**
 * Created by DELL on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegates mNewsActionDelegates;
    public ItemNewsViewHolder(View itemView,NewsActionDelegates newsActionDelegates) {

        super(itemView);

        ButterKnife.bind(this,itemView);  //viewholder mhar bind yin second parameter is itemView

        mNewsActionDelegates= newsActionDelegates ;
    }
    @OnClick(R.id.cv_news_item)                  //user tap loat mae component yae id
    public void onNewsItemTap(View view){         // View obj as parameter
      /*  Toast.makeText(view.getContext(), "News item clicked",Toast.LENGTH_LONG).show();*/
      mNewsActionDelegates.onTapNewsItem();
    }
}
