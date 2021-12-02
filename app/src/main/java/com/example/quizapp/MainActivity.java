package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String selected_topic="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout java = findViewById(R.id.layout_java);
        final LinearLayout html= findViewById(R.id.layout_html);
        final LinearLayout php = findViewById(R.id.layout_php);
        final LinearLayout android = findViewById(R.id.layout_android);
        final Button btn_start = findViewById(R.id.sartQuiz_btn);


        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected_topic="java";
                java.setBackgroundResource(R.drawable.round_back_other_option);
                php.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.round);
                android.setBackgroundResource(R.drawable.round);

            }
        });
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_topic="html";
                html.setBackgroundResource(R.drawable.round_back_other_option);
                php.setBackgroundResource(R.drawable.round);
                java.setBackgroundResource(R.drawable.round);
                android.setBackgroundResource(R.drawable.round);
            }
        });
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_topic="php";
                php.setBackgroundResource(R.drawable.round_back_other_option);
                java.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.round);
                android.setBackgroundResource(R.drawable.round);
            }
        });
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_topic="android";
                android.setBackgroundResource(R.drawable.round_back_other_option);
                php.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.round);
                java.setBackgroundResource(R.drawable.round);
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_topic.isEmpty()){
                    Toast.makeText(MainActivity.this,"please select the topic",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                    intent.putExtra("selected_topic",selected_topic);
                    startActivity(intent);

                }
            }
        });
    }
}