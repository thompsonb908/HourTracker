package com.floridapoly.volunteer.hourtracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.floridapoly.volunteer.hourtracker.DBHelper;
import com.floridapoly.volunteer.hourtracker.NavActivity;
import com.floridapoly.volunteer.hourtracker.R;
import com.floridapoly.volunteer.hourtracker.SessionListAdapter;
import com.floridapoly.volunteer.hourtracker.StudySession;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    DBHelper db;


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

        SessionListAdapter adapter = new SessionListAdapter(root.getContext(), R.layout.adapter_view_layout, db.getAllSessions());
        listView.setAdapter(adapter);

        return root;
    }
}