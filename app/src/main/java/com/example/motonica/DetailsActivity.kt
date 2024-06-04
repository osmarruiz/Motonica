package com.example.motonica

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price = intent.getStringExtra("price")
        val mileage = intent.getStringExtra("mileage")
        val year = intent.getStringExtra("year")
        val brand = intent.getStringExtra("brand")
        val model = intent.getStringExtra("model")
        val engine = intent.getStringExtra("engine")
        val color = intent.getStringExtra("color")
        val location = intent.getStringExtra("location")
        val description = intent.getStringExtra("description")

        val txtPrice: TextView = findViewById(R.id.txt_precio)
        val txtMileage: TextView = findViewById(R.id.txt_kilometro)
        val txtYear: TextView = findViewById(R.id.txt_anio)
        val txtBrand: TextView = findViewById(R.id.textBrand)
        val txtModel: TextView = findViewById(R.id.textModel)
        val txtEngine: TextView = findViewById(R.id.textMotor)
        val txtColor: TextView = findViewById(R.id.textColor)
        val txtLocation: TextView = findViewById(R.id.textFind)
        val txtDescription: TextView = findViewById(R.id.txt_description)

        txtPrice.text = price
        txtMileage.text = mileage + "KM"
        txtYear.text = year
        txtBrand.text = brand
        txtModel.text = model
        txtEngine.text = engine
        txtColor.text = color
        txtLocation.text = location
        txtDescription.text = description

    }
}