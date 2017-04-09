package com.wtmk.additionquizapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestGen {

    private int mQuest;
    private int mSideQuest;
    private int mAnswer;
    private List<Integer> mAnswers = new ArrayList<>();
    private Random mRandom = new Random();

  public int getQuest(){
        mQuest = mRandom.nextInt(30);
        return mQuest;
    }

    public int getSideQuest(){
        mSideQuest = mRandom.nextInt(30);
        return mSideQuest;
    }

    public int getAnswer(int quest, int sideQuest){
        mQuest = quest;
        mSideQuest = sideQuest;
        mAnswer = mQuest + mSideQuest;
        return mAnswer;
    }

    public int getGotcha(int mAnswer) {
        int gotcha = mAnswer + mRandom.nextInt(5);
        if (gotcha == mAnswer) {
            int newGotcha = gotcha - 1;
            return newGotcha;
        } else {
            return gotcha;
        }
    }

    public List<Integer> getAnswers(){
        int one = getAnswer(mQuest,mSideQuest);
        int two = getGotcha(one);
        int three = getGotcha(one);
        mAnswers.add(one);
        mAnswers.add(two);
        mAnswers.add(three);
        return mAnswers;
    }





}
