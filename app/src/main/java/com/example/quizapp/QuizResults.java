package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    private AppCompatButton btn_new ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        btn_new=findViewById(R.id.start_new_quiz);
        final TextView correct=findViewById(R.id.correct);
        final int getCorrect = getIntent().getIntExtra("correct",0);
        final  int getIncorrect = getIntent().getIntExtra("incorrect",0);
        int res = 0;
        res=getCorrect*10-getIncorrect*10;

        if(res<=0)
        {
            correct.setText("votre score est "+String.valueOf(res));
            correct.setTextColor(Color.RED);
        }
        else
        {
            correct.setText("votre score est "+String.valueOf(res));
            correct.setTextColor(Color.GREEN);
        }

        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResults.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this,MainActivity.class));
        finish();
    }
}