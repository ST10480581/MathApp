package vcmsa.nika.mathapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEnterValueOne = findViewById<EditText>(R.id.edtEnterValueOne)
        val edtEnterValueTwo = findViewById<EditText>(R.id.edtEnterValueTwo)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvFinalAnswer = findViewById<TextView>(R.id.tvFinalAnswer)

        btnCalculate.setOnClickListener {
            val first = edtEnterValueOne.text.toString()
            val second = edtEnterValueTwo.text.toString()

            if (first.isNotEmpty() && second.isNotEmpty()) {
                val sum = first.toInt() + second.toInt()
                tvFinalAnswer.text = "Final Answer: $sum"
            } else {
                tvFinalAnswer.text = "Please enter both numbers"
            }
        }
    }
}
