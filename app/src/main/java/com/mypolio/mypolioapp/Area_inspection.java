package com.mypolio.mypolioapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Area_inspection extends AppCompatActivity {
    private TextInputLayout Inchrage_name , Current_houseno, Current_Vaccinated_children,Used_coils , Current_missing_children, current_time;
    private Button inspection_SubmitButton;
    private ProgressDialog loadingBar;
    private DatabaseReference rootDatabaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_inspection);

        Inchrage_name  = findViewById(R.id.areaincharge);
        Current_houseno=  findViewById(R.id.Currenthouse);
        Current_Vaccinated_children =  findViewById(R.id.vaccinatedchildren);
        Used_coils = findViewById(R.id.usedvaccinecoil);
        Current_missing_children= findViewById(R.id.Missingchildren);
        current_time=  findViewById(R.id.Visitingtime);
        inspection_SubmitButton =(Button) findViewById(R.id.button_area);
        loadingBar = new ProgressDialog(this);

        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Area_inspection");
        inspection_SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Inchragename = Inchrage_name.getEditText().getText().toString();
                String Team_currenthouse = Current_houseno.getEditText().getText().toString();
                String currentvaccinated_children = Current_Vaccinated_children.getEditText().getText().toString();
                String usedcoils=  Used_coils .getEditText().getText().toString();
                String currentmissing_children = Current_missing_children.getEditText().getText().toString();
                String currenttime=  current_time.getEditText().getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("Inchrage Name", Inchragename);
                hashMap.put("Current_house", Team_currenthouse);
                hashMap.put("Vaccinated_children", currentvaccinated_children);
                hashMap.put("NO of used coil", usedcoils );
                hashMap.put("No of missing children",currentmissing_children );
                hashMap.put("Current time",currenttime );

                rootDatabaseref.child("firstvisit").setValue(hashMap);

            }
        });
    }
}