package com.example.baitap01_22110006

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baitap01_22110006.ui.theme.Baitap01_22110006Theme
import kotlin.math.sqrt
import com.example.baitap01_22110006.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        // Tạo mảng số nguyên
        val numbers = arrayListOf(11, 15, 18, 23, 29)

        // Duyệt qua mảng và in ra các số nguyên tố
        numbers.forEach { num ->
            if (isPrime(num)) {
                Log.d("PrimeNumber", "$num là số nguyên tố")
            }
        }

        val editTextArray: EditText = findViewById(R.id.editTextArray)
        val buttonProcessArray: Button = findViewById(R.id.buttonProcessArray)
        val textViewArrayResult: TextView = findViewById(R.id.textViewArrayResult)
        val circleImageView = findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.circleImageView)
        val textViewInfo = findViewById<TextView>(R.id.textViewInfo)

        // Xử lý khi nhấn nút
        buttonProcessArray.setOnClickListener {
            val input = editTextArray.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mảng!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Chuyển chuỗi nhập vào thành mảng số
            val numbers = parseArray(input)
            if (numbers == null) {
                Toast.makeText(this, "Dữ liệu không hợp lệ. Vui lòng nhập lại!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Xử lý: Tìm số chính phương trong mảng
            val squareNumbers = findSquareNumbers(numbers)

            // Hiển thị kết quả
            val result = "Các số chính phương trong mảng: $squareNumbers"
            textViewArrayResult.text = result
            Toast.makeText(this, "Số chính phương: $squareNumbers", Toast.LENGTH_SHORT).show()
        }
    }

    // Hàm kiểm tra số nguyên tố
    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }

    // Hàm chuyển chuỗi thành mảng số
    private fun parseArray(input: String): List<Int>? {
        return try {
            input.split(",")
                .map { it.trim().toInt() } // Loại bỏ khoảng trắng và chuyển thành số
        } catch (e: NumberFormatException) {
            null // Trả về null nếu có lỗi khi chuyển đổi
        }
    }

    // Hàm kiểm tra số chính phương
    private fun isSquareNumber(n: Int): Boolean {
        val sqrt = sqrt(n.toDouble()).toInt()
        return sqrt * sqrt == n
    }

    // Hàm tìm các số chính phương trong mảng
    private fun findSquareNumbers(numbers: List<Int>): List<Int> {
        return numbers.filter { isSquareNumber(it) }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Baitap01_22110006Theme {
        Greeting("Android")
    }
}