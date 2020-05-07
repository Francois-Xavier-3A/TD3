package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra("rarity")){
                str = intent.getStringExtra("rarity");
            }

            TextView textView = (TextView) findViewById(R.id.textView3);
            textView.setText(str);
        }
    }

    public void quitterActivity(View view) {this.finish();}
}
