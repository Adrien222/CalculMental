package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import neidra.fr.myapplication.R;
import neidra.fr.myapplication.database.ScoreBoardDao;
import neidra.fr.myapplication.database.ScoreBoardHelper;
import neidra.fr.myapplication.model.Entities.Score;
import neidra.fr.myapplication.service.ScoreService;

public class ActivityRegister extends AppCompatActivity {

    private Button btn_valide_pseudo;
    private ImageButton btn_home;
    private EditText editTextPseudo;
    private ScoreService scoreService;
    private TextView score_tw;

    private int final_score;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        scoreService = new ScoreService(new ScoreBoardDao(new ScoreBoardHelper(this)));

        this.final_score = getIntent().getIntExtra("score",0);

        this.btn_valide_pseudo=findViewById(R.id.btn_valide_pseudo);
        this.score_tw=findViewById(R.id.tw_score);
        score_tw.setText(getString(R.string.register_score) + " " + final_score);
        this.btn_home=findViewById(R.id.btn_home);
        this.editTextPseudo=findViewById(R.id.editTextPseudo);

        btn_valide_pseudo.setOnClickListener(view -> ouvrirPageScoreboard());
        btn_home.setOnClickListener(view -> retourPageHome());
    }

    // Affiche un toast si l'utilisateur n'a pas saisi de pseudo sinon retour sur la page scoreboard
    private void ouvrirPageScoreboard() {
        String nickname = editTextPseudo.getText().toString();
        if(nickname.equalsIgnoreCase("")){
            Toast.makeText(this, getString(R.string.aucun_pseudo), Toast.LENGTH_SHORT).show();
        } else {
            Score score = new Score();
            score.setScore(final_score);
            score.setNickname(nickname);
            scoreService.storeInDb(score);
            Intent activityScoreboard = new Intent(getApplicationContext(), ActivityScoreboard.class);
            startActivity(activityScoreboard);
            finish();
        }
    }

    // Retour sur la page menu principal
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}