package xyz.winmyataung.news.data.vo;

/**
 * Created by DELL on 12/17/2017.
 */

public class SentTosVO {

    private String sendToId;
    private String sentDate;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;

    public String getSendToId() {
        return sendToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
