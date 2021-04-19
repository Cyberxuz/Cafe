package com.example.hotcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    TextInputEditText textInputEditText1,textInputEditText2,textInputEditText3,textInputEditText4,textInputEditText5;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
        progressBar=findViewById(R.id.progressbar);
        button=findViewById(R.id.buttonregister);
        textInputEditText1=findViewById(R.id.edittext11);
        textInputEditText2=findViewById(R.id.edittext22);
        textInputEditText3=findViewById(R.id.edittext33);
        textInputEditText4=findViewById(R.id.edittext44);
        textInputEditText5=findViewById(R.id.edittext55);

        firebaseAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(textInputEditText1.getText().toString(), textInputEditText4.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(MainActivity2.this, "Registratsiya bo`lding axir", Toast.LENGTH_SHORT).show();

                        Register userRegister = new Register();
                        userRegister.setEmail(textInputEditText1.getText().toString());
                        userRegister.setUsername(textInputEditText2.getText().toString());
                        userRegister.setPhone(textInputEditText3.getText().toString());
                        userRegister.setPassword(textInputEditText4.getText().toString());
                        databaseReference.push().setValue(userRegister);
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(MainActivity2.this, MainActivity.class));

                    }
                });

            }
        });
    }
}