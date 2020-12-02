package com.rafaelirineu.desafiowebservices.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.rafaelirineu.desafiowebservices.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnCreate_fragmentLogin).setOnClickListener {
                navController.navigate(R.id.action_loginFragment_to_registerFragment)
            }

        view.findViewById<Button>(R.id.btnLogin_fragmentLogin).setOnClickListener {
            if (validaCamposLogin(view)) {
                navController.navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    private fun validaCamposLogin(view: View): Boolean {

        var emailLogin =
            view.findViewById<TextInputEditText>(R.id.txtInputEmail_fragmentLogin)
        var passwordLogin =
            view.findViewById<TextInputEditText>(R.id.txtInputPassword_fragmentLogin)

        var resultado = true

        if (emailLogin.text?.isBlank()!!) {
            view.findViewById<TextInputLayout>(R.id.txtEmail_fragmentLogin).editText?.error =
                getString(R.string.campo_vazio)
            resultado = false
        }
        if (passwordLogin.text?.isBlank()!!) {
            view.findViewById<TextInputLayout>(R.id.txtPassword_fragmentLogin).editText?.error =
                getString(R.string.campo_vazio)
            resultado = false
        }
        return resultado
    }
}