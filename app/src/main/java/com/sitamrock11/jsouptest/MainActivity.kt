package com.sitamrock11.jsouptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    lateinit var imgTest: ImageView
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgTest = findViewById(R.id.imgTest)
        val url = "https://firebase.google.com/"
        CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect(url).get()
            val img = document.select("img").first()
            val imgSrc = img.absUrl("src")
            withContext(Dispatchers.Main){
                Glide.with(baseContext).load(imgSrc).into(imgTest)
            }
        }
    }
}