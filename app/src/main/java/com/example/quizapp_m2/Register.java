package com.example.quizapp_m2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private TextInputLayout textInputName;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;
    private Button buttonRegister;

    public FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        textInputName = findViewById(R.id.etName);
        textInputEmail = findViewById(R.id.etEmail);
        textInputLogin = findViewById(R.id.etLogin);
        textInputPassword = findViewById(R.id.etPassword);
        buttonRegister=findViewById(R.id.btRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){

            startActivity(new Intent(getApplicationContext(),Quiz1.class));
            finish();
        }

        buttonRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if (!validateEmail() | !validateLogin() | !validatePassword() | !validateName()) {
                    return;
                }

                String email = textInputEmail.getEditText().getText().toString().trim();
                String password = textInputPassword.getEditText().getText().toString().trim();


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String input = "Username: " + textInputName.getEditText().getText().toString();
                            input += "\n";
                            input += "Email: " + textInputEmail.getEditText().getText().toString();
                            input += "\n";
                            input += "Login: " + textInputLogin.getEditText().getText().toString();
                            input += "\n";
                            input += "Password: " + textInputPassword.getEditText().getText().toString();

                            Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }
                    }
                });


            }
        });
    }

    private boolean validateName() {
        String usernameInput = textInputLogin.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            textInputName.setError("Login too long");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }

        private boolean validateEmail(){
            String emailInput = textInputEmail.getEditText().getText().toString().trim();

            if (emailInput.isEmpty()) {
                textInputEmail.setError("Field can't be empty");
                return false;
            } else {
                textInputEmail.setError(null);
                return true;
            }
        }

        private boolean validateLogin() {
            String usernameInput = textInputLogin.getEditText().getText().toString().trim();

            if (usernameInput.isEmpty()) {
                textInputLogin.setError("Field can't be empty");
                return false;
            } else if (usernameInput.length() > 15) {
                textInputLogin.setError("Login too long");
                return false;
            } else {
                textInputLogin.setError(null);
                return true;
            }
        }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }




}
