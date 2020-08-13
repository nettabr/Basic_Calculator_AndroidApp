package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button emailBtn;
    private  Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         Button emailBtn = findViewById(R.id.emailBtn);
         Button shareBtn = findViewById(R.id.shareBtn);

            emailBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendMail();
                }
            });

            shareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       Intent share = new Intent(Intent.ACTION_SEND);
                       share.setType("text/plain");
                       String shareBody = "Share us";
                       String shareSubject = "Thanks for the support";
                       share.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                       share.putExtra(Intent.EXTRA_TEXT,shareBody);
                       startActivity(Intent.createChooser(share,"Share using"));

                }
            });
    }


    public void sendMail(){
        Intent intent = new Intent(this, EMailActivity.class);
        startActivity(intent);
    }
}