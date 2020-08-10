package com.anelcc.daggertohilt.registration.enterdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.anelcc.daggertohilt.R
import com.anelcc.daggertohilt.registration.RegistrationActivity
import com.anelcc.daggertohilt.registration.RegistrationViewModel

import javax.inject.Inject

/*
*
* @Inject annotated fields will be provided by Dagger
*/
class EnterDetailsFragment : Fragment() {
    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    @Inject
    lateinit var enterDetailsViewModel: EnterDetailsViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        registrationViewModel = (activity as RegistrationActivity).registrationViewModel
        enterDetailsViewModel = EnterDetailsViewModel()
        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        enterDetailsViewModel = EnterDetailsViewModel()
        enterDetailsViewModel.enterDetailsState.observe(this,
            Observer<EnterDetailsViewState> { state ->
                when (state) {
                    is EnterDetailsSuccess -> {

                        val username = usernameEditText.text.toString()
                        val password = passwordEditText.text.toString()
                        registrationViewModel.updateUserData(username, password)

                        (activity as RegistrationActivity).onDetailsEntered()
                    }
                    is EnterDetailsError -> {
                        errorTextView.text = state.error
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            })

        view?.let { setupViews(it) }
        return view
    }

    private fun setupViews(view: View) {
        errorTextView = view.findViewById(R.id.error)

        usernameEditText = view.findViewById(R.id.username)
        /*usernameEditText.doOnTextChanged { _, _, _, _ ->
            errorTextView.visibility = View.INVISIBLE
        }*/

        passwordEditText = view.findViewById(R.id.password)
       // passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            enterDetailsViewModel.validateInput(username, password)
        }
    }
}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()
