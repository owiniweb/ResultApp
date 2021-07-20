package com.example.resultapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels


class ViewResult : Fragment() {

    private val model: StudentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )
    : View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_result, container, false)
    }

}