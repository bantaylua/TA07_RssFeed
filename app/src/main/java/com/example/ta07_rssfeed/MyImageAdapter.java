package com.example.ta07_rssfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyImageAdapter extends BaseAdapter {

    private Context context;
    Integer[] smallImages;

    public MyImageAdapter(Context mainActivityContext, Integer[] thumbnails) {
        context = mainActivityContext;
        smallImages = thumbnails;
    }

    public int getCount(){
        return smallImages.length;
    }

    public Object getItem(int position) {
        return smallImages[position];
    }

    public long getItemId(int position){
        return position;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(context);
            imageView .setLayoutParams(new GridView.LayoutParams(100, 75));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(smallImages[position]);
        return imageView;
    }
}



