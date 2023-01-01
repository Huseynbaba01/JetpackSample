package com.thenexprojects.firstjetpacksample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.thenexprojects.firstjetpacksample.databinding.FragmentUserDetailBinding

class UserDetailFragment : BaseFragment() {
    override lateinit var binding: FragmentUserDetailBinding
    private val args by navArgs<UserDetailFragmentArgs>()
    override fun setListeners() {
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        setListeners()
        binding.also {
            it.txtId.text = "ID = ${args.userData.id}"
            it.username.text = args.userData.username
            it.name.text = args.userData.name
            it.surname.text = args.userData.surname
            it.age.text = args.userData.age.toString()
        }
        return binding.root
    }
}