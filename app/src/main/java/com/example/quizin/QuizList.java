package com.example.quizin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizList extends AppCompatActivity {

    TextView welcomeUsr;

    Button quiz1;
    Button quiz2;
    Button quiz3;
    Button quiz4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        welcomeUsr = findViewById(R.id.welcomeUsr);
        quiz1 = findViewById(R.id.quiz1);
        quiz2 = findViewById(R.id.quiz2);
        quiz3 = findViewById(R.id.quiz3);
        quiz4 = findViewById(R.id.quiz4);

        Intent usernameIntent = getIntent();
        String usrName = usernameIntent.getStringExtra("username");
        welcomeUsr.setText("Welcome " + usrName + " ! ");
        quiz1.setText("Quiz 1");
        quiz2.setText("Quiz 2");
        quiz3.setText("Quiz 3");
        quiz4.setText("Quiz 4");

        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz1 = new Intent(getApplicationContext(), QuizTime.class);
                startQuiz1.putExtra("username", usrName);
                startActivity(startQuiz1);
            }
        });

        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz2 = new Intent(getApplicationContext(), QuizTime.class);
                startQuiz2.putExtra("username", usrName);
                startActivity(startQuiz2);
            }
        });

        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz3 = new Intent(getApplicationContext(), QuizTime.class);
                startQuiz3.putExtra("username", usrName);
                startActivity(startQuiz3);
            }
        });

        quiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuiz4 = new Intent(getApplicationContext(), QuizTime.class);
                startQuiz4.putExtra("username", usrName);
                startActivity(startQuiz4);
            }
        });

    }
}