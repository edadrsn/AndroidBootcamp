package com.edadursun.trycatch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var globalX=10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TRY CATCH FINALLY
        var str = "5a"   //NumberFormatException
        var i: Int

        try {
            i = str.toInt()
        }
        catch (e:NumberFormatException){
            println("Yanlış Format")
        }
        catch (e: Exception) {
            println(e.message)
        }
        finally {
            //HER DURUMDA ÇALIŞIR
            println("Finally")
        }
        kontrol()


        val sonuc=intOrNullFonksiyonu("atil")

        println(globalX)
        fonk2()
        fonk1()


    }

    fun kontrol(){
        throw Exception("Hata oluştu")
    }

    fun intOrNullFonksiyonu(str:String):Int?{
        try {
            val numara=str.toInt()
            return  numara
        }catch (e: IOException){

        }catch (e:NumberFormatException){
            e.printStackTrace()
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        return null
    }


    fun fonk1(){
        globalX=20
        println(globalX)
    }

    fun fonk2(){
        globalX=30
        println(globalX)
    }
}

