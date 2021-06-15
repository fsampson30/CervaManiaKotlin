package br.com.cervamania.cervamania.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;


import com.ortiz.touchview.TouchImageView;

import br.com.cervamania.cervamania.Model.ImagensCervejas;
import br.com.cervamania.cervamania.R;

public class VisualizaFotoFamiliaCervejaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String familiaCerveja;
    private String nomeCerveja;
    private TouchImageView imgFamiliaCerveja;
    private ImagensCervejas imagensCervejas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_foto_familia_cerveja);

        savedInstanceState = getIntent().getExtras();
        familiaCerveja = savedInstanceState.getString("familia");
        nomeCerveja = savedInstanceState.getString("nomeCerveja");


        imgFamiliaCerveja = (TouchImageView) findViewById(R.id.imgFamiliaCerveja);

        toolbar = (Toolbar) findViewById(R.id.toolBarVisualizaFamiliaCervejaActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        switch (familiaCerveja) {
            case "lager": {
                imgFamiliaCerveja.setImageResource(R.drawable.familia_lager_reduzida);
                break;
            }
            case "ale": {
                imgFamiliaCerveja.setImageResource(R.drawable.familia_ale_reduzida);
                break;
            }
            case "garrafa":{
                imagensCervejas = new ImagensCervejas();
                imgFamiliaCerveja.setImageResource(imagensCervejas.retornaImagemCerveja(nomeCerveja));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}
