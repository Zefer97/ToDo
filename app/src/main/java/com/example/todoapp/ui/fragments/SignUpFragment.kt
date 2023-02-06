package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(), View.OnClickListener,View.OnFocusChangeListener,View.OnKeyListener  {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun validateFullName() : Boolean{
        var error :String? = null
        val value = binding.nameText.text.toString()
        if(value.isEmpty()){
            error = "Full Name is required"
        }
        return error == null
    }

    private fun validateEmail(): Boolean{
        var error : String? = null
        val value = binding.emailText.text.toString()
        if (value.isEmpty()){
            error = "Email is required"
        }else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            error = "Email address is invalid"
        }
        return error == null
    }

    private fun validatePassword(): Boolean{
        var error : String? = null
        val value = binding.passwordtext.text.toString()
        if (value.isEmpty()){
            error = "Password is required"
        }else if (value.length < 6){
            error = "Password must be 6 characters long"
        }
        return error == null
    }

    private fun validateConfirmPassword():Boolean{
        var error : String? = null
        val value = binding.confirmpasswordtext.text.toString()
        if (value.isEmpty()){
            error = "Confirm Password is required"
        }else if (value.length < 6){
            error = "Confirm Password must be 6 characters long"
        }
        return error == null
    }

    private fun validatePasswordAndConfirmPassword():Boolean{
        var error : String? = null
        val password = binding.passwordtext.text.toString()
        val confirmPassword = binding.confirmpasswordtext.text.toString()
        if (password != confirmPassword){
            error = "Confirm Password doesn't match with password"
        }
        return error == null
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }
}