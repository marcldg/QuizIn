package com.example.quizin;

import android.app.Application;

public class Global extends Application{
    private static Global instance;
    private static int score;
    private  static  String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Global.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static synchronized Global getInstance(){
        if(instance==null){
            instance=new Global();
        }
        return instance;
    }
}
