package com.example.tugaspertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugaspertemuan8.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root
        val authenticationActivity = requireActivity() as AuthenticationActivity

        // mengambil data
        val args = this.arguments
        val usernameRegister = args?.get("username").toString()
        val passwordRegister = args?.get("password").toString()

        with(binding){
            editTextUsername.setSingleLine(true)

            btnLogin.setOnClickListener{
                val usernameLogin = editTextUsername.text.toString()
                val passwordLogin = editTextPassword.text.toString()

                if (usernameLogin != "" && passwordLogin != "") {
                    if (usernameLogin == usernameRegister && passwordLogin == passwordRegister) {
                        // pindah ke HomeActivity
                        val intentToHomeActivity = Intent(requireContext(), HomeActivity::class.java)
                        startActivity(intentToHomeActivity)
                    } else {
                        // username dan password salah
                        Toast.makeText(requireContext(), "Incorrect password and username.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // edit text masih ada yang kosong atau kosong semua
                    Toast.makeText(requireContext(), "Please make sure that all forms are filled in!", Toast.LENGTH_SHORT).show()
                }
            }

            txtToRegister.setOnClickListener {
                authenticationActivity.navigateToRegisterPage()
            }
        }

        return view
    }
}
