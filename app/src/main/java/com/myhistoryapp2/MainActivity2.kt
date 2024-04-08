package com.myhistoryapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var editText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var constraintLayout: ConstraintLayout


    private val historicalFiguresImages = mapOf(
        76 to R.drawable.stephen,
        81 to R.drawable.victoria,
        57 to R.drawable.thomas,
        84 to R.drawable.newton,
        90 to R.drawable.florence,
        73 to R.drawable.darwin,
        36 to R.drawable.diana,
        41 to R.drawable.jane,
        57 to R.drawable.thomas,
        38 to R.drawable.henry

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        searchButton = findViewById(R.id.search)
        clearButton = findViewById(R.id.clear)
        editText = findViewById(R.id.editTextText)
        resultTextView = findViewById(R.id.textView)
        constraintLayout = findViewById(R.id.main)

        clearButton.setOnClickListener {
            editText.text.clear()
        }

        searchButton.setOnClickListener {

            val num = editText.text.toString().toIntOrNull()

            // If the number is not null and corresponds to a historical figure
            if (num != null && num in historicalFiguresImages.keys) {
                // Retrieve the corresponding image resource ID from the map
                val imageResourceId = historicalFiguresImages[num]
                // Set the background of the ConstraintLayout to the retrieved image
                if (imageResourceId != null) {
                    constraintLayout.setBackgroundResource(imageResourceId)
                }


                val specialNum = when (num) {
                    76 -> "Stephen Hawking"
                    81 -> "Queen Victoria"
                    52 -> "William Shakespeare"
                    84 -> "Isaac Newton"
                    90 -> "Florence Nightingale"
                    73 -> "Charles Darwin"
                    36 -> "Princess Diana"
                    41 -> "Jane Austen"
                    57 -> "Thomas More"
                    38 -> "Henry VIII"

                    else -> null
                }

                // Display the description in the resultTextView
                val message = if (specialNum != null) {
                    "Your historical twin is $specialNum."
                } else {
                    "No one seems to match your age."
                }
                resultTextView.text = message
            }
        }
    }
}