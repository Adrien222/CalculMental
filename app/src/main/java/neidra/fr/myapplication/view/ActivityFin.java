package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import neidra.fr.myapplication.R;

public class ActivityFin extends AppCompatActivity {

    private TextView score_tw;
    private Button menu_principal;
    private ImageView imageBien;
    private ImageView imagePasBien;
    private ImageView imageMoyen;
    private TextView bien;
    private TextView moyen;
    private TextView pasBien;
    private Button enregistrer;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        this.score = getIntent().getIntExtra("score",0);
        String cptResultat = String.valueOf(score);

        this.imageBien=findViewById(R.id.imageBien);
        this.imagePasBien=findViewById(R.id.imagePasBien);
        this.imageMoyen=findViewById(R.id.imageMoyen);

        this.bien=findViewById(R.id.bien);
        this.moyen=findViewById(R.id.moyen);
        this.pasBien=findViewById(R.id.pasBien);

        this.score_tw =findViewById(R.id.score);

        affichage(score,cptResultat);

        this.menu_principal=findViewById(R.id.menu_principal);
        menu_principal.setOnClickListener(view->retourHome());

        this.enregistrer=findViewById(R.id.enregistrer);
        enregistrer.setOnClickListener(view->PageEnregitrer());


    }

    //Envoie sur la page d'enregistrement
    private void PageEnregitrer() {
        Intent activityRegister=new Intent(this, ActivityRegister.class);
        activityRegister.putExtra("score", score);
        startActivity(activityRegister);
        finish();
    }

    // Affichage d'une image en fonction du score de l'utilsateur
    private void affichage(int cpt, String cptResultat){
        if(cpt>=7){
            imageBien.setVisibility(View.VISIBLE);
            bien.setVisibility(View.VISIBLE);
        }
        else if((cpt>3)&&(cpt<7)){
            imageMoyen.setVisibility(View.VISIBLE);
            moyen.setVisibility(View.VISIBLE);
        }
        else{
            imagePasBien.setVisibility(View.VISIBLE);
            pasBien.setVisibility(View.VISIBLE);
        }
        score_tw.setText(getString(R.string.bonnes_reponses)+ " " +cptResultat+"/10");

    }

    // Retour sur la page home
    private void retourHome() {
        Intent mainActivity=new Intent(this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}