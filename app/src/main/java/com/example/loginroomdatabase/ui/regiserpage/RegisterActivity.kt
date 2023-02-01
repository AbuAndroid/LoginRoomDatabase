package com.example.loginroomdatabase.ui.regiserpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.RadioGroup
import android.widget.Toast
import com.example.loginroomdatabase.databinding.ActivityMainBinding


import com.example.loginroomdatabase.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    var binding: ActivityMainBinding? = null
    val registerViewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpListeners()

        binding?.uiRgGender?.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                Toast.makeText(this, "Checked Text : ${checkedId}", Toast.LENGTH_SHORT).show()
            }
        )

    }

    private fun setUpListeners() {
        binding?.uiBtSubmit?.setOnClickListener {
            insertDataToDb()
        }

        fetchAllDataInDb()
    }

    private fun fetchAllDataInDb() {
        registerViewModel.readAllData.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun insertDataToDb() {
        val name = binding?.uiTvUserName?.text.toString()
        val password = binding?.uiTvPassword?.text.toString()
        val email = binding?.uiTvUserEmail?.text.toString()
        val gender = binding?.uiRgGender?.checkedRadioButtonId.toString()
        val user = User(0, name = name, password = password, email = email, gender = gender)
        if (inputCheck(name, password)) {
            startActivity(Intent(this,RegisteredUsersActivity::class.java))
            CoroutineScope(Dispatchers.IO).launch {
                registerViewModel.insert(user)
            }
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Data is not inserted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, password: String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(password))
    }
}