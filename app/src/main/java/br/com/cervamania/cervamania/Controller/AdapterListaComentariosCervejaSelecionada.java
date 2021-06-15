package br.com.cervamania.cervamania.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.cervamania.cervamania.R;

public class AdapterListaComentariosCervejaSelecionada extends RecyclerView.Adapter<ViewHolderListaComentariosClassificacaoCervejaSelecionada> {

    private ArrayList<String> listaComentarios = new ArrayList<>();

    public AdapterListaComentariosCervejaSelecionada(ArrayList<String> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    @NonNull
    @Override
    public ViewHolderListaComentariosClassificacaoCervejaSelecionada onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_classificacao_cerveja_selecionada, parent, false);
        return new ViewHolderListaComentariosClassificacaoCervejaSelecionada(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListaComentariosClassificacaoCervejaSelecionada holder, int position) {
        String comentarioAtual = listaComentarios.get(position);
        holder.txtComentarios.setText(comentarioAtual);
    }

    @Override
    public int getItemCount() {
        return listaComentarios.size();
    }
}
