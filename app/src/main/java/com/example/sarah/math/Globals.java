package com.example.sarah.math;

import android.app.Application;

/**
 * Created by Sarah on 07/04/2019.
 */

public class Globals extends Application {

    private int CorrectAnswers=0;
    private int WrongAnswers=0;
    private long time= System.currentTimeMillis();



    public int getCorrectAnswers(){
        return CorrectAnswers;
    }

    public int getWrongAnswers(){
        return this.WrongAnswers;
    }
    public void setCorrectAnswers (int d){
        this.CorrectAnswers=d;
    }

    public void setWrongAnswers(int d){
        this.WrongAnswers=d;
    }

    public long getTime(){
        return this.time;
    }
}
