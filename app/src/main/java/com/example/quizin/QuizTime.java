package com.example.quizin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.ArrayList;
import java.util.List;

public class QuizTime extends AppCompatActivity {

    TextView welcomeMsg;
    TextView questionTitle;
    TextView questionDescription;

    String[] progressTracker = {"Q1", "Q2", "Q3", "Q4", "Q5"};

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;
    Button submitBtn;
    Button usrAnswer;

    Global g = Global.getInstance();
    Integer score = g.getScore();
    String name = g.getName();
    Integer questionCounter;
    private List<questionSet> questions;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void createQuestions(){
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);

        optionA.setSelected(false);
        optionB.setSelected(false);
        optionC.setSelected(false);
        optionD.setSelected(false);

        optionA.setActivated(false);
        optionB.setActivated(false);
        optionC.setActivated(false);
        optionD.setActivated(false);

        optionA.setHovered(false);
        optionB.setHovered(false);
        optionC.setHovered(false);
        optionD.setHovered (false);

        usrAnswer = null;

        if(questionCounter == 0) {
            questionTitle.setText(questions.get(0).getQuestionNum().toString());
            questionDescription.setText(questions.get(0).getQuestion().toString());
            optionA.setText(questions.get(0).getOptionA().toString());
            optionB.setText(questions.get(0).getOptionB().toString());
            optionC.setText(questions.get(0).getOptionC().toString());
            optionD.setText(questions.get(0).getOptionD().toString());
        }
        else if(questionCounter == 1){
            questionTitle.setText(questions.get(1).getQuestionNum().toString());
            questionDescription.setText(questions.get(1).getQuestion().toString());
            optionA.setText(questions.get(1).getOptionA().toString());
            optionB.setText(questions.get(1).getOptionB().toString());
            optionC.setText(questions.get(1).getOptionC().toString());
            optionD.setText(questions.get(1).getOptionD().toString());
        }
        else if(questionCounter == 2){
            questionTitle.setText(questions.get(2).getQuestionNum().toString());
            questionDescription.setText(questions.get(2).getQuestion().toString());
            optionA.setText(questions.get(2).getOptionA().toString());
            optionB.setText(questions.get(2).getOptionB().toString());
            optionC.setText(questions.get(2).getOptionC().toString());
            optionD.setText(questions.get(2).getOptionD().toString());
        }
        else if(questionCounter == 3){
            questionTitle.setText(questions.get(3).getQuestionNum().toString());
            questionDescription.setText(questions.get(3).getQuestion().toString());
            optionA.setText(questions.get(3).getOptionA().toString());
            optionB.setText(questions.get(3).getOptionB().toString());
            optionC.setText(questions.get(3).getOptionC().toString());
            optionD.setText(questions.get(3).getOptionD().toString());
        }
        else if(questionCounter == 4){
            questionTitle.setText(questions.get(4).getQuestionNum().toString());
            questionDescription.setText(questions.get(4).getQuestion().toString());
            optionA.setText(questions.get(4).getOptionA().toString());
            optionB.setText(questions.get(4).getOptionB().toString());
            optionC.setText(questions.get(4).getOptionC().toString());
            optionD.setText(questions.get(4).getOptionD().toString());
        }
    }

    public void showScore(){
        Intent secondIntent = new Intent(this, EndQuiz.class);
        String finalScore = score.toString();
        secondIntent.putExtra("finalScore", finalScore);
        secondIntent.putExtra("username", name);

        startActivity(secondIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_time);

        Global global = (Global) getApplicationContext();
        g.setScore(0);

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.stateProgressBar);
        stateProgressBar.setStateDescriptionData(progressTracker);


        welcomeMsg = findViewById(R.id.welcomeMsg);
        questionTitle = findViewById(R.id.questionTitle);
        questionDescription = findViewById(R.id.questionDescription);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        submitBtn = findViewById(R.id.submitBtn);

        Intent usernameIntent = getIntent();
        name = usernameIntent.getStringExtra("username");
        welcomeMsg.setText("Welcome " + name + " ! ");
        submitBtn.setText("SUBMIT");

        questions = new ArrayList<>();
        questions.add(new questionSet("Question 1", "What are the different types of layout available in android?", "A - Linear Layout", "B - Frame Layout", "C - Table Layout", "D - All of above", "D - All of above"));
        questions.add(new questionSet("Question 2", "How do you pass data between activities in Android Studio?", "A - Content Provider", "B - Intent", "C - Broadcast receiver", "D - None of the above", "B - Intent"));
        questions.add(new questionSet("Question 3", "What is Manifest.xml in android?", "A - Info about app layout", "B - Info about activities in app", "C - All info about app", "D - None of the above", "C - All info about app"));
        questions.add(new questionSet("Question 4", "What is APK in android?", "A - Android packages", "B - Android pack", "C - Android packaging kit", "D - None of the above.", "C - Android packaging kit"));
        questions.add(new questionSet("Question 5", "What is the life cycle of services in android?", "A - onCreate()−>onStartCommand()−>onDestory()", "B - onRecieve()", "C - final()", "D - Service life cycle is same as activity life cycle.", "A - onCreate()−>onStartCommand()−>onDestory()"));
        questionCounter = 0;
        createQuestions();

        optionA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(optionA.isSelected()==true){
                    optionA.setSelected(false);
                    optionB.setEnabled(true);
                    optionC.setEnabled(true);
                    optionD.setEnabled(true);
                    usrAnswer = null;
                }else if(optionA.isSelected()==false){
                    optionA.setSelected(true);
                    optionB.setEnabled(false);
                    optionC.setEnabled(false);
                    optionD.setEnabled(false);
                    usrAnswer = optionA;
                }
            }
        });

        optionB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(optionB.isSelected()==true){
                    optionB.setSelected(false);
                    optionA.setEnabled(true);
                    optionC.setEnabled(true);
                    optionD.setEnabled(true);
                    usrAnswer = null;
                }else if(optionB.isSelected()==false){
                    optionB.setSelected(true);
                    optionA.setEnabled(false);
                    optionC.setEnabled(false);
                    optionD.setEnabled(false);
                    usrAnswer = optionB;
                }
            }
        });

        optionC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(optionC.isSelected()==true){
                    optionC.setSelected(false);
                    optionA.setEnabled(true);
                    optionB.setEnabled(true);
                    optionD.setEnabled(true);
                    usrAnswer = null;
                }else if(optionC.isSelected()==false){
                    optionC.setSelected(true);
                    optionA.setEnabled(false);
                    optionB.setEnabled(false);
                    optionD.setEnabled(false);
                    usrAnswer = optionC;
                }
            }
        });

        optionD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(optionD.isSelected()==true){
                    optionD.setSelected(false);
                    optionA.setEnabled(true);
                    optionB.setEnabled(true);
                    optionC.setEnabled(true);
                    usrAnswer = null;
                }else if(optionD.isSelected()==false){
                    optionD.setSelected(true);
                    optionA.setEnabled(false);
                    optionC.setEnabled(false);
                    optionB.setEnabled(false);
                    usrAnswer = optionD;
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String buttonOption = submitBtn.getText().toString();
                if(buttonOption.equals("SUBMIT")){
                    if(usrAnswer == null){
                        Toast.makeText(QuizTime.this, "Please select an answer !", Toast.LENGTH_LONG).show();
                    }
                    else{
                        usrAnswer.setSelected(false);
                        if(questionCounter == 0){
                            if(usrAnswer.getText().toString().equals(questions.get(0).getAnswer())){
                                //usrAnswer.setBackgroundTintList (ColorStateList.valueOf(Color.parseColor("green")));
                                //usrAnswer.setBackgroundColor(Color.GREEN);
                                //usrAnswer.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                                //Toast.makeText(QuizTime.this, "correct", Toast.LENGTH_LONG).show();
                                usrAnswer.setActivated(true);
                                score++;
                            }else {
                                usrAnswer.setHovered(true);
                                optionD.setActivated(true);
                                //Toast.makeText(QuizTime.this, "wrong", Toast.LENGTH_LONG).show();
                                //usrAnswer.setBackgroundTintList (ColorStateList.valueOf(Color.parseColor("red")));
                                //usrAnswer.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                                //optionD.setBackgroundTintList (ColorStateList.valueOf(Color.parseColor("green")));
                                //optionD.setBackgroundColor(Color.GREEN);
                                //optionD.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                            }
                        }
                        else if(questionCounter == 1){
                            if(usrAnswer.getText().toString().equals(questions.get(1).getAnswer())){
                                usrAnswer.setActivated(true);
                                //Toast.makeText(QuizTime.this, "correct", Toast.LENGTH_LONG).show();
                                score++;
                            }
                            else {
                                usrAnswer.setHovered(true);
                                optionB.setActivated(true);
                                //Toast.makeText(QuizTime.this, "wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                        else if(questionCounter == 2){
                            if(usrAnswer.getText().toString().equals(questions.get(2).getAnswer())){
                                usrAnswer.setActivated(true);
                                //Toast.makeText(QuizTime.this, "correct", Toast.LENGTH_LONG).show();
                                score++;
                            }
                            else {
                                usrAnswer.setHovered(true);
                                optionC.setActivated(true);
                                //Toast.makeText(QuizTime.this, "wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                        else if(questionCounter == 3){
                            if(usrAnswer.getText().toString().equals(questions.get(3).getAnswer())){
                                usrAnswer.setActivated(true);
                                //Toast.makeText(QuizTime.this, "correct", Toast.LENGTH_LONG).show();
                                score++;
                            }
                            else {
                                usrAnswer.setHovered(true);
                                optionC.setActivated(true);
                                //Toast.makeText(QuizTime.this, "wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                        else if(questionCounter == 4){
                            if(usrAnswer.getText().toString().equals(questions.get(4).getAnswer())){
                                usrAnswer.setActivated(true);
                                //Toast.makeText(QuizTime.this, "correct", Toast.LENGTH_LONG).show();
                                score++;
                            }
                            else {
                                usrAnswer.setHovered(true);
                                optionA.setActivated(true);
                                //Toast.makeText(QuizTime.this, "wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                        optionA.setEnabled(false);
                        optionB.setEnabled(false);
                        optionC.setEnabled(false);
                        optionD.setEnabled(false);
                        questionCounter++;
                        submitBtn.setText("NEXT");
                        //Toast.makeText(QuizTime.this, score.toString(), Toast.LENGTH_LONG).show();
                    }
                }
                else if(buttonOption.equals("NEXT") && questionCounter <= 4){
                    if(questionCounter == 1){
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                    }
                    else if (questionCounter ==2){
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                    }
                    else if (questionCounter ==3){
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                    }
                    else if (questionCounter ==4){
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);
                    }
                    createQuestions();
                    submitBtn.setText("SUBMIT");
                }
                else{
                    submitBtn.setText("VIEW SCORE");
                    showScore();
                }
            }
        });
    }
}