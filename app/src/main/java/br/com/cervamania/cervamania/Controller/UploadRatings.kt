package br.com.cervamania.cervamania.Controller

import android.widget.Toast
import br.com.cervamania.cervamania.Model.ClassificacaoCerveja
import br.com.cervamania.cervamania.View.InsereClassificacaoCervejaSelecionadaActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private const val TAG = "UploadRatings"

class UploadRatings(
    val context : InsereClassificacaoCervejaSelecionadaActivity
) {

    fun addRating(classificacao: ClassificacaoCerveja ){
        context.exibeProgresso()
        val db = Firebase.firestore
        val rating = hashMapOf(
            "codigo_cerveja" to classificacao.codigoCerveja,
            "comentarios" to classificacao.comentarios,
            "nota" to classificacao.estrelas
        )
        db.collection("ratings").add(rating).addOnSuccessListener {
            Toast.makeText(context,"Cerveja classificada com sucesso!", Toast.LENGTH_SHORT).show()
            context.escondeProgresso()
            context.onBackPressed()
        }.addOnFailureListener { e ->
            Toast.makeText(context, "Erro ao classificar, tente novamente", Toast.LENGTH_SHORT).show();
            context.escondeProgresso()
            return@addOnFailureListener
        }
    }
}