package com.nfragiskatos.coroutinesdemo1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(Dispatchers.Main).launch {
//            Log.i("MyTag", "Calculation Starting...")
//
//            val stock1: Deferred<Int> = async(Dispatchers.IO) { getStock1() }
//            val stock2: Deferred<Int> = async(Dispatchers.IO) { getStock2() }
//            val total = stock1.await() + stock2.await()
//            Toast.makeText(applicationContext, "Total Value: $total", Toast.LENGTH_LONG).show()
//            Log.i("MyTag", "Total is $total")
//        }

//        btnCount.setOnClickListener {
//            tvCount.text = count++.toString()
//        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
//                downloadUserData()
//                tvUserMessage.text = UserDataManager1().getTotalUserCount().toString()
                tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()
            }
        }
    }

    private suspend fun downloadUserData() {

//            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        withContext(Dispatchers.Main) {
            for (i in 1..200000) {
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(1000)
            }
        }

    }
}

private suspend fun getStock1() : Int {
    delay(10000)
    Log.i("MyTag", "stock 1 returned")
    return 55000
}

private suspend fun getStock2() : Int {
    delay(8000)
    Log.i("MyTag", "stock 2 returned")
    return 35000
}
