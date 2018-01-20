package xyz.winmyataung.news.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.winmyataung.news.MMNewsApp;
import xyz.winmyataung.news.events.LoadedNewsEvent;
import xyz.winmyataung.news.network.responses.GetNewsResponses;

/**
 * Created by DELL on 1/6/2018.
 */

public class OkHttpDataAgent implements NewsDataAgent {

    private OkHttpDataAgent() {
    }

    private static OkHttpDataAgent objInstance;



    public static OkHttpDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgent();
        }
        return objInstance;
    }


    @Override
    public void loadNews() {
        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");

    }

    /**
     * 1st parameter = URL (String)
     * 2nd void
     * 3rd parameter =  Text (JSOn)
     */
    private static class LoadNewsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {            //String... (String array), string => urls
            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder() //1.
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2.
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;
            try {
                Response response = httpClient.newCall(request).execute(); //4.
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                    //  return responseString;
                }
            } catch (IOException e) {
                Log.e(MMNewsApp.LOG_TAG, e.getMessage());
            }

            return responseString;
        }

        /**
         * onPostExecute is not in background thread
         *
         * @param response
         */
        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetNewsResponses getNewsResponses= gson.fromJson(response, GetNewsResponses.class);

            LoadedNewsEvent event =new LoadedNewsEvent(getNewsResponses.getMmNews());

            EventBus eventBus= new EventBus().getDefault();
            eventBus.post(event);
        }
    }
}
