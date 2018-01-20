package xyz.winmyataung.news.delegates;

import xyz.winmyataung.news.data.vo.NewsVO;

/**
 * Created by DELL on 12/17/2017.
 */

public interface NewsActionDelegates {

    void onTapNewsItem(NewsVO tappedNews);
    void onTapCommentButton();
    void onTapSendToButton();
    void onTapFavouriteButton();
}
