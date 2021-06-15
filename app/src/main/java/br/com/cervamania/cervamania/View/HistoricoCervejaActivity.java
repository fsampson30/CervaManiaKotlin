package br.com.cervamania.cervamania.View;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.ortiz.touchview.TouchImageView;

import br.com.cervamania.cervamania.R;

public class HistoricoCervejaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgFamiliaCerveja;
    private TouchImageView imgTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_cerveja);

        toolbar = (Toolbar) findViewById(R.id.toolBarHistoricoCervejaActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        switch (item.getItemId()) {
            case R.id.menuItemLager: {
                Intent intent = new Intent(this, VisualizaFotoFamiliaCervejaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("familia", "lager");
                intent.putExtras(bundle);
                this.startActivity(intent);
                break;
            }
            case R.id.menuItemAle: {
                Intent intent = new Intent(this, VisualizaFotoFamiliaCervejaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("familia", "ale");
                intent.putExtras(bundle);
                this.startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_historico_cerveja_activity, menu);
        return true;
    }


}
