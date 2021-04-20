package com.example.hotcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextInputEditText textInputEditText1, textInputEditText2;
    Button button;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        textInputEditText1 = findViewById(R.id.edittext1);
        textInputEditText2 = findViewById(R.id.edittext2);

        firebaseAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signInWithEmailAndPassword(textInputEditText1.getText().toString(), textInputEditText2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if (textInputEditText1.length()>13 && textInputEditText2.length()>8){ }else {
//                            if (textInputEditText1.length()<13){
//                                textInputEditText1.setError("Email xato");
//                            }
//                            if (textInputEditText1.length()<8){
//                                textInputEditText1.setError("Pasword xato");
//                            }
//                        }
                        if (task.isSuccessful()
                        ) {
                            startActivity(new Intent(MainActivity.this, MainActivity3.class));
                            finish();
                        } else {

                            Toast.makeText(MainActivity.this, "Error Register", Toast.LENGTH_SHORT).show();
                            if (textInputEditText1.length()<13){
                                textInputEditText1.setError("Email xato");
                            }
                            if (textInputEditText2.length()<8){
                                textInputEditText2.setError("Pasword xato");
                            }
                        }

                    }
                });
            }
        });
    }

    public void register(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));

    }
}