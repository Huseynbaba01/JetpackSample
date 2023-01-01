package com.thenexprojects.firstjetpacksample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.thenexprojects.firstjetpacksample.data.local.room.RoomDBHelper
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
        val room = RoomDBHelper.getRoomInstance(requireContext())
        val user = room.usersDao().getById(args.userId)
        binding.also {
            it.txtId.text = "ID = ${args.userId}"
            it.username.text = user.username
            it.name.text = user.name
            it.surname.text = user.surname
            it.age.text =user.age.toString()
        }
        return binding.root
    }
}