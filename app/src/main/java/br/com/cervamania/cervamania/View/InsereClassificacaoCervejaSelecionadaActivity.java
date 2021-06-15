package br.com.cervamania.cervamania.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cervamania.cervamania.Controller.TarefaInsereClassificacao;
import br.com.cervamania.cervamania.Model.ClassificacaoCerveja;
import br.com.cervamania.cervamania.Model.CoresCervejas;
import br.com.cervamania.cervamania.Model.ImagensCervejas;
import br.com.cervamania.cervamania.R;

public class InsereClassificacaoCervejaSelecionadaActivity extends AppCompatActivity {

    private TextView txtNomeCerveja;
    private RatingBar barraClassificacao;
    private ImageView imgGarrafa;
    private String nomeCerveja, codigoCerveja, codigoCor;
    private LinearLayout linearLayout;
    private Toolbar toolbar;
    private RatingBar barraNota;
    private Button btnConfirma;
    private EditText txtComentarios;
    private ImagensCervejas imagensCervejas = new ImagensCervejas();
    private CoresCervejas coresCervejas = new CoresCervejas();
    private ClassificacaoCerveja classificacaoCerveja;

    public ProgressBar barraCircular;
    public TextView txtBaixandoInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_classificacao_cerveja_selecionada);

        savedInstanceState = getIntent().getExtras();

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarInsereClassificacaoCervejaSelecionadaActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        codigoCerveja = savedInstanceState.getString("codigoCerveja");
        nomeCerveja = savedInstanceState.getString("nomeCerveja");
        codigoCor = savedInstanceState.getString("codigoCor");

        txtNomeCerveja = (TextView) findViewById(R.id.txtInsereClassificacaoCervejaSelecionadaNomeCerveja);
        barraClassificacao = (RatingBar) findViewById(R.id.barraInsereClassificacaoCervejaSelecionada);
        imgGarrafa = (ImageView) findViewById(R.id.imageInsereClassificacaoCervejaSelecionadaGarrafa);
        linearLayout = (LinearLayout) findViewById(R.id.layoutHeaderInsereClassificacaoCervejaSelecionada);
        barraNota = (RatingBar) findViewById(R.id.barraInsereClassificacaoCervejaSelecionada);
        btnConfirma = (Button) findViewById(R.id.btnEnviaComentario);
        txtComentarios = (EditText) findViewById(R.id.txtDigitaComentario);

        barraCircular = (ProgressBar) findViewById(R.id.listaCervejasCircularBarInsereClassificacaoCervejaSelecionada);
        txtBaixandoInformacoes = (TextView) findViewById(R.id.txtBaixandoInformaçoesInsereClassificacaoCervejaSelecionada);
        barraCircular.setVisibility(View.GONE);
        txtBaixandoInformacoes.setVisibility(View.GONE);

        linearLayout.setBackgroundColor(getResources().getColor(coresCervejas.retornaCoresHexaDecimal(codigoCor)));
        txtNomeCerveja.setText(nomeCerveja);
        imgGarrafa.setImageResource(imagensCervejas.retornaImagemCervejaReduzida(nomeCerveja));

        btnConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classificacaoCerveja = new ClassificacaoCerveja();
                classificacaoCerveja.setCodigoCerveja(codigoCerveja);
                Log.d("codigoCerveja",codigoCerveja);
                classificacaoCerveja.setNomeCerveja(nomeCerveja);
                classificacaoCerveja.setComentarios(txtComentarios.getText().toString());
                classificacaoCerveja.setEstrelas(barraNota.getRating());

                new TarefaInsereClassificacao(InsereClassificacaoCervejaSelecionadaActivity.this).execute(classificacaoCerveja);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void retornoTarefaExterna(Boolean retorno){
        if(retorno){
            Toast.makeText(InsereClassificacaoCervejaSelecionadaActivity.this, "Cerveja classificada com sucesso!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        } else {
            Toast.makeText(InsereClassificacaoCervejaSelecionadaActivity.this, "Erro!", Toast.LENGTH_SHORT).show();
        }
    }
}
