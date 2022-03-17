package com.gmail.weronikapios7.navcomponentexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gmail.weronikapios7.navcomponentexercise.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var  binding: FragmentWelcomeBinding
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        viewModel.user.observe(viewLifecycleOwner, Observer {
            binding.tvWelcomeUser.text = "Welcome ${it.username}"
        })
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}