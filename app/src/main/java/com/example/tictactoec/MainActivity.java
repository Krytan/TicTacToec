package com.example.tictactoec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] Boxpos = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerturn = 1;
    private int totalboxes = 1;

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
            R.id.btn9,
            R.id.btnreset
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<Button>(BTN_IDS.length);

        for (int id : BTN_IDS) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }
        Combinations.add(new int[]{0, 1, 2});
        Combinations.add(new int[]{3, 4, 5});
        Combinations.add(new int[]{6, 7, 8});
        Combinations.add(new int[]{0, 3, 6});
        Combinations.add(new int[]{1, 4, 7});
        Combinations.add(new int[]{2, 5, 8});
        Combinations.add(new int[]{2, 4, 6});
        Combinations.add(new int[]{0, 4, 8});
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (BoxSelected(0)) {
                    Action(buttons.get(0), 0);

                }
                break;
            case R.id.btn2:
                if (BoxSelected(1)) {
                    Action(buttons.get(1), 1);
                }
                break;
            case R.id.btn3:
                if (BoxSelected(2)) {
                    Action(buttons.get(2), 2);
                }

                break;
            case R.id.btn4:
                if (BoxSelected(3)) {
                    Action(buttons.get(3), 3);
                }

                break;

            case R.id.btn5:
                if (BoxSelected(4)) {
                    Action(buttons.get(4), 4);
                }

                break;

            case R.id.btn6:
                if (BoxSelected(5)) {
                    Action(buttons.get(5), 5);
                }

                break;

            case R.id.btn7:
                if (BoxSelected(6)) {
                    Action(buttons.get(6), 6);
                }

                break;

            case R.id.btn8:
                if (BoxSelected(7)) {
                    Action(buttons.get(7), 7);
                }

                break;

            case R.id.btn9:
                if (BoxSelected(8)) {
                    Action(buttons.get(8), 8);
                }

                break;
            case R.id.btnreset:
                Boxpos = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                playerturn = 1;
                totalboxes = 1;
                buttons.get(0).setText(" ");
                buttons.get(1).setText(" ");
                buttons.get(2).setText(" ");
                buttons.get(3).setText(" ");
                buttons.get(4).setText(" ");
                buttons.get(5).setText(" ");
                buttons.get(6).setText(" ");
                buttons.get(7).setText(" ");
                buttons.get(8).setText(" ");


                break;
        }

    }

    private void Action(Button button, int SelectedBox) {
        Boxpos[SelectedBox] = playerturn;

        if (playerturn == 1) {
            button.setText("X");
            if (CheckWin()) {
                Toast.makeText(this, "Winner", Toast.LENGTH_SHORT).show();
            } else if (totalboxes == 9) {
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            } else {
                playerturn = 2;
                totalboxes++;
            }


        } else {
            button.setText("O");

            if (CheckWin()) {
                Toast.makeText(this, "Winner", Toast.LENGTH_SHORT).show();
            } else if (totalboxes == 9) {
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            } else {
                playerturn = 1;
                totalboxes++;
            }
        }


    }

    private boolean CheckWin() {
        boolean res = false;
        for (int i = 0; i < Combinations.size(); i++) {
            final int[] combination = Combinations.get(i);

            if (Boxpos[combination[0]] == playerturn && Boxpos[combination[1]] == playerturn && Boxpos[combination[2]] == playerturn) {
                res = true;
            }


        }
        return res;
    }

    private boolean BoxSelected(int boxpos) {
        boolean res = false;
        if (Boxpos[boxpos] == 0) {
            res = true;

        }
        return res;

    }


}