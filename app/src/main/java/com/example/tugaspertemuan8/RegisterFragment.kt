package com.example.tugaspertemuan8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
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
            val authenticationActivity = requireActivity() as AuthenticationActivity
            editTextUsername.setSingleLine(true)

            btnRegister.setOnClickListener{
                val username = editTextUsername.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                val password = editTextPassword.text.toString()

                if (username != "" && email != "" && phone != "" && password != "") {
                    if (checkboxTc.isChecked) {
                        // memasukkan data ke bundle
                        val bundle = Bundle()
                        bundle.putString("username", username)
                        bundle.putString("password", password)

                        // mengirim data ke LoginFragment
                        val adapter = authenticationActivity.viewPager2.adapter as FragmentStateAdapter
                        val loginFragment = adapter.createFragment(1) as LoginFragment
                        loginFragment.arguments = bundle

                        // pindah ke LoginFragment
                        authenticationActivity.navigateToLoginPage()
                    } else {
                        // belum check checkbox
                        Toast.makeText(requireContext(), "Please agree to our terms and conditions!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // edit text masih ada yang kosong atau kosong semua
                    Toast.makeText(requireContext(), "Please make sure that all forms are filled in!", Toast.LENGTH_SHORT).show()
                }
            }

            txtToLogin.setOnClickListener {
                authenticationActivity.navigateToLoginPage()
            }
        }

        return view
    }
}
