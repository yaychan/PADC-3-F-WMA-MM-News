package xyz.winmyataung.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.adapters.ImagesInNewsDetailsAdapter;

/**
 * Created by DELL on 12/9/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager news_details_images;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        ButterKnife.bind(this,this);
       /* setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);*/

       mImagesInNewsDetailsAdapter =new ImagesInNewsDetailsAdapter();
      /* bind*/
       news_details_images.setAdapter(mImagesInNewsDetailsAdapter);
    }
}
