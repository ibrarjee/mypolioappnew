package com.mypolio.mypolioapp;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class Data_collection extends AppCompatActivity {
    private TextInputLayout Houseno , Totalcouples, Vaccinated_children, Totalchildren, agebelow12m, agebelow9y;
    private Button SubmitButton;
    private ProgressDialog loadingBar;
    private DatabaseReference rootDatabaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);

      Houseno = findViewById(R.id.housenumber);
        Totalcouples=  findViewById(R.id.Couples);
        Vaccinated_children =  findViewById(R.id.vaccinated);
        Totalchildren= findViewById(R.id.childern);
        agebelow12m = findViewById(R.id.Ageunder9months);
        agebelow9y=  findViewById(R.id.Ageunder9years);
        SubmitButton =(Button) findViewById(R.id.data_submit_button);
        loadingBar = new ProgressDialog(this);
       rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("polioData");

     SubmitButton.setOnClickListener(new View.OnClickListener() {
         @RequiresApi(api = Build.VERSION_CODES.KITKAT)
         @Override
         public void onClick(View view) {

             String Houseno_data = Houseno.getEditText().getText().toString();
             String Totalcouples_data = Objects.requireNonNull(Totalcouples.getEditText()).getText().toString();
             String Vaccinated_children_data = (Vaccinated_children.getEditText().getText().toString());
             String Totalchildren_data = Objects.requireNonNull(Totalchildren.getEditText()).getText().toString();
             String agebelow12month_data = agebelow12m.getEditText().getText().toString();
             String agebelow9y_data =  agebelow9y.getEditText().getText().toString();

             HashMap hashMap = new HashMap();
             hashMap.put("Houseno", Houseno_data );
             hashMap.put("Couples", Totalcouples_data );
             hashMap.put("total_children", Totalchildren_data );
             hashMap.put("Vaccinated_children", Vaccinated_children_data );
             hashMap.put("agebelow12m",agebelow12month_data );
             hashMap.put("agebelow9y", agebelow9y_data);

              rootDatabaseref.child("houseno1").setValue(hashMap);

         }

     });}}







