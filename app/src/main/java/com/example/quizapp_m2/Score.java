
package com.example.quizapp_m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;


import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.Direction;

public class Score extends AppCompatActivity {

    private Timer timer;
    private TextView text;
    private DonutProgress donut;
    private Button retry;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ActivityScoreBinding activityScoreBinding = DataBindingUtil.setContentView(this,R.layout.activity_score);
        setContentView(R.layout.activity_score);

        text = findViewById(R.id.tScore);
        donut = findViewById(R.id.donut_progress);
        retry = findViewById(R.id.btRetry);
        exit = findViewById(R.id.btExit);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE", 0);
        text.setText(String.valueOf(score));

       // Percent percentage = new Percent((score / 3) * 100);
       // activityScoreBinding.setPercentage(percentage);
        float newScore = (float)score;
        float cal =(float)((newScore/3)*100);
        final int percent = (int)cal;

        donut.setProgress(percent);




        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Quiz1.class);
                startActivity(intent);
             }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

      }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
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
