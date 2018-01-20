package xyz.winmyataung.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.news.MMNewsApp;
import xyz.winmyataung.news.R;
import xyz.winmyataung.news.adapters.NewsAdapter;
import xyz.winmyataung.news.data.model.NewsModel;
import xyz.winmyataung.news.data.vo.NewsVO;
import xyz.winmyataung.news.delegates.NewsActionDelegates;
import xyz.winmyataung.news.events.LoadedNewsEvent;

public class MainActivity extends AppCompatActivity implements NewsActionDelegates {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.menu_item_all_news);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mNewsAdapter = new NewsAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(mNewsAdapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.menu_news_by_category){

                    /**
                     * launch newsByCategory
                     */
                    Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                    startActivity(intent);

                    /**
                     * close left menu after back button is pressed.
                     */
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

        NewsModel.getObjInstance().loadNews();             //call method from singleton pattern model
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTabFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapNewsItem(NewsVO tappedNews) {
        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class); //paramenter = context object , communicate loat chin tae activity yae class type.
        /**
         * pass to details screen for tapped news. pass with key value pair
         */
        intent.putExtra("news_id", tappedNews.getNewsId());
        startActivity(intent);
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

    /**
     * created event object as param
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded : " + event.getNewsList());
        mNewsAdapter.setNews(event.getNewsList());


    }

}
