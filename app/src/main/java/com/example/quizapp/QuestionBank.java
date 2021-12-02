package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private static List<QuestionList> javaquestions (){
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList q1 = new QuestionList("What is the size of int variable ","8 bit","16 bit ","32 bit","64 bit","32 bit","");
        final QuestionList q2 = new QuestionList("What is the default value of boolean variable ","True","False","Null","Not defined","True","");
        final QuestionList q3 = new QuestionList("What of the following is the default value of of an instance variable ","Depends upon the type of variable","null","0","not assigned","Depends upon the type of variable","");
        final QuestionList q4 = new QuestionList("Which of the following is NOT a keyword or reserved words in java ?","if","then","goto","while","then","");
        final QuestionList q5 = new QuestionList("Which the valid declaration within an interface definition ?","public double method();","public final double method();","static void method(double a);","protected void method(int a);","public double method();","");
        final QuestionList q6 = new QuestionList("Which is a reserved word in Java Programming language ","method","native","reference","array","native","");
        questionLists.add(q1);
        questionLists.add(q2);
        questionLists.add(q3);
        questionLists.add(q4);
        questionLists.add(q5);
        questionLists.add(q6);

        return questionLists;
    }

    private static List<QuestionList> phpquestions (){
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList q1 = new QuestionList("What does php stand for ? ","Professional Home Page","Hypertext Preprocessor","Pretext Hypertext Processor","Preprocessor Home Page ","Hypertext Preprocessor","");
        final QuestionList q2 = new QuestionList("Who is the father of the PHP  ","Ramsus Lerdorf","William Makepiece","Drek Kolkevi","List Barely ","Ramsus Lerdorf","");
        final QuestionList q3 = new QuestionList("PHP file have a default file extension of . ",".html",".php",".xml",".json",".php","");
        final QuestionList q4 = new QuestionList("A PHP script should start with ___ and end with ____","< php >","<php />","<? ?>","<? php ?>","<? php ?>","");
        final QuestionList q5 = new QuestionList("Which version of PHP introduced Try/catch Exception ?","PHP 4","PHP 5","PHP 6","PHP 5.3","PHP 5","");
        final QuestionList q6 = new QuestionList("If $a = 12 what will be returned when ($a == 12 ) ? 5 :1 is executed","12","1","5","Error","5","");
        questionLists.add(q1);
        questionLists.add(q2);
        questionLists.add(q3);
        questionLists.add(q4);
        questionLists.add(q5);
        questionLists.add(q6);

        return questionLists;
    }
    private static List<QuestionList> htmlquestions (){
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList q1 = new QuestionList("HTML is stand for ?","Hyper Text Markup Language","High Text Markup Language","Hyper Tabular Markup Language","No one of these","Hyper Text Markup Language","");
        final QuestionList q2 = new QuestionList("Which of the following tag is used to mark the begining of a paragraph ? ","<TD> ","<br>","<p>","<TR>","<p>","");
        final QuestionList q3 = new QuestionList("From which tag descriptive list starts ?","<LL>","<DD>","<DL>","<DS>","<DL>","");
        final QuestionList q4 = new QuestionList("Correct HTML tag for the largest heading is : ","<head>","<large>","<h6>","<heading>","<h6>","");
        final QuestionList q5 = new QuestionList("the attribute of <form> tag","Method","Action","Both (a)&(b)","None of these ","Both (a)&(b)","");
        final QuestionList q6 = new QuestionList("Markup tags tell the web  browser ","How to organise the page ","How to display the page ","How to display message box on page ","None of these","How to display the page ","");
        questionLists.add(q1);
        questionLists.add(q2);
        questionLists.add(q3);
        questionLists.add(q4);
        questionLists.add(q5);
        questionLists.add(q6);

        return questionLists;
    }
    private static List<QuestionList> androidquestions (){
        final List<QuestionList> questionLists = new ArrayList<>();

        final QuestionList q1 = new QuestionList("Select a component which is NOT PART of Android Architecture ","Android FrameWork","Libraries","Linux Kernel","Android Document ","Linux Kernel","");
        final QuestionList q2 = new QuestionList("A ____________ makes a specific set of the application data available to other applications ","Content provider ","Broadcast receivers ","Intent ","None of these ","Content provider ","");
        final QuestionList q3 = new QuestionList("Which among these are NOT a part  of android's native libraries ? ","Webkit","Dalvik","OpenGl","Sqlite","Dalvik","");
        final QuestionList q4 = new QuestionList("During an activity life-cycle ,what is the first callback method invoked by the system ? ","onStop()","onStart()","onCreate()","onRestore()","onCreate()","");
        final QuestionList q5 = new QuestionList("What activity method you use to retrieve a reference to an android view by using the id attribute of a ressource XML ?","findViewByReference(int id);","findViewById(int id);","findViewById(String id)","retrieveResourceById(int id);","findViewById(int id);","");
        final QuestionList q6 = new QuestionList("The requests from content provider class is handled by method","onCreate","onSelect","ContentResolver","onClick","ContentResolver","");
        questionLists.add(q1);
        questionLists.add(q2);
        questionLists.add(q3);
        questionLists.add(q4);
        questionLists.add(q5);
        questionLists.add(q6);

        return questionLists;
    }
    public static List<QuestionList> getQuestions (String selected_topic){

        switch (selected_topic)
        {
            case "java":
                return javaquestions();
            case "php":
                return  phpquestions();
            case "html":
                return  htmlquestions();
            default:
                return androidquestions();
        }
    }

}
