package com.mypolio.mypolioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private Button StartButton , Area_InchargeButton , ShowsaveData,Teaminfo , Button_areainfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StartButton = (Button) findViewById(R.id.button_start);

      Area_InchargeButton= (Button) findViewById(R.id.button_incharge);
       ShowsaveData= (Button) findViewById(R.id.button_saved);
       Teaminfo= (Button) findViewById(R.id.button_teaminfo);
        Button_areainfo= (Button) findViewById(R.id.button_areainfo);


       StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Data_collection.class);
                startActivity(intent);
            }
        });
        Area_InchargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Area_inspection.class);
                startActivity(intent);
            }
        });
        Teaminfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, Teaminformation.class);
                startActivity(intent);
            }
        });
        Button_areainfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this, areainformation.class);
                startActivity(intent);
            }
        });



    }
    private void startActivity() {
    }
}