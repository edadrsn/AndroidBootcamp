package com.example.arrays

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arrays.databinding.ActivityBahsisHesaplaBinding
import java.text.NumberFormat
import java.util.Locale

class BahsisHesaplaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBahsisHesaplaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityBahsisHesaplaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TOOLBAR : App logosu - Sayfa başlığı vs içeren en üstteki bölüm
        //Constraint Layout
        //Linear Layout
        //Frame Layout
        //themes içinde statusBarcolor rengini değiştirirsen toolbar rengi değişir
        //window action bar false yap, windowNoTitle false de tooolbarı tamamen kaldır

        //Butona bas
        binding.hesaplaButon.setOnClickListener {
            bahsisHesapla()
        }

    }

    fun bahsisHesapla(){

        val alinanHizmetBedeli=binding.girilenHizmetBedeli.text.toString().toDouble()

        if(alinanHizmetBedeli==null){
            Toast.makeText(this@BahsisHesaplaActivity,"Lütfen Hizmet Bedeli değerini boş geçmeyiniz",Toast.LENGTH_SHORT).show()
        }

        val secilenBahsisSecenegi=binding.bahsisSecenekleriRadioGroup.checkedRadioButtonId
        val secilenDeger=when(secilenBahsisSecenegi){
            R.id.yuzde_yirmi_radio_button -> 0.20
            R.id.yuzde_onsekiz_radio_button -> 0.18
            else -> 0.15
        }

        var bahsis=alinanHizmetBedeli* secilenDeger

        val bahsisYuvarlansinMi=binding.bahsisYuvarlaSwitch.isChecked
        if(bahsisYuvarlansinMi){
            bahsis=kotlin.math.ceil(bahsis)
        }

        val formatlananBahsis=NumberFormat.getCurrencyInstance(Locale("tr","TR")).format(bahsis)
        binding.bahsisTutariTextView.text="Bahşiş Tutarı: ${formatlananBahsis} "


    }

}