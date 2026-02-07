package com.edadursun.conditionsandloops

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edadursun.conditionsandloops.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //OPERATORS
        //Arithmetic Operators: + - * / % ++ --
        //Assignment Operators: = += -= *= /= %=
        //Comparison Operators:== != > < >= <=
        //Logical Operators: && || !



        println("------------------CONDITIONS------------------")
        println("----IF----")

        val score = 10
        if (score < 10) {
            println("Kötü")
        } else if (10 <= score && score <= 20) {
            println("Orta")
        } else {
            println("İyi")
        }

        //Bankacılık işlemlerinde eft yapılmak isteniyor. İşlem yapılacak gün ve saat bilgisinin mesai günleri ve saatleri içinde olup olmadığına göre
        //kullanıcını işlemin yapılabileceği en yakın zaman bilgilendirmesinin yapılması
        var kullanici_islem_gunu = 2 //1.gün pazartesi
        var kullanici_islem_saati = 10
        if (kullanici_islem_gunu > 0 && kullanici_islem_gunu <= 7) {

            if (kullanici_islem_gunu <= 5) {
                if (kullanici_islem_saati > 0 && kullanici_islem_saati <= 24) {
                    if (kullanici_islem_saati >= 9 && kullanici_islem_saati <= 18) {
                        println("İşleminiz gerçekleştirilmiştir")
                    } else {
                        if (kullanici_islem_gunu == 5) {
                            println("İşleminiz 2 gün sonra saat 09:00 da gerçekleştirilecektir")
                        } else {
                            println("İşleminiz yarın saat 09:00 da gerçekleştirilecektir")
                        }
                    }

                } else {
                    println("Geçersiz saat")
                }

            } else if (kullanici_islem_gunu == 6) {
                println("İşleminiz 2 gün sonra saat 09:00 da gerçekleştirilecektir")
            } else {
                println("İşleminiz yarın saat 09:00 da gerçekleştirilecektir")
            }

        } else {
            println("Geçersiz işlem günü")
        }


        println("-----------WHEN-----------")
        //val varName=X
        /*when(varName) {
            1 -> value
            2 -> value
            3 -> value
            4 -> value
                ...
            else -> values
        }*/

        val day = 3
        when (day) {
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            4 -> println("Thursday")
            5 -> println("Friday")
            6 -> println("Saturay")
            7 -> println("Sunday")
            else -> println("Invalid day")
        }

        println("------------------------LOOPS---------------------------")

        println("------------FOR-------------")
        //for(i in arrayName){
        //    //codes
        //}

        //for(i in arrayName:indices){
        //  println(array[i])
        //}

        for (i in 0..9) {
            println(i)
        }

        val rastgele = (1..6).random()
        println(rastgele)

        var gun = 3
        var saat = 10
        when (gun) {
            in 1..5 -> {
                when (saat) {
                    in 9..17 -> {
                        println("İşleminiz gerçekleştirilmiştir")
                    }

                    in 0..8 -> {
                        println("İşleminiz bugün saat 09:00 da gerçekleştirilecektir")
                    }

                    in 18..24 -> {
                        when (gun) {
                            5 -> {
                                println("İşleminiz 3 gün sonra saat 09:00 da gerçekleştirilecektir")
                            }

                            else -> {
                                println("İşleminiz hafta içi gerçekleştirilecektir")
                            }
                        }
                    }

                }
            }

            6 -> {
                println("İşleminiz 2 gün sonra saat 09:00 da gerçekleştirilecektir")
            }

            7 -> {
                println("İşleminiz yarın saat 09:00 da gerçekleştirilecektir")

            }
        }


        println("---------WHILE--------")
        var i=0
        while (i <=10){
            println(i)
            i++
        }

        println("---------DO WHILE-------")
        var j=10
        do{
            println(j)
            j--
        }while (j>=0)

        // BREAK: Bir döngüyü tamamen kırmak,sonlandırmak için kullanılır
        // CONTINUE: Döngüde sadece verilen şarta ait iterasyonu atlayp diğer işlemleri yapmayı sağlar
        var x=0
        while (x<10){
            println(x)
            x++
            if(x==4) break
        }

        var y=0
        while (y<10){
            println(y)
            if(y == 5) continue
        }

        val cars= arrayOf("Volvo","BMW","Doblo")
        for(car in cars){
            println(car)
        }

        val numbers= arrayOf(10,20,30,40,50)
        for(num in numbers){
            println(i*10 / 5)
        }
        for(n in numbers.indices){
            var x=numbers[n] * 5
            println(x)
        }

        //ZAR OYUNU
        binding.button.setOnClickListener {
            val gelenSayi = (1..6).random()

            binding.number.setText("Sayı: " + gelenSayi)

            when (gelenSayi) {
                1 -> binding.imageView.setBackgroundResource(R.drawable.zar1)
                2 -> binding.imageView.setBackgroundResource(R.drawable.zar2)
                3 -> binding.imageView.setBackgroundResource(R.drawable.zar3)
                4 -> binding.imageView.setBackgroundResource(R.drawable.zar4)
                5 -> binding.imageView.setBackgroundResource(R.drawable.zar5)
                6 -> binding.imageView.setBackgroundResource(R.drawable.zar6)
                else -> binding.imageView.setBackgroundResource(R.drawable.ic_launcher_foreground)
            }


        }
    }
}