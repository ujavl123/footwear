package com.example.footwear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otp_verification extends AppCompatActivity {

    EditText    inputnum1,inputnum2,inputnum3,inputnum4,inputnum5,inputnum6;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        otp =getIntent().getStringExtra(otp);


        Button veryfybtn=findViewById(R.id.getotp);
        inputnum1=findViewById(R.id.inputotp1);
        inputnum2=findViewById(R.id.inputotp2);
        inputnum3=findViewById(R.id.inputotp3);
        inputnum4=findViewById(R.id.inputotp4);
        inputnum5=findViewById(R.id.inputotp5);
        inputnum6=findViewById(R.id.inputotp6);


        TextView textView=findViewById(R.id.viewphone);
        textView.setText(String.format("+91 %s",getIntent().getStringExtra("mobile")));
        veryfybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputnum1.getText().toString().trim().isEmpty()&& !inputnum2.getText().toString().trim().isEmpty()&& !inputnum3.getText().toString().trim().isEmpty()&& !inputnum4.getText().toString().trim().isEmpty()&&!inputnum5.getText().toString().trim().isEmpty()&& !inputnum6.getText().toString().trim().isEmpty())
                {
                     String  entercode= inputnum1.getText().toString()+
                                        inputnum2.getText().toString()+
                                                inputnum3.getText().toString()+
                                        inputnum5.getText().toString()+
                                        inputnum6.getText().toString();

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                                entercode,otp

                        );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Intent intent= new Intent(getApplicationContext(),Homepage.class);
                                    startActivity(intent);

                                }
                            });





                }
                else
                {
                    Toast.makeText(otp_verification.this, "all enternumber", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}