package com.floridapoly.volunteer.hourtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

public class SessionListAdapter extends ArrayAdapter<StudySession> {
    private static final String TAG ="SessionListAdapter";

    private Context mContext;
    private int mResource;

    public SessionListAdapter(@NonNull Context context, int resource, @NonNull List<StudySession> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Date startTime = getItem(position).getStartTime();
        Date endTime = getItem(position).getEndTime();
        Location location = getItem(position).getLocation();
//        long hours = getItem(position).getElapsedHours();
//        long minutes = getItem(position).getElapsedMinutes();
//        long seconds = getItem(position).getElapsedSeconds();

        StudySession s = new StudySession(startTime,endTime,location);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvStartTime = (TextView) convertView.findViewById(R.id.tvStartTime);
        TextView tvEndTime = (TextView) convertView.findViewById(R.id.tvEndTime);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);

        tvLocation.setText(location.toString());
        tvStartTime.setText(startTime.toString());
        tvEndTime.setText(endTime.toString());

        return convertView;
    }
}
