package com.example.sarah.math;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.sarah.math.R.id.operation;

/**
 * Created by Sarah on 27/03/2019.
 */

public class createExercises extends AppCompatActivity {

    Button Ok;
    TextView param1;
    TextView param2;
    EditText result;
    TextView SumC;
    TextView SumW;
    TextView operationType;
    Random rand= new Random();

    public int r1;
    public int r2;
   public int CorrectAns;
    public int WrongAns;

    String sign;
    String myOperation;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);

        Intent intent = getIntent();
        myOperation = intent.getStringExtra("MYOPERATION");

        Globals g = (Globals)getApplication();
         CorrectAns= g.getCorrectAnswers() ;
         WrongAns=g.getWrongAnswers();

        param1= (TextView) findViewById(R.id.firstParameter);
        param2= (TextView) findViewById(R.id.secondParameter);
        result= (EditText) findViewById(R.id.answer);
        SumC= (TextView) findViewById(R.id.correctAnswers);
        SumW= (TextView) findViewById(R.id.wrongAnswers);
        operationType= (TextView)findViewById(operation);

        SumC.setText(String.valueOf(CorrectAns));
        SumW.setText(String.valueOf(WrongAns));


       // operationType.setText(myOperation);

        newExe(myOperation);
    }


    public void newExe (String type){



    switch (type){

        case "+":
            sign= "+";
            operationType.setText(sign);

            r1 = rand.nextInt(11);
            r2 = rand.nextInt(11);
            break;

        case "-":
            sign= "-";
            operationType.setText(String.valueOf(sign));

            r1 = rand.nextInt(20-10)+10;
            r2 = rand.nextInt(10);
            break;

        case "x":
            sign= "x";
            operationType.setText(String.valueOf(sign));

            r1 = rand.nextInt(11);
            r2 = rand.nextInt(13);
            break;

        default:
            int r= rand.nextInt(3);
            String chosenOperation;
            if(r==0){chosenOperation="+";}
            else if(r==1){chosenOperation="-";}
            else chosenOperation="x";
            newExe(chosenOperation);

    }
        param1.setText(String.valueOf(r1));
        param2.setText(String.valueOf(r2));

    }


    public void confirmAnswer (View view){

        String Answer= result.getText().toString().trim();

        if (!Answer.isEmpty()) {

            int a = Integer.parseInt(Answer);



            if ((a == (r1 + r2) && sign=="+") || (a == (r1 - r2) && sign=="-")||(a == (r1 * r2) && sign=="x") ){


                CorrectAns = CorrectAns + 1;
                ((Globals) this.getApplication()).setCorrectAnswers(CorrectAns);

                SumC.setText(String.valueOf(CorrectAns));

                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct);
                mediaPlayer.start();

                result.setText("");

                long time2= System.currentTimeMillis();


                if ( time2 < ((Globals) this.getApplication()).getTime()+ 600000) {

                    newExe(myOperation);
                }
                else {


                    Intent intent = new Intent(this, Finish.class);

                    Bundle bundleC = new Bundle();
                    Bundle bundle1W = new Bundle();
                    bundleC.putString("ResultC", String.valueOf(CorrectAns));
                    bundle1W.putString("ResultW",String.valueOf(WrongAns));
                    intent.putExtras(bundleC);
                    intent.putExtras(bundle1W);
                    startActivity(intent);
                }

            }
            else {
                WrongAns = WrongAns + 1;
                ((Globals) this.getApplication()).setWrongAnswers(WrongAns);

                SumW.setText(String.valueOf(WrongAns));
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wrong);
                mediaPlayer.start();
                result.setText("");
            }

        }
        else {

            Toast.makeText(this, "Please Enter a number", Toast.LENGTH_LONG).show();
        }

    }
}
