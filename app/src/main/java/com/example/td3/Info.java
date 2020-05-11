package com.example.td3;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Info extends AppCompatActivity {

    private static final String TAG = "Info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();

    }

    private void set(String textRarity, String textName, String textText, String textRace, String Picture,
                     String textCiv, String textType, String textID, String textPower, String textIllustrator, String textSet, String textCost){

        TextView name = findViewById(R.id.tv1);
        name.setText(textName);

        TextView name2 = findViewById(R.id.tv2);
        name2.setText("Level: " +textRarity);

        TextView name3 = findViewById(R.id.tv3);
        name3.setText("Civilization: " +textCiv);

        TextView name4 = findViewById(R.id.tv4);
        name4.setText("Type: " +textType);

        TextView name5 = findViewById(R.id.tv5);
        name5.setText("Race: " +textRace);

        TextView name6 = findViewById(R.id.tv6);
        name6.setText("Cost: " +textCost);

        TextView name7 = findViewById(R.id.tv7);
        name7.setText("Power: " +textPower);

        TextView name8 = findViewById(R.id.tv8);
        name8.setText(textText);

        TextView name9 = findViewById(R.id.tv9);
        name9.setText("Illustrator: " +textIllustrator);

        TextView name10 = findViewById(R.id.tv10);
        name10.setText(textSet);

        TextView name11 = findViewById(R.id.tv11);
        name11.setText("Number: " + textID);

        ImageView name12 = findViewById(R.id.image);
        Picasso.with(this)
                .load(Picture)
                .into(name12);
        //name5.setImageURI(picture);
        //image.setImageResource(Integer.parseInt(Picture));

    }

    private void getIncomingIntent() {
            Log.d(TAG, "getIncommingIntent: checking for incomming intents.");

            if (getIntent().hasExtra("rarity") && getIntent().hasExtra("name") && getIntent().hasExtra("text") &&
                    getIntent().hasExtra("race") && getIntent().hasExtra("picture") && getIntent().hasExtra("civilization")
                    && getIntent().hasExtra("type") && getIntent().hasExtra("id") && getIntent().hasExtra("cost") && getIntent().hasExtra("illustrator")
                    && getIntent().hasExtra("set") && getIntent().hasExtra("cost")){

                Log.d(TAG, "getIncomingIntent: found intent extras");
                {
                    String textName = getIntent().getStringExtra("name");
                    String textID = getIntent().getStringExtra("id");
                    String textCiv = getIntent().getStringExtra("civilization");
                    String textRarity = getIntent().getStringExtra("rarity");
                    String textType = getIntent().getStringExtra("type");
                    String textText = getIntent().getStringExtra("text");
                    String textRace = getIntent().getStringExtra("race");
                    String textPower = getIntent().getStringExtra("power");
                    String Picture = getIntent().getStringExtra("picture");
                    String textIllustrator = getIntent().getStringExtra("illustrator");
                    String textSet = getIntent().getStringExtra("set");
                    String textCost = getIntent().getStringExtra("cost");

                    set(textRarity, textName, textText, textRace, Picture, textCiv, textType, textID, textPower, textIllustrator, textSet, textCost);
                }
            }
    }
}