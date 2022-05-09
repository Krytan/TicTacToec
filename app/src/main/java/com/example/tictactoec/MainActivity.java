package com.example.tictactoec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private List<int[]> Combinations = new ArrayList<>();
    private List<Button> buttons;
    private static final int[] BTN_IDS = {
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<Button>(BTN_IDS.length);

        for(int id: BTN_IDS){
            Button button = findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);

            if (id < 7)
            { Combinations.add(new int[]{0,1,2});}
        }




    }

    @Override
    public void onClick(View view) {

    }
}