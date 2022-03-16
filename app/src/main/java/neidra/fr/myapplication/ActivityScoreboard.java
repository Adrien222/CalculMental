package neidra.fr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import neidra.fr.myapplication.database.ScoreBoardDao;
import neidra.fr.myapplication.database.ScoreBoardHelper;
import neidra.fr.myapplication.service.ScoreService;

public class ActivityScoreboard extends AppCompatActivity {

    private ScoreService scoreService;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        scoreService = new ScoreService(new ScoreBoardDao(new ScoreBoardHelper(this)));
        TextView textViewNombreScore = findViewById(R.id.tw_nombrescore);
        textViewNombreScore.setText(getString(R.string.nombrescore)+" "+scoreService.getScoreCount());
    }
}