package neidra.fr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import neidra.fr.myapplication.database.ScoreBoardDao;
import neidra.fr.myapplication.database.ScoreBoardHelper;
import neidra.fr.myapplication.service.ScoreService;

public class ActivityScoreboard extends AppCompatActivity {

    private ScoreService scoreService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        scoreService = new ScoreService(new ScoreBoardDao(new ScoreBoardHelper(this)));
    }
}