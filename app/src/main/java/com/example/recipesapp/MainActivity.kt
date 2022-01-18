package com.example.recipesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowId
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var foodlist: ArrayList<Food>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        foodlist = ArrayList<Food>()

        //Data
        val patlicanyemegi = Food("Patlıcan Yemeği" , "1) 4 adet orta boy patlıcan\n" + "2) 3 adet domates\n" + "3) 1 adet soğan\n" + "4) 1 adet kırmızı biber\n" + "5) 1 adet yeşil biber\n" + "6) 6 diş sarımsak\n" + "7) 1 tatlı kaşığı salça\n" + "8) 5 yemek kaşığı sıvı yağ\n" + "9) Üzerine çıkmayacak kadar soğuk su\n" + "10) Pul biber, tuz, karabiber",R.drawable.patlicanyemegi)
        val karniyarik = Food("Karnıyarık","1) 6adet orta boy patlıcan\n" + "2) 3 yemek kaşığı zeytinyağı\n" + "3) 1 adet büyük kuru soğan\n" + "4) 2 adet yeşil biber\n" + "5) 350 Gr kıyma\n" + "6) 1/2 tatlı kaşığı biber salçasıv\n" + "7) 1 çay kaşığı tuz\n" + "8) 2 adet domates",R.drawable.karniyarik)
        val manti = Food("Etli Mantı","1) 4 su bardağı un\n" + "2) 2 yumurta\n" + "3) 50 gr margarin\n" + "4) 250 gr kıyma\n" + "5) 1 demet maydanoz\n" + "6) 1 soğan\n" + "7) 2 su bardağı yoğurt\n" + "8) pulbiber\n" + "9) 1 paket et suyu tableti\n" + "10) 2 çorba kaşığı salça",R.drawable.etlimanti)
        val patatesyemegi = Food("Patates Yemeği","1) 3 adet patates\n" + "2) 1 adet soğan\n" + "3) 2 kaşık biber salçası\n"+"4) 3 yemek kaşığı yağ\n" + "5) 1 tatlı kaşığı pul biber\n"+"6) 1 tatlı kaşığı tuz\n" + "7) Sıcak su",R.drawable.patatesyemegi)
        val patatesKoftesi = Food("Patate Köftesi","1) 4 adet büyük boy haşlanmış patates\n" + "2) 1 çorba kaşığı domates salçası\n" + "3) 1 buçuk su bardağı galeta unu\n"+"1 yemek kaşığı pul biber\n" + "3 diş sarımsak\n" + "1 çay kaşığı karabiber",R.drawable.patateskofte)
        val pirincpilavi = Food("Pirinç Pilavı","1)2 adet patates\n" + "2) 2 su bardağı pirinç\n" + "3) 3 su bardağı sıcak su\n" + "4) 1 çay bardağı sıvı yağ\n" + "5) 1/2 (yarım) adet (5 gram) et veya tavuk bulyon\n" + "6) Tuz",R.drawable.pirincpilavi)
        val bulgurpilavi = Food("Bulgur Pilavı","1) 2 su bardağı pilavlık bulgur\n" + "2 adet domates\n" + "1 adet soğan\n" + "2 adet sivri biber\n" + "1 su bardağı tavuk suyu\n" + "2,5 su bardağı sıcak su (tavuk suyu da kullanabilirsiniz)\n" + "4 yemek kaşığı sıvı yağ\n" + "Tuz",R.drawable.bulgurpilavi)
        val sutlac = Food("Sütlaç","1) 1 lt süt\n" + "2) 2 çay bardağı pirinç\n" + "1 litre su\n" + "3) 3 yemek kaşığı pirinç unu\n" + "4) 1,5 -2 su bardağı toz şeker (eğer çok şekerli sevmiyorsanız 1,5 bardak kullanabilirsiniz)\n" + "tarçın",R.drawable.sutlacjpg)
        val irmiktatlisi=Food("İrmik Tatlısı","1) 3 yumurta\n" + "2) 1 su bardağı un\n" + "3) 1 su bardağı şeker\n" + "4)1 su bardağı yoğurt\n" + "5) 1, 5 su bardağı irmik\n" + "6) Yarım su bardağı sıvı yağ\n" + "7) 1 çay kaşığı karbonat yada 1 paket kabartma tozu",R.drawable.irmiktatlisi)
        val mozaiktatlisi=Food("Mozaik Tatlısı","1) 300 gram petibör bisküvi\n" + "2)1 su bardağı süt\n" + "3) 3 yemek kaşığı kakao\n" + "4)5 yemek kaşığı şeker\n" + "5) 3 yemek kaşığı eritilmiş tereyağı/margarin\n" + "6) 1 su bardağı ceviz veya fındık (isteğe bağlı)",R.drawable.mozaiktatlisi)


        foodlist.add(patlicanyemegi)
        foodlist.add(karniyarik)
        foodlist.add(manti)
        foodlist.add(patatesyemegi)
        foodlist.add(patatesKoftesi)
        foodlist.add(pirincpilavi)
        foodlist.add(bulgurpilavi)
        foodlist.add(sutlac)
        foodlist.add(irmiktatlisi)
        foodlist.add(mozaiktatlisi)




        //Adapter : Layout & Data and Maping

         val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1 , foodlist.map { food -> food.name })

        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,RecipesDetailes :: class.java )
            intent.putExtra("food",foodlist.get(position))
            startActivity(intent)
        }





    }




}