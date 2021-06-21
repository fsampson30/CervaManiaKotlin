package br.com.cervamania.cervamania.Controller

import android.content.Context
import android.util.Log
import br.com.cervamania.cervamania.Model.ImagensCervejas
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


private const val TAG = "DownloadImages"

class DownloadImages(
    val context: Context,
    val nomeCerveja: String
) {

    fun retornaImageUrl(): String {
        val arquivo = ImagensCervejas().retornaArquivoCerveja(nomeCerveja)
        val db = Firebase.storage
        val storageRef = db.reference
        val pathRef = storageRef.child(arquivo)
        var stringUrl = ""
        Log.i(TAG, "URL Foto: $stringUrl")
        pathRef.downloadUrl.addOnSuccessListener {
            stringUrl = it.toString()
            Log.i(TAG, "URL Foto aqui:  $stringUrl")
        }.addOnFailureListener {
            Log.i(TAG, "URL Foto ERRO")
            return@addOnFailureListener
        }
        return stringUrl
    }
}