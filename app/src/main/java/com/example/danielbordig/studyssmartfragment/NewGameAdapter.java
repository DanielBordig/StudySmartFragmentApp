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
import android.widget.TextView;

/**
 * Created on 27-12-2015, 09:59.<br>
 * Project : R-TicTacToe<br>
 * Adapter for showing the relevant information about new game selection.
 * @author rudz
 */
public class NewGameAdapter extends ArrayAdapter<NewGameItem> {

    private final Context mContext;
    private final int layoutResourceId;
    private final NewGameItem[] data;
    private static ViewHolder viewHolder = new ViewHolder();

    public NewGameAdapter(final Context mContext, final int layoutResourceId, final NewGameItem[] data) {
        super(mContext, layoutResourceId, data);

        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;

    }

    static class ViewHolder {
//        TextView textViewItem;
//        TextView textViewDesc;
        ImageView icon;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = convertView;
//        if (view == null) {
            final LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);
//            viewHolder.textViewItem = (TextView) view.findViewById(R.id.new_game_item);
//            viewHolder.textViewDesc = (TextView) view.findViewById(R.id.new_game_description);
            viewHolder.icon = (ImageView) view.findViewById(R.id.new_game_icon);
//        }

        final NewGameItem newGameItem = data[position];

//        viewHolder.textViewItem.setText(newGameItem.itemName);
//        viewHolder.textViewItem.setTag(newGameItem.itemId);

//        viewHolder.textViewDesc.setText(newGameItem.description);
//        viewHolder.textViewDesc.setTag(newGameItem.itemId);

        viewHolder.icon.setImageResource(newGameItem.resourceIcon);

        return view;
    }

}