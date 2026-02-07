package com.edadursun.arrays

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


        println("------------------ ARRAYS --------------------")

        //ARRAYOF: Kotlinde dizi oluşturmak için arrayOf kullanılır
        //Dizilere eleman ekleme çıkarma işlemi yapılmaz katı kuralları vardır.

        val cars= arrayOf("Volvo","BMW","Ford")
        println(cars.size)  //Dizinin eleman sayısını döndürür
        println(cars[0])    //Dizinin ilk elemanını döndürür
        cars[0] = "Porsche"
        println(cars[0])
        println(cars.get(0))

        if("Volvo" in cars){
            println("Exists")
        }else{
            println("No exists")
        }

        //Örn:
        val numbers= arrayOf(1,2,3,4,5)
        //println(numbers[5])bu satır çalışmaz çünkü son index 4 tür
        println(numbers[4])

        //Örn:
        val mixArray= arrayOf("Hello",true,5,2.8f,'e',null)
        println(mixArray.size)


        println("------------- RANGES -----------------")
        for(letter in 'a'..'z'){
            println(letter)
        }

        var total=0
        for(i in 0..9){
            total += i
        }
        println("Total: $total")

        for(num in 5..15){
            if(num==10) break
            println(num)
        }

        // DİZİ OLUŞTURMA
        val arr1= arrayOf(1,2,3)
        println(arr1.joinToString())

        val nullArr:Array<Int?> = arrayOfNulls(10)
        println(nullArr.joinToString())

        val emptyArray= emptyArray<String>()
        println(emptyArray.size)

        val initArr=Array(5){0}
        println(initArr.joinToString ())

        val squarredArray=Array(5){ i ->
            i * i
        }
        println(squarredArray.joinToString ())

        // DİZİ METOTLARI
        val sayilar= arrayOf(1,2,3,4,5,6,7,8,9,10)
        println(sayilar.slice(0..4))  //[1, 2, 3, 4, 5]
        println(sayilar.slice(0 until 4)) //[1, 2, 3, 4]

        val tek=sayilar.filter { it % 2 != 0 }
        for(i in tek){
            print("$i")
        }

        println(sayilar.count())      //10
        println(sayilar.first())      //1
        println(sayilar.last())       //10
        println(sayilar.contains(7))  //true

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
        //IMMUTABLE LIST: Elemanların eklenip çıkarılamayacağı bir koleksiyondur
        //Elemanlara erişim mümkündür. Değer ataması yapılmaz sadece erişim vardır
        val list:List<String> = listOf("Apple","Banana","Kiwi")
        println(list[0])
        // list[0] = "Orange" böyle bir şey olamaz immutable listlerde elemanlar değiştirilemez

        //MUTABLE LIST:Elemanların eklenip çıkarılabileceği ve güncellenebileceği koleksiyon türüdür
        val mutableList:MutableList<String> = mutableListOf("Apple","Banana","Kiwi")

        //Eleman ekleme
        mutableList.add(3,"Strawberry")
        mutableList.add("Strawberry")

        //Eleman çıkarma
        mutableList.remove("Kiwi")
        println(mutableList)   //["Apple","Banana","Strawberry"]

        //Eleman güncelleme
        mutableList[0] = "Cherry"
        println(mutableList[0])


        println("--------------------ARRAYLIST-------------------")
        //Dinamik olarak büyüyen bir dizidir.MutableList türündedir

        val arrayList = arrayListOf("Apple", "Banana", "Cherry")

        //Eleman ekleme
        arrayList.add("Mango")
        println(arrayList)

        //Eleman çıkarma
        arrayList.removeAt(1) // 1. indisteki elemanı çıkarır.
        println(arrayList)

        val isimler = arrayListOf("ali", "ela", "ala", "ece", "ada")
        println(isimler[0])
        println(isimler[1])
        println(isimler.size)

        // SONRADAN ELEMAN EKLEYEBİLİRİZ DİZİLERDE BU OLMUYORDU
        isimler.add(3, "irem")
        println(isimler[3])
        isimler.removeAt(2)

        val numaraListesi= arrayListOf<Int>()
        val digerListe=ArrayList<Int>()

        numaraListesi.add(10)
        numaraListesi.add(20)
        digerListe.add(30)
        digerListe.add(40)
        println(numaraListesi[1] * digerListe[1])

        val karisikListe= arrayListOf<Any>()
        karisikListe.add("atil")
        karisikListe.add(345)
        karisikListe.add(true)
        karisikListe.add(2.7F)

        val meyveler= arrayListOf<String>()
        meyveler.add("Elma")
        meyveler.add("Çilek")
        meyveler.add("Kiraz")
        for(index in 0..meyveler.size-1){
            println("${index} indexindeki meyvenin adı: ${meyveler[index]}")
        }

        println("---------------------ARRAYLIST<>--------------------------")
        //Dinamik Boyut: Eleman sayısı arttıkça boyutu otomatik olarak büyür.
        //Sıralı: Elemanlar sıralıdır, yani eklediğiniz sıraya göre elemanlara erişebilirsiniz.
        //İndekslenebilir: Elemanlar bir indeksle erişilebilir.

        val arrayList2= arrayListOf("Apple","Banana","Cherry")

        //Eleman ekleme
        arrayList2.add("Mango")
        println(arrayList2) // [Apple, Banana, Cherry, Mango]

        //Eleman çıkarma
        arrayList2.remove("Banana")
        println(arrayList2)  // [Apple, Cherry, Mango]

        //Eleman güncelleme
        arrayList2[0] = "Avocado"
        println(arrayList2)  // [Avocado, Cherry, Mango]



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


        println("------------------ HASHSET ---------------------")
        //HASHSET:Elemanları sırasız bir şekilde tutan ve tekrarlanan elemanları kabul etmeyen bir koleksiyon türüdür

        val hashset= hashSetOf("Apple","Banana","Cherry")
        //Eleman ekleme
        hashset.add("Mango")
        println(hashset) // [Apple, Banana, Cherry, Mango]

        //Tekrarlanan eleman eklemeye çalışma
        hashset.add("Apple") // Apple zaten var, eklenmez.
        println(hashset) // [Apple, Banana, Cherry, Mango]


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

        //Elimizde öğrencilerin notları bulunmaktadır.Bu listeye göre öğrencilerin not ortalamasının alınıp geçme ve
        // kalma durumlarını kontrol edilmesi ve ekrana yazdırılması
        var notlar= arrayListOf<ArrayList<Float>>()
        var ortalamalar= arrayListOf<Float>()
        var durumlar= arrayListOf<String>()

        notlar.add(arrayListOf(50f,40f,40f))
        notlar.add(arrayListOf(100f,100f,90f))

        for(i in 0..notlar.size-1){
            var ortalama=notlar[i].reduce { baslangic, gecerli ->baslangic + gecerli  } / notlar[i].size
            ortalamalar.add(ortalama)
        }

        durumlar= ortalamalar.map {
            if(it < 50){
                "Kaldı"
            }else{
                "Geçti"
            }
        } as ArrayList<String>

        ortalamalar.forEach{
            println(it)
        }

        durumlar.forEach{
            println(it)
        }

    }
}