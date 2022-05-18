package com.amvlabs.kotlinsamples.mvvmSample.viewmodel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.amvlabs.kotlinsamples.BR
import com.amvlabs.kotlinsamples.mvvmSample.models.UserDetails


class AppViewModel() : BaseObservable() {
    // creating object of Model class
    private val model: UserDetails

    // string variables for
    // toast messages
    private val successMessage: String = "Login successful"
    private val errorMessage: String = "Email or Password is not valid"

    // getter and setter methods
    // for toast message
    @Bindable // string variable for
    // toast message
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    // getter and setter methods
    // for email variable
    @get:Bindable
    var userEmail: String?
        get() = model.email
        set(email) {
            model.email=email
            notifyPropertyChanged(BR.userEmail)
        }

    // getter and setter methods
    // for password variable
    @get:Bindable
    var userPassword: String?
        get() = model.password
        set(password) {
            model.password=password
            notifyPropertyChanged(BR.userPassword)
        }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
        if (isValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    val isValid: Boolean
        get() = (!TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(
            userEmail
        ).matches()
                && (userPassword!!.length > 5))

    // constructor of ViewModel class
    init {

        // instantiating object of
        // model class
        model = UserDetails("", "")
    }
}