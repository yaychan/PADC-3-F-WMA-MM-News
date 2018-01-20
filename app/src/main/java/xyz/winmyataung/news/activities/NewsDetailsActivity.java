package xyz.winmyataung.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.adapters.ImagesInNewsDetailsAdapter;
import xyz.winmyataung.news.data.model.NewsModel;
import xyz.winmyataung.news.data.vo.NewsVO;

import static xyz.winmyataung.news.R.id.iv_news_details_image;
import static xyz.winmyataung.news.R.id.vp_news_details_images;

/**
 * Created by DELL on 12/9/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

         /*
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        */

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetailsAdapter);

        /**
         * get tapped id from onTappedNewsItem() from main activity.
         */
        String newsId = getIntent().getStringExtra("news_id");

        NewsVO news = NewsModel.getObjInstance().getNewsById(newsId);

        bindData(news);
    }

    private void bindData(NewsVO news) {
        tvNewsDetails.setText(news.getDetails());
        tvPublicationTitle.setText(news.getPublication().getTitle());

        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);

       /* Glide.with(vpNewsDetailsImages.getContext())
                .load(news.getImages())
                .into(();*/



    }

}
