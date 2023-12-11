package com.ai.aston_intensive_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import com.ai.aston_intensive_4.R

class FragmentB : Fragment() {

    companion object {
        const val KEY_FOR_TEXT = "Text from fragment B"
        const val REQUEST_KEY = "Fragment B"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = parentFragmentManager
        val buttonFragmentC: Button = view.findViewById(R.id.button_fragment_c)
        val buttonFragmentA: Button = view.findViewById(R.id.button_fragment_a)

        buttonFragmentA.setOnClickListener {
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentA())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }

        buttonFragmentC.setOnClickListener {
            val result = "Hello Fragment C"
            fragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_FOR_TEXT to result))
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task1, FragmentC())
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
    }
}
