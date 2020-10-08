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

public class Teaminformation extends AppCompatActivity {
    private TextInputLayout TeamNO , Tamleader, Teammember, areainchragetf, Unioncouncilm ;
    private Button SubmitButtonTinfo;
    private ProgressDialog loadingBar;
    private DatabaseReference rootDatabaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaminformation);

        TeamNO = findViewById(R.id.teamno);
        Tamleader=  findViewById(R.id.teamleader);
        Teammember =  findViewById(R.id.teammembers);
        areainchragetf= findViewById(R.id.areainchargenTF);
        Unioncouncilm = findViewById(R.id.unionmedical);
        SubmitButtonTinfo=  findViewById(R.id.Team_button);

        loadingBar = new ProgressDialog(this);
        rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("Team information");

      SubmitButtonTinfo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String teamno = TeamNO.getEditText().getText().toString();
              String teamleader = Tamleader.getEditText().getText().toString();
              String teammembers= Teammember.getEditText().getText().toString();
              String areainchargeteaminfo =  areainchragetf.getEditText().getText().toString();
              String unioncouncilMedicaloff = Unioncouncilm.getEditText().getText().toString();

              HashMap hashMap = new HashMap();
              hashMap.put("Team NO", teamno );
              hashMap.put("Team Leader", teamleader );
              hashMap.put("Team members",teammembers );
              hashMap.put("Area Incharge", areainchargeteaminfo);
              hashMap.put("Union Council officer", unioncouncilMedicaloff);


              rootDatabaseref.child("teaminfo1").setValue(hashMap);

          }
      });
    }
}