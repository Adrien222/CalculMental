package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import neidra.fr.myapplication.R;

public class ActivityRegister extends AppCompatActivity {

    private Button btn_valide_pseudo;
    private ImageButton btn_home;
    private EditText editTextPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.btn_valide_pseudo=findViewById(R.id.btn_valide_pseudo);
        this.btn_home=findViewById(R.id.btn_home);
        this.editTextPseudo=findViewById(R.id.editTextPseudo);

        btn_valide_pseudo.setOnClickListener(view -> ouvrirPageScoreboard());
        btn_home.setOnClickListener(view -> retourPageHome());

    }

    // Affiche un toast si l'ui n'a pas saisi de pseudo sinon retour sur la page scoreboard
    private void ouvrirPageScoreboard() {
        if(editTextPseudo.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, getString(R.string.aucun_pseudo), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent activityScoreboard = new Intent(getApplicationContext(), ActivityScoreboard.class);
        startActivity(activityScoreboard);
        finish();
    }

    // Retour sur la page menue principale
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}