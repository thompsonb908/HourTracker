package com.floridapoly.volunteer.hourtracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment extends Fragment {

    Button btnRegister;
    EditText etUsername, etPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container,false);
        etUsername = view.findViewById(R.id.reg_username);
        etPassword = view.findViewById(R.id.reg_password);

        btnRegister = view.findViewById(R.id.reg_register);

        btnRegister.setOnClickListener(v -> {
            // Registration
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            Fragment fragment = new LoginFragment();
            ft.replace(R.id.fragmentContainer, fragment);
            ft.commit();
        });
        return view;
    }
}