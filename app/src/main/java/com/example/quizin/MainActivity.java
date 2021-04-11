package com.example.quizin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void startQuiz(View view)
    {
        Intent intentStartQuiz = new Intent(this, QuizList.class);
        String User = Username.getText().toString();

        if (TextUtils.isEmpty(User)){
            Toast.makeText(MainActivity.this, "Empty fields are not allowed please enter your name !", Toast.LENGTH_LONG).show();
        }
        else
        {
            intentStartQuiz.putExtra("username", User);
            startActivity(intentStartQuiz);
        }
    }

    EditText Username;
    ImageButton LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.Username);
        LoginButton = findViewById(R.id.LoginButton);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}

