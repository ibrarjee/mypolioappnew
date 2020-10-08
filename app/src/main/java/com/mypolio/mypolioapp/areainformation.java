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

public class areainformation extends AppCompatActivity {
    private TextInputLayout Unionconcil, Zone,tehsil, district, today_area, Campaing_day;
    private Button Areainfo_SubmitButton;
    private ProgressDialog loadingBar;
    private DatabaseReference rootDatabaseref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areainformation);

       Unionconcil = findViewById(R.id.unioncouncil);
       Zone=  findViewById(R.id.zone);
       tehsil =  findViewById(R.id.tehsil);
        district= findViewById(R.id.district);
        today_area = findViewById(R.id.todayarea);
        Campaing_day=  findViewById(R.id.campaingday);

        loadingBar = new ProgressDialog(this);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Area information");
        Areainfo_SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UnionConcil = Unionconcil.getEditText().getText().toString();
                String  zone1 = Zone.getEditText().getText().toString();
                String Tehsil= tehsil.getEditText().getText().toString();
                String District =  district.getEditText().getText().toString();
                String Today_area = today_area.getEditText().getText().toString();
                String Campaign_day1 = Campaing_day.getEditText().getText().toString();


                HashMap hashMap = new HashMap();
                hashMap.put("Union Council", UnionConcil );
                hashMap.put("Zone", zone1 );
                hashMap.put("Tehsil", Tehsil );
                hashMap.put("District",District );
                hashMap.put("Today_Area", Today_area);
                hashMap.put("Campaign_Day", Campaign_day1);


                rootDatabaseref.child("areainfo1").setValue(hashMap);
            }
        });
    }
}