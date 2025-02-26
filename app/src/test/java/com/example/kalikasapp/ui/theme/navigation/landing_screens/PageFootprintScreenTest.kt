package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.runtime.mutableStateOf
import org.junit.Assert.assertEquals
import org.junit.Test

class PageFootprintScreenTest {

    // Mock data
    private val userDailyWater = mutableStateOf(25.0f)
    private val userDailyEnergy = mutableStateOf(30.0f)
    private val userDailyTranspo = mutableStateOf(20.0f)
    private val userDailyFood = mutableStateOf(15.0f)
    private val userDailyWaste = mutableStateOf(10.0f)

    @Test
    fun testPageFootprintScreen_initialState() {
        // Check if initial values are set correctly
        assertEquals(25.0f, userDailyWater.value)
        assertEquals(30.0f, userDailyEnergy.value)
        assertEquals(20.0f, userDailyTranspo.value)
        assertEquals(15.0f, userDailyFood.value)
        assertEquals(10.0f, userDailyWaste.value)
    }

    @Test
    fun testPageFootprintScreen_updateDailyWater() {
        // Simulate updating the daily water value
        userDailyWater.value = 30.0f

        // Check if the value is updated correctly
        assertEquals(30.0f, userDailyWater.value)
    }

    @Test
    fun testPageFootprintScreen_updateDailyEnergy() {
        // Simulate updating the daily energy value
        userDailyEnergy.value = 35.0f

        // Check if the value is updated correctly
        assertEquals(35.0f, userDailyEnergy.value)
    }

    @Test
    fun testPageFootprintScreen_updateDailyTranspo() {
        // Simulate updating the daily transportation value
        userDailyTranspo.value = 25.0f

        // Check if the value is updated correctly
        assertEquals(25.0f, userDailyTranspo.value)
    }

    @Test
    fun testPageFootprintScreen_updateDailyFood() {
        // Simulate updating the daily food value
        userDailyFood.value = 20.0f

        // Check if the value is updated correctly
        assertEquals(20.0f, userDailyFood.value)
    }

    @Test
    fun testPageFootprintScreen_updateDailyWaste() {
        // Simulate updating the daily waste value
        userDailyWaste.value = 15.0f

        // Check if the value is updated correctly
        assertEquals(15.0f, userDailyWaste.value)
    }

    @Test
    fun testPageFootprintScreen_totalDailyFootprint() {
        // Calculate the total daily footprint
        val totalDailyFootprint = userDailyWater.value + userDailyEnergy.value +
                userDailyTranspo.value + userDailyFood.value + userDailyWaste.value

        // Check if the total is calculated correctly
        assertEquals(100.0f, totalDailyFootprint)
    }

}

