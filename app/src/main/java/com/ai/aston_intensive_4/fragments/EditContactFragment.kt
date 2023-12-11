package com.ai.aston_intensive_4.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.ai.aston_intensive_4.R
import com.ai.aston_intensive_4.model.Contact
import com.squareup.picasso.Picasso


class EditContactFragment(private val contact: Contact) : Fragment() {

    private lateinit var imageViewPhoto: ImageView
    private var selectedImageUri: Uri? = null

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

        imageViewPhoto = view.findViewById(R.id.image_edit_contact)
        val textFirstname: EditText = view.findViewById(R.id.edit_text_firstname)
        val textLastname: EditText = view.findViewById(R.id.edit_text_lastname)
        val textPhone: EditText = view.findViewById(R.id.edit_text_phone)

        Picasso.get().load(contact.photoUrl).into(imageViewPhoto)

        textFirstname.setText(contact.firstName)
        textLastname.setText(contact.lastName)
        textPhone.setText(contact.phone)

        imageViewPhoto.setOnClickListener {
            openGallery()
        }

        buttonEdit.setOnClickListener {
            if (selectedImageUri == null) {
                val uri = Uri.parse(contact.photoUrl)
                selectedImageUri = uri
            }
            val newContact = Contact(
                id = contact.id,
                photoUrl = selectedImageUri.toString(),
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

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    selectedImageUri = data.data
                    imageViewPhoto.setImageURI(selectedImageUri)
                }
            }
        }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }
}
