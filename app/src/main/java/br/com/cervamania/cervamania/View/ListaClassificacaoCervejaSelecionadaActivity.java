package br.com.cervamania.cervamania.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.sql.Array;
import java.util.ArrayList;

import br.com.cervamania.cervamania.Controller.AdapterListaComentariosCervejaSelecionada;
import br.com.cervamania.cervamania.Controller.DownloadRatings;
import br.com.cervamania.cervamania.Controller.TarefaRetornaListaComentariosCervejaSelecionada;
import br.com.cervamania.cervamania.Controller.TarefaRetornaNotaClassificacaoIndividual;
import br.com.cervamania.cervamania.Model.CoresCervejas;
import br.com.cervamania.cervamania.Model.ImagensCervejas;
import br.com.cervamania.cervamania.R;

public class ListaClassificacaoCervejaSelecionadaActivity extends AppCompatActivity {

    private TextView txtNomeCerveja;
    private RatingBar barraClassificacao;
    private ImageView imgGarrafa;
    private String nomeCerveja, codigoCerveja, codigoCor;
    private LinearLayout linearLayout;
    private Toolbar toolbar;
    private ImagensCervejas imagensCervejas = new ImagensCervejas();
    private CoresCervejas coresCervejas = new CoresCervejas();
    private AdapterListaComentariosCervejaSelecionada adapter;
    private RecyclerView recyclerViewListaComentarios;

    public ProgressBar barraCircular;
    public TextView txtBaixandoInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_classificacao_cerveja_selecionada);

        savedInstanceState = getIntent().getExtras();

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarClassificacaoCervejaSelecionadaActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        codigoCerveja = savedInstanceState.getString("codigoCerveja");
        nomeCerveja = savedInstanceState.getString("nomeCerveja");
        codigoCor = savedInstanceState.getString("codigoCor");

        txtNomeCerveja = (TextView) findViewById(R.id.txtClassificacaoCervejaSelecionadaNomeCerveja);
        barraClassificacao = (RatingBar) findViewById(R.id.barraClassificacaoCervejaSelecionada);
        imgGarrafa = (ImageView) findViewById(R.id.imageClassificacaoCervejaSelecionadaGarrafa);
        linearLayout = (LinearLayout) findViewById(R.id.layoutHeaderClassificacaoCervejaSelecionada);
        recyclerViewListaComentarios = (RecyclerView) findViewById(R.id.recyclerViewListaCLassificacaoCervejaSelecionada);
        recyclerViewListaComentarios.setLayoutManager(new LinearLayoutManager(this));

        barraCircular = (ProgressBar) findViewById(R.id.listaCervejasCircularBarClassificacaoCervejaSelecionada);
        txtBaixandoInformacoes = (TextView) findViewById(R.id.txtBaixandoInformaçoesClassificacaoCervejaSelecionada);
        barraCircular.setVisibility(View.GONE);
        txtBaixandoInformacoes.setVisibility(View.GONE);

        linearLayout.setBackgroundColor(getResources().getColor(coresCervejas.retornaCoresHexaDecimal(codigoCor)));
        txtNomeCerveja.setText(nomeCerveja);
        String path = imagensCervejas.retornaArquivoCervejaReduzida(nomeCerveja);
        Picasso.get().load(path).fetch();
        Picasso.get().load(path).placeholder(R.drawable.caneca).into(imgGarrafa);
        //imgGarrafa.setImageResource(imagensCervejas.retornaImagemCervejaReduzida(nomeCerveja));

        //new TarefaRetornaNotaClassificacaoIndividual(this).execute(codigoCerveja);
        recuperaClassificacao(codigoCerveja);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    public void retornoTarefaExterna(String nota) {
        if (nota.equals("ERRO_CONEXAO")) {
            Toast.makeText(this, "Erro de Acesso ao Servidor. Tente Novamente", Toast.LENGTH_LONG).show();
            onBackPressed();
        } else
            barraClassificacao.setRating(Float.valueOf(nota));
        new TarefaRetornaListaComentariosCervejaSelecionada(this).execute(nomeCerveja);
    }

    public void retornoTarefaListaComentarios(ArrayList<String> listaComentarios) {
        if (listaComentarios.isEmpty()) {
            Toast.makeText(this, "Sem comentários pra essa Cerveja.", Toast.LENGTH_LONG).show();
        } else {
            adapter = new AdapterListaComentariosCervejaSelecionada(listaComentarios);
            recyclerViewListaComentarios.setAdapter(adapter);
        }
    }

    private void recuperaClassificacao(String codigo) {
        DownloadRatings downloadRatings = new DownloadRatings(this, null);
        downloadRatings.downloadRatingsOneBeer(codigo);
    }

    public void exibeProgresso(){
        barraCircular.setVisibility(View.VISIBLE);
        txtBaixandoInformacoes.setVisibility(View.VISIBLE);

    }

    public void escondeProgresso(){
        barraCircular.setVisibility(View.GONE);
        txtBaixandoInformacoes.setVisibility(View.GONE);
    }

    public void populaComentarios(ArrayList<String> lista, Float nota){
        barraClassificacao.setRating(nota);
        if (lista.isEmpty()){
            Toast.makeText(this, "Sem comentários pra essa Cerveja.", Toast.LENGTH_LONG).show();
        } else {
            adapter = new AdapterListaComentariosCervejaSelecionada(lista);
            recyclerViewListaComentarios.setAdapter(adapter);
        }
    }
}
