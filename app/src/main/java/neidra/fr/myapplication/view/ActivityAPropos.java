package neidra.fr.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import neidra.fr.myapplication.R;

public class ActivityAPropos extends AppCompatActivity {
    private ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
        this.btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(view -> retourPageHome());
    }

    //Retour sur la page d'accueil si clique sur btn_home
    private void retourPageHome() {
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}