package com.thenexprojects.firstjetpacksample.ui.fragment

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment: Fragment() {
    protected abstract val binding: ViewBinding
    protected abstract fun setListeners()
}