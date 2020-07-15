package com.example.quizapp_m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;

public class Quiz1 extends AppCompatActivity {

    private RadioButton radioButton;
    private Button button;
    private RadioGroup group;

    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button=findViewById(R.id.btApply);
        group=findViewById(R.id.radioGroup);


        button.setOnClickListener(new View.OnClickListener() {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_activity_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.logout_menu:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void checkButton(View view) {
    }
}
