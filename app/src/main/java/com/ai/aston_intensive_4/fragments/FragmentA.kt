package com.ai.aston_intensive_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.ai.aston_intensive_4.R

class FragmentA : Fragment() {

    override fun onResume() {
        super.onResume()
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonFragmentB: Button = view.findViewById(R.id.button_fragment_b)
        val fragmentManager = parentFragmentManager
        buttonFragmentB.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentB())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
    }
}
