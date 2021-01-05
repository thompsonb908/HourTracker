package com.floridapoly.volunteer.hourtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(this);
    }

    private void validate(Editable username, Editable password) {
        //if((username.toString() == "Test") && (password.toString() == "1234")){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        //}
    }

    @Override
    public void onClick(View v) {
        validate(username.getText(), password.getText());
    }

}