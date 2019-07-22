package com.example.ud3_ejemplo8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // "Inflamos" el menú diseñado
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del elemento pulsado hacemos una acción u otra.
        switch(item.getItemId()){
            case R.id.elem1:
                Toast.makeText(this, "Elemento1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.elem2:
                Toast.makeText(this, "Elemento2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.elem3:
                Toast.makeText(this, "Elemento3", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }
}
