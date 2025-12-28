package com.example.variables

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //KOTLINDE ÇIKTI ALMAK İÇİN 2 METOT KULLANILIR
        // print(): Aynı satıra yazı yazdırmak için kullanılır
        // println(): Yeni satıra yazı yazdırmak için kullanılır \n

        // SINGLE-LINE COMMENT
        /* MULTI-LINE COMMENTS */

        //VARIABLES
        // Verileri geçici olarak sakladığımız kapsayıcılardır
        // Verileri saklamak ve üzerlerinde işlem yapmak için kullanırız
        // var degisken_adi : var ile oluşturulan değişkenin değeri daha sonra değiştirilebilir
        // val degisken_adi : val ile oluşturulan değişkenin değeri daha sonra değiştirilemez , sabit gibidirler
        // $: işareti parametre çağırır


        println("-----------------INTEGER & LONG -----------------------")
        var x=10
        print(x*20)

        x=30  // x var bir değişken olduğu için yeni bir değer atayabiliriz
        println(x*30)

        var y=5
        println(x*y)

        //Implicit tanımlama: kapalı tanımlama
        val z=20
        println(z*50)
        //z=30 yapamayız çünkü val değişkenler sabitler(final,const) gibidirler

        //Explicit Tanımlama: Türünü yanına değişken adı:Tür adı=Değeri şeklinde yazıyoruz
        val ornekInt:Int=30
        val ornekLong:Long=1000000L
        println(ornekInt*20)
        println(ornekLong*10)

        val m=10
        val n=20
        val sonuc=m-n
        println(sonuc)


        println("-----------------DOUBLE & FLOAT -----------------------")
        //Kotlin default olarak double görür. float olduğunu belirtmek için sonuna f/F koymamız gerekiyor
        val pi=3.14
        println(pi*3)

        val ornekDouble=3.4
        println(pi*ornekDouble)

        val ornekFloat:Float=2.25F
        println(ornekFloat*7)

        //Unsigned Integers
        val q:UByte=1u
        val s:UShort=1u
        val l:ULong=1u
        val a1=42u
        val a2=0xFFFF_FFFF_FFFFu

        println("-----------------SHORT & BYTE -------------------------")
        val ilkShort:Short=-32768
        val sonShort:Short=32767
        val ilkByte:Byte=-128
        val sonByte:Byte=127


        println("---------------------BOOLEANS---------------------")
        var myBool:Boolean=true
        myBool=false

        println(3>5)
        println(3<5)
        println(6==6)
        println(6!=5)

        val userAge="18"
        println(userAge.toInt()>=18)

        println("atil"=="atil")
        println(4>3 && 3>5)
        println(5>8 || 6>8)
        println(10!=10)

        println("---------------------CHAR---------------------")
        val myGrade:Char='E'
        val charNumber:Char='6'
        val convertedCharNum=charNumber.toChar()
        println(convertedCharNum)



        println("------------------------STRINGS-----------------------")
        val myString="This is my string"
        println(myString)

        //String Concenation: + veya .plus() ile yapılır
        val name="atil"
        val surname="samancığlu"
        println(name + " " + surname)
        println(name.plus(surname))

        //INITIALIZE
        val benimstring:String
        benimstring="benim stringim"

        println("STRING METHODS")
        println(benimstring.get(5))
        println(benimstring.uppercase())
        println(benimstring.lowercase())
        println(benimstring.equals("hello"))
        println(benimstring.isEmpty())
        println(benimstring.replace("stringim","değişkenim"))
        println(benimstring.length)
        println(benimstring.indexOf('i'))
        println(benimstring.lastIndexOf('a'))

        //String Templates/Interpolation
        var firstName="John"
        var lastName="Doe"
        println("My name is $firstName $lastName")
        println("My name length is ${firstName.length}")


        println("---------------------------TYPE CASTING------------------------")
        //Türleri birbirine dönüştürmek için kullanılır.
        //toByte(),toShort(),toInt(),toLong(),toFloat(),toDouble(),toChar()
        val yas2="15"
        val yasInt=yas2.toInt()
        println(yasInt*20)

        val myNum=5
        var myLongNum=myNum.toLong()
        println(myLongNum)




        // ÖRN
        // ==============================
        // 25' inci yaş günün kutlu olsun
        // ==============================
        //
        // ''''''''''''''''''''''''''''''
        // ||||||||||||||||||||||||||||||
        // ==============================
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //
        // Nice mutlu yıllara
        // -Eda

        var isim="Eda"
        var yas=25
        var kat=4

        catiEkle(yas)
        println("${yas}'inci yaş günün kutlu olsun")
        catiEkle(yas)
        println("\n")

        mumEkle(yas)
        println()
        catiEkle(yas)
        pastaAlti(yas,kat)

        println("\n")
        println("Nice mutlu yıllara !")
        println("-${isim}")


    }

    fun catiEkle(yas:Int){
        repeat(yas + 4){
            print("=")
        }
        println()
    }

    fun mumEkle(yas:Int){
        repeat(yas+4){
            print("'")
        }
        println()
        repeat(yas+4){
            print("|")
        }
    }

    fun pastaAlti(yas:Int,kat:Int){
        repeat(kat){
            repeat(yas+4){
                print("@")
            }
            println()
        }
    }

}