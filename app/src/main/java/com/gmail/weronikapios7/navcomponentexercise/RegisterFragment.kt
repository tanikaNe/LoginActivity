package com.gmail.weronikapios7.navcomponentexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.gmail.weronikapios7.navcomponentexercise.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.tvLogin.setOnClickListener {
            it.findNavController().navigate(R.id.register_to_login)
        }

        binding.btnSubmit.setOnClickListener {
            createUser()
            it.findNavController().navigate(R.id.register_to_welcome)
        }
        return binding. root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun createUser(){
        val username = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if(isFilled(username, email, password)){
            viewModel.newUser(User(username, email, password))
        }
    }

    /**
     * Check if all the fields have been filled, return error message if there
     * is an empty field left
     */
    private fun isFilled(username: String, email: String, password: String): Boolean {
        when {
            email.isEmpty() -> {
                createToast("Email cannot be empty")
                return false
            }
            password.isEmpty() -> {
                createToast("Password cannot be empty")
                return false
            }
            username.isEmpty() -> {
                createToast("Username cannot be empty")
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun createToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}