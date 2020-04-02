package com.example.quizapp_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz2 extends AppCompatActivity {

        private Button back;
        private Button next;
        private RadioGroup group;
        private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        back=findViewById(R.id.btBack);
        next=findViewById(R.id.btNext);
        group=findViewById(R.id.radioGroup);

        Intent intent=getIntent();
        int score =intent.getIntExtra("SCORE",0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = group.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);

                Intent intent = new Intent(getApplicationContext(),Quiz1.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = group.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);

                if(radioButton.getId()==R.id.radio_two){
                    score=score+1;
                }
                Intent intent = new Intent(getApplicationContext(),Quiz2.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
            }
        });
    }
}
