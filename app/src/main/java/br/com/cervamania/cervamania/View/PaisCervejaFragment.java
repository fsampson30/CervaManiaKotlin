package br.com.cervamania.cervamania.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import br.com.cervamania.cervamania.R;

public class PaisCervejaFragment extends Fragment {

    private Context context;
    private Button btnAlemanha, btnArgentina, btnAustralia, btnAustria, btnBelgica, btnBrasil, btnDinamarca, btnEspanha, btnEstadosUnidos, btnHolanda;
    private Button btnInglaterra, btnIrlanda, btnItalia, btnJamaica, btnLibano, btnMexico, btnNovaZelandia, btnPortugal, btnRepublicaTcheca, btnUruguai;
    private View view;
    private Bundle bundle = new Bundle();


    public static Fragment newInstance() {
        PaisCervejaFragment fragment = new PaisCervejaFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = container.getContext();
        view = inflater.inflate(R.layout.tela_principal_cardview_pais_cerveja, container, false);

        btnAlemanha = (Button) view.findViewById(R.id.btnAlemanha);
        btnArgentina = (Button) view.findViewById(R.id.btnArgentina);
        btnAustralia = (Button) view.findViewById(R.id.btnAustralia);
        btnAustria = (Button) view.findViewById(R.id.btnAustria);
        btnBelgica = (Button) view.findViewById(R.id.btnBelgica);
        btnBrasil = (Button) view.findViewById(R.id.btnBrasil);
        btnDinamarca = (Button) view.findViewById(R.id.btnDinamarca);
        btnEspanha = (Button) view.findViewById(R.id.btnEspanha);
        btnEstadosUnidos = (Button) view.findViewById(R.id.btnEstadosUnidos);
        btnHolanda = (Button) view.findViewById(R.id.btnHolanda);
        btnInglaterra = (Button) view.findViewById(R.id.btnInglaterra);
        btnIrlanda = (Button) view.findViewById(R.id.btnIrlanda);
        btnItalia = (Button) view.findViewById(R.id.btnItalia);
        btnJamaica = (Button) view.findViewById(R.id.btnJamaica);
        btnLibano = (Button) view.findViewById(R.id.btnLibano);
        btnMexico = (Button) view.findViewById(R.id.btnMexico);
        btnNovaZelandia = (Button) view.findViewById(R.id.btnNovaZelandia);
        btnPortugal = (Button) view.findViewById(R.id.btnPortugal);
        btnRepublicaTcheca = (Button) view.findViewById(R.id.btnRepublicaTcheca);
        btnUruguai = (Button) view.findViewById(R.id.btnUruguai);

        final Intent intent = new Intent(context, ListaCervejasActivity.class);
        bundle = new Bundle();
        bundle.putString("origem", "paises");

        btnAlemanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0001");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnArgentina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0002");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0003");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnAustria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0004");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnBelgica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0005");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnBrasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0006");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnDinamarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0007");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnEspanha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0008");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnEstadosUnidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0009");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnHolanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0010");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnInglaterra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0011");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnIrlanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0012");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnItalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0013");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnJamaica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0014");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnLibano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0015");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnMexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0016");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnNovaZelandia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0017");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnPortugal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0018");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnRepublicaTcheca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0019");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnUruguai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0020");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return view;
    }

}
