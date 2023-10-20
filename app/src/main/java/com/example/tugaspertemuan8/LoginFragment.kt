package com.example.tugaspertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugaspertemuan8.databinding.FragmentLoginBinding
import com.example.tugaspertemuan8.databinding.FragmentRegisterBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        with(binding){
            val activity = requireActivity() as AuthenticationActivity
            val (username, password) = activity.getUserData()

            btnLogin.setOnClickListener{
                val usernameLogin = editTextUsername.text.toString()
                val passwordLogin = editTextPassword.text.toString()

                if (usernameLogin != "" && passwordLogin != "") {
                    if (usernameLogin == username && passwordLogin == password) {
                        val intentToHomeActivity = Intent(requireContext(), HomeActivity::class.java)
                        startActivity(intentToHomeActivity)
                    } else {
                        Toast.makeText(requireContext(), "Incorrect password and username.", Toast.LENGTH_SHORT).show()
                    }
                } else {
//                    Toast.makeText(requireContext(), "$usernameLogin, $username, $passwordLogin, $password", Toast.LENGTH_LONG).show()
                    Toast.makeText(requireContext(), "Please make sure that all forms are filled in!", Toast.LENGTH_SHORT).show()
                }
            }

            txtToRegister.setOnClickListener {
                activity.navigateToRegisterPage()
            }
        }

        return view
    }
}
