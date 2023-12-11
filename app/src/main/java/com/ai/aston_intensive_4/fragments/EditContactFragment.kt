package com.ai.aston_intensive_4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.ai.aston_intensive_4.R
import com.ai.aston_intensive_4.model.Contact


class EditContactFragment(private val contact: Contact) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = parentFragmentManager
        val fragmentContact = ContactFragment()

        val buttonEdit: Button = view.findViewById(R.id.button_edit)
        val buttonCancel: Button = view.findViewById(R.id.button_cancel)

        val imageViewPhoto: ImageView = view.findViewById(R.id.image_edit_contact)
        val textFirstname: EditText = view.findViewById(R.id.edit_text_firstname)
        val textLastname: EditText = view.findViewById(R.id.edit_text_lastname)
        val textPhone: EditText = view.findViewById(R.id.edit_text_phone)

        var intResourceId = contact.photo

        imageViewPhoto.setImageResource(contact.photo)
        textFirstname.setText(contact.firstName)
        textLastname.setText(contact.lastName)
        textPhone.setText(contact.phone)

        imageViewPhoto.setOnClickListener {
            if (intResourceId == R.drawable.unknown_person_man) {
                intResourceId = R.drawable.unknown_person_woman
                imageViewPhoto.setImageResource(intResourceId)
            } else {
                intResourceId = R.drawable.unknown_person_man
                imageViewPhoto.setImageResource(intResourceId)
            }
        }

        buttonEdit.setOnClickListener {
            val newContact = Contact(
                id = contact.id,
                photo = intResourceId,
                firstName = textFirstname.text.toString(),
                lastName = textLastname.text.toString(),
                phone = textPhone.text.toString()
            )

            val bundle = Bundle()
            bundle.putParcelable("new_class", newContact)
            fragmentManager.setFragmentResult("request_key", bundle)

            fragmentManager.popBackStack()
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task2, fragmentContact)
                .setReorderingAllowed(true)
                .commit()
        }

        buttonCancel.setOnClickListener {
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task2, fragmentContact)
                .setReorderingAllowed(true)
                .commit()
        }
    }
}
