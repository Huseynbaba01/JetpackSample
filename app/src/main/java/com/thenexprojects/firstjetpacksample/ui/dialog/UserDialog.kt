package com.thenexprojects.firstjetpacksample.ui.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.thenexprojects.firstjetpacksample.R
import com.thenexprojects.firstjetpacksample.databinding.UserDialogBinding
import com.thenexprojects.firstjetpacksample.listener.UserAdapterResultListener
import com.thenexprojects.firstjetpacksample.model.User
import com.thenexprojects.firstjetpacksample.type.UserDialogOperationType
import java.util.*

class UserDialog : DialogFragment(R.layout.user_dialog) {
    private lateinit var binding: UserDialogBinding
    private lateinit var opType: UserDialogOperationType
    private var user: User? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        Objects.requireNonNull(dialog)!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        binding = UserDialogBinding.inflate(inflater, container, false)
        opType = requireArguments().getSerializable("opType") as UserDialogOperationType
        user = requireArguments().getSerializable("user") as User?

        when (opType) {
            UserDialogOperationType.ADD -> {
                binding.apply {
                    txtId.visibility = GONE
                    commit.setText(R.string.add)
                }
            }
            UserDialogOperationType.UPDATE -> {
                binding.apply {
                    txtId.visibility = VISIBLE
                    txtId.text = user!!.id.toString()
                    commit.setText(R.string.update)
                    ageLayout.editText!!.setText("ID = " + user!!.age.toString())
                    nameLayout.editText!!.setText(user!!.name)
                    surnameLayout.editText!!.setText(user!!.surname)
                    usernameLayout.editText!!.setText(user!!.username)
                }
            }
        }
        binding.commit.setOnClickListener {
            (requireArguments().getSerializable("resultListener") as UserAdapterResultListener)
                .onResultsAvailable(
                    User(
                        user?.id?:requireArguments().getInt("lastId"),
                        binding.usernameLayout.editText!!.text.toString(),
                        binding.nameLayout.editText!!.text.toString(),
                        binding.surnameLayout.editText!!.text.toString(),
                        binding.ageLayout.editText!!.text.toString().toInt()
                    ),
                    opType
                )
            dismiss()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}