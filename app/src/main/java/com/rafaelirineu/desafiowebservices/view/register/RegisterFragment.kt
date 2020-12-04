package com.rafaelirineu.desafiowebservices.view.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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

        view.findViewById<ImageView>(R.id.imgBack).setOnClickListener {
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }

        view.findViewById<Button>(R.id.btnSave_fragmentRegister).setOnClickListener {
            if (validaCamposRegister(view)) {
                navController.navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
    }

    private fun validaCamposRegister(view: View): Boolean {

        val nameRegister =
            view.findViewById<TextInputEditText>(R.id.txtInputName_fragmentRegister)
        val emailRegister =
            view.findViewById<TextInputEditText>(R.id.txtInputEmail_fragmentRegister)
        val passwordRegister =
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