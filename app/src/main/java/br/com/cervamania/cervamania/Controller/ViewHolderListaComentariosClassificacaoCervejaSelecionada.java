package br.com.cervamania.cervamania.Controller;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.cervamania.cervamania.R;

public class ViewHolderListaComentariosClassificacaoCervejaSelecionada extends RecyclerView.ViewHolder {

    public TextView txtComentarios;

    public ViewHolderListaComentariosClassificacaoCervejaSelecionada(View itemView) {
        super(itemView);
        this.txtComentarios = (TextView) itemView.findViewById(R.id.txtItemListaClassificacaoCervejaSelecionadaComentarios);
    }
}
