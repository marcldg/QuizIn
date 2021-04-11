package com.example.quizin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndQuiz extends AppCompatActivity {

    TextView congratsText;
    TextView score;

    String name;
    String totalScore;

    Button newQuiz;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        congratsText = findViewById(R.id.congratsText);
        score = findViewById(R.id.score);

        newQuiz = findViewById(R.id.newQuiz);
        exit = findViewById(R.id.exit);

        Intent userNameIntent = getIntent();
        Intent finalScore = getIntent();

        totalScore = finalScore.getStringExtra("finalScore");
        name = userNameIntent.getStringExtra("username");

        congratsText.setText("Congratulations " + name + " ! ");
        score.setText("Your Score: " + totalScore + "/5");
        newQuiz.setText("TAKE NEW QUIZ");
        exit.setText("EXIT");


        newQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeNewQuiz = new Intent(getApplicationContext(), QuizList.class);
                takeNewQuiz.putExtra("username", name);
                startActivity(takeNewQuiz);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitApp = new Intent(getApplicationContext(), MainActivity.class);
                exitApp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                exitApp.putExtra("EXIT", true);
                startActivity(exitApp);
            }
        });
    }

}