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

    public static final String NUMBER = "CPTRESULTAT";
    private TextView score;
    private Button menu_principal;
    private ImageView imageBien;
    private ImageView imagePasBien;
    private ImageView imageMoyen;
    private TextView bien;
    private TextView moyen;
    private TextView pasBien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        Intent values = getIntent();
        int cpt = values.getIntExtra(NUMBER,0);
        String cptResultat = String.valueOf(cpt);

        this.imageBien=findViewById(R.id.imageBien);
        this.imagePasBien=findViewById(R.id.imagePasBien);
        this.imageMoyen=findViewById(R.id.imageMoyen);

        this.bien=findViewById(R.id.bien);
        this.moyen=findViewById(R.id.moyen);
        this.pasBien=findViewById(R.id.pasBien);

        this.score=findViewById(R.id.score);

        affichage(cpt,cptResultat);

        this.menu_principal=findViewById(R.id.menu_principal);
        menu_principal.setOnClickListener(view->retourHome());


    }

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
        score.setText(getString(R.string.bonnes_reponses)+ " " +cptResultat+"/10");

    }

    private void retourHome() {
        Intent mainActivity=new Intent(this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}