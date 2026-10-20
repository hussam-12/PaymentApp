package ca.gbc.comp3074.mtatri.paymentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // enable the back botton
        val btnBack = findViewById<Button>(R.id.Back)

        btnBack.setOnClickListener {
            finish()
        }
    }
}
