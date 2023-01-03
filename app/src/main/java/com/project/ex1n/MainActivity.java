package com.project.ex1n;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.ex1n.databinding.ActivityMainBinding;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateData();
            }
        });
    }

    private String username="",password="";
    private void validateData() {

        final EditText nametext=(EditText)findViewById(R.id.et_username);
       username = binding.etUsername.getText().toString().trim();
        password = binding.etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {

            Toast.makeText(this, "enter username", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();

        } else if(username.equals("m") && password.equals("2001")) {

            String name=nametext.getText().toString();
            Intent intent=new Intent(getApplicationContext(),Calculator.class);
            intent.putExtra("myname",name);
            startActivity(intent);


        }
        else {
            Toast.makeText(this, "username or password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}