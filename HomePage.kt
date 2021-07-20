package com.example.resultapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.resultapp.R.layout.fragment_home_page
import java.nio.channels.Selector


class HomePage : Fragment(), View.OnClickListener {
// navigation controller object
    private var navController: NavController? = null

    // view moddel

    private lateinit var studentSelector : Selector

    //

    private val model: StudentViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(fragment_home_page, container, false)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view code

        //navigation code
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.enterbutton).setOnClickListener(this)
        view.findViewById<TextView>(R.id.adminLogin).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.enterbutton -> navController!!.navigate(R.id.action_homePage_to_viewResult)
            R.id.adminLogin -> navController!!.navigate(R.id.action_homePage_to_adminLogin2)
        }
    }
}