package xyz.winmyataung.news.data.model;

import android.support.v4.view.NestedScrollingChild;

import xyz.winmyataung.news.network.HttpUrlConnectionDataAgent;
import xyz.winmyataung.news.network.NewsDataAgent;

/**
 * Created by DELL on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;                    // s = static

    private NewsDataAgent mDataAgent;

    private NewsModel(){

        mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();

    }
    public static NewsModel getObjInstance(){
        if(sObjInstance==null){                              //factory logic
            sObjInstance=new NewsModel();
        }
        return sObjInstance;
    }
   /*
   load news from network api
   */
    public void loadNews(){
        mDataAgent.loadNews();

    }
}
