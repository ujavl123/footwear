package com.example.footwear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("deprecation")
public class sendotp extends AppCompatActivity {
    EditText enternumber;
    Button sendotp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendotp);

        enternumber=findViewById(R.id.input_mobile_number);
        sendotp=findViewById(R.id.sendotpBtn);

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!enternumber.getText().toString().trim().isEmpty()) {
                    if ((enternumber.getText().toString().trim()).length()==10) {
                        Intent intent=new Intent(getApplicationContext(),otp_verification.class);
//                            startActivity(new Intent(getApplicationContext(),otp_verification.class));
                        intent.putExtra("mobile",enternumber.getText().toString());
                        startActivity(intent);

                    }else {
                        Toast.makeText(getApplicationContext(), "please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Enter Mobile number", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        sendotp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!enternumber.getText().toString().isEmpty())
//                {
//                    if ((enternumber.getText().toString().trim()).length() == 10)
//                    {
//                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                                "+91" + enternumber.getText().toString(),
//                                60,
//                                TimeUnit.SECONDS,
//                                sendotp.this,
//                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                                    @Override
//                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//
//                                    }
//
//                                    @Override
//                                    public void onVerificationFailed(@NonNull FirebaseException e) {
//                                        Toast.makeText(sendotp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//
//                                    @Override
//                                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken
//                                                           forceResendingToken)
//                                    {
//                                        super.onCodeSent(s, forceResendingToken);
//
//                                        Intent intent = new Intent(getApplicationContext(), otp_verification.class);
//                                        startActivity(intent);
//                                    }
//                                }
//                        );
//                    }
//                    else {
//                        Toast.makeText(sendotp.this, "Enter valid Number", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(sendotp.this, "Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}