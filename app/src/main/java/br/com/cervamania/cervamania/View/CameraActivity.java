package br.com.cervamania.cervamania.View;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.cervamania.cervamania.R;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG = "CameraActivity";
    private androidx.appcompat.widget.Toolbar toolbar;
    private String localArquivoFoto = "";
    private boolean ok;
    private Button btnCamera, btnEnviarFoto;

    public ProgressBar barraCircular;
    public TextView txtBaixandoInformacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarCameraActivity);
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
                //new TarefaEnviaFotoExterno(CameraActivity.this).execute(localArquivoFoto);
                uploadPhotoToFirebase();
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

    public void uploadPhotoToFirebase(){
        barraCircular.setVisibility(View.VISIBLE);
        txtBaixandoInformacoes.setVisibility(View.VISIBLE);
        String valPath = "upload/" + System.currentTimeMillis()+".jpg";
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();
        StorageReference filePath = storageReference.child(valPath);
        FileInputStream arquivo = null;
        try {
            arquivo = new FileInputStream(localArquivoFoto);
            byte[] foto = new byte[arquivo.available()];
            arquivo.read(foto);
            arquivo.close();
            UploadTask uploadTask = filePath.putBytes(foto);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.i(TAG, "Failure to upload Image");
                    barraCircular.setVisibility(View.GONE);
                    txtBaixandoInformacoes.setVisibility(View.GONE);
                    Toast.makeText(CameraActivity.this, "Erro ao enviar. Tente novamente.", Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Log.i(TAG, "Finish Uploading ");
                    barraCircular.setVisibility(View.GONE);
                    txtBaixandoInformacoes.setVisibility(View.GONE);
                    Toast.makeText(CameraActivity.this, "Foto enviada. Agradecemos o Feedback.", Toast.LENGTH_LONG).show();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
