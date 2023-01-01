package com.thenexprojects.firstjetpacksample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thenexprojects.firstjetpacksample.databinding.FragmentUsersBinding
import com.thenexprojects.firstjetpacksample.listener.UserAdapterResultListener
import com.thenexprojects.firstjetpacksample.listener.UserClickListener
import com.thenexprojects.firstjetpacksample.model.User
import com.thenexprojects.firstjetpacksample.type.UserDialogOperationType
import com.thenexprojects.firstjetpacksample.ui.adapter.UsersAdapter
import com.thenexprojects.firstjetpacksample.ui.dialog.UserDialog


class UsersFragment : BaseFragment(), UserClickListener, UserAdapterResultListener {
    override lateinit var binding: FragmentUsersBinding

    //lazy is used to initialize a value lazily (it means the variable is not initialize unless it gets called.)
    private val adapter by lazy {UsersAdapter(this)}
    private val userDialog by lazy { UserDialog() }
    var lastCreatedUserId: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        setListeners()
        binding.users.apply {
            layoutManager = LinearLayoutManager(requireContext())
            //we differentiate between recyclerView context (from apply -> this) and this class (this@UsersFragment)
            this.adapter = this@UsersFragment.adapter
        }
        return binding.root
    }

    override fun setListeners() {
        binding.add.setOnClickListener {
            userDialog.apply {
                arguments = Bundle().apply {
                    putSerializable("resultListener", this@UsersFragment)
                    putSerializable("opType", UserDialogOperationType.ADD)
                    putSerializable("lastId", lastCreatedUserId++)
                }
                show(this@UsersFragment.childFragmentManager, "dialog")
            }

        }
    }

    override fun onClick(user: User, isLongClick: Boolean) {
        if(isLongClick) onUserLongClick(user)
        else onUserSimpleClick(user)
    }

    private fun onUserSimpleClick(user: User) {
        //todo will take user to the other page
    }

    private fun onUserLongClick(user: User) {
        userDialog.apply {
            arguments = Bundle().apply {
                putSerializable("user", user)
                putSerializable("resultListener", this@UsersFragment)
                putSerializable("opType", UserDialogOperationType.UPDATE)
            }
            show(this@UsersFragment.childFragmentManager, "dialog")
        }
    }

    override fun onResultsAvailable(user: User, operationType: UserDialogOperationType) {
        when(operationType){
            UserDialogOperationType.ADD -> {
                adapter.addUser(user)
            }
            UserDialogOperationType.UPDATE -> {
                adapter.updateUser(user)
            }
        }
    }
}
