/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright © 2015.
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <s133235@student.dtu> wrote this file. As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return - Rudy Alex Kohn
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created on 27-12-2015, 09:59.<br>
 * @author rudz
 */
public class GroupImagesAdapter extends ArrayAdapter<GroupImages> {

    private final Context mContext;
    private final int layoutResourceId;
    private final GroupImages[] data;
    private static ViewHolder viewHolder = new ViewHolder();

    public GroupImagesAdapter(final Context mContext, final int layoutResourceId, final GroupImages[] data) {
        super(mContext, layoutResourceId, data);

        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class ViewHolder {
        ImageView course;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            final LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);
            //viewHolder.course = (ImageView) view.findViewById(R.id.courseImage);
        }

        final GroupImages newGameItem = data[position];
        viewHolder.course.setImageResource(newGameItem.resourceIcon);

        return view;
    }

}