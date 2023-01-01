package com.thenexprojects.firstjetpacksample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thenexprojects.firstjetpacksample.databinding.FragmentUserDetailBinding

class UserDetailFragment() : BaseFragment() {
    override lateinit var binding: FragmentUserDetailBinding
    override fun setListeners() {

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)

        return binding.root
    }
}