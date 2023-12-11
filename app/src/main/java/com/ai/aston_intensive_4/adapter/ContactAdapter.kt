package com.ai.aston_intensive_4.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ai.aston_intensive_4.ActivityTask2
import com.ai.aston_intensive_4.ContactDiffUtilCallback
import com.ai.aston_intensive_4.R
import com.ai.aston_intensive_4.fragments.EditContactFragment
import com.ai.aston_intensive_4.model.Contact
import com.google.android.material.card.MaterialCardView

class ContactAdapter(
    private val context: Context): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contactList = arrayListOf<Contact>()

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val contactPhoto: ImageView = view.findViewById(R.id.imageViewPhoto)
        val contactFirstName: TextView = view.findViewById(R.id.textViewFirstname)
        val contactLastName: TextView = view.findViewById(R.id.textViewLastname)
        val contactPhone: TextView = view.findViewById(R.id.textViewPhone)
        val cardView: MaterialCardView = view.findViewById(R.id.materialCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList[position]
        holder.apply {
            contactPhoto.setImageResource(currentContact.photo)
            contactFirstName.text = currentContact.firstName
            contactLastName.text = currentContact.lastName
            contactPhone.text = currentContact.phone
        }

        holder.cardView.setOnClickListener {
            val editFragment = EditContactFragment(currentContact)
            val activity =  context as ActivityTask2
            val fragmentManager = activity.supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.host_fragment_task2, editFragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
        }
    }

    fun updateData(newContactList: ArrayList<Contact>) {
        val diffUtilCallBack = ContactDiffUtilCallback(contactList, newContactList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallBack)
        contactList.clear()
        contactList.addAll(newContactList)
        diffResult.dispatchUpdatesTo(this)
    }
}