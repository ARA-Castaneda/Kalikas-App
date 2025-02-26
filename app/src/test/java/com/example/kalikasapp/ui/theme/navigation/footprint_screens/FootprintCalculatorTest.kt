package com.example.kalikasapp.ui.theme.navigation.landing_screens

import com.example.kalikasapp.ui.theme.navigation.footprint_screens.EnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FoodFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.TranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.Triple
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.Tuple
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WasteFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WaterFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userCarbonFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userEnergyEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userFoodEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userTranspoEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userWasteEmission
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.userWaterEmission
import org.junit.Assert.assertEquals
import org.junit.Test

class FootprintCalculatorTest {

    /* testing with default values */

    // Test data
    private val waterFootprint = WaterFootprint(
        household = 1,
        showerDuration = "11-30 mins",
        sinkDuration = "under 5 mins",
        toiletUsage = "always",
        dishesContrib = Triple("everyday", "handwash", "2 loads"),
        laundryContrib = Triple("every week", "own", "4 loads")
    )

    private val energyFootprint = EnergyFootprint(
        tvsetCountUnplugged = Tuple(1, false),
        desktopCountUnplugged = Tuple(1, false),
        laptopCountUnplugged = Tuple(1, false),
        smartphoneCountUnplugged = Tuple(1, false),
        tabletCountUnplugged = Tuple(1, false),
        electricfanCountUnplugged = Tuple(1, false),
        airconCountUnplugged = Tuple(0, false),
        lightbulbCountUnplugged = Tuple(4, false),

        refrigeratorCountUnplugged = Tuple(0, true),
        microwaveCountUnplugged = Tuple(1, true),
        stoveCountUnplugged = Tuple(0, true),
        toasterCountUnplugged = Tuple(0, true),
        ricecookerCountUnplugged = Tuple(1, true),

        dispenserCountUnplugged = Tuple(0, true),
        kettleCountUnplugged = Tuple(1, true),
        washingmachineCountUnplugged = Tuple(0, true),
        dryerCountUnplugged = Tuple(0, true)
    )

    private val transpoFootprint = TranspoFootprint(
        walkBicycle = false,
        carDuration = "60 mins",
        jeepneyDuration = "30 mins",
        busDuration = "30 mins",
        trainDuration = "30 mins",
        puvDuration = "0 mins",
        motorcycleDuration = "60 mins",
        tricycleDuration = "0 mins"
    )

    private val foodFootprint = FoodFootprint(
        beefServings = "2-3x per week",
        chickenServings = "4-6x per week",
        porkServings = "4-6x per week",
        seafoodServings = "2-3x per week",
        eggServings = "2-3x per week",
        milkServings = "2-3x per week",
        cheeseServings = "2-3x per week",
        riceServings = "2-3x per day",
        fruitServings = "everyday",
        vegetableServings = "everyday",
        wheatServings = "4-6x per week",
        processedServings = "4-6x per week"
    )

    private val wasteFootprint = WasteFootprint(
        organicWeight = "1-2 kg",
        recycledOrganic = "none",
        paperWeight = "less than 1 kg",
        recycledPaper = "none",
        plasticWeight = "less than 1 kg",
        recycledPlastic = "none",
        nonbioWeight = "less than 1 kg",
        recycledNonBio = "none"
    )

    @Test
    fun testUserCarbonFootprint() {
        val carbonFootprint = userCarbonFootprint(
            household = 1,
            waterComponent = waterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = wasteFootprint
        )

        // Verify that the total carbon footprint is the sum of all components
        assertEquals(
            carbonFootprint.water + carbonFootprint.energy + carbonFootprint.transpo +
                    carbonFootprint.food + carbonFootprint.waste,
            carbonFootprint.total
        )
    }

    @Test
    fun testUserWaterEmission() {
        val waterEmission = userWaterEmission(
            userHousehold = 1,
            userWaterFootprint = waterFootprint
        )

        // Verify that the water emission is calculated correctly
        assert(waterEmission > 0.0f)
    }

    @Test
    fun testUserEnergyEmission() {
        val energyEmission = userEnergyEmission(
            userEnergyFootprint = energyFootprint
        )

        // Verify that the energy emission is calculated correctly
        assert(energyEmission > 0.0f)
    }

    @Test
    fun testUserTranspoEmission() {
        val transpoEmission = userTranspoEmission(
            userTranspoFootprint = transpoFootprint
        )

        // Verify that the transportation emission is calculated correctly
        assert(transpoEmission > 0.0f)
    }

    @Test
    fun testUserFoodEmission() {
        val foodEmission = userFoodEmission(
            userFoodFootprint = foodFootprint
        )

        // Verify that the food emission is calculated correctly
        assert(foodEmission > 0.0f)
    }

    @Test
    fun testUserWasteEmission() {
        val wasteEmission = userWasteEmission(
            userWasteFootprint = wasteFootprint
        )

        // Verify that the waste emission is calculated correctly
        assert(wasteEmission > 0.0f)
    }


    /* new values outside of default */
    @Test
    fun testModifiedWaterFootprint() {
        val modifiedWaterFootprint = waterFootprint.copy(
            showerDuration = "over 30 mins",
            sinkDuration = "5-10 mins",
            toiletUsage = "sometimes"
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 1,
            waterComponent = modifiedWaterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = wasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.water > 0.0f)
        assert(modifiedWaterFootprint != waterFootprint)
    }

    @Test
    fun testModifiedEnergyFootprint() {
        val modifiedEnergyFootprint = energyFootprint.copy(
            airconCountUnplugged = Tuple(2, false),
            lightbulbCountUnplugged = Tuple(6, false)
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 3,
            waterComponent = waterFootprint,
            energyComponent = modifiedEnergyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = wasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.energy > 0.0f)
        assert(modifiedEnergyFootprint != energyFootprint)
    }

    @Test
    fun testModifiedTranspoFootprint() {
        val modifiedTranspoFootprint = transpoFootprint.copy(
            carDuration = "120 mins",
            busDuration = "60 mins"
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 3,
            waterComponent = waterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = modifiedTranspoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = wasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.transpo > 0.0f)
        assert(modifiedTranspoFootprint != transpoFootprint)
    }

    @Test
    fun testModifiedFoodFootprint() {
        val modifiedFoodFootprint = foodFootprint.copy(
            beefServings = "every meal",
            processedServings = "everyday"
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 3,
            waterComponent = waterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = modifiedFoodFootprint,
            wasteComponent = wasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.food > 0.0f)
        assert(modifiedFoodFootprint != foodFootprint)
    }

    @Test
    fun testModifiedWasteFootprint() {
        val modifiedWasteFootprint = wasteFootprint.copy(
            organicWeight = "5-6 kg",
            recycledPlastic = "all"
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 3,
            waterComponent = waterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = modifiedWasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.waste > 0.0f)
        assert(modifiedWasteFootprint != wasteFootprint)
    }

    @Test
    fun testAllFootprintsModified() {
        val modifiedWaterFootprint = waterFootprint.copy(
            showerDuration = "unknown",
            sinkDuration = "over 30 mins",
            household = 5
        )

        val modifiedEnergyFootprint = energyFootprint.copy(
            airconCountUnplugged = Tuple(3, true),
            lightbulbCountUnplugged = Tuple(10, false),
            washingmachineCountUnplugged = Tuple(2, false)
        )

        val modifiedTranspoFootprint = transpoFootprint.copy(
            carDuration = "0 mins",
            busDuration = "180 mins",
            trainDuration = "unknown"
        )

        val modifiedFoodFootprint = foodFootprint.copy(
            beefServings = "never",
            processedServings = "every meal",
            vegetableServings = "unknown"
        )

        val modifiedWasteFootprint = wasteFootprint.copy(
            organicWeight = "unknown",
            recycledPlastic = "none",
            recycledNonBio = "all"
        )

        val modifiedCarbonFootprint = userCarbonFootprint(
            household = 5,
            waterComponent = modifiedWaterFootprint,
            energyComponent = modifiedEnergyFootprint,
            transpoComponent = modifiedTranspoFootprint,
            foodComponent = modifiedFoodFootprint,
            wasteComponent = modifiedWasteFootprint
        )

        assert(modifiedCarbonFootprint.total > 0.0f)
        assert(modifiedCarbonFootprint.water > 0.0f)
        assert(modifiedCarbonFootprint.energy > 0.0f)
        assert(modifiedCarbonFootprint.transpo > 0.0f)
        assert(modifiedCarbonFootprint.food > 0.0f)
        assert(modifiedCarbonFootprint.waste > 0.0f)

        assert(modifiedWaterFootprint != waterFootprint)
        assert(modifiedEnergyFootprint != energyFootprint)
        assert(modifiedTranspoFootprint!= transpoFootprint)
        assert(modifiedFoodFootprint != foodFootprint)
        assert(modifiedWasteFootprint != wasteFootprint)
    }

}
