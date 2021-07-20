package com.example.resultapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.resultapp.databinding.FragmentAddStudentInformationBinding

// TODO: Rename parameter arguments, choose names that match
class AddStudentInformation : Fragment(), View.OnClickListener {

    private var navController: NavController? = null

    lateinit var student: Student


    private val viewModel: StudentViewModel by activityViewModels {

        StudentViewModelFactory(
            (
                    activity?.application as ResultApplication)
                .database.studentRepository()
        )
    }

    private var _binding: FragmentAddStudentInformationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddStudentInformationBinding.inflate(inflater, container, false)
        return binding.root

    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.nameString.text.toString(),
            binding.departmentString.text.toString(),
            binding.levelString.text.toString(),
            binding.regNumString.text.toString(),
        )
    }


    private fun createStudent() {
        if (isEntryValid()) {
            viewModel.createStudent(
                binding.nameString.text.toString(),
                binding.departmentString.text.toString(),
                binding.levelString.text.toString(),
                binding.regNumString.text.toString(),
            )

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.saveStudentBtn).setOnClickListener(this)
        binding.saveStudentBtn.setOnClickListener {
            createStudent()
        }


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.saveStudentBtn -> navController!!.navigate(R.id.action_addStudentInformation_to_adminInterface)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                    InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            requireActivity().currentFocus?.windowToken,
            0
        )
        _binding = null
    }
}

