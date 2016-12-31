package com.example.android.mivok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the View that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView family = (TextView) findViewById(R.id.family);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView phrases = (TextView) findViewById(R.id.phrases);
        numbers.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent numberintent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numberintent);
            };
        });

        phrases.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent phrasesintent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesintent);
            };
        });

        colors.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent colorintent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorintent);
            };
        });

        family.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                Intent familyintent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(familyintent);
            };
        });
    }
}
