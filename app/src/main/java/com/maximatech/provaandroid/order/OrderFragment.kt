package com.maximatech.provaandroid.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maximatech.provaandroid.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private val binding by lazy { FragmentOrderBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}