package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game_display extends AppCompatActivity {

    private TicTacToeBoard tictactoeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBtn = findViewById(R.id.play_again);
        Button homeBtn = findViewById(R.id.home_btn);
        TextView playerTurn = findViewById(R.id.player_disp);
        TextView playerScore = findViewById(R.id.player_score);

        playAgainBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
            playerScore.setText((playerNames[0] + ": 0 " + "\t\t" + playerNames[1] + ": 0"));
        }

        tictactoeBoard = findViewById(R.id.ticTacToeBoard);

        tictactoeBoard.setupGame(playAgainBtn, homeBtn, playerTurn, playerNames, playerScore);
    }

    public void playAgainButtonClick(View view){
        tictactoeBoard.resetGame();
        tictactoeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}