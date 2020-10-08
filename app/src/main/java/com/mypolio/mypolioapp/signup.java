package com.mypolio.mypolioapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.Validation;

import java.util.HashMap;
import java.util.Objects;

public class signup extends AppCompatActivity {
    TextInputLayout regName,  regPhoneNO, regPassword ;
    Button regbtn ;
    private ProgressDialog loadingBar;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        regName = findViewById(R.id.fullname);
        regPhoneNO = findViewById(R.id.phoneno);
        regPassword = findViewById(R.id.password);
        regbtn = findViewById(R.id.button);
        loadingBar = new ProgressDialog(this);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccont();

            }
        });
    }

    private void CreateAccont() {
        String name = regName.getEditText().getText().toString();
        String phoneno = regPhoneNO.getEditText().getText().toString();
        String password = (regPassword.getEditText()).getText().toString();
         if(TextUtils.isEmpty(name) ){
          Toast.makeText(this, "please enter name",Toast.LENGTH_SHORT).show();
         }

       else if(TextUtils.isEmpty(phoneno) ){
            Toast.makeText(this, "please enter phoneno",Toast.LENGTH_SHORT).show();
        }
       else if(TextUtils.isEmpty(password) ){
            Toast.makeText(this, "please enter password",Toast.LENGTH_SHORT).show();

    }
       else {
           loadingBar.setTitle("Create account");
           loadingBar.setMessage("Please wait, while we check you data");
           loadingBar.setCanceledOnTouchOutside(false);
           loadingBar.show();
             Validatephonenumber(name,phoneno,password);

         }
}

    private void Validatephonenumber(final String name, final String phoneno, final String password) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.child("users").child(phoneno).exists())
                {
                    HashMap<String, Object> userdatamap =new  HashMap <>();
                    userdatamap.put("name",name);
                    userdatamap.put("phoneno",phoneno);
                    userdatamap.put("password",password);
                    Rootref.child("users").child(phoneno).updateChildren(userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)

                            {
                                if(task.isSuccessful())
                                {
                                Toast.makeText(signup.this, "your account has been created",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent =new Intent(signup.this, login.class);
                                startActivity(intent);
                                }
                                else {
                                    Toast.makeText(signup.this, "error occur",Toast.LENGTH_SHORT).show();
                                }
                            }


                            });

            }
                else{
                    Toast.makeText(signup.this, "this" + phoneno + "already exist", Toast.LENGTH_LONG).show();
                    loadingBar.dismiss();
                    Intent intent =new Intent(signup.this, MainActivity.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    }
