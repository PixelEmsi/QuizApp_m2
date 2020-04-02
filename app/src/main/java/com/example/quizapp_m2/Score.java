
package com.example.quizapp_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        text=findViewById(R.id.tScore);

        Intent intent=getIntent();
        int score=intent.getIntExtra("SCORE",0);
        text.setText(score);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }
}
