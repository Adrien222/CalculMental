package neidra.fr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_n1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button_n1 = findViewById(R.id.button_n1);
        button_n1.setOnClickListener(View -> ouvrirActivityNiveau1());
    }

    private void ouvrirActivityNiveau1() {
        Intent activityNiveau1 = new Intent(getApplicationContext(), ActivityNiveau1.class);
        startActivity(activityNiveau1);
        finish();
    }
}