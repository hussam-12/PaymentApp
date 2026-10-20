package ca.gbc.comp3074.mtatri.paymentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            
        }
        val inHours = findViewById<EditText>(R.id.noOfHour)
        val inHourlyRate= findViewById<EditText>(R.id.hourlyRate)
        val inTaxRate = findViewById<EditText>(R.id.taxRate)

        val outPay = findViewById<EditText>(R.id.pay)
        val outOverTimePay = findViewById<EditText>(R.id.overtimePay)
        val outTotalPay = findViewById<EditText>(R.id.totalPay)
        val outTax = findViewById<EditText>(R.id.tax)

        val btnCalculate = findViewById<Button>(R.id.Calculate)
        val btnAbout = findViewById<Button>(R.id.About)

        btnAbout.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

       btnCalculate.setOnClickListener {
            val hoursS = inHours.text.toString()
            val rateS = inHourlyRate.text.toString()
            val taxRateS = inTaxRate.text.toString()

            val hours = hoursS.toDouble()
            val hourlyRate = rateS.toDouble()
            val taxRate = taxRateS.toDouble()

            val pay: Double
            val overtimePay : Double

            if( hours <= 40.0){
                pay = hours * hourlyRate
                overtimePay = 0.0

            }else{
                pay = 40.0 * hourlyRate
                overtimePay = (hours - 40.0) * hourlyRate * 1.5
            }
            val totalPay = pay + overtimePay
            val tax = pay * taxRate/100

            outPay.setText(String.format("%.2f",pay))
            outOverTimePay.setText(String.format("%.2f",overtimePay))
            outTotalPay.setText(String.format("%.2f",totalPay))
            outTax.setText(String.format("%.2f",tax))

        }
    }

}
