package com.sitamrock11.jsouptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val url = Constants.someUrl
        val wbUrl = Constants.wbUrl
        CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect(wbUrl).get()
            val cylinderCnt = document.select("#content [class='badge badge-pill badge-success']")
              val bedCnt = document.select("#counter2")
            withContext(Dispatchers.Main){
              //  Glide.with(baseContext).load(imgSrc).into(imgTest)

            }
        }
    }
}