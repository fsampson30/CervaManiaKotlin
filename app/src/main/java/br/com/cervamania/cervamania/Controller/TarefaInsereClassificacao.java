package br.com.cervamania.cervamania.Controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import br.com.cervamania.cervamania.Model.ClassificacaoCerveja;
import br.com.cervamania.cervamania.View.CameraActivity;
import br.com.cervamania.cervamania.View.InsereClassificacaoCervejaSelecionadaActivity;

public class TarefaInsereClassificacao extends AsyncTask<ClassificacaoCerveja, Void, Boolean> {

    private InsereClassificacaoCervejaSelecionadaActivity context;
    private CaminhoServlets caminho = new CaminhoServlets();
    private ClassificacaoCerveja classificacaoCerveja;

    public TarefaInsereClassificacao(InsereClassificacaoCervejaSelecionadaActivity context) {
        this.context =  context;
    }

    @Override
    protected void onPreExecute() {
        context.barraCircular.setVisibility(View.VISIBLE);
        context.txtBaixandoInformacoes.setVisibility(View.VISIBLE);
    }

    @Override

    protected Boolean doInBackground(ClassificacaoCerveja... strings) {
        try {
            classificacaoCerveja = strings[0];
            URL url = new URL(caminho.getCaminho() + "/ServletInsereClassificacao");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setConnectTimeout(10000);
            conexao.setDoInput(true);
            conexao.setRequestMethod("POST");
            classificacaoCerveja = strings[0];
            String parametro = URLEncoder.encode(new Gson().toJson(classificacaoCerveja,ClassificacaoCerveja.class), "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(conexao.getOutputStream());
            writer.write(parametro);
            writer.close();

            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String resposta = URLDecoder.decode(reader.readLine(), "UTF-8");
            if(resposta.equals("true")){
                return true;
            }
            Log.d("retorno", resposta);
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean retorno) {
        context.barraCircular.setVisibility(View.GONE);
        context.txtBaixandoInformacoes.setVisibility(View.GONE);
        this.context.retornoTarefaExterna(retorno);
    }
}

