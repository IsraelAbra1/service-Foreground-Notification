package com.example.serviceforegroundnotification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = (TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        String str = intent.getExtras().getString("key");
        tv.setText(str);


        Intent i = new Intent(this,PushService.class);
        stopService(i);
    }
}