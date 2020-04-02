package com.example.quizapp_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLogin=findViewById(R.id.etLogin);
        textInputPassword=findViewById(R.id.etPassword);

        textInputLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateLogin() && validatePassword())
                    if((textInputLogin.getEditText().getText().toString().equals("baudouin") | textInputLogin.getEditText().getText().toString().equals("amine.bouarraf@gmail.com")) &&
                            textInputPassword.getEditText().getText().toString().equals("1234")){
                        Toast.makeText(getApplicationContext(),"Connexion reussi",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),Quiz1.class);
                        startActivity(intent);
                    }
            }
        });
    }

    private boolean validateLogin() {
        String login = textInputLogin.getEditText().getText().toString().trim();

        if (login.isEmpty()) {
            textInputLogin.setError("Field can't be empty");
            return false;
        } else {
            textInputLogin.setError(null);
            return true;
        }
    }

        private boolean validatePassword() {
            String password = textInputPassword.getEditText().getText().toString().trim();

            if (password.isEmpty()) {
                textInputPassword.setError("Field can't be empty");
                return false;
            } else {
                textInputPassword.setError(null);
                return true;
            }
        }
}
