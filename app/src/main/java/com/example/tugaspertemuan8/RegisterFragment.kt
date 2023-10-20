package com.example.tugaspertemuan8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugaspertemuan8.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val view = binding.root

        with(binding){
            val activity = requireActivity() as AuthenticationActivity

            btnRegister.setOnClickListener{
                val username = editTextUsername.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                val password = editTextPassword.text.toString()

                if (username != "" && email != "" && phone != "" && password != "") {
                    if (checkboxTc.isChecked) {
                        activity.setUserData(username, password)
                        activity.navigateToLoginPage()
                    } else {
                        Toast.makeText(requireContext(), "Please agree to our terms and conditions!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Please make sure that all forms are filled in!", Toast.LENGTH_SHORT).show()
                }
            }

            txtToLogin.setOnClickListener {
                activity.navigateToLoginPage()
            }
        }

        return view
    }
}
