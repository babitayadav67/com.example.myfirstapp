package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
TextView textView;
int milliseconds=0;
boolean IsBuilding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        textView=(TextView) findViewById(R.id.textView4);
        startTimer();

    }
    public void onClickStart(View view){
IsBuilding=true;
    }
    public void onClickStop(View view){
IsBuilding=false;
    }
    public void onClickReset(View view){
        IsBuilding=false;
milliseconds=0;
    }
    public void startTimer(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

int s=milliseconds%60;
int m=milliseconds/60;
int h=m/60;
if(IsBuilding){
    milliseconds++;
}

String formatString=String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);

textView.setText(formatString);
handler.postDelayed(this,1000);

            }
        };
        handler.post(runnable);
    }
}