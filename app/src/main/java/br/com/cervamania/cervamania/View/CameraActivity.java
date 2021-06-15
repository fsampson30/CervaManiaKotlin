package br.com.cervamania.cervamania.View;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import br.com.cervamania.cervamania.Controller.TarefaEnviaFotoExterno;
import br.com.cervamania.cervamania.R;

public class CameraActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private String localArquivoFoto = "";
    private boolean ok;
    private Button btnCamera, btnEnviarFoto;

    public ProgressBar barraCircular;
    public TextView txtBaixandoInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBarCameraActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnCamera = (Button) findViewById(R.id.btnAbrirCamera);
        btnEnviarFoto = (Button) findViewById(R.id.btnEnviarFoto);

        barraCircular = (ProgressBar) findViewById(R.id.listaCervejasCircularBarCameraActivity);
        txtBaixandoInformacoes = (TextView) findViewById(R.id.txtBaixandoInformaçoesCameraActivity);

        barraCircular.setVisibility(View.GONE);
        txtBaixandoInformacoes.setVisibility(View.GONE);

        localArquivoFoto = getExternalFilesDir(null) + "/foto.jpg";

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEnviarFoto.setEnabled(true);
                Intent foto = new Intent("android.media.action.IMAGE_CAPTURE");
                foto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri uri = FileProvider.getUriForFile(CameraActivity.this, CameraActivity.this.getApplicationContext().getPackageName() + ".provider", new File(CameraActivity.this.localArquivoFoto));
                foto.putExtra("output", uri);
                CameraActivity.this.startActivityForResult(foto, 123);
                Bundle caminho = new Bundle();
                caminho.putString("caminho", localArquivoFoto);
                Log.d("FOTO", localArquivoFoto);
            }
        });


        btnEnviarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TarefaEnviaFotoExterno(CameraActivity.this).execute(localArquivoFoto);
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

    public void retornoTarefaExterna(String retorno) {
        if (retorno.equals("Arquivo Salvo com Sucesso!")) {
            Toast.makeText(CameraActivity.this, "Foto enviada. Agradecemos o Feedback.", Toast.LENGTH_LONG).show();
            onBackPressed();
        } else {
            Toast.makeText(CameraActivity.this, "Erro ao enviar. Tente novamente.", Toast.LENGTH_LONG).show();
        }
    }
}
