package com.sslavik.toolbarpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sustituimos la Toolbar Actual por la que queremos enseñar
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_add:
                Toast.makeText(this, "ACHIS ADDED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:
                break;
            case R.id.action_settings:
                // Se mostraran las preferencias
                showSettings();
                break;
            case R.id.action_aboutus:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // CARGA FRAGMENT DE PREFERENCIAS GENERALES
    private void showSettings() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, SettingFragment.newInstance(null));
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
