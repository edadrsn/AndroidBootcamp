package com.edadursun.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edadursun.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPreferences:SharedPreferences
    var getAge:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SHARED PREFERENCES:KÜÇÜK BOYUTLU VERİLERİ KALICI OLARAK SAKLAMAK İÇİN KULLANILIR
        //UYGULAMA KAPATILIP AÇILSA BİLE VERİLER KAYBOLMAZ. VERİLER KEY-VALUE FORMATINDA SAKLANIR. VERİLER XML DOSYASI OLARAK CİHAZ HAFIZASINDA SAKLANIR

        sharedPreferences=this.getSharedPreferences("com.edadursun.sharedpreferences", Context.MODE_PRIVATE)

        //VERİ KAYDETME
        //sharedPreferences.edit().putString(key,value).apply()
        //sharedPreferences.edit().putInt(key,value).apply()
        //sharedPreferences.edit().putLong(key,value).apply()
        //sharedPreferences.edit().putFloat(key,value).apply()
        //sharedPreferences.edit().putBoolean(key,value).apply()

        //VERİ SİLME
        //sharedPreferences.edit().remove(key).apply()
        //sharedPreferences.edit().clear().apply()

        //VERİ ALMA
        getAge=sharedPreferences.getInt("age",0)
        if(getAge != 0){
            binding.result.text= "YOUR AGE: $getAge"
        }

    }
    //Kaydet
    fun save(view: View){
        val myAge=binding.age.text.toString().toIntOrNull()
        if(myAge != null){
            binding.result.text="YOUR AGE: $myAge"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }
    //Sil
    fun delete(view:View){
        binding.result.text="YOUR AGE:"
        sharedPreferences.edit().remove("age").apply()
    }
}