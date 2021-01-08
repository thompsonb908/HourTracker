package com.floridapoly.volunteer.hourtracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.floridapoly.volunteer.hourtracker.DBHelper;
import com.floridapoly.volunteer.hourtracker.R;
import com.floridapoly.volunteer.hourtracker.SessionListAdapter;
import com.floridapoly.volunteer.hourtracker.StudySession;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    DBHelper db;
    TextView totalHours;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        ListView listView = (ListView) root.findViewById(R.id.lvSessionList);
        db = new DBHelper(root.getContext());
        totalHours = (TextView) root.findViewById(R.id.tvTotalHours);

        List<StudySession> totalList = db.getAllSessions();
        SessionListAdapter adapter = new SessionListAdapter(root.getContext(), R.layout.adapter_view_layout, totalList);
        listView.setAdapter(adapter);

        totalHours.setText(calculateTime(totalList));

        return root;
    }

    public String calculateTime(List<StudySession> list){
        long totalHours = 0;
        long totalMinutes = 0;
        long totalSeconds = 0;

        for (StudySession s : list){
            long seconds = s.getElapsedSeconds();
            long minutes = s.getElapsedMinutes();
            long hours = s.getElapsedHours();

            totalSeconds += seconds;
            if (totalSeconds >= 60){
                totalSeconds -= 60;
                totalMinutes++;
            }
            totalMinutes += minutes;
            if(totalMinutes >= 60){
                totalMinutes -= 60;
                totalHours++;
            }
            totalHours += hours;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(totalHours);
        stringBuilder.append(":");
        stringBuilder.append(totalMinutes);
        stringBuilder.append(":");
        stringBuilder.append(totalSeconds);

        return  stringBuilder.toString();
    }
}