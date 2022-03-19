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
    private TextView tw_top5;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        this.btn_home = findViewById(R.id.btn_home);
        this.tw_top5 = findViewById(R.id.tw_top5);
        setTop5();
        btn_home.setOnClickListener(view -> retourPageHome());
        scoreService = new ScoreService(new ScoreBoardDao(new ScoreBoardHelper(this)));
        TextView textViewNombreScore = findViewById(R.id.tw_nombrescore);
        textViewNombreScore.setText(getString(R.string.nombrescore) + " " + scoreService.getScoreCount());
    }

    private void setTop5(){
        tw_top5.setText("TOP 1 : <USER> / <SCORE>" +
                "\nTOP 2 : <USER> / <SCORE>"+
                "\nTOP 3 : <USER> / <SCORE>"+
                "\nTOP 4 : <USER> / <SCORE>"+
                "\nTOP 5 : <USER> / <SCORE>");
    }

    //Retour sur la page d'accueil si clique sur btn_home
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}