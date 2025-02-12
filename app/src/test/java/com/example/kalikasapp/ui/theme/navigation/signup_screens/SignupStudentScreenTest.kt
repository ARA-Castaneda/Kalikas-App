package com.example.kalikasapp.ui.theme.navigation.signup_screens

import org.junit.Test

import org.junit.Assert.*

class SignupStudentScreenTest {

    @Test
    fun isValidEmail_validUpEmail_returnsTrue() {
        val validEmail = "test.student@up.edu.ph"
        val domain = "up.edu.ph"
        val result = isValidEmail(validEmail, domain)
        assertTrue(result)
    }

    @Test
    fun isValidEmail_invalidUpEmailWrongDomain_returnsFalse() {
        val invalidEmail = "test.student@gmail.com" // Wrong domain
        val domain = "up.edu.ph"
        val result = isValidEmail(invalidEmail, domain)
        assertFalse(result)
    }

    @Test
    fun isValidEmail_invalidEmailNoAtSymbol_returnsFalse() {
        val invalidEmail = "test.studentup.edu.ph" // No @ symbol
        val domain = "up.edu.ph"
        val result = isValidEmail(invalidEmail, domain)
        assertFalse(result)
    }

    @Test
    fun isValidEmail_invalidEmailNoUsername_returnsFalse() {
        val invalidEmail = "@up.edu.ph" // No username
        val domain = "up.edu.ph"
        val result = isValidEmail(invalidEmail, domain)
        assertFalse(result)
    }

    @Test
    fun isValidEmail_invalidEmailEmpty_returnsFalse() {
        val invalidEmail = "" // Empty
        val domain = "up.edu.ph"
        val result = isValidEmail(invalidEmail, domain)
        assertFalse(result)
    }

    @Test
    fun isValidEmail_invalidEmailWhiteSpace_returnsFalse() {
        val invalidEmail = " " // Single Whitespace
        val domain = "up.edu.ph"
        val result = isValidEmail(invalidEmail, domain)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_validPassword_returnsTrue() {
        val validPassword = "Password123" // Has capital and number, length >= 8
        val result = isValidPassword(validPassword)
        assertTrue(result)
    }

    @Test
    fun isValidPassword_shortPassword_returnsFalse() {
        val shortPassword = "Pass1" // Too short
        val result = isValidPassword(shortPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_noCapitalLetter_returnsFalse() {
        val noCapitalPassword = "password123" // No capital letter
        val result = isValidPassword(noCapitalPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_noNumber_returnsFalse() {
        val noNumberPassword = "PasswordABC" // No number
        val result = isValidPassword(noNumberPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_onlyNumbers_returnsFalse() {
        val onlyNumbersPassword = "12345678" // Only numbers
        val result = isValidPassword(onlyNumbersPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_onlyCapitalLetters_returnsFalse() {
        val onlyCapitalLettersPassword = "ABCDEFGH" // Only capital letters
        val result = isValidPassword(onlyCapitalLettersPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_empty_returnsFalse() {
        val emptyPassword = "" // Empty
        val result = isValidPassword(emptyPassword)
        assertFalse(result)
    }

    @Test
    fun isValidPassword_onlyWhitespace_returnsFalse() {
        val onlyWhitespacePassword = "        "
        val result = isValidPassword(onlyWhitespacePassword)
        assertFalse(result)
    }

}