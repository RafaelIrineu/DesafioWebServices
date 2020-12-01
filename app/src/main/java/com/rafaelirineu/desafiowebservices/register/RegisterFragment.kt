package com.rafaelirineu.desafiowebservices.register

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

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnSave_fragmentRegister).setOnClickListener {
            if (validaCamposRegister(view)) {
                navController.navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
    }

    private fun validaCamposRegister(view: View): Boolean {

        var nameRegister =
            view.findViewById<TextInputEditText>(R.id.txtInputName_fragmentRegister)
        var emailRegister =
            view.findViewById<TextInputEditText>(R.id.txtInputEmail_fragmentRegister)
        var passwordRegister =
            view.findViewById<TextInputEditText>(R.id.txtInputPassword_fragmentRegister)

        var resultado = true

        if (nameRegister.text?.isBlank()!!) {
            view.findViewById<TextInputLayout>(R.id.txtName_fragmentRegister).editText?.error =
                getString(R.string.campo_vazio)
            resultado = false
        }
        if (emailRegister.text?.isBlank()!!) {
            view.findViewById<TextInputLayout>(R.id.txtEmail_fragmentRegister).editText?.error =
                getString(R.string.campo_vazio)
            resultado = false
        }
        if (passwordRegister.text?.isBlank()!!) {
            view.findViewById<TextInputLayout>(R.id.txtPassword_fragmentRegister).editText?.error =
                getString(R.string.campo_vazio)
            resultado = false
        }
        return resultado
    }
}