package br.com.cervamania.cervamania.Controller;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import br.com.cervamania.cervamania.View.ListaCervejasActivity;
import br.com.cervamania.cervamania.View.ListaClassificacaoCervejaSelecionadaActivity;

public class TarefaRetornaNotaClassificacaoIndividual extends AsyncTask<String, Void, String> {

    private CaminhoServlets caminhoServlets = new CaminhoServlets();
    private ListaClassificacaoCervejaSelecionadaActivity context;

    public TarefaRetornaNotaClassificacaoIndividual(ListaClassificacaoCervejaSelecionadaActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        context.barraCircular.setVisibility(View.VISIBLE);
        context.txtBaixandoInformacoes.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(caminhoServlets.getCaminho() + "/ServletConsultaNotaRankingIndividual");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setConnectTimeout(10000);
            conexao.setDoInput(true);
            conexao.setRequestMethod("POST");

            String parametroConsulta = strings[0];
            parametroConsulta = URLEncoder.encode(parametroConsulta, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(conexao.getOutputStream());
            writer.write(parametroConsulta);
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String retorno = URLDecoder.decode(reader.readLine(), "UTF-8");
            reader.close();
            return retorno;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERRO_CONEXAO";
    }

    @Override
    protected void onPostExecute(String nota) {
        context.barraCircular.setVisibility(View.GONE);
        context.txtBaixandoInformacoes.setVisibility(View.GONE);
        context.retornoTarefaExterna(nota);
    }
}
