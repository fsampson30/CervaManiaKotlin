package br.com.cervamania.cervamania.Controller;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

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

import br.com.cervamania.cervamania.Model.Cerveja;
import br.com.cervamania.cervamania.View.DetalhesCervejaActivity;
import br.com.cervamania.cervamania.View.ListaCervejasActivity;

public class TarefaRetornaObjetoCerveja extends AsyncTask<String, Void, Cerveja> {

    private CaminhoServlets caminhoServlets = new CaminhoServlets();
    private ProgressDialog pb;
    private DetalhesCervejaActivity context;
    private Cerveja cerveja = new Cerveja();


    public TarefaRetornaObjetoCerveja(DetalhesCervejaActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        context.barraCircular.setVisibility(View.VISIBLE);
        context.txtBaixandoInformacoes.setVisibility(View.VISIBLE);
    }

    @Override
    protected Cerveja doInBackground(String... strings) {

        try {
            URL url = new URL(caminhoServlets.getCaminho() + "/ServletConsultaObjetoCerveja");
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
            cerveja = new Gson().fromJson(retorno, Cerveja.class);
            reader.close();
            return cerveja;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cerveja.setNome_cerveja("ERRO_CONEXAO");
        return cerveja;
    }

    @Override
    protected void onPostExecute(Cerveja cerveja) {
        context.barraCircular.setVisibility(View.GONE);
        context.txtBaixandoInformacoes.setVisibility(View.GONE);
        context.retornoTarefaExterna(cerveja);
    }
}
