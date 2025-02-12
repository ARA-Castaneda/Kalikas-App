package com.example.kalikasapp.ui.theme.navigation.landing_screens

import org.junit.Test

import org.junit.Assert.*

import androidx.compose.runtime.mutableStateOf

class AppLoginScreenTest {


    //temporary tests for login

    @Test
    fun appLoginScreen_emptyEmailOrPassword_setsShowErrorTrue() {
        val emailState = mutableStateOf("")
        val passwordState = mutableStateOf("")
        val showErrorState = mutableStateOf(false)

        // Simulate "Login" button click
        if (emailState.value.isEmpty() || passwordState.value.isEmpty()) {
            showErrorState.value = true
        } else if (emailState.value == "kalikas@up.edu.ph" && passwordState.value == "Admin123") {
            showErrorState.value = false
        } else {
            showErrorState.value = true
        }

        assertTrue(showErrorState.value)
    }

    @Test
    fun appLoginScreen_invalidCredentials_setsShowErrorTrue() {
        val emailState = mutableStateOf("wrong@email.com")
        val passwordState = mutableStateOf("WrongPassword")
        val showErrorState = mutableStateOf(false)

        // Simulate "Login" button click
        if (emailState.value.isEmpty() || passwordState.value.isEmpty()) {
            showErrorState.value = true
        } else if (emailState.value == "kalikas@up.edu.ph" && passwordState.value == "Admin123") {
            showErrorState.value = false
        } else {
            showErrorState.value = true
        }

        assertTrue(showErrorState.value)
    }

    @Test
    fun appLoginScreen_validCredentials_setsShowErrorFalse() {
        val emailState = mutableStateOf("kalikas@up.edu.ph")
        val passwordState = mutableStateOf("Admin123")
        val showErrorState = mutableStateOf(false)

        // Simulate the "Login" button click action
        if (emailState.value.isEmpty() || passwordState.value.isEmpty()) {
            showErrorState.value = true
        } else if (emailState.value == "kalikas@up.edu.ph" && passwordState.value == "Admin123") {
            showErrorState.value = false
        } else {
            showErrorState.value = true
        }

        assertFalse(showErrorState.value)
    }
}