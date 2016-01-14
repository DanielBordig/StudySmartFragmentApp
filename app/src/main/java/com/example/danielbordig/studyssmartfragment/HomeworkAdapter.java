package com.example.danielbordig.studyssmartfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel Bordig on 12-01-2016.
 */
public class HomeworkAdapter extends ArrayAdapter<HomeworkDTO> {

    private final Context mContext;
    private final int layoutResourceId;
    private final ArrayList<HomeworkDTO> data;
    private static ViewHolder viewHolder = new ViewHolder();


    public HomeworkAdapter(final Context mContext, final int layoutResourceId, final ArrayList<HomeworkDTO> data) {
        super(mContext, layoutResourceId, data);

        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class ViewHolder {
        ImageView course;
        TextView description;
    }

    @Override
    public int getItemViewType(int position) {
        String landEllerOverskrift = data.get(position).date;
        if (landEllerOverskrift.startsWith("date")) return 0;
        return 1;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view;
//        if (view == null) {
            final LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);
            viewHolder.course = (ImageView) view.findViewById(R.id.listeelem_billede);
            viewHolder.description = (TextView) view.findViewById(R.id.listeelem_overskrift);
//        }

        final HomeworkDTO homework = data.get(position);
        viewHolder.course.setImageResource((homework.course));
        viewHolder.description.setText(homework.description);

        return view;
    }
}
