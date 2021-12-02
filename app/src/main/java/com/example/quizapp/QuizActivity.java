package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions ;
    private TextView question ;
    private AppCompatButton option1,option2,option3,option4;
    private AppCompatButton nextbtn;
    private Timer quizTimer;
    private final int total_mins=0;
    private  int seconds=10;
    private int current_question;
    private List<QuestionList> questionLists ;
    private String selected_opt;
    public  int correctAnswer=0;
    public  int IncorrectAnswer=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final String getselectedtopic = getIntent().getStringExtra("selected_topic");
        questionLists=QuestionBank.getQuestions(getselectedtopic);//obtenir liste de questions selon le sujet choisit
        final ImageView back = findViewById(R.id.btn_back);
        final TextView timer = findViewById(R.id.timer);
        final TextView selected_topic = findViewById(R.id.selected_topic);
        selected_topic.setText(getselectedtopic);
        questions=findViewById(R.id.place_questions); //le text de question
        question=findViewById(R.id.questions);//le numero de question
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        nextbtn=findViewById(R.id.next_btn);
        current_question=0;
        question.setText((current_question+1)+"/"+questionLists.size());
        questions.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());
        //questionLists =QuestionBank.getQuestions(getselectedtopic);
        startTimer(timer);
        selected_opt="";
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_opt.isEmpty()){

                    selected_opt=option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.red_for_option);
                    option1.setTextColor(Color.WHITE);
                    questionLists.get(current_question).setUserAnswer(selected_opt);
                    reveal_answer();//colorer l'option correcte avec le vert
                    final String getuseranswer=questionLists.get(current_question).getUserAnswer();
                    final String getanswer =questionLists.get(current_question).getAnswer();
                    if(getuseranswer.equals(getanswer))//utiliser pour le calcul de score
                    {
                        correctAnswer++;
                    }
                    else {
                        IncorrectAnswer++;
                    }
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_opt.isEmpty()){
                    selected_opt=option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.red_for_option);
                    option2.setTextColor(Color.WHITE);
                    reveal_answer();
                    questionLists.get(current_question).setUserAnswer(selected_opt);
                    final String getuseranswer=questionLists.get(current_question).getUserAnswer();
                    final String getanswer =questionLists.get(current_question).getAnswer();
                    if(getuseranswer.equals(getanswer))
                    {
                        correctAnswer++;
                    }
                    else
                    {
                        IncorrectAnswer++;
                    }
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_opt.isEmpty()){
                    selected_opt=option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.red_for_option);
                    option3.setTextColor(Color.WHITE);
                    reveal_answer();
                    questionLists.get(current_question).setUserAnswer(selected_opt);
                    final String getuseranswer=questionLists.get(current_question).getUserAnswer();
                    final String getanswer =questionLists.get(current_question).getAnswer();
                    if(getuseranswer.equals(getanswer))
                    {
                        correctAnswer++;
                    }
                    else
                    {
                        IncorrectAnswer++;
                    }
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_opt.isEmpty()){
                    selected_opt=option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.red_for_option);
                    option4.setTextColor(Color.WHITE);
                    questionLists.get(current_question).setUserAnswer(selected_opt);
                    reveal_answer();
                    final String getuseranswer=questionLists.get(current_question).getUserAnswer();
                    final String getanswer =questionLists.get(current_question).getAnswer();
                    if(getuseranswer.equals(getanswer))
                    {
                        correctAnswer++;
                    }
                    else
                    {
                        IncorrectAnswer++;
                    }
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected_opt.isEmpty())
                {
                    Toast.makeText(QuizActivity.this,"Please select an option",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    change_next_question();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void change_next_question()
    {
        final TextView timer = findViewById(R.id.timer);
        current_question++;
        if((current_question+1)==questionLists.size())
        {
            startTimer(timer);
            nextbtn.setText("Submit Quiz");
        }
        if(current_question < questionLists.size())
        {
            selected_opt="";
            startTimer(timer);
            option1.setBackgroundResource(R.drawable.round_for_option);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_for_option);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_for_option);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_for_option);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            question.setText((current_question+1)+"/"+questionLists.size());
            questions.setText(questionLists.get(current_question).getQuestion());
            option1.setText(questionLists.get(current_question).getOption1());
            option2.setText(questionLists.get(current_question).getOption2());
            option3.setText(questionLists.get(current_question).getOption3());
            option4.setText(questionLists.get(current_question).getOption4());
        }
        else
        {
            Intent intent=new Intent(QuizActivity.this,QuizResults.class);
            intent.putExtra("correct",correctAnswer);
            intent.putExtra("incorrect",IncorrectAnswer);
            startActivity(intent);
            finish();
        }
    }

    private void startTimer (TextView timertextview)
    {
        quizTimer=new Timer();
        seconds=10;
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0) {
                    quizTimer.purge();
                    quizTimer.cancel();
                    change_next_question();
                    /*Toast.makeText(QuizActivity.this,"Time Over",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(QuizActivity.this,QuizResults.class);
                    intent.putExtra("correct ",getcorrectanswer());
                    intent.putExtra("incorrect ",getIncorrectanswer());
                    startActivity(intent);
                    finish();*/
                    //change_next_question();
                   /* else if(current_question==questionLists.size())
                    {
                        quizTimer.cancel();
                        quizTimer.purge();
                        Intent intent=new Intent(QuizActivity.this,QuizResults.class);
                        intent.putExtra("correct",correctAnswer);
                        intent.putExtra("incorrect",IncorrectAnswer);
                        startActivity(intent);
                        finish();
                    }*/
                } else if (current_question == questionLists.size()) {
                    quizTimer.purge();
                    quizTimer.cancel();
                    change_next_question();
                } else {
                    seconds--;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String finalminites = String.valueOf(total_mins);
                            String finalseconds = String.valueOf(seconds);
                            if (finalminites.length() == 1) {
                                finalminites = "0" + finalminites;
                            }
                            if (finalseconds.length() == 1) {
                                finalseconds = "0" + finalseconds;
                            }
                            timertextview.setText(finalminites + ":" + finalseconds);
                        }
                    });
                }
            }
        },1000,1000);
    }
    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }

    private void reveal_answer (){
        final String getAnswer =questionLists.get(current_question).getAnswer();
        if(option1.getText().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.correctanswer_green_round);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.correctanswer_green_round);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.correctanswer_green_round);
            option3.setTextColor(Color.WHITE);
        }
        if(option4.getText().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.correctanswer_green_round);
            option4.setTextColor(Color.WHITE);
        }
    }


}