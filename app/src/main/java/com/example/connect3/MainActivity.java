package com.example.connect3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float x[] = {0,1000,-1000};
    int activePlayer = 1;
    int board[][] = new int[4][4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<=3;i++)
        {
            for(int j=0;j<=3;j++)
            {
                board[i][j] = 0;
            }
        }
    }
    public boolean checkWin1()
    {
        if(board[1][1] == 1 && board[1][2] == 1 && board[1][3] == 1)
        {
            return true;
        }
        else if(board[2][1] == 1 && board[2][2] == 1 && board[2][3] == 1)
        {
            return true;
        }
        else if(board[3][1] == 1 && board[3][2] == 1 && board[3][3] == 1)
        {
            return true;
        }
        else if(board[1][1] == 1 && board[2][1] == 1 && board[3][1] == 1)
        {
            return true;
        }
        else if(board[1][2] == 1 && board[2][2] == 1 && board[3][2] == 1)
        {
            return true;
        }
        else if(board[1][3] == 1 && board[2][3] == 1 && board[3][3] == 1)
        {
            return true;
        }
        else if(board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1)
        {
            return true;
        }
        else if(board[1][3] == 1 && board[2][2] == 1 && board[3][1] == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkWin2()
    {
        if(board[1][1] == 2 && board[1][2] == 2 && board[1][3] == 2)
        {
            return true;
        }
        else if(board[2][1] == 2 && board[2][2] == 2 && board[2][3] == 2)
        {
            return true;
        }
        else if(board[3][1] == 2 && board[3][2] == 2 && board[3][3] == 2)
        {
            return true;
        }
        else if(board[1][1] == 2 && board[2][1] == 2 && board[3][1] == 2)
        {
            return true;
        }
        else if(board[1][2] == 2 && board[2][2] == 2 && board[3][2] == 2)
        {
            return true;
        }
        else if(board[1][3] == 2 && board[2][3] == 2 && board[3][3] == 2)
        {
            return true;
        }
        else if(board[1][1] == 2 && board[2][2] == 2 && board[3][3] == 2)
        {
            return true;
        }
        else if(board[1][3] == 2 && board[2][2] == 2 && board[3][1] == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkDraw()
    {
        boolean ans = true;
        for(int i=1;i<=3;i++)
        {
            for(int j=1;j<=3;j++)
            {
                if(board[i][j] == 0)
                {
                    ans = false;
                    return ans;
                }
            }
        }
        return ans;
    }

    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        String s = (String) counter.getTag();
        if(checkIfFull(s) == false) {
            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.x);
                counter.setTranslationY(x[activePlayer]);
                counter.animate().translationYBy(-x[activePlayer]).setDuration(600);
                updateBoard(s, activePlayer);
                activePlayer = 2;
            } else {
                counter.setImageResource(R.drawable.o);
                counter.setTranslationY(x[activePlayer]);
                counter.animate().translationYBy(-x[activePlayer]).setDuration(600);
                updateBoard(s, activePlayer);
                activePlayer = 1;
            }
            if(checkWin1())
            {
                Toast.makeText(this, "Player 1 WON", Toast.LENGTH_SHORT).show();
                resetGame();
            }
            else if(checkWin2())
            {
                Toast.makeText(this, "Player 2 WON", Toast.LENGTH_SHORT).show();
                resetGame();
            }
            else if(checkDraw())
            {
                Toast.makeText(this, "It's a DRAW", Toast.LENGTH_SHORT).show();
                resetGame();
            }
        }
    }

    public boolean checkIfFull(String s)
    {
        if(s.equalsIgnoreCase("a"))
        {
            if(board[1][1] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("b"))
        {
            if(board[1][2] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("c"))
        {
            if(board[1][3] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("d"))
        {
            if(board[2][1] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("e"))
        {
            if(board[2][2] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("f"))
        {
            if(board[2][3] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("g"))
        {
            if(board[3][1] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("h"))
        {
            if(board[3][2] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else if(s.equalsIgnoreCase("i"))
        {
            if(board[3][3] == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public void updateBoard(String s, int turn)
    {
        if(s.equalsIgnoreCase("a"))
        {
            board[1][1] = turn;
        }
        if(s.equalsIgnoreCase("b"))
        {
            board[1][2] = turn;
        }
        if(s.equalsIgnoreCase("c"))
        {
            board[1][3] = turn;
        }
        if(s.equalsIgnoreCase("d"))
        {
            board[2][1] = turn;
        }
        if(s.equalsIgnoreCase("e"))
        {
            board[2][2] = turn;
        }
        if(s.equalsIgnoreCase("f"))
        {
            board[2][3] = turn;
        }
        if(s.equalsIgnoreCase("g"))
        {
            board[3][1] = turn;
        }
        if(s.equalsIgnoreCase("h"))
        {
            board[3][2] = turn;
        }
        if(s.equalsIgnoreCase("i"))
        {
            board[3][3] = turn;
        }
    }
    public void resetGame()
    {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    public void resetButtonClicked(View view)
    {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}