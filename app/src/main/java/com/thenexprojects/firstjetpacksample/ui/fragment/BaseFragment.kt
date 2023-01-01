package com.thenexprojects.firstjetpacksample.ui.fragment

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment: Fragment() {
    abstract val binding: ViewBinding
    abstract fun setListeners()
}