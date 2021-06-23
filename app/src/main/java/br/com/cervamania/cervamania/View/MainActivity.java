package br.com.cervamania.cervamania.View;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.cervamania.cervamania.Controller.UploadRatings;
import br.com.cervamania.cervamania.R;
import br.com.cervamania.cervamania.sqlite.DataBaseHelper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private EditText txtPesquisaCerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View layout = findViewById(R.id.mainLayout);

        if (!verificaConexao()) {
            criaSnackBar(layout);
            return;
        }

        final DataBaseHelper db = new DataBaseHelper(this);
        if (!db.selectCountCervejas()){
            db.populateTipoCerveja();
            db.populatePaisCerveja();
            db.populateCerveja();
        }

        montaFragment(EstiloCervejaFragment.newInstance());

        toolbar = (Toolbar) findViewById(R.id.toolBarMainActivity);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.barraNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);

        txtPesquisaCerveja = (EditText) findViewById(R.id.txtpesquisaCerveja);

        txtPesquisaCerveja.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean flag = false;
                if (i == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(layout.getWindowToken(), 0);
                    Intent intent = new Intent(MainActivity.this, ListaCervejasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("origem", "pesquisa");
                    bundle.putString("textoPesquisado", txtPesquisaCerveja.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    flag = true;
                }
                return flag;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemHistorico: {
                Intent intent = new Intent(this, HistoricoCervejaActivity.class);
                this.startActivity(intent);
                break;
            }
            case R.id.menuItemCamera: {
                Intent intent = new Intent(this, CameraActivity.class);
                this.startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_estilo_cerveja: {
                montaFragment(EstiloCervejaFragment.newInstance());
                break;
            }
            case R.id.menu_pais_cerveja: {
                montaFragment(PaisCervejaFragment.newInstance());
                break;
            }
            case R.id.menu_classificacao_cerveja: {
                Intent intent = new Intent(this, ListaCervejasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("origem", "classificacoes");
                intent.putExtras(bundle);
                this.startActivity(intent);
                break;
            }
        }
        return true;
    }

    public void montaFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

    public boolean verificaConexao() {
        ConnectivityManager localConnectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        return (localConnectivityManager.getActiveNetworkInfo() != null) && (localConnectivityManager.getActiveNetworkInfo().isAvailable()) && (localConnectivityManager.getActiveNetworkInfo().isConnected());
    }

    public void criaSnackBar(View layout) {
        Snackbar snackbar = Snackbar.make(layout, "SEM CONEXÃO COM A INTERNET.", Snackbar.LENGTH_INDEFINITE);
        View snackView = snackbar.getView();

        snackView.setBackgroundColor(getResources().getColor(R.color.colorNotFound));

        TextView snackTitle = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
        snackTitle.setTextColor(getResources().getColor(R.color.colorFontLight));
        snackbar.setActionTextColor(getResources().getColor(R.color.colorFontLight));

        snackbar.setAction("FECHAR", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        snackbar.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(verificaConexao()){
            txtPesquisaCerveja.setText("");
            txtPesquisaCerveja.clearFocus();
        }
    }
}
