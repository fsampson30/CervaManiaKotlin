package br.com.cervamania.cervamania.Controller

import android.content.Context
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.util.concurrent.Executor

private const val TAG = "DownloadImages"

class DownloadImages  (
    val context: Context,
    val nomeCerveja : String
        ) {

    fun retornaImageUrl() : String {
        val db = Firebase.storage
        val storageRef = db.reference
        val pathRef = storageRef.child("amber1.png")
        var stringUrl = ""
        pathRef.downloadUrl.addOnSuccessListener {
            stringUrl = it.toString()
            Log.i(TAG, "URL Foto aqui$stringUrl" )
        }.addOnFailureListener{
            stringUrl = "https://firebasestorage.googleapis.com/v0/b/cervamania.appspot.com/o/amber1.png?alt=media&token=801e103d-459b-4956-906d-14cd0b758f5c"
            Log.i(TAG, "URL Foto ERRO")
        }
        return stringUrl
    }
}