package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");

        EditText Edit1,Edit2;
        TextView textview;
        Button BtnAdd, BtnSub, BtnMul, BtnDiv;
        final Integer[] result = new Integer[1];
        final String[] num1 = new String[1];
        final String[] num2 = new String[1];
        Button[] numButtons = new Button[10];
        Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,R.id.BtnNum5,R.id.BtnNum6,
                R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};
        int i;

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        textview = (TextView) findViewById(R.id.textView);
        BtnAdd = (Button) findViewById(R.id.BtnAdd);
        BtnSub = (Button) findViewById(R.id.BtnSub);
        BtnMul = (Button) findViewById(R.id.BtnMul);
        BtnDiv = (Button) findViewById(R.id.BtnDiv);


        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1[0] = Edit1.getText().toString();
                num2[0] = Edit2.getText().toString();
                result[0] = Integer.parseInt(num1[0]) + Integer.parseInt(num2[0]);
                textview.setText("계산 결과 :" + result[0].toString());
                return;
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1[0] = Edit1.getText().toString();
                num2[0] = Edit2.getText().toString();
                result[0] = Integer.parseInt(num1[0]) - Integer.parseInt(num2[0]);
                textview.setText("계산 결과 :" + result[0].toString());
                return;

            }
        });

        BtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1[0] = Edit1.getText().toString();
                num2[0] = Edit2.getText().toString();
                result[0] = Integer.parseInt(num1[0]) * Integer.parseInt(num2[0]);
                textview.setText("계산 결과 :" + result[0].toString());
                return;

            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1[0] = Edit1.getText().toString();
                num2[0] = Edit2.getText().toString();
                result[0] = Integer.parseInt(num1[0]) / Integer.parseInt(num2[0]);
                textview.setText("계산 결과 :" + result[0].toString());
                return;

            }
        });

        for (i=0; i < numBtnIDs.length; i++); {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i=0; i < numBtnIDs.length; i++); {
            final int index;
            index = i;

        numButtons[index].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Edit1.isFocused()==true) {
                    num1[0] = Edit1.getText().toString() + numButtons[index].getText().toString();
                    Edit1.setText(num1[0]);
                } else if (Edit2.isFocused()==true) {
                    num2[0] = Edit2.getText().toString() + numButtons[index].getText().toString();
                    Edit1.setText(num2[0]);
                } else {
                    Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요",  Toast.LENGTH_SHORT).show();
                }

                }
            });
        }
    }
}