package xyz.winmyataung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.data.vo.NewsVO;
import xyz.winmyataung.news.delegates.NewsActionDelegates;

/**
 * Created by DELL on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;


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

    public void setNews(NewsVO news){
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBrief.setText(news.getBrief());
        /**
         * image bind with glide
         * Glide.with(context object)
         * .load(url of image)
         * into(which ImageView);
         */
        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);

        if(news.getImages() != null) {
            ivNews.setVisibility(View.VISIBLE);
            Glide.with(ivNews.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNews);
        }else {
            ivNews.setVisibility(View.GONE);
        }
    }
}
