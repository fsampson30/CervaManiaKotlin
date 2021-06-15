package br.com.cervamania.cervamania.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.cervamania.cervamania.Model.CoresCervejas;
import br.com.cervamania.cervamania.R;

public class DescricaoEstiloCervejaActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private TextView txtDescricaoEstiloCerveja;
    private TextView txtEstiloCerveja;
    private String codigoEstiloCerveja;
    private CoresCervejas cores = new CoresCervejas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_estilo_cerveja);

        savedInstanceState = getIntent().getExtras();
        codigoEstiloCerveja = savedInstanceState.getString("codigoEstiloCerveja");

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolBarDescricaoEstiloCervejaActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        txtDescricaoEstiloCerveja = (TextView) findViewById(R.id.txtDescricaoEstiloCerveja);
        txtEstiloCerveja = (TextView) findViewById(R.id.txtEstiloCerveja);
        recuperaDescricao(codigoEstiloCerveja);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }

    public void recuperaDescricao(String codigoEstiloCerveja) {
        switch (codigoEstiloCerveja) {
            case "0001": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoStardartAmericanLager);
                txtEstiloCerveja.setText(R.string.txtStardartAmericanLager);
                break;
            }
            case "0002": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoAmberLager);
                txtEstiloCerveja.setText(R.string.txtAmberLager);
                break;
            }
            case "0003": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoViennaLager);
                txtEstiloCerveja.setText(R.string.txtViennaLager);
                break;
            }
            case "0004": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoPilsener);
                txtEstiloCerveja.setText(R.string.txtPilsener);
                break;
            }
            case "0005": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoPremium);
                txtEstiloCerveja.setText(R.string.txtPremium);
                break;
            }
            case "0006": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoHelles);
                txtEstiloCerveja.setText(R.string.txtHelles);
                break;
            }
            case "0007": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoMunchnerDunkel);
                txtEstiloCerveja.setText(R.string.txtMunchnerDunkel);
                break;
            }
            case "0008": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoDarkAmericanLager);
                txtEstiloCerveja.setText(R.string.txtDarkAmericanLager);
                break;
            }
            case "0009": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoSchwarzbier);
                txtEstiloCerveja.setText(R.string.txtSchwarzbier);
                break;
            }
            case "0010": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoBock);
                txtEstiloCerveja.setText(R.string.txtBock);
                break;
            }
            case "0011": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoDoppelbock);
                txtEstiloCerveja.setText(R.string.txtDoppelbock);
                break;
            }
            case "0012": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoAmericanPaleAle);
                txtEstiloCerveja.setText(R.string.txtAmericanPaleAle);
                break;
            }
            case "0013": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoExtraSpecialBitter);
                txtEstiloCerveja.setText(R.string.txtExtraSpecialBitter);
                break;
            }
            case "0014": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoBelgianPaleAle);
                txtEstiloCerveja.setText(R.string.txtBelgianPaleAle);
                break;
            }
            case "0015": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoBelgianBlondAle);
                txtEstiloCerveja.setText(R.string.txtBelgianBlondAle);
                break;
            }
            case "0016": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoBelgianSpecialtyAle);
                txtEstiloCerveja.setText(R.string.txtBelgianSpecialtyAle);
                break;
            }
            case "0017": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoIndiaPaleAle);
                txtEstiloCerveja.setText(R.string.txtIndiaPaleAle);
                break;
            }
            case "0018": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoRedAle);
                txtEstiloCerveja.setText(R.string.txtRedAle);
                break;
            }
            case "0019": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoBrownAle);
                txtEstiloCerveja.setText(R.string.txtBrownAle);
                break;
            }
            case "0020": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoDubbel);
                txtEstiloCerveja.setText(R.string.txtDubbel);
                break;
            }
            case "0021": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoTripel);
                txtEstiloCerveja.setText(R.string.txtTripel);
                break;
            }
            case "0022": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoQuadrupel);
                txtEstiloCerveja.setText(R.string.txtQuadrupel);
                break;
            }
            case "0023": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoGoldenStrongAle);
                txtEstiloCerveja.setText(R.string.txtGoldenStrongAle);
                break;
            }
            case "0024": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoDarkStrongAle);
                txtEstiloCerveja.setText(R.string.txtDarkStrongAle);
                break;
            }
            case "0025": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoWeissbier);
                txtEstiloCerveja.setText(R.string.txtWeissbier);
                break;
            }
            case "0026": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoWeizenbock);
                txtEstiloCerveja.setText(R.string.txtWeizenbock);
                break;
            }
            case "0027": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoDunkelweizen);
                txtEstiloCerveja.setText(R.string.txtDunkelweizen);
                break;
            }
            case "0028": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoWitbier);
                txtEstiloCerveja.setText(R.string.txtWitbier);
                break;
            }
            case "0029": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoStout);
                txtEstiloCerveja.setText(R.string.txtStout);
                break;
            }
            case "0030": {
                txtDescricaoEstiloCerveja.setText(R.string.txtDescricaoPorter);
                txtEstiloCerveja.setText(R.string.txtPorter);
                break;
            }
        }
    }
}

