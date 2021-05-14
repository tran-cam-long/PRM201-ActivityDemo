package com.example.day02_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername, editAge;
    private static final int INPUT = 666;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.editUsername);
        editAge = findViewById(R.id.editAge);
        txtResult = findViewById(R.id.txtResult);
    }

    public void clickToSignUp(View view) {
        String username = editUsername.getText().toString();
        String age = editAge.getText().toString();

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("username", username);
        intent.putExtra("age", age);
        //startActivity(intent);
        startActivityForResult(intent, INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("onActivityResult is invoked");
        if(requestCode == INPUT) {
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("result");
                txtResult.setText("Result: " + name);
            }
        }
    }

    //TO DO xem thu onActivityR o dau


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart is invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart is invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume is invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause is invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop is invoke");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy is invoked");
    }
}