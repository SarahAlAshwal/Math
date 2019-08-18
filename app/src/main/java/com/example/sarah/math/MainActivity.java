package com.example.sarah.math;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    //createExercises newExercises = new createExercises();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addition (View view){

        String message="+";


        Intent intent= new Intent(MainActivity.this,createExercises.class);
        intent.putExtra("MYOPERATION",message);
        startActivity(intent);

    }

    public void soustraction (View view){


        String message="-";


        Intent intent= new Intent(MainActivity.this,createExercises.class);
        intent.putExtra("MYOPERATION",message);
        startActivity(intent);
    }

    public void multiplication (View view){

        String message="x";


        Intent intent= new Intent(MainActivity.this,createExercises.class);
        intent.putExtra("MYOPERATION",message);
        startActivity(intent);
    }

    public void mix (View view){

        String message="m";


        Intent intent= new Intent(MainActivity.this,createExercises.class);
        intent.putExtra("MYOPERATION",message);
        startActivity(intent);


    }
}
