package com.ai.aston_intensive_4.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ai.aston_intensive_4.R
import com.ai.aston_intensive_4.adapter.ContactAdapter
import com.ai.aston_intensive_4.data.Datasource
import com.ai.aston_intensive_4.model.Contact


class ContactFragment : Fragment() {

    companion object {
        val contactList = Datasource().loadContacts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val contactAdapter = ContactAdapter(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = contactAdapter
        contactAdapter.updateData(contactList)

        val fragmentManager = parentFragmentManager

        fragmentManager.setFragmentResultListener("request_key", this) { key, bundle ->
            if (Build.VERSION.SDK_INT >= 33) {
                val contact = bundle.getParcelable("new_class", Contact::class.java)
                contactList[contact?.id?.minus(1)!!] = contact
            } else {
                val contact = bundle.getParcelable<Contact>("new_class")
                contactList[contact?.id?.minus(1)!!] = contact
            }
            contactAdapter.updateData(contactList)
        }
    }
}
