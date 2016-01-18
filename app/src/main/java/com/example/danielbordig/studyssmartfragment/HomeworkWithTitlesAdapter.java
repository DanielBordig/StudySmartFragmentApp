package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 16-01-2016.
 */
public class HomeworkWithTitlesAdapter extends ArrayAdapter<String> {

    private final Context mContext;
    private final int layoutResourceId;
    private final ArrayList<String> data;
    private final ArrayList<Integer> courseImages;

    public HomeworkWithTitlesAdapter(final Context mContext, final int layoutResourceId, final ArrayList<String> data, ArrayList<Integer> courseImages) {
        super(mContext, layoutResourceId, data);

        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.courseImages = courseImages;
    }

    @Override
    public int getItemViewType(int position) {
        String titleOrNot = data.get(position);
        if (titleOrNot.startsWith("date")) return 0;
        return 1;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup parent) {
        int type = getItemViewType(position);
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

        if (type == 0) {
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        } else {
            view = inflater.inflate(R.layout.listview_hwc_layout, null);
        }

        String titleOrNot = data.get(position);
        if (type == 0) {
            titleOrNot = titleOrNot.substring(4);
            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setTextSize(22);
            //textView.setTextIsSelectable(false);
            textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            textView.setText(titleOrNot);
        } else {
            ImageView imageView = (ImageView) view.findViewById(R.id.homeworkCourseImage);
            imageView.setImageResource(courseImages.get(position));
            TextView tvo = (TextView) view.findViewById(R.id.descriptionView);
            tvo.setText(titleOrNot);
        }
        return view;
    }
    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) > 0;
    }
}
