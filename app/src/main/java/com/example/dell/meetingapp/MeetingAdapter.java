package com.example.dell.meetingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends ArrayAdapter<meeting> {

    private Context mContext;
    private List<meeting> arrayList = new ArrayList<>();

    public MeetingAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<meeting> list) {
        super(context, 0 , list);
        mContext = context;
        arrayList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_view,parent,false);

        meeting meeting = getItem(position);

        TextView topic = (TextView) listItem.findViewById(R.id.tv1);
        topic.setText(meeting.getTopic());

        TextView duration = (TextView) listItem.findViewById(R.id.tv2);
        duration.setText(meeting.getDuration());

        TextView date = (TextView) listItem.findViewById(R.id.tv3);
        date.setText(meeting.getDate());

        TextView time = (TextView) listItem.findViewById(R.id.tv4);
        time.setText(meeting.getTime());

        return listItem;
    }
}