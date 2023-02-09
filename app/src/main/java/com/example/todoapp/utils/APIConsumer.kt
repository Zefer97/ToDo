package com.example.todoapp.utils

import com.example.todoapp.data.UniqueEmailValidationResponse
import com.example.todoapp.data.ValidateEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {

    @POST("users/validate-unique-email")
    fun validateEmailAddress(@Body body: ValidateEmailBody): Response<UniqueEmailValidationResponse>

}