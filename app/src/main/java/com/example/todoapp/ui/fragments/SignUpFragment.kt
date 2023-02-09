package com.example.todoapp.ui.fragments

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
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
        savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fullNameTil.editText?.onFocusChangeListener = this
        binding.emailTil.editText?.onFocusChangeListener = this
        binding.passwordTil.editText?.onFocusChangeListener = this
        binding.cPasswordTil.editText?.onFocusChangeListener = this
    }
    private fun validateFullName() : Boolean{
        var errorMessage :String? = null
        val value = binding.fullNameEt.text.toString()
        if(value.isEmpty()){
            errorMessage = "Full Name is required"
        }

        if(errorMessage != null){
            binding.fullNameTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        Log.e("myTag","isl-emir10")
        return errorMessage == null
    }

    private fun validateEmail(): Boolean{
        var errorMessage : String? = null
        val value = binding.emailEt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Email is required"
        }else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email address is invalid"
        }

        if(errorMessage != null){
            binding.emailTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean{
        var errorMessage : String? = null
        val value = binding.passwordEt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Password is required"
        }else if (value.length < 6){
            errorMessage = "Password must be 6 characters long"
        }
        if(errorMessage != null){
            binding.passwordTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword():Boolean{
        var errorMessage : String? = null
        val value = binding.cPasswordEt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Confirm Password is required"
        }else if (value.length < 6){
            errorMessage = "Confirm Password must be 6 characters long"
        }
        if(errorMessage != null) {
            binding.cPasswordTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword():Boolean{
        var errorMessage : String? = null
        val password = binding.passwordEt.text.toString()
        val confirmPassword = binding.cPasswordEt.text.toString()
        if (password != confirmPassword){
            errorMessage = "Confirm Password doesn't match with password"
        }
        if(errorMessage != null) {
            binding.cPasswordTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null ){
            when(view.id){
                R.id.fullNameEt -> {
                    if (hasFocus){
                        if (binding.fullNameTil.isErrorEnabled){
                            binding.fullNameTil.isErrorEnabled = false
                        }
                    }else{
                        validateFullName()
                    }
                }
                R.id.emailText -> {
                    if (hasFocus){
                        if (binding.emailTil.isErrorEnabled){
                            binding.emailTil.isErrorEnabled = false
                        }
                    }else{
                        if (validateEmail()){
                            //do validation for its uniqueness
                        }
                    }
                }
                R.id.passwordtext -> {
                    if (hasFocus){
                        if (binding.passwordTil.isErrorEnabled){
                            binding.passwordTil.isErrorEnabled = false
                        }
                    }else{
                        if (validatePassword() && binding.passwordEt.text!!.isNotEmpty() && validateConfirmPassword()
                            &&validatePasswordAndConfirmPassword()){
                            if (binding.cPasswordTil.isErrorEnabled){
                                binding.cPasswordTil.isErrorEnabled =false
                            }
                            binding.cPasswordTil.apply {
                                setStartIconDrawable(R.drawable.ic_baseline_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
                R.id.cPasswordEt -> {
                    if (hasFocus){
                        if (binding.cPasswordTil.isErrorEnabled){
                            binding.cPasswordTil.isErrorEnabled = false
                        }
                    }else{
                        if (validateConfirmPassword() && validatePassword() && validatePasswordAndConfirmPassword()){
                            if (binding.passwordTil.isErrorEnabled){
                                binding.passwordTil.isErrorEnabled =false
                            }
                            binding.cPasswordTil.apply {
                                setStartIconDrawable(R.drawable.ic_baseline_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}
