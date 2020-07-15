package com.example.quizapp_m2;

 import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseUtil {

    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private static FirebaseUtil firebaseUtil;
    public static FirebaseAuth mFirebaseAuth;
    public static FirebaseAuth.AuthStateListener mAuthStateListener;


    private FirebaseUtil(){};

    public static void openFbReference(String ref) {
        if (firebaseUtil == null) {
            firebaseUtil = new FirebaseUtil();
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            mFirebaseAuth = FirebaseAuth.getInstance();
             mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                 @Override
                 public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                 }
             };
        }

        mDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }

    public static void attachListener(){

        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
    public static void detachListener(){

        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

}
