package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointA = 0;
    int pointB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void threePointerA(View view) {
        pointA = pointA + 3;
        displayPointA(pointA);
    }

    public void twoPointerA(View view) {
        pointA = pointA + 2;
        displayPointA(pointA);
    }

    public void onePointerA(View view) {
        pointA = pointA + 1;
        displayPointA(pointA);
    }

    public void threePointerB(View view) {
        pointB = pointB + 3;
        displayPointB(pointB);
    }

    public void twoPointerB(View view) {
        pointB = pointB + 2;
        displayPointB(pointB);
    }

    public void onePointerB(View view) {
        pointB = pointB + 1;
        displayPointB(pointB);
    }

    public void reset(View view) {
        pointA = 0;
        pointB = 0;
        displayPointA(pointA);
        displayPointB(pointB);
    }

    public void displayPointA(int point){
        TextView threepoints = (TextView) findViewById(R.id.pointA_text_view);
        threepoints.setText(""+point);
    }

    public void displayPointB(int point){
        TextView threepoints = (TextView) findViewById(R.id.pointB_text_view);
        threepoints.setText(""+point);
    }
}
