package br.com.cervamania.cervamania.Controller;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.cervamania.cervamania.R;

public class ViewHolderListaCervejas extends RecyclerView.ViewHolder {

    public ImageView imgListaCervejaGarrafa;
    public TextView txtListaCervejaNome;
    public Button btnListaCervejaDetalhes;
    public LinearLayout layoutHeaderListaCerveja;
    public RatingBar barraClassificacao;



    public ViewHolderListaCervejas(View itemView) {
        super(itemView);
        this.imgListaCervejaGarrafa = (ImageView) itemView.findViewById(R.id.imgListaCervejaGarrafa);
        this.txtListaCervejaNome = (TextView) itemView.findViewById(R.id.txtListaCervejaNome);
        this.btnListaCervejaDetalhes = (Button) itemView.findViewById(R.id.btnListaCervejaDetalhes);
        this.layoutHeaderListaCerveja = (LinearLayout) itemView.findViewById(R.id.layoutHeaderListaCervejas);
        this.barraClassificacao = (RatingBar) itemView.findViewById(R.id.barClassificacaoCerveja);
    }
}
