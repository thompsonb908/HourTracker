package com.floridapoly.volunteer.hourtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    Button btnLogin, btnRegister;
    EditText etUsername, etPassword;
    CallbackFragment callbackFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);

        etUsername = view.findViewById(R.id.log_username);
        etPassword = view.findViewById(R.id.log_password);

        btnLogin = view.findViewById(R.id.log_login);
        btnRegister = view.findViewById(R.id.log_register);

        btnLogin.setOnClickListener((View.OnClickListener) v -> {
            if ((etUsername.getText().toString().equals("")) || (etPassword.getText().toString().equals(""))) {
                Toast.makeText((Activity) getContext(), "Input username and password", Toast.LENGTH_SHORT).show();
            } else {
                // needs authentication
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(v -> {
            if(callbackFragment!=null){
                callbackFragment.changeFragment();
            }
        });
                // Inflate the layout for this fragment
        return view;
    }
    public void setCallbackFragment(CallbackFragment callbackFragment){
        this.callbackFragment = callbackFragment;
    }
}