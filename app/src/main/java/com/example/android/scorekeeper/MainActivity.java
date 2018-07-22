package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int homeScore = 0;
    private int awayScore = 0;
    /**
     * Teams
     */
    private Team homeTeam = Team.Home;
    private Team awayTeam = Team.Away;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayHomeTeamScore(homeScore);
        displayAwayTeamScore(awayScore);
    }

    public void updateTeamScore(View view) {
        // Get which button was clicked
        int teamPointsId = view.getId();
        switch (teamPointsId) {
            case R.id.add_six_home:
                addToTeamScore(homeTeam, 6);
                break;
            case R.id.add_three_home:
                addToTeamScore(homeTeam, 3);
                break;
            case R.id.add_two_home:
                addToTeamScore(homeTeam, 2);
                break;
            case R.id.add_one_home:
                addToTeamScore(homeTeam, 1);
                break;
            case R.id.add_six_away:
                addToTeamScore(awayTeam, 6);
                break;
            case R.id.add_three_away:
                addToTeamScore(awayTeam, 3);
                break;
            case R.id.add_two_away:
                addToTeamScore(awayTeam, 2);
                break;
            case R.id.add_one_away:
                addToTeamScore(awayTeam, 1);
                break;
            default:
                // All possible cases covered so do nothing
                break;
        }
    }

    /**
     * @param team   the team that must have its score updated
     * @param points the number of points scored
     *               <p>
     *               Updates team score and display it
     */
    private void addToTeamScore(Team team, int points) {
        if (team == Team.Home) {
            homeScore += points;
            displayHomeTeamScore(homeScore);
        } else if (team == Team.Away) {
            awayScore += points;
            displayAwayTeamScore(awayScore);
        }
    }

    /**
     * Updates home team score
     */
    public void displayHomeTeamScore(int score) {
        TextView homeTeamTv = findViewById(R.id.home_score);
        homeTeamTv.setText(String.valueOf(score));
    }

    /**
     * Updates away team score
     */
    public void displayAwayTeamScore(int score) {
        TextView awayTeamTv = findViewById(R.id.away_score);
        awayTeamTv.setText(String.valueOf(score));
    }

    /**
     * Reset Both teams scores
     */
    public void resetScores(View view) {
        homeScore = awayScore = 0;
        displayHomeTeamScore(0);
        displayAwayTeamScore(0);
    }

    /**
     * Enum to represent team
     */
    private enum Team {
        Home, Away
    }
}
