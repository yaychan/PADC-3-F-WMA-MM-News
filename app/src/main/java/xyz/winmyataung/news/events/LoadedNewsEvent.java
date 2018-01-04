package xyz.winmyataung.news.events;

import java.util.List;

import xyz.winmyataung.news.data.vo.NewsVO;

/**
 * Created by DELL on 1/3/2018.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
