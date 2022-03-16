package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import neidra.fr.myapplication.R;
import neidra.fr.myapplication.database.ScoreBoardDao;
import neidra.fr.myapplication.database.ScoreBoardHelper;
import neidra.fr.myapplication.service.ScoreService;

public class ActivityScoreboard extends AppCompatActivity {

    private ScoreService scoreService;
    private ImageButton btn_home;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        this.btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(view -> retourPageHome());
        scoreService = new ScoreService(new ScoreBoardDao(new ScoreBoardHelper(this)));
        TextView textViewNombreScore = findViewById(R.id.tw_nombrescore);
        textViewNombreScore.setText(getString(R.string.nombrescore) + " " + scoreService.getScoreCount());
    }

    //Retour sur la page d'accueil si clique sur btn_home
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}