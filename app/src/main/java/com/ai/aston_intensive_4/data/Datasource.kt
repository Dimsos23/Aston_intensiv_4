package com.ai.aston_intensive_4.data

import com.ai.aston_intensive_4.R
import com.ai.aston_intensive_4.model.Contact

class Datasource {

    fun loadContacts(): ArrayList<Contact> {
        var indexID = 1
        val listContact = arrayListOf<Contact>()
        val mutableListContact = mutableListOf(
            Contact(
                indexID++,
                "android.resource://com.ai.aston_intensive_4/" + R.drawable.unknown_person_man,
                "Дмитрий",
                "Ветров",
                "+7 (111) 111-11-11"
            ),
            Contact(
                indexID++,
                "android.resource://com.ai.aston_intensive_4/" + R.drawable.unknown_person_woman,
                "Юлия",
                "Хорошая",
                "+7 (333) 333-33-33"
            ),
            Contact(
                indexID++,
                "android.resource://com.ai.aston_intensive_4/" + R.drawable.unknown_person_man,
                "Станислав",
                "Бойко",
                "+7 (555) 555-55-55"
            ),
            Contact(indexID)
        )

        listContact.addAll(mutableListContact)
        return listContact
    }
}
