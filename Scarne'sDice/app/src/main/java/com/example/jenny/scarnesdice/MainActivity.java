package com.example.jenny.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userScore;
    int computerScore;
    int userTurnScore;
    int computerTurnScore;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_main);

        Button rollDice = (Button) findViewById(R.id.roll);
        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number;
                Random random = new Random();
                ImageView dice = (ImageView) findViewById(R.id.diceImage);
                number = random.nextInt(6)+1;

                if(number >6 || number <1){
                    throw new IllegalFormatCodePointException(0);
                }
                if(number == 1) dice.setImageResource(R.drawable.dice1);
                else if(number == 2) dice.setImageResource(R.drawable.dice2);
                else if(number == 3) dice.setImageResource(R.drawable.dice3);
                else if(number == 4) dice.setImageResource(R.drawable.dice4);
                else if(number == 5) dice.setImageResource(R.drawable.dice5);
                else if(number == 6) dice.setImageResource(R.drawable.dice6);

            }
        });
        Button hold = (Button) findViewById(R.id.hold);

        hold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });
        Button reset = (Button) findViewById(R.id.roll);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });



    }
}
