package com.example.sarah.math;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sarah on 07/04/2019.
 */

public class Finish extends AppCompatActivity {

    TextView FinalCorrect;
    TextView FinalWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        FinalCorrect = (TextView)findViewById(R.id.FinalC);
        FinalWrong= (TextView)findViewById(R.id.FinalW);


        Intent intent= getIntent();
        Bundle bundle1 = intent.getExtras();
        String Result1= bundle1.getString("ResultC");
        Bundle bundel2 = intent.getExtras();
        String Result2= bundel2.getString("ResultW");

        FinalCorrect.setText(Result1);
        FinalWrong.setText(Result2);
    }
}
