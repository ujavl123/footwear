package com.example.footwear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class otp_verification extends AppCompatActivity {

    EditText    inputnum1,inputnum2,inputnum3,inputnum4,inputnum5,inputnum6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

//        Button veryfybtn=findViewById(R.id.getotp);
//        inputnum1=findViewById(R.id.inputotp1);
//        inputnum2=findViewById(R.id.inputotp2);
//        inputnum3=findViewById(R.id.inputotp3);
//        inputnum4=findViewById(R.id.inputotp4);
//        inputnum5=findViewById(R.id.inputotp5);
//        inputnum6=findViewById(R.id.inputotp6);

        TextView textView=findViewById(R.id.viewphone);
        textView.setText(String.format("+91 %s",getIntent().getStringExtra("mobile")));
    }
}