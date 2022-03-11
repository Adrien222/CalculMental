package neidra.fr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_jouer;
    private Button button_scoreboard;
    private Button button_a_propos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button_jouer = findViewById(R.id.button_jouer);
        this.button_scoreboard = findViewById(R.id.button_scoreboard);
        this.button_a_propos = findViewById(R.id.button_a_propos);
        button_jouer.setOnClickListener(View -> ouvrirActivityNiveau1());
        button_scoreboard.setOnClickListener(View -> ouvrirActivityScoreboard());
        button_a_propos.setOnClickListener(View -> ouvrirActivityAPropos());
    }
    //Envoie sur la page à propos
    private void ouvrirActivityAPropos() {
        Intent activityAPropos = new Intent(getApplicationContext(), ActivityAPropos.class);
        startActivity(activityAPropos);
        finish();
    }

    //Envoie sur la page scoreboard
    private void ouvrirActivityScoreboard() {
        Intent activityScoreboard = new Intent(getApplicationContext(), ActivityScoreboard.class);
        startActivity(activityScoreboard);
        finish();
    }

    ////Envoie sur la page Jouer
    private void ouvrirActivityNiveau1() {
        Intent activityNiveau1 = new Intent(getApplicationContext(), ActivityNiveau1.class);
        startActivity(activityNiveau1);
        finish();
    }
}