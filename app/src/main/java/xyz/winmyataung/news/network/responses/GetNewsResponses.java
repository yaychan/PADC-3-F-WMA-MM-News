package xyz.winmyataung.news.network.responses;

import java.util.List;

import xyz.winmyataung.news.data.vo.NewsVO;

/**
 * Created by DELL on 1/3/2018.
 */

public class GetNewsResponses {
    private int code;
    private String mesage;
    private String apiVersion;
    private String page;
    private List<NewsVO> mmNews;

    public int getCode() {
        return code;
    }

    public String getMesage() {
        return mesage;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getMmNews() {
        return mmNews;
    }
}
