package com.example.day02_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtUsername, txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtUsername = findViewById(R.id.txtUsername);
        txtAge = findViewById(R.id.txtAge);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = this.getIntent();
        txtUsername.setText("Username: " + intent.getStringExtra("username"));
        txtAge.setText("Age: " + intent.getStringExtra("age"));

    }

    public void clickToDone(View view) {
  //      Intent intent = new Intent(this, MainActivity.class);
  //      startActivity(intent);
        Intent intent = this.getIntent();
        String username = intent.getStringExtra("username") + " Return to home";
        intent.putExtra("result", username);
        this.setResult(RESULT_OK, intent);
        finish();

    }
}