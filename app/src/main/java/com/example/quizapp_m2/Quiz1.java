package com.example.quizapp_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz1 extends AppCompatActivity {

    private RadioButton radioButton;
    private Button button;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button=findViewById(R.id.btApply);
        group=findViewById(R.id.radioGroup);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        button.setOnClickListener(new View.OnClickListener() {
            int score=0;
            @Override
            public void onClick(View v) {

                int radioId = group.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);

                if(radioButton.getId()==R.id.radio_one){
                    score=score+1;
                }
                Intent intent = new Intent(getApplicationContext(),Quiz2.class);
                intent.putExtra("SCORE",score);
                startActivity(intent);
            }
        });

    }

    public void checkButton(View view) {
    }
}
