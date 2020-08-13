package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.SoftReference;

public class MainActivity extends AppCompatActivity {

    private  Button aboutBTN;
    private Button one;
    private  Button two;
    private  Button three;
    private  Button four;
    private  Button five;
    private  Button six;
    private  Button seven;
    private  Button eight;
    private  Button nine;
    private  Button zero;
    private  Button add;
    private  Button sub;
    private  Button mul;
    private  Button div;
    private  Button equal;
    private TextView input;
    private TextView result;
    private Button clear;
    //constant variables for calculations
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';

    private  double val1 = Double.NaN;
    private  double val2;
    private  char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutBtn = findViewById(R.id.aboutBtn);

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout();
            }
        });

        setUIView();

        //setting buttons to concat view
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText().toString()+"9");
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ADDITION;
                result.setText(String.valueOf(val1)+"+");
                input.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                input.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=MULTIPLICATION;
                result.setText(String.valueOf(val1)+"*");
                input.setText(null);
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=DIVISION;
                result.setText(String.valueOf(val1)+"/");
                input.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=EQU;
                result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
                input.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().length()>0){
                    CharSequence name = input.getText().toString();
                    input.setText(name.subSequence(0,name.length()-1));
                }
                else{
                     val1=Double.NaN;
                     val2=Double.NaN;
                     input.setText(null);
                     result.setText(null);
                }
            }
        });
    }

    private void  setUIView(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnPlus);
        sub = (Button)findViewById(R.id.btnMinus);
        mul = (Button)findViewById(R.id.btnMult);
        div = (Button)findViewById(R.id.btnDivide);
        equal = (Button)findViewById(R.id.btnEquel);
        clear = (Button)findViewById(R.id.btnCLR);
        input =(TextView)findViewById(R.id.txtInput);
        result =(TextView)findViewById(R.id.txtRes);
    }

    private void compute(){
        if (!Double.isNaN(val1)){
            val2=Double.parseDouble(input.getText().toString());
            switch (ACTION){
                case ADDITION:
                    val1 = val1+val2;
                    break;
                case  SUBTRACTION:
                    val1 = val1-val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1*val2;
                    break;
                case  DIVISION:
                    val1 = val1/val2;
                break;
                case  EQU:
                    break;
            }
        }
        else {
            val1 = Double.parseDouble(input.getText().toString());
        }
    }

    //about section
    public  void  openAbout(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}