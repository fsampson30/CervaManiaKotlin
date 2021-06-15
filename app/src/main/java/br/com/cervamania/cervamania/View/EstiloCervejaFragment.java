package br.com.cervamania.cervamania.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Button;
import android.widget.Toast;

import br.com.cervamania.cervamania.R;

public class EstiloCervejaFragment extends android.support.v4.app.Fragment {

    private Context context;
    private Button btnAmericanLager, btnAmberLager, btnViennaLager, btnPilsener, btnPremium, btnHelles, btnMunchnerDunkel, btnDarkAmericanLager, btnSchwarzbier, btnBock;
    private Button btnDoppelBock, btnAmericanPaleAle, btnExtraSpecialBitter, btnBelgianPaleAle, btnBelgianBlondAle, btnBelgianSpecialtyAle, btnIndiaPaleAle, btnRedALe;
    private Button btnBrownAle, btnDubbel, btnTrippel, btnQuadrupel, btnGoldenStrongAle, btnDarkStrongAle, btnWeissbier, btnWeizenbock, btnDunkelWeizen, btnWitbier, btnStout, btnPorter;
    private Button btnDescricaoAmericanLager, btnDescricaoAmberLager, btnDescricaoViennaLager, btnDescricaoPilsener, btnDescricaoPremium, btnDescricaoHelles, btnDescricaoMunchnerDunkel, btnDescricaoDarkAmericanLager, btnDescricaoSchwarzbier, btnDescricaoBock;
    private Button btnDescricaoDoppelBock, btnDescricaoAmericanPaleAle, btnDescricaoExtraSpecialBitter, btnDescricaoBelgianPaleAle, btnDescricaoBelgianBlondAle, btnDescricaoBelgianSpecialtyAle, btnDescricaoIndiaPaleAle, btnDescricaoRedALe;
    private Button btnDescricaoBrownAle, btnDescricaoDubbel, btnDescricaoTrippel, btnDescricaoQuadrupel, btnDescricaoGoldenStrongAle, btnDescricaoDarkStrongAle, btnDescricaoWeissbier, btnDescricaoWeizenbock, btnDescricaoDunkelWeizen, btnDescricaoWitbier, btnDescricaoStout, btnDescricaoPorter;
    private View view;
    private Bundle bundle;


    public static android.support.v4.app.Fragment newInstance() {
        EstiloCervejaFragment fragment = new EstiloCervejaFragment();
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
        //view = inflater.inflate(R.layout.tela_principal_estilo_cerveja, container, false);
        view = inflater.inflate(R.layout.tela_principal_cardview_estilo_cerveja, container, false);

        btnAmericanLager = (Button) view.findViewById(R.id.btnAmericanLager);
        btnAmberLager = (Button) view.findViewById(R.id.btnAmberLager);
        btnViennaLager = (Button) view.findViewById(R.id.btnViennaLager);
        btnPilsener = (Button) view.findViewById(R.id.btnPilsener);
        btnPremium = (Button) view.findViewById(R.id.btnPremium);
        btnHelles = (Button) view.findViewById(R.id.btnHelles);
        btnMunchnerDunkel = (Button) view.findViewById(R.id.btnMunchnerDunkel);
        btnDarkAmericanLager = (Button) view.findViewById(R.id.btnDarkAmericanLager);
        btnSchwarzbier = (Button) view.findViewById(R.id.btnSchwarzbier);
        btnBock = (Button) view.findViewById(R.id.btnBock);
        btnDoppelBock = (Button) view.findViewById(R.id.btnDoppelbock);
        btnAmericanPaleAle = (Button) view.findViewById(R.id.btnAmericanPaleAle);
        btnExtraSpecialBitter = (Button) view.findViewById(R.id.btnExtraSpecialBitter);
        btnBelgianPaleAle = (Button) view.findViewById(R.id.btnBelgianPaleAle);
        btnBelgianBlondAle = (Button) view.findViewById(R.id.btnBelgianBlondAle);
        btnBelgianSpecialtyAle = (Button) view.findViewById(R.id.btnBelgianSpecialtyAle);
        btnIndiaPaleAle = (Button) view.findViewById(R.id.btnIndiaPaleAle);
        btnRedALe = (Button) view.findViewById(R.id.btnRedAle);
        btnBrownAle = (Button) view.findViewById(R.id.btnBrownAle);
        btnDubbel = (Button) view.findViewById(R.id.btnDubbel);
        btnTrippel = (Button) view.findViewById(R.id.btnTripel);
        btnQuadrupel = (Button) view.findViewById(R.id.btnQuadrupel);
        btnGoldenStrongAle = (Button) view.findViewById(R.id.btnGoldenStrongAle);
        btnDarkStrongAle = (Button) view.findViewById(R.id.btnDarkStrongAle);
        btnWeissbier = (Button) view.findViewById(R.id.btnWeissbier);
        btnWeizenbock = (Button) view.findViewById(R.id.btnWeizenbock);
        btnDunkelWeizen = (Button) view.findViewById(R.id.btnDunkelweizen);
        btnWitbier = (Button) view.findViewById(R.id.btnWitbier);
        btnStout = (Button) view.findViewById(R.id.btnStout);
        btnPorter = (Button) view.findViewById(R.id.btnPorter);

        btnDescricaoAmericanLager = (Button) view.findViewById(R.id.btnDescricaoStandartAmericanLager);
        btnDescricaoAmberLager = (Button) view.findViewById(R.id.btnDescricaoAmberLager);
        btnDescricaoViennaLager = (Button) view.findViewById(R.id.btnDescricaoViennaLager);
        btnDescricaoPilsener = (Button) view.findViewById(R.id.btnDescricaoPilsener);
        btnDescricaoPremium = (Button) view.findViewById(R.id.btnDescricaoPremium);
        btnDescricaoHelles = (Button) view.findViewById(R.id.btnDescricaoHelles);
        btnDescricaoMunchnerDunkel = (Button) view.findViewById(R.id.btnDescricaoMunchnerDunkel);
        btnDescricaoDarkAmericanLager = (Button) view.findViewById(R.id.btnDescricaoDarkAmericanLager);
        btnDescricaoSchwarzbier = (Button) view.findViewById(R.id.btnDescricaoSchwarzbier);
        btnDescricaoBock = (Button) view.findViewById(R.id.btnDescricaoBock);
        btnDescricaoDoppelBock = (Button) view.findViewById(R.id.btnDescricaoDoppelbock);
        btnDescricaoAmericanPaleAle = (Button) view.findViewById(R.id.btnDescricaoAmericanPaleAle);
        btnDescricaoExtraSpecialBitter = (Button) view.findViewById(R.id.btnDescricaoExtraSpecialBitter);
        btnDescricaoBelgianPaleAle = (Button) view.findViewById(R.id.btnDescricaoBelgianPaleAle);
        btnDescricaoBelgianBlondAle = (Button) view.findViewById(R.id.btnDescricaoBelgianBlondAle);
        btnDescricaoBelgianSpecialtyAle = (Button) view.findViewById(R.id.btnDescricaoBelgianSpecialtyAle);
        btnDescricaoIndiaPaleAle = (Button) view.findViewById(R.id.btnDescricaoIndiaPaleAle);
        btnDescricaoRedALe = (Button) view.findViewById(R.id.btnDescricaoRedAle);
        btnDescricaoBrownAle = (Button) view.findViewById(R.id.btnDescricaoBrownAle);
        btnDescricaoDubbel = (Button) view.findViewById(R.id.btnDescricaoDubbel);
        btnDescricaoTrippel = (Button) view.findViewById(R.id.btnDescricaoTripel);
        btnDescricaoQuadrupel = (Button) view.findViewById(R.id.btnDescricaoQuadrupel);
        btnDescricaoGoldenStrongAle = (Button) view.findViewById(R.id.btnDescricaoGoldenStrongAle);
        btnDescricaoDarkStrongAle = (Button) view.findViewById(R.id.btnDescricaoDarkStrongAle);
        btnDescricaoWeissbier = (Button) view.findViewById(R.id.btnDescricaoWeissbier);
        btnDescricaoWeizenbock = (Button) view.findViewById(R.id.btnDescricaoWeizenbock);
        btnDescricaoDunkelWeizen = (Button) view.findViewById(R.id.btnDescricaoDunkelweizen);
        btnDescricaoWitbier = (Button) view.findViewById(R.id.btnDescricaoWitbier);
        btnDescricaoStout = (Button) view.findViewById(R.id.btnDescricaoStout);
        btnDescricaoPorter = (Button) view.findViewById(R.id.btnDescricaoPorter);

        final Intent intent = new Intent(context,ListaCervejasActivity.class);
        bundle = new Bundle();

        btnAmericanLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0001");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnAmberLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0002");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnViennaLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0003");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnPilsener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0004");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0005");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnHelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0006");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnMunchnerDunkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0007");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnDarkAmericanLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0008");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnSchwarzbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0009");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnBock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0010");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnDoppelBock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0011");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
        btnAmericanPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0012");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnExtraSpecialBitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0013");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnBelgianPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0014");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnBelgianBlondAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0015");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnBelgianSpecialtyAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0016");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnIndiaPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0017");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnRedALe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0018");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnBrownAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0019");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnDubbel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0020");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnTrippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0021");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnQuadrupel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0022");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnGoldenStrongAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0023");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnDarkStrongAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0024");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnWeissbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0025");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnWeizenbock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0026");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnDunkelWeizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0027");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnWitbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0028");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnStout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0029");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        btnPorter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("codigo", "0030");
                bundle.putString("origem","estilos");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        btnDescricaoAmericanLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0001");
            }
        });
        btnDescricaoAmberLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0002");
            }
        });
        btnDescricaoViennaLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0003");
            }
        });
        btnDescricaoPilsener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0004");
            }
        });
        btnDescricaoPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0005");
            }
        });
        btnDescricaoHelles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0006");
            }
        });
        btnDescricaoMunchnerDunkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0007");
            }
        });
        btnDescricaoDarkAmericanLager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0008");
            }
        });
        btnDescricaoSchwarzbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0009");
            }
        });
        btnDescricaoBock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0010");
            }
        });
        btnDescricaoDoppelBock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0011");
            }
        });
        btnDescricaoAmericanPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0012");
            }
        });
        btnDescricaoExtraSpecialBitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0013");
            }
        });
        btnDescricaoBelgianPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0014");
            }
        });
        btnDescricaoBelgianBlondAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0015");
            }
        });
        btnDescricaoBelgianSpecialtyAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0016");
            }
        });
        btnDescricaoIndiaPaleAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0017");
            }
        });
        btnDescricaoRedALe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0018");
            }
        });
        btnDescricaoBrownAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0019");
            }
        });
        btnDescricaoDubbel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0020");
            }
        });
        btnDescricaoTrippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0021");
            }
        });
        btnDescricaoQuadrupel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0022");
            }
        });
        btnDescricaoGoldenStrongAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0023");
            }
        });
        btnDescricaoDarkStrongAle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0024");
            }
        });
        btnDescricaoWeissbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0025");
            }
        });
        btnDescricaoWeizenbock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0026");
            }
        });
        btnDescricaoDunkelWeizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0027");
            }
        });
        btnDescricaoWitbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0028");
            }
        });
        btnDescricaoStout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0029");
            }
        });
        btnDescricaoPorter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retornaCodigoEstiloCerveja("0030");
            }
        });


        return view;
    }

    public void retornaCodigoEstiloCerveja(String codigoEstiloCerveja) {
        Intent intent = new Intent(context, DescricaoEstiloCervejaActivity.class);
        bundle = new Bundle();
        bundle.putString("codigoEstiloCerveja", codigoEstiloCerveja);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


}
