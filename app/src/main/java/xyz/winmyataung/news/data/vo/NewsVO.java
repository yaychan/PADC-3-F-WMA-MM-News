package xyz.winmyataung.news.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DELL on 12/17/2017.
 */

public class NewsVO {
    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    private PublicationVO publication;

    private List<favoriteVO> favorites;

    private List<CommentsVO> comments;

    @SerializedName("sent-tos")
    private List<SentTosVO> sentTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }



    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<String> getImages() {
        return images;
    }

    public List<favoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentsVO> getComments() {
        return comments;
    }

    public List<SentTosVO> getSentTos() {
        return sentTos;
    }
}
