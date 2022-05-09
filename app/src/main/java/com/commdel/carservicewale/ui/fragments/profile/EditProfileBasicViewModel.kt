package com.commdel.carservicewale.ui.fragments.profile

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class EditProfileBasicViewModel: BaseObservable() {
    private var firstName: String? = null
    private var lastName: String? = null
    private var dob: String? = null
    private var gender: String? = null
    private var mContext: Context? = null

    fun EditProfileBasicViewModel(context: Context?) {
        mContext = context
    }

    @Bindable
    fun getFirstName(): String? {
        return firstName ?: " "
    }
    fun setFirstName(firstName: String?) {
        this.firstName = firstName
    }

    @Bindable
    fun getLastName(): String? {
        return lastName ?: ""
    }
    fun setLastName(lastName: String?) {
        this.lastName = lastName
    }

    @Bindable
    fun getDob(): String? {
        return dob ?: ""
    }
    fun setDob(dob: String?) {
        this.dob = dob
    }

    @Bindable
    fun getGender(): String? {
        return gender ?: ""
    }

    fun setGender(gender: String?) {
        this.gender = gender
    }
}