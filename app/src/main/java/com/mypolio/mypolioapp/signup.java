package com.mypolio.mypolioapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class signup extends AppCompatActivity {
    TextInputLayout regName, regUsername, regEmail, regPhoneNO, regPassword ;
    Button regbtn ;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        regName = findViewById(R.id.fullname);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPhoneNO = findViewById(R.id.phoneno);
        regPassword = findViewById(R.id.password);
        regbtn = findViewById(R.id.button);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");

                // get all value
                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneno = regPhoneNO.getEditText().getText().toString();
                String password = (regPassword.getEditText()).getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneno, password);
                reference.child(phoneno).setValue(helperClass);

            }
        });
    }
}
