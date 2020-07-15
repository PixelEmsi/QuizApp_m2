package com.example.quizapp_m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Quiz2 extends AppCompatActivity {

        private int score;
        private Button back;
        private Button next;
        private RadioGroup group;
        private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        back=findViewById(R.id.btBack);
        next=findViewById(R.id.btNext);
        group=findViewById(R.id.radioGroup);

        Intent intent=getIntent();
        score =intent.getIntExtra("SCORE",0);

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

                if(radioButton.getId()==R.id.radio_one){
                    score=score+1;
                }
                Intent intent = new Intent(getApplicationContext(),Quiz3.class);
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
}
