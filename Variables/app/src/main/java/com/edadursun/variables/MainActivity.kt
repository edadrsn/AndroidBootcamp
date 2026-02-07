package com.edadursun.variables

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

        //VARIABLES
        // Verileri geçici olarak sakladığımız kapsayıcılardır. Bellekte tuttuğumuz değerler için kullanılan kavramdır
        // Verileri saklamak ve üzerlerinde işlem yapmak için kullanırız
        // Kotlin type-safe tip-güvenli bir dildir
        // var degisken_adi : var ile oluşturulan değişkenin değeri daha sonra değiştirilebilir
        // val degisken_adi : val ile oluşturulan değişkenin değeri daha sonra değiştirilemez , sabit gibidirler
        // $: işareti parametre çağırır

        //KOTLINDE ÇIKTI ALMAK İÇİN 2 METOT KULLANILIR
        // print(): Aynı satıra yazı yazdırmak için kullanılır
        // println(): Yeni satıra yazı yazdırmak için kullanılır \n

        // SINGLE-LINE COMMENT
        /* MULTI-LINE COMMENTS */


        println("-----------------INTEGER & LONG -----------------------")
        var x = 10
        println(x * 10)

        x = 30 // x değişkeni var türünde olduğu için yeni bir değer atayabiliyoruz
        println(x / 5)

        var y = 5
        println(x * y)

        // Implicit Tanımlama:Kapalı tanımlama      type variable_name:variable type = value
        val z = 20
        println(z * 23)
        // z=30 yapamayız çünkü val değişkenler(final,const gibidirler) değerleri daha sonra değiştirilemez


        // Explicit Tanımlama:Açık tanımlama,türünü yazıyoruz
        val ornek: Int = 30
        val ornek2: Long = 129282872L
        println(ornek)
        print(ornek2)

        val m=10
        val n=30
        val sonuc=m*n
        println(sonuc)

        println("-----------------DOUBLE & FLOAT -----------------------")
        //Kotlin default olarak double görür. float olduğunu belirtmek için sonuna f/F koymamız gerekiyor
        val pi=3.14
        println(pi*4)

        val ornekDouble:Double=2.7
        println(pi*ornekDouble)

        val ornekFloat:Float = 2.25F
        println(ornekFloat-3)


        //Unsigned Integers
        val s1:UByte=1u
        val s2:UShort=1u
        val s3:ULong=1u
        val s4=42u
        val s5=0xFFF_FFFF_FFFu

        println("-----------------SHORT & BYTE -------------------------")
        val ilkShort:Short=-32768
        val sonShort:Short=32767
        val ilkByte:Byte=-128
        val sonByte:Byte=127


        println("---------------------BOOLEANS---------------------")
        var my_boolean:Boolean=true
        my_boolean=false

        println(3<5)  //true
        println(3>5)  //false
        println(2==2) //true
        println(1!=5) //true

        println("atil"=="atil") //true
        println(4>3 && 3>5)     //false
        println(5>8 || 6>8)     //false
        println(10!=10)         //false

        val userAge="18"
        println(userAge.toInt()  >= 18) //true

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

        //PAIR : bir veri çiftinin tek bir veri içinde tutulmasını sağlar
        var (a,b)=Pair(3,7)
        println(a)
        println(b)

        println("---------------------------TYPE CASTING------------------------")
        //Türleri birbirine dönüştürmek için kullanılır.
        //toByte(),toShort(),toInt(),toLong(),toFloat(),toDouble(),toChar()
        val yas2="15"
        val yasInt=yas2.toInt()
        println(yasInt*20)

        val myNum=5
        var myLongNum=myNum.toLong()
        println(myLongNum)

    }
}
