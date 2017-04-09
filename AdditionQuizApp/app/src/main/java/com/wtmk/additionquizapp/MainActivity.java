package com.wtmk.additionquizapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button answerA;
    private Button answerB;
    private Button answerC;
    private TextView mQuestTextView;
    private Button mNextQuest;
    private Button mSubmit;
    private int one;
    private int exp;
    private int checkIntA;
    private int checkIntB;
    private int checkIntC;
    private boolean newAnswer;
    private QuestGen mQuest = new QuestGen();
    private List<Integer> mAnswers = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestTextView = (TextView) findViewById(R.id.quest);
        mNextQuest = (Button) findViewById(R.id.checkAns);
        answerA = (Button) findViewById(R.id.aRadioButton);
        answerB = (Button) findViewById(R.id.bRadioButton);
        answerC = (Button) findViewById(R.id.cRadioButton);
        mSubmit = (Button) findViewById(R.id.submitAns);
        newAnswer = false;







        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int quest = mQuest.getQuest();
                int sideQuest = mQuest.getSideQuest();
                mQuestTextView.setTextSize(20);
                mQuestTextView.setText("What is " + quest + " + " + sideQuest + " ?");
                one = mQuest.getAnswer(quest,sideQuest);
                int two = mQuest.getGotcha(one);
                int three = mQuest.getGotcha(one);
                mAnswers.add(one);
                mAnswers.add(two);
                mAnswers.add(three);
                int rOne = setAnswers();
                int rTwo = setAnswers();
                int rThree = setAnswers();
                mNextQuest.setText("Next question");
                mSubmit.setText("");
                answerA.setText(rOne +"");
                answerB.setText(rTwo+"");
                answerC.setText(rThree+"");
                newAnswer = true;
                answerA.setTextColor(Color.BLACK);
                answerB.setTextColor(Color.BLACK);
                answerC.setTextColor(Color.BLACK);
                mSubmit.setText(" ? ");

            }

        };


        View.OnClickListener checkAnswerA = new View.OnClickListener(){
            @Override
            public void onClick(View a){
                String checkA = (String) answerA.getText();
                checkIntA = Integer.parseInt(checkA);
                mSubmit.setText(checkA + " Final Answer?");
                answerA.setTextColor(Color.RED);
                answerB.setTextColor(Color.BLACK);
                answerC.setTextColor(Color.BLACK);
            }
        };

        View.OnClickListener checkAnswerB = new View.OnClickListener(){
            @Override
            public void onClick(View b){
                String checkB = (String) answerB.getText();
                checkIntB = Integer.parseInt(checkB);
                mSubmit.setText(checkB + " Final Answer?");
                answerA.setTextColor(Color.BLACK);
                answerB.setTextColor(Color.RED);
                answerC.setTextColor(Color.BLACK);
            }
        };

        View.OnClickListener checkAnswerC = new View.OnClickListener(){
            @Override
            public void onClick(View c){
                String checkC = (String) answerC.getText();
                checkIntC = Integer.parseInt(checkC);
                mSubmit.setText(checkC + " Final Answer?");
                answerA.setTextColor(Color.BLACK);
                answerB.setTextColor(Color.BLACK);
                answerC.setTextColor(Color.RED);
            }
        };

        View.OnClickListener subListener = new View.OnClickListener() {
            @Override
            public void onClick(View d) {
                String bingo = (String) mSubmit.getText();
                int bingoInt = Integer.parseInt(bingo.replaceAll("[\\D]", ""));
                checkAnswer(bingoInt);


            }


        };




        answerA.setOnClickListener(checkAnswerA);
        answerB.setOnClickListener(checkAnswerB);
        answerC.setOnClickListener(checkAnswerC);
        mSubmit.setOnClickListener(subListener);
        mNextQuest.setOnClickListener(listener);




    }

    private int setAnswers(){
        Random mRandom = new Random();
        int chosen = mRandom.nextInt(mAnswers.size());
        int setAnswer = mAnswers.get(chosen);
        mAnswers.remove(chosen);
        return setAnswer;
    }
    private void checkAnswer(int numb){
        int bingoInt = numb;
        if (bingoInt == one){
            Toast.makeText(MainActivity.this,"NICE!!!",Toast.LENGTH_SHORT).show();
            newAnswer = false;

        }else {Toast.makeText(MainActivity.this,"Bummer... That's wrong, Try Again!",Toast.LENGTH_SHORT).show();}
        if (newAnswer == false && bingoInt == one){
            mQuestTextView.setText("Keep up to good work tap next question.");


        }




    }



}





