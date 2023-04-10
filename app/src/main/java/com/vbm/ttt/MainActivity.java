package com.vbm.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ErrorTagMain";

    boolean isTurn;

    ArrayList<Integer> red = new ArrayList<>();
    ArrayList<Integer> redInt = new ArrayList<>();

    ArrayList<Integer> white = new ArrayList<>();
    ArrayList<Integer> whiteInt = new ArrayList<>();


    int counter;
    int flag = 0;

    int colorCounterP = 1;
    int colorCounterC = 2;
    boolean isPlayer = false;
    boolean isCom = false;

    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;

    int[] myIntArray = new int[8];
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    HashMap<String , Integer> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id._1);
        txt2 = findViewById(R.id._2);
        txt3 = findViewById(R.id._3);
        txt4 = findViewById(R.id._4);
        txt5 = findViewById(R.id._5);
        txt6 = findViewById(R.id._6);
        txt7 = findViewById(R.id._7);
        txt8 = findViewById(R.id._8);
        txt9 = findViewById(R.id._9);
         this.isPlayer = true;

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,1);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,2);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,3);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,4);
            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,5);
            }
        });

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,6);
            }
        });

        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,7);
            }
        });

        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,8);
            }
        });

        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marker(view,9);
            }
        });

    }

    private String turnShifter(){
        if(isTurnTime() == true){
            isPlayer = true;
            isCom = false;
            return "player turn";
        }
        else {
            isPlayer = false;
            isCom = true;
            return "com turn";
        }
    }

    private void marker(View view, int flag){
        if (flag !=0) {
            toggle(view, flag);
            integerArrayList.add(flag);

            Log.i(TAG, "marker: integerArrayList" + integerArrayList.size());
            for (Integer i: integerArrayList) {
                Log.i(TAG, "marker: " + i + "\n");
            }
            Log.i(TAG,   "\n");
        }else {Toast.makeText(MainActivity.this,"block already clicked",Toast.LENGTH_SHORT).show();
            Log.i(TAG, "marker: in toast block");}
    }

    private int toss(){
        Random r = new Random();
        int i = r.nextInt(1);
        i +=1;
        return i;
    }

    private boolean isTurnTime(){
        int i = toss();
        if (i == 1){
            return true;
        }else return false;
    }

    private void toggle(View view, int flag) {
        counter ++;
        Log.i(TAG, "toggle: counter" + counter);
        if (isPlayer){
            hashMap.put("red",flag);
            whiteInt.add(flag);
            view.setBackgroundColor(getResources().getColor(R.color.red));
            this.isPlayer = false;
            view.setEnabled(false);
            nervousSystem();
        }else {
            view.setBackgroundColor(getResources().getColor(R.color.white));
            hashMap.put("white",flag);
            redInt.add(flag);
            this.isPlayer =true;
            view.setEnabled(false);
            nervousSystem();

        }
    }

    private void nervousSystem(){
        String key = null;
        Integer value = null;
        for (Map.Entry<String , Integer> h: hashMap.entrySet()) {
             key = h.getKey();
             value = h.getValue();
            if (key == "red"){
                this.red.add(value);
            }else{
                this.white.add(value);
            }

//            Log.i(TAG, "nervousSystem: key : " + key + "value : " + value);

            Log.d(TAG, "nervousSystem: " + "<<<< ------------ ---------  >>>");

            for (Integer a: whiteInt) {
                Log.i(TAG, "nervousSystem: whiteMoves : " + a  + " size : " + white.size());
            }

            Log.i(TAG, "nervousSystem: " + "$$$$$$$$$$$$$$");

            for (Integer a: redInt) {
                Log.i(TAG, "nervousSystem: redMoves : " + a + " size : " + redInt.size());
            }

            Log.d(TAG, "nervousSystem: " + "<<<< **********************  >>>");
        }
      /*  if (key.equalsIgnoreCase("red") ){
            this.red.add(value);
        }else{
            this.white.add(value);
        }*/
//        Log.i(TAG, "nervousSystem: red.size()" + red.size());
//        Log.i(TAG, "nervousSystem: white.size()" + white.size());

       /* for (Integer i : red) {
            Log.i(TAG, "nervousSystem: red array " + i + "\n");
        }
        Log.i(TAG,  "\n");
        for (Integer i : white) {
            Log.i(TAG, "nervousSystem: white array " + i + "\n");
        }*/
    }




}