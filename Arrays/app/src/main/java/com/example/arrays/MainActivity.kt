package com.example.arrays

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arrays.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ileri.setOnClickListener {
            startActivity(Intent(this@MainActivity, BahsisHesaplaActivity::class.java))
        }


        println("------------------ ARRAYS --------------------")

        //ARRAYOF: Kotlinde dizi oluşturmak için arrayOf kullanılır
        //Dizilere eleman ekleme çıkarma işlemi yapılmaz katı kuralları vardır.Bunun için farklı yapılar var

        val cars = arrayOf("Volvo", "BMW", "Ford")
        println(cars.size)  //Dizinin eleman sayısını döndürür
        println(cars[0])    //Dizinin ilk elemanını döndürür
        cars[0] = "Porsche"   //Dizinin ilk elemanının değerini değiştirir
        println(cars[0])

        if ("Volvo" in cars) {
            println("Exists")
        } else {
            println("No exists")
        }

        //Örn:
        val numbers = arrayOf(1, 2, 3, 4, 5)
        //println(numbers[5]) BU SATIR ÇALIŞMAZ ÇÜNKÜ DİZİDEKİ SONUNCU INDEX 4 TÜR.
        print(numbers[4])

        //Örn:
        val mixArray = arrayOf(10, 3.5, true, "hello", false, 'e')
        println(mixArray[2])

        println("------------- RANGES -----------------")
        for (chars in 'a'..'x') {
            println(chars)
        }

        var toplam = 0
        for (i in 0..9) {
            toplam = toplam + i
        }
        println("Toplam: $toplam")

        for (nums in 5..15) {
            if (nums == 10)
                break
            println(nums)
        }


        //DİZİ OLUŞTURMA
        val arr1 = arrayOf(1, 2, 3)
        println(arr1.joinToString())

        val nullArr: Array<Int?> = arrayOfNulls(3)
        println(nullArr.joinToString())

        val emptyArray = emptyArray<String>()
        println(emptyArray.size)

        val initArr = Array(5) { 0 }
        println(initArr.joinToString())

        val squaredArr = Array(5) { i ->
            (i * i)
        }
        println(squaredArr.joinToString())

        // DİZİ METOTLARI
        val sayilar = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println(sayilar.slice(0..4))
        println(sayilar.slice(0 until 4))

        val tek = sayilar.filter { it % 2 != 0 }
        for (i in tek) {
            print(" $i ")
        }
        println()

        println(sayilar.count())
        println(sayilar.first())
        println(sayilar.last())
        println(sayilar.contains(7))

        // Kotlin 1.4 ve sonrası için:
        println(sayilar.maxOrNull())
        println(sayilar.minOrNull())

        // println(sayilar.sort()) // Array.sort() void döner, println yazmak doğru değil
        sayilar.reverse()
        for (j in sayilar) {
            println(j)
        }

        // sayilar.set(10,11) // BU SATIR HATALI! ÇÜNKÜ 10. index yok.
        // Eğer MutableList kullanırsan eleman ekleyebilirsin:
        val sayilarList = sayilar.toMutableList()
        sayilarList.add(11)
        println(sayilarList[10])

        println("--------------------COLLECTIONS-------------------")

        //IMMUTABLE LIST:Elemanların eklenip çıkarılmayacağı bir koleksiyondur.
        //Elemanlara erişim mümkündür. Değer ataması yapılamaz sadece erişim vardır
        val list: List<String> = listOf("Apple", "Banana", "Cherry")

        //Elemanlara erişim
        println(list[0]) //Apple
        // x list[0]= "Orange" olmaz hatalıdır

        //MUTABLE LIST:Elemanların eklenip çıkarılabileceği ve güncellenebileceği koleksiyon türüdür
        val mutableList: MutableList<String> = mutableListOf("Apple", "Banana", "Cherry")

        //Eleman ekleme
        mutableList.add(3, "Watermelon")
        mutableList.add("Kiwi")

        //Eleman çıkarma
        mutableList.remove("Kiwi")  //Kiwi elemanını çıkarır
        println(mutableList)  // ["Apple","Banana","Cherry","Watermelon"]

        //Eleman güncelleme
        mutableList[0] = "Avocado"  //Apple yerine Avocado yazar
        println(mutableList[0])   // ["Avocado","Banana","Cherry","Watermelon"]


        println("--------------------ARRAYLIST-------------------")

        //ARRAYLIST : dinamik olarak büyüyen bir dizidir ve MutableList türündedir.

        val arrayList = arrayListOf("Apple", "Banana", "Cherry")

        // Eleman ekleme
        arrayList.add("Mango")
        println(arrayList) // [Apple, Banana, Cherry, Mango]

        // Eleman çıkarma
        arrayList.removeAt(1) // 1. indisteki elemanı (Banana) çıkarır.
        println(arrayList) // [Apple, Cherry, Mango]

        val isimler = arrayListOf("ali", "ela", "ala", "ece", "ada")
        println(isimler[0])
        println(isimler[1])
        println(isimler.size)

        //SONRADAN ELEMAN EKLEYEBİLİRİZ DİZİLERDE BU OLMUYORDU
        isimler.add(3, "irem")
        println(isimler[3])
        isimler.removeAt(2)


        val numaraListesi = arrayListOf<Int>()
        val digerListe = ArrayList<Int>()
        numaraListesi.add(10)
        numaraListesi.add(20)
        digerListe.add(30)
        digerListe.add(40)
        println(numaraListesi[1] * digerListe[1])

        val karisikListe = arrayListOf<Any>()
        karisikListe.add("atil")
        karisikListe.add(20)
        karisikListe.add(true)

        println("--------------------SET-------------------")

        // SET:(immutable set): Küme.Tekrarlanan elemanları kabul etmez.Eleman eklenip çıkarılmaz
        val set: Set<String> = setOf("Apple", "Banana", "Cherry")

        // Set içerisinde belirli bir eleman var mı?
        println(set.contains("Apple")) // true
        println(set.contains("Mango")) // false

        // SET:(mutable set): Elemanları ekleyip çıkarabileceğimiz bir set türüdür
        val mutableSet: MutableSet<String> = mutableSetOf("Apple", "Banana", "Cherry")

        // Eleman ekleme
        mutableSet.add("Mango") // Mango'yu sete ekler.
        println(mutableSet) // [Apple, Banana, Cherry, Mango]

        // Eleman çıkarma
        mutableSet.remove("Banana") // "Banana"yı çıkarır.
        println(mutableSet) // [Apple, Cherry, Mango]


        println("--------------------MAP-------------------")

        // MAP: (immutable map): Anahtar-Değer çiftlerini tutan bir koleksiyondur.Immutable mapte eleman eklenip çıkarılamaz
        val map: Map<String, String> = mapOf("A" to "Apple", "B" to "Banana", "C" to "Cherry")

        // Anahtar üzerinden değer erişimi
        println(map["A"]) // Apple
        println(map["D"]) // null

        // MAP:(mutable map): Anahtar-değer çiftlerine eleman ekleyip çıkarabileceğimiz bir koleksiyon türüdür
        val mutableMap: MutableMap<String, String> = mutableMapOf("A" to "Apple", "B" to "Banana", "C" to "Cherry")

        // Eleman ekleme
        mutableMap["D"] = "Date" // "D" anahtarı ile "Date" değeri ekler.
        println(mutableMap) // {A=Apple, B=Banana, C=Cherry, D=Date}

        // Eleman çıkarma
        mutableMap.remove("B") // "B" anahtarı ile "Banana"yı çıkarır.
        println(mutableMap) // {A=Apple, C=Cherry, D=Date}

        // Eleman güncelleme
        mutableMap["A"] = "Avocado" // "Apple" yerine "Avocado" koyar.
        println(mutableMap) // {A=Avocado, C=Cherry, D=Date}

        println("------------------ HASHSET ---------------------")
        //HASHSET:Elemanları sırasız bir şekilde tutan ve tekrarlanan elemanları kabul etmeyen bir koleksiyon türüdür

        val hashset= hashSetOf("Apple","Banana","Cherry")
        //Eleman ekleme
        hashset.add("Mango")
        println(hashset) // [Apple, Banana, Cherry, Mango]

        //Tekrarlanan eleman eklemeye çalışma
        hashset.add("Apple") // Apple zaten var, eklenmez.
        println(hashset) // [Apple, Banana, Cherry, Mango]

        println("--------------- HASHMAP --------------------")
        //HASHMAP: anahtar-değer çiftlerini tutan sırasız bir koleksiyondur
        val hashMap= hashMapOf("A" to "Apple" , "B" to "Banana")

        //Eleman ekleme
        hashMap["C"] = "Cherry" // "C" anahtarı ile "Cherry" değeri ekler.
        println(hashMap) // {A=Apple, B=Banana, C=Cherry}

        // Eleman çıkarma
        hashMap.remove("B") // "B" anahtarı ile "Banana"yı çıkarır.
        println(hashMap) // {A=Apple, C=Cherry}

        // Eleman güncelleme
        hashMap["A"] = "Avocado" // "Apple" yerine "Avocado" koyar.
        println(hashMap) // {A=Avocado, C=Cherry


        println("---------------------ARRAYLIST<>--------------------------")
        //Dinamik Boyut: Eleman sayısı arttıkça boyutu otomatik olarak büyür.
        //Sıralı: Elemanlar sıralıdır, yani eklediğiniz sıraya göre elemanlara erişebilirsiniz.
        //İndekslenebilir: Elemanlar bir indeksle erişilebilir.

        val arrayList2 = arrayListOf("Apple", "Banana", "Cherry")

        // Eleman ekleme
        arrayList2.add("Mango")
        println(arrayList2) // [Apple, Banana, Cherry, Mango]

        // Eleman çıkarma
        arrayList2.remove("Banana")
        println(arrayList2) // [Apple, Cherry, Mango]

        // Eleman güncelleme
        arrayList2[0] = "Avocado"
        println(arrayList2) // [Avocado, Cherry, Mango]

        println("----------------------------HASHSET<>--------------------------")
        //Sırasız: Elemanlar belirli bir sırada saklanmaz.
        //Benzersiz Elemanlar: Aynı eleman birden fazla kez eklenemez.
        //Hızlı Erişim: Elemanlara hızlı erişim sağlar, çünkü bir HashSet dahili olarak hash tablosu kullanır.

        // HashSet ile String türünde bir set
        val hashSet2 = hashSetOf("Apple", "Banana", "Cherry")

        // Eleman ekleme
        hashSet2.add("Mango")
        println(hashSet2) // [Apple, Banana, Cherry, Mango]

        // Tekrarlanan eleman eklemeye çalışma
        hashSet2.add("Apple") // Apple zaten var, eklenmez.
        println(hashSet2) // [Apple, Banana, Cherry, Mango]


        println("------------------------HASHMAP<K,V>-------------------------")
        //Anahtar-Değer Çiftleri: Her anahtar bir değere karşılık gelir.
        //Benzersiz Anahtarlar: Aynı anahtar yalnızca bir kez bulunabilir.
        //Sırasız: Elemanlar sırasızdır, yani eklediğiniz sıraya göre erişim yapamazsınız.

        // HashMap ile String türünde anahtarlar ve Integer türünde değerler
        val hashMap2 = hashMapOf("A" to "Apple", "B" to "Banana", "C" to "Cherry")

        // Eleman ekleme
        hashMap2["D"] = "Date"
        println(hashMap2) // {A=Apple, B=Banana, C=Cherry, D=Date}

        // Eleman çıkarma
        hashMap2.remove("B")
        println(hashMap2) // {A=Apple, C=Cherry, D=Date}

        // Eleman güncelleme
        hashMap2["A"] = "Avocado"
        println(hashMap2) // {A=Avocado, C=Cherry, D=Date}

    }
}