package com.example.pokeapp.network

import android.os.Build
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.stream.Collectors

class NetworkClient(var url: String) {
    fun download(callbackOK : (String) -> Unit, callBackError : ( String) -> Unit) {

         Thread(){
             var urlConn = URL(url)
             val conn = urlConn.openConnection() as HttpURLConnection
             conn.requestMethod = "GET"
             conn.doOutput = true

             conn.connect()

             val statusCode = conn.responseCode
             if (statusCode!= 200){
                 // Errpr
                 callBackError("Error en la comunicacion")
             }else{
                 val inputStream = conn.inputStream
                 val resp = convertInputStreamtoString(inputStream)
                 inputStream.close()
                 callbackOK(resp)
             }
         }.start()


    }

    fun upload(){

    }

    private fun convertInputStreamtoString(inputStream : InputStream): String {
        val br = BufferedReader(InputStreamReader(inputStream))
        val cadena = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            br.lines().collect(Collectors.joining("\n"))
        }else{
            val cadenaCompleta = StringBuilder()
            var line : String = ""
            line = br.readLine()
            while(line != null){
                cadenaCompleta.append(line).append("\n")
                line = br.readLine()
            }
            cadenaCompleta.toString()
        }
        return cadena
    }
}