package com.example.quizapp_m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;
    private Button confirm;
    private TextView register;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLogin=findViewById(R.id.etLogin);
        textInputPassword=findViewById(R.id.etPassword);
        confirm = findViewById(R.id.btConfirm);
        register = findViewById(R.id.tvRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogin() && validatePassword()){

                        String login = textInputLogin.getEditText().getText().toString().trim();
                        String password = textInputPassword.getEditText().getText().toString().trim();

                        firebaseAuth.signInWithEmailAndPassword(login,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Connexion reussi", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), Quiz1.class);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(getApplicationContext(), "Connexion echoué"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                    Toast.makeText(getApplicationContext(), "Connexion reussi", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Quiz1.class);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
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
