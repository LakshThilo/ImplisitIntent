 package com.example.implicitintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnTakePhoto.setOnClickListener {

            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*" // Content could be anything here we need to specify the what Content we are looking for -->> Images

                startActivityForResult(it, 0) // here activity that we going to start is Gallery App
            }
        }
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
         super.onActivityResult(requestCode, resultCode, intent)

         if(resultCode == Activity.RESULT_OK && resultCode ==0){
             val uri = intent?.data

            ivPhoto.setImageURI(uri)
         }
     }
}