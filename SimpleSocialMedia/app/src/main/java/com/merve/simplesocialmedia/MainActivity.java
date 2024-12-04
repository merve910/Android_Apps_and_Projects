package com.merve.simplesocialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.merve.simplesocialmedia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;
        private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        auth = FirebaseAuth.getInstance();

    }



    public void click_signup(View view)
    {
        String email = binding.editTextText.getText().toString();
        String password = binding.editPassword.getText().toString();
        if(email.equals("")|| password.equals("")){

            Toast.makeText(this,"Email or Password can not be NULL",Toast.LENGTH_SHORT).show();
        }
        else{
            auth.createUserWithEmailAndPassword(email,password).addOnCanceledListener(new OnCanceledListener() {
                @Override
                public void onCanceled() {
                    Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}