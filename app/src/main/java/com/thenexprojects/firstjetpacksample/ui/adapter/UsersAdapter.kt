package com.thenexprojects.firstjetpacksample.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thenexprojects.firstjetpacksample.databinding.ListItemUsersBinding
import com.thenexprojects.firstjetpacksample.listener.UserClickListener
import com.thenexprojects.firstjetpacksample.model.User

class UsersAdapter(private val userClickListener: UserClickListener): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    var users = arrayListOf<User>()

    inner class ViewHolder(val binding: ListItemUsersBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.binding.also {
            it.id.text = user.id.toString()
            it.age.text = user.age.toString()
            it.name.text = user.name
            it.username.text = user.username
            it.surname.text = user.surname
        }

        holder.itemView.setOnClickListener { userClickListener.onClick(user, false) }
        holder.itemView.setOnLongClickListener {
            userClickListener.onClick(user, true)
            false
        }
    }

    override fun getItemCount() = users.size

    fun addUser(user: User){
        users.add(user)
        notifyItemInserted(itemCount)
    }

    fun updateUser(user: User){
        for(i in users.indices){
            if(users[i].id == user.id){
                users[i] = user
                notifyItemChanged(i)
                return
            }
        }
    }

    fun removeUserById(id: Int){
        var userPosition:Int? = null
        users.forEachIndexed { index, user ->
            if(user.id == id){
                userPosition = index
            }
        }
        userPosition?.let {
            users.removeAt(it)
            notifyItemRemoved(it)
        }?: run {
            Log.d("UsersAdapter", "No user found to remove")
        }
    }
}