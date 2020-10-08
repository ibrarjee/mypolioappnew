package com.mypolio.mypolioapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.mypolio.mypolioapp.model.Users;

public class login extends AppCompatActivity {
    private EditText Inputnumber ,Inputpassword;
    private Button loginbutton;
    private ProgressDialog loadingBar;
    private  String ParentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Inputnumber = findViewById(R.id.phoneno);
        Inputpassword= findViewById(R.id.password);
        loginbutton = findViewById(R.id.join_now);
        loadingBar = new ProgressDialog(this);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();

            }

        });
        }



    private void loginuser()
    {
        String phoneno = Inputnumber.getText().toString();
        String password = Inputpassword.getText().toString();
         if(TextUtils.isEmpty(phoneno) )
         {
            Toast.makeText(this, "please enter phoneno",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password) )
        {
            Toast.makeText(this, "please enter password",Toast.LENGTH_SHORT).show();

        }
        else
            {
                loadingBar.setTitle("Login account");
                loadingBar.setMessage("Please wait, while we check you data");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                AllowAcessToAccount(phoneno,password);
         }
    }

    private void AllowAcessToAccount(final String phoneno, final String password) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               if(dataSnapshot.child("ParentDbName").child(phoneno).exists())
               {
                   Users userData = dataSnapshot.child(ParentDbName).child(phoneno).getValue(Users.class);
                   if(userData.getPhoneno().equals(phoneno))
                   {
                       if(userData.getPassword().equals(password))
                       {
                           Toast.makeText(login.this, "Logged in sucessfully",Toast.LENGTH_SHORT).show();
                           loadingBar.dismiss();
                           Intent intent =new Intent(login.this, Home.class);
                           startActivity(intent);

                       }
                       }
                   }



               else
                   {
                       Toast.makeText( login.this, "Account does not exist",Toast.LENGTH_SHORT).show();
                       loadingBar.dismiss();
                   }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }
}