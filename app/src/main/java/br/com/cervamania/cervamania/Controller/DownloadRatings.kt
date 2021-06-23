package br.com.cervamania.cervamania.Controller

import android.util.Log
import br.com.cervamania.cervamania.Model.ClassificacaoCerveja
import br.com.cervamania.cervamania.View.ListaCervejasActivity
import br.com.cervamania.cervamania.View.ListaClassificacaoCervejaSelecionadaActivity
import br.com.cervamania.cervamania.sqlite.DataBaseHelper
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private const val TAG = "DownloadRatings"

class DownloadRatings(
    val listOne: ListaClassificacaoCervejaSelecionadaActivity?,
    val listAll: ListaCervejasActivity?
) {


    fun downloadRatingsOneBeer(codigo: String) {
        listOne?.exibeProgresso()
        var sum = 0f
        var size = 0
        var comments = arrayListOf<String>()
        val db = Firebase.firestore
        db.collection("ratings")
            .whereEqualTo("codigo_cerveja", codigo)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    sum += document.data.get("nota").toString().toFloat()
                    size = documents.size()
                    comments.add(document.data.get("comentarios").toString())
                }
            }.addOnFailureListener { exception ->
                Log.i(TAG, "Error retrieving data:  ", exception)
                return@addOnFailureListener
            }.addOnCompleteListener {
                listOne?.populaComentarios(comments, sum / size)
                listOne?.escondeProgresso()
            }
    }

    fun downloadAllRatings() {
        listAll!!.exibeProgresso()
        val db = Firebase.firestore
        var lista = arrayListOf<ClassificacaoCerveja>()
        val hashMap = hashMapOf<String, Double>()
        val sql = DataBaseHelper(listAll!!.baseContext)
        var returnList = mapOf<String, Double>()
        db.collection("ratings")
            .orderBy("codigo_cerveja")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val classificacaoAtual = ClassificacaoCerveja(
                        document.get("codigo_cerveja").toString(),
                        document.get("comentarios").toString(),
                        "",
                        document.get("nota").toString().toDouble()
                    )
                    lista.add(classificacaoAtual)
                }
            }.addOnFailureListener { exception ->
                Log.i(TAG, "Error downloading", exception)
            }.addOnCompleteListener {
                val grouped = lista.groupBy { it.codigoCerveja }
                val codes = grouped.keys.toMutableList()
                for (i in 0 until codes.size) {
                    var rate = grouped[codes[i]]!!.sumOf { it.estrelas } / lista.count { it.codigoCerveja == codes[i] }
                    val nomeCerveja = sql.selectNomeCervejaPorCodigo(codes.get(i))
                    hashMap.put(nomeCerveja.toString().replace("[","").replace("]","") , rate)
                }
                returnList = hashMap.toList().sortedByDescending { (_, value) -> value }.toMap()
                val names = ArrayList(returnList.keys.toList())
                val notas = ArrayList(returnList.values.toList())
                listAll.escondeProgresso()
                listAll.populaLista(names,notas)
            }
    }
}
