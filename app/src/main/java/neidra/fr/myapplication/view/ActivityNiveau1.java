package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import neidra.fr.myapplication.R;

public class ActivityNiveau1 extends AppCompatActivity {

    private TextView affichage_calcul;
    private Button btn_valide;
    private Button btn_suivant;
    private Button btn_un;
    private Button btn_deux;
    private Button btn_trois;
    private Button btn_quatre;
    private Button btn_cinq;
    private Button btn_six;
    private Button btn_sept;
    private Button btn_huit;
    private Button btn_neuf;
    private Button btn_zero;
    private Button btn_moins;
    private Button btn_effacer;
    private ImageButton btn_home;
    private TextView resultatUI;
    private TextView correcte;
    private TextView faux;
    private TextView la_reponse;
    private TextView score;
    private TextView mauvaises_rep;
    private int premierNbre;
    private int secondNbre;
    private char operateur;
    private int resultat;
    private int cptBonneRep=0;
    private int cptRep=0;
    private int cptMauvaisesRep=0;
    private String affichageResultat="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau1);

        // Affichage du calcul random
        this.affichage_calcul= findViewById(R.id.affichage_calcul);
        setAffichage_calcul();

        //On récupére le symbole et on calcul le resulat
        getResultat();

        this.btn_valide=findViewById(R.id.btn_valide);
        this.resultatUI=findViewById(R.id.resultatUI);
        this.btn_suivant=findViewById(R.id.btn_suivant);
        this.la_reponse=findViewById(R.id.la_reponse);
        this.faux=findViewById(R.id.faux);
        this.correcte=findViewById(R.id.correcte);
        this.score=findViewById(R.id.score);
        this.mauvaises_rep=findViewById(R.id.mauvaisesrep);


        this.btn_zero=findViewById(R.id.btn_zero);
        this.btn_un=findViewById(R.id.btn_un);
        this.btn_deux=findViewById(R.id.btn_deux);
        this.btn_trois=findViewById(R.id.btn_trois);
        this.btn_quatre=findViewById(R.id.btn_quatre);
        this.btn_cinq=findViewById(R.id.btn_cinq);
        this.btn_six=findViewById(R.id.btn_six);
        this.btn_sept=findViewById(R.id.btn_sept);
        this.btn_huit=findViewById(R.id.btn_huit);
        this.btn_neuf=findViewById(R.id.btn_neuf);
        this.btn_moins=findViewById(R.id.btn_moins);
        this.btn_effacer=findViewById(R.id.btn_effacer);

        this.btn_home=findViewById(R.id.btn_home);

        btn_un.setOnClickListener(view -> cliqueBtnChiffre(btn_un));
        btn_deux.setOnClickListener(view -> cliqueBtnChiffre(btn_deux));
        btn_trois.setOnClickListener(view -> cliqueBtnChiffre(btn_trois));
        btn_quatre.setOnClickListener(view -> cliqueBtnChiffre(btn_quatre));
        btn_cinq.setOnClickListener(view -> cliqueBtnChiffre(btn_cinq));
        btn_six.setOnClickListener(view -> cliqueBtnChiffre(btn_six));
        btn_sept.setOnClickListener(view -> cliqueBtnChiffre(btn_sept));
        btn_huit.setOnClickListener(view -> cliqueBtnChiffre(btn_huit));
        btn_neuf.setOnClickListener(view -> cliqueBtnChiffre(btn_neuf));
        btn_zero.setOnClickListener(view -> cliqueBtnChiffre(btn_zero));
        btn_moins.setOnClickListener(view -> cliqueBtnChiffre(btn_moins));


        btn_effacer.setOnClickListener(view ->cliqueBtnEffacer());

        btn_valide.setOnClickListener(view -> affichagePageResultat());
        btn_suivant.setOnClickListener(view -> affichagePageCalcul());

        btn_home.setOnClickListener(view -> retourPageHome());
    }

    // Fonction qui retourne un entier compris entre 0 et 20
    private int nombreAleatoire(){
        Random r = new Random();
        return r.nextInt(12);
    }

    // Fonction qui retourne un opérateur aléatoire entre +, - et *
    private char operateurAleatoire(){
        char operateur ;
        Random op = new Random();
        int operateurAleatoire = op.nextInt(3);
        if(operateurAleatoire==0)
            operateur='+';
        else if(operateurAleatoire==1)
            operateur='-';
        else
            operateur='x';
        return operateur;
    }

    //Test si la réponse saisi par l'ui est V/F
    @SuppressLint("SetTextI18n")
    private void vraiFaux(int nbre){
        if(resultat==nbre) {
            correcte.setVisibility(View.VISIBLE);
            cptBonneRep++;
            score.setText(getString(R.string.bonnes_reponses)+ " " +cptBonneRep+"/10");
        } else {
            addMauvaisesReponses();
            faux.setVisibility(View.VISIBLE);
            la_reponse.setText(getString(R.string.reponse) + " " + resultat );
            la_reponse.setVisibility(View.VISIBLE);
        }
    }

    //Ajoute et affiche le nombre de mauvaises réponses
    private void addMauvaisesReponses(){
        cptMauvaisesRep++;
        mauvaises_rep.setText(getString(R.string.mauvaises_rep)+ " " +cptMauvaisesRep+"/10");
    }

    //Affiche le calcul
    private void setAffichage_calcul(){
        premierNbre=nombreAleatoire();
        secondNbre=nombreAleatoire();
        operateur=operateurAleatoire();
        affichage_calcul.setText(premierNbre + " " + operateur + " " + secondNbre + " = ?");
    }

    //Retourne le résulat du calcul
    private void getResultat(){
        if(operateur=='+')
            resultat=premierNbre+secondNbre;
        else if(operateur=='-')
            resultat=premierNbre-secondNbre;
        else
            resultat=premierNbre*secondNbre;
        System.out.println(resultat);
    }

    //Retour sur la page d'accueil si clique sur btn_home
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }

    //Effacer resultat_ui si clique sur btn-effacer
    private void cliqueBtnEffacer() {
        resultatUI.setText("");
        affichageResultat="";
    }

    //Affichage du chiffre correspondant au boutonChiffre qui a été cliqué
    private void cliqueBtnChiffre(Button btn) {
        String chiffre = btn.getText().toString();
        affichageResultat+=chiffre;
        resultatUI.setText(affichageResultat);
    }

    private void PageFin(){
        Intent activityFin = new Intent(this, ActivityFin.class);
        activityFin.putExtra(ActivityFin.NUMBER, cptBonneRep);
        startActivity(activityFin);
        finish();
    }

    //Affichage de la page avec le calcul à réaliser
    private void affichagePageCalcul() {
        if (cptRep>=10){
            PageFin();
        } else {
            btn_valide.setClickable(true);
            btn_valide.setVisibility(Button.VISIBLE);
            btn_suivant.setClickable(false);
            affichage_calcul.setVisibility(View.VISIBLE);
            resultatUI.setClickable(true);
            resultatUI.setVisibility(EditText.VISIBLE);
            faux.setVisibility(View.INVISIBLE);
            correcte.setVisibility(View.INVISIBLE);
            la_reponse.setVisibility(View.INVISIBLE);
            btn_suivant.setVisibility(Button.INVISIBLE);
            resultatUI.setText("");
            affichageResultat = "";
            setAffichage_calcul();
        }
    }

    //Affichage de la page avec le résultat du calcul
    private void affichagePageResultat() {
        if(resultatUI.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this, getString(R.string.aucun_resultat), Toast.LENGTH_SHORT).show();
            return;
        }
        cptRep++;
        getResultat();
        btn_valide.setClickable(false);
        btn_valide.setVisibility(Button.INVISIBLE);
        btn_suivant.setClickable(true);
        btn_suivant.setVisibility(Button.VISIBLE);
        affichage_calcul.setVisibility(View.INVISIBLE);
        resultatUI.setVisibility(EditText.INVISIBLE);
        resultatUI.setClickable(false);
        vraiFaux(Integer.parseInt(String.valueOf(resultatUI.getText())));
    }
}