package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    private val myName: MyName = MyName("Malik LAFIA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        biding.myName = myName
        //val doneButton: Button = findViewById(R.id.done_button)
         biding.doneButton.setOnClickListener {
             addNickName(it)
         }
    }

    private fun addNickName(view: View) {
        //val nicknameTextView: TextView = findViewById(R.id.nickname_textView)
        //val nicknameEditText: EditText = findViewById(R.id.nickename_editText)

        biding.apply {
            biding.myName?.nickname = biding.nickenameEditText.text.toString()
            biding.nicknameTextView.text = biding.nickenameEditText.text

            invalidateAll()
            biding.doneButton.visibility = View.GONE
            biding.nickenameEditText.visibility = View.GONE
            biding.nicknameTextView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}