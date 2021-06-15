package br.com.cervamania.cervamania.Controller;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import br.com.cervamania.cervamania.View.ListaCervejasActivity;

public class TarefaRetornaListaCervejasClassificacaoNotas extends AsyncTask<String, Integer, ArrayList<Double>> {

    private ArrayList<Double> listaNotasCervejas = new ArrayList<>();
    private CaminhoServlets caminhoServlets = new CaminhoServlets();
    private ListaCervejasActivity context;

    public TarefaRetornaListaCervejasClassificacaoNotas(ListaCervejasActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        context.barraCircular.setVisibility(View.VISIBLE);
        context.txtBaixandoInformacoes.setVisibility(View.VISIBLE);
    }

    @Override
    protected ArrayList<Double> doInBackground(String... strings) {

        try {
            URL url = new URL(caminhoServlets.getCaminho() + "/ServletConsultaNotaRanking");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setConnectTimeout(10000);
            conexao.setDoInput(true);
            conexao.setRequestMethod("POST");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String retorno = URLDecoder.decode(reader.readLine(), "UTF-8");
            JSONArray json = new JSONArray(retorno);
            int i = 0;
            while (i < json.length()) {
                listaNotasCervejas.add(json.getDouble(i));
                i++;
            }
            reader.close();
            return listaNotasCervejas;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Double> listaNotasCervejas) {
        context.barraCircular.setVisibility(View.GONE);
        context.txtBaixandoInformacoes.setVisibility(View.GONE);
        context.retornaNotasClassificacao(listaNotasCervejas);
    }
}
