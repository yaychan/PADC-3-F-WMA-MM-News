package xyz.winmyataung.news.data.model;

import android.support.v4.view.NestedScrollingChild;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import xyz.winmyataung.news.data.vo.NewsVO;
import xyz.winmyataung.news.events.LoadedNewsEvent;
import xyz.winmyataung.news.network.HttpUrlConnectionDataAgent;
import xyz.winmyataung.news.network.NewsDataAgent;
import xyz.winmyataung.news.network.OkHttpDataAgent;
import xyz.winmyataung.news.network.RetrofitDataAgent;

/**
 * Created by DELL on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;                    // s = static

    private NewsDataAgent mDataAgent;

    /**
     * for data repository
     */
    private Map<String,NewsVO> mNews;

    private NewsModel(){

        mDataAgent = RetrofitDataAgent.getObjInstance();

        /**
         * initialize mNews
         */
        mNews = new HashMap<>();

        EventBus.getDefault().register(this);

    }
    public static NewsModel getObjInstance(){
        if(sObjInstance==null){                              //factory logic
            sObjInstance=new NewsModel();
        }
        return sObjInstance;
    }
   /**
   load news from network api
   */
    public void loadNews(){
        mDataAgent.loadNews();

    }

    /**
     * Get news object by ID ( for details screen)
     * @param newsId
     * @return
     */
    public NewsVO getNewsById(String newsId){
        return mNews.get(newsId);
    }

    /**
     * listen event bus
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event){
        for(NewsVO news : event.getNewsList()){
            mNews.put(news.getNewsId(), news);
        }

    }
}
