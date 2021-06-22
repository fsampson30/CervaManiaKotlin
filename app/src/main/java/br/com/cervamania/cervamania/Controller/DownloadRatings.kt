package br.com.cervamania.cervamania.Controller

import android.util.Log
import br.com.cervamania.cervamania.View.ListaClassificacaoCervejaSelecionadaActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private const val TAG = "DownloadRatings"

class DownloadRatings(
    val context : ListaClassificacaoCervejaSelecionadaActivity
) {


    fun downloadRatingsOneBeer(codigo: String) {
        context.exibeProgresso()
        var sum = 0f
        var size = 0
        var comments = arrayListOf<String>()
        val db = Firebase.firestore
        db.collection("ratings")
            .whereEqualTo("codigo_cerveja", codigo)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.i(TAG, "Donwload information: $documents.id => ${document.data}")
                    sum += document.data.get("nota").toString().toFloat()
                    size = documents.size()
                    comments.add(document.data.get("comentarios").toString())
                }
            }.addOnFailureListener{ exception ->
                Log.i(TAG, "Error retrieving data:  ", exception)
                return@addOnFailureListener
            }.addOnCompleteListener {
                context.populaComentarios(comments, sum/size)
                Log.i(TAG, "Donwload information: $sum")
                context.escondeProgresso()
            }
    }
}