package com.gmail.weronikapios7.navcomponentexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.gmail.weronikapios7.navcomponentexercise.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.tvCreateAccount.setOnClickListener {
            it.findNavController().navigate(R.id.login_to_register)
        }

        binding.btnSubmit.setOnClickListener {
            createUser()
            it.findNavController().navigate(R.id.login_to_welcom)
        }

        return binding.root

    }

    private fun createUser(){
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
            viewModel.newUser(User(username, "", password))
    }



    private fun createToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}