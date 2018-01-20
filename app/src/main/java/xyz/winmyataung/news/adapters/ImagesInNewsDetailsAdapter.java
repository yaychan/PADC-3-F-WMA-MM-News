package xyz.winmyataung.news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.winmyataung.news.R;
import xyz.winmyataung.news.viewitems.ImageInNewsDetailsViewItem;

/**
 * Created by DELL on 12/10/2017.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {

    private List<String> mImages;

    public ImagesInNewsDetailsAdapter(){
        mImages = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mImages.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
       /* if (object instanceof View)
            return true;
        else
            return false;*/
/*
       return (object instanceof View);
*/

        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInNewsDetailsViewItem view = (ImageInNewsDetailsViewItem) layoutInflater.inflate(R.layout.item_news_details_images, container, false);
       /* View view=layoutInflater.inflate(R.layout.item_news_details_images, container, false)*/
        /**
         * composite custom view htal ko item htae tar
         */
        view.setData(mImages.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View)object);  //removeView ကobject type ကိုလက္မခံဘူး
    }

}
