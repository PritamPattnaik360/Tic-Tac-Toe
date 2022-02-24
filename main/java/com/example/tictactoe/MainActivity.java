package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,back;
    private boolean player1Turn = true;
    private int count;
    private int player1;
    private int player2;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);
        b1 = findViewById(R.id.but1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.but2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.but3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.but4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.but5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.but6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.but7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.but8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.but9);
        b9.setOnClickListener(this);

        Button Reset = findViewById(R.id.reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        count++;
        if (checkwin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (count == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }
    private boolean checkwin() {
        String[][] XorO = new String[3][3];
        XorO[0][0] = b1.getText().toString();
        XorO[0][1] = b2.getText().toString();
        XorO[0][2] = b3.getText().toString();
        XorO[1][0] = b4.getText().toString();
        XorO[1][1] = b5.getText().toString();
        XorO[1][2] = b6.getText().toString();
        XorO[2][0] = b7.getText().toString();
        XorO[2][1] = b8.getText().toString();
        XorO[2][2] = b9.getText().toString();

        for (int i = 0; i < 3; i++) {
            if (XorO[i][0].equals(XorO[i][1])
                    && XorO[i][0].equals(XorO[i][2])
                    && !XorO[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (XorO[0][i].equals(XorO[1][i])
                    && XorO[0][i].equals(XorO[2][i])
                    && !XorO[0][i].equals("")) {
                return true;
            }
        }
        if (XorO[0][0].equals(XorO[1][1])
                && XorO[0][0].equals(XorO[2][2])
                && !XorO[0][0].equals("")) {
            return true;
        }
        if (XorO[0][2].equals(XorO[1][1])
                && XorO[0][2].equals(XorO[2][0])
                && !XorO[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void player1Wins() {
        player1++;
        Toast.makeText(this, "Player X wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void player2Wins() {
        player2++;
        Toast.makeText(this, "Player O wins!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    private void updatePointsText() {
        textViewPlayer1.setText("Player X: " + player1);
        textViewPlayer2.setText("Player O: " + player2);
    }
    private void resetBoard() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count = 0;
        player1Turn = true;
    }
}