package vcmsa.nika.mathapp

import android.os.Bundle
import android.util.Log
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
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        btnCalculate.setOnClickListener {
            val first = edtEnterValueOne.text.toString().trim()
            val second = edtEnterValueTwo.text.toString().trim()

            tvFinalAnswer.text = ""

            if (first.isEmpty() || second.isEmpty()) {
                tvFinalAnswer.text = "Please enter both numbers"
            } else {
                val firstNum = first.toIntOrNull()
                val secondNum = second.toIntOrNull()

                if (firstNum == null || secondNum == null) {
                    tvFinalAnswer.text = "Please enter valid integer numbers"
                } else {
                    val selectedOperationId = radioGroup.checkedRadioButtonId

                    if (selectedOperationId == -1) {
                        tvFinalAnswer.text = "Please select an operation (Addition or Subtraction)"
                    } else {
                        val selectedOperation = findViewById<RadioButton>(selectedOperationId)

                        val result: Int
                        val operationName: String

                        when (selectedOperation.id) {
                            R.id.rbtnAdd -> {
                                result = firstNum + secondNum
                                operationName = "Addition"
                            }
                            R.id.rbtnSubtract -> {
                                result = firstNum - secondNum
                                operationName = "Subtraction"
                            }
                            else -> {
                                result = 0
                                operationName = "Unknown operation"
                            }
                        }

                        Log.d("CalculationResult", "Operation: $operationName, Result: $result")
                        tvFinalAnswer.text = "$operationName result: $result"
                    }
                }
            }
        }
    }
}
