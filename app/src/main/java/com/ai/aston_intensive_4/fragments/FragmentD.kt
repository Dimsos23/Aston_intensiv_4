package com.ai.aston_intensive_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.ai.aston_intensive_4.R


class FragmentD : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = parentFragmentManager
        val buttonFragmentB: Button = view.findViewById(R.id.button_fragment_c)

        buttonFragmentB.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentB())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
