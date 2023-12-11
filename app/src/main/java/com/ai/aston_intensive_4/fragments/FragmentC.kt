package com.ai.aston_intensive_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.ai.aston_intensive_4.R

class FragmentC : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = parentFragmentManager

        val buttonFragmentA: Button = view.findViewById(R.id.button_fragment_a)
        val buttonFragmentD: Button = view.findViewById(R.id.button_fragment_d)
        val textView: TextView = view.findViewById(R.id.text_from_fragment_c)

        fragmentManager.setFragmentResultListener(FragmentB.REQUEST_KEY, this) { key, bundle ->
            val result = bundle.getString(FragmentB.KEY_FOR_TEXT)
            textView.text = result.toString()
        }

        buttonFragmentD.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentD())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        buttonFragmentA.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentA())
                .setReorderingAllowed(true)
                .commit()
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
