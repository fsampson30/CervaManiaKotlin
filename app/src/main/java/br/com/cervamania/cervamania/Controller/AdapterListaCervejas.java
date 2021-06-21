package br.com.cervamania.cervamania.Controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.cervamania.cervamania.Model.CoresCervejas;
import br.com.cervamania.cervamania.Model.ImagensCervejas;
import br.com.cervamania.cervamania.Model.NomesEstilosCervejas;
import br.com.cervamania.cervamania.R;
import br.com.cervamania.cervamania.View.DetalhesCervejaActivity;


public class AdapterListaCervejas extends RecyclerView.Adapter<ViewHolderListaCervejas> {

    private static final String TAG = "AdapterListaCervejas";
    private ArrayList<String> listaNomesCervejas = new ArrayList<>();
    private ArrayList<Double> notasClassificacoes = new ArrayList<>();
    private String codigoTipoCerveja;
    private String origemFragment;
    private ImagensCervejas imagens = new ImagensCervejas();
    private CoresCervejas cores = new CoresCervejas();

    public AdapterListaCervejas(ArrayList<String> nomeCerveja, String codigoTipoCerveja, String origemFragment, ArrayList<Double> notasClassificacoes) {
        this.listaNomesCervejas = nomeCerveja;
        this.codigoTipoCerveja = codigoTipoCerveja;
        this.origemFragment = origemFragment;
        this.notasClassificacoes = notasClassificacoes;
    }

    @NonNull
    @Override
    public ViewHolderListaCervejas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_cervejas, parent, false);
        return new ViewHolderListaCervejas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderListaCervejas holder, int position) {
        final String nomeAtual = listaNomesCervejas.get(position);
        String path = imagens.retornaArquivoCerveja(nomeAtual);
        //DownloadImages downloadImages = new DownloadImages(holder.itemView.getContext(), nomeAtual);
        //String teste = downloadImages.retornaImageUrl();
        holder.txtListaCervejaNome.setText(nomeAtual);
        Picasso.get().load(path).fetch();

        //holder.imgListaCervejaGarrafa.setImageResource(R.drawable.caneca);
        if (!path.isEmpty()) {
            Picasso.get().load(path).placeholder(R.drawable.caneca).into(holder.imgListaCervejaGarrafa);
        } else {
            holder.imgListaCervejaGarrafa.setImageResource(R.drawable.caneca);
        }


        switch (origemFragment) {
            case "estilos": {
                holder.layoutHeaderListaCerveja.setBackgroundColor(holder.itemView.getContext().getResources().getColor(cores.retornaCoresCervejasHeaderCard(codigoTipoCerveja)));
                break;
            }
            case "paises": {
                holder.layoutHeaderListaCerveja.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorHeader));
                break;
            }
            case "classificacoes": {
                holder.layoutHeaderListaCerveja.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorHeader));
                break;
            }
        }

        holder.btnListaCervejaDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalhesCervejaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nomeCerveja", nomeAtual);
                bundle.putString("codigoEstiloCerveja", codigoTipoCerveja);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.barraClassificacao.setVisibility(View.GONE);

        if (origemFragment.equals("classificacoes")) {
            holder.barraClassificacao.setRating(notasClassificacoes.get(position).floatValue());
            holder.barraClassificacao.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listaNomesCervejas.size();
    }
}
