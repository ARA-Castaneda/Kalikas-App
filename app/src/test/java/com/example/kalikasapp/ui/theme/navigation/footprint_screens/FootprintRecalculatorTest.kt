package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userEnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userFoodFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userTranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userWasteFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userWaterFootprint
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FootprintRecalculatorTest {

    // Test data (using copies of the data classes from FootprintCalculator.kt)
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

    @Before
    fun setup() {
        // Reset Dailies and footprints before each test
        userDailiesProgress = DailiesProgress()
        userWaterFootprint = waterFootprint
        userEnergyFootprint = energyFootprint
        userTranspoFootprint = transpoFootprint
        userFoodFootprint = foodFootprint
        userWasteFootprint = wasteFootprint

        userRecalcWaterFootprint = adjustWaterEmission()
        userRecalcEnergyFootprint = adjustEnergyEmission()
        userRecalcTranspoFootprint = adjustTranspoEmission()
        userRecalcFoodFootprint = adjustFoodEmission()
        userRecalcWasteFootprint = adjustWasteEmission()
    }


    @Test
    fun testAdjustEmissions_NoDailiesCompleted() {
        // Check that no changes occur if no dailies are completed.
        assertEquals(waterFootprint, adjustWaterEmission())
        assertEquals(energyFootprint, adjustEnergyEmission())
        assertEquals(transpoFootprint, adjustTranspoEmission())
        assertEquals(foodFootprint, adjustFoodEmission())
        assertEquals(wasteFootprint, adjustWasteEmission())
    }

    @Test
    fun testAdjustEmissions_AllDailiesCompleted() {
        // Simulate completing all dailies in all categories
        userDailiesProgress.waterDailies.d1.t2 = true
        userDailiesProgress.waterDailies.d2.t2 = true
        userDailiesProgress.waterDailies.d3.t2 = true
        userDailiesProgress.energyDailies.d1.t2 = true
        userDailiesProgress.energyDailies.d2.t2 = true
        userDailiesProgress.energyDailies.d3.t2 = true
        userDailiesProgress.transpoDailies.d1.t2 = true
        userDailiesProgress.transpoDailies.d2.t2 = true
        userDailiesProgress.transpoDailies.d3.t2 = true
        userDailiesProgress.foodDailies.d1.t2 = true
        userDailiesProgress.foodDailies.d2.t2 = true
        userDailiesProgress.foodDailies.d3.t2 = true
        userDailiesProgress.wasteDailies.d1.t2 = true
        userDailiesProgress.wasteDailies.d2.t2 = true
        userDailiesProgress.wasteDailies.d3.t2 = true

        // Check key changes for each category
        val adjustedWater = adjustWaterEmission()
        assertEquals("daily target", adjustedWater.showerDuration)
        assertEquals("daily target", adjustedWater.sinkDuration)
        assertEquals("daily target", adjustedWater.toiletUsage)

        val adjustedEnergy = adjustEnergyEmission()
        assertTrue(adjustedEnergy.tvsetCountUnplugged.t2) // And other vampire devices
        assertEquals(0, adjustedEnergy.lightbulbCountUnplugged.t1)

        val adjustedTranspo = adjustTranspoEmission()
        assertEquals("0 mins", adjustedTranspo.carDuration)
        assertTrue(adjustedTranspo.walkBicycle)
        assertEquals("60 mins", adjustedTranspo.jeepneyDuration)
        assertEquals("0 mins", adjustedTranspo.motorcycleDuration)


        val adjustedFood = adjustFoodEmission()
        assertEquals("once a week", adjustedFood.beefServings)
        assertEquals("2-3x per week", adjustedFood.chickenServings) //and other meats
        assertEquals("2-3x per week", adjustedFood.processedServings)

        val adjustedWaste = adjustWasteEmission()
        assertEquals("almost 1 kg", adjustedWaste.organicWeight)
        assertEquals("less than half", adjustedWaste.recycledPaper) //and other recycling
        assertEquals("none", adjustedWaste.plasticWeight)
    }


    @Test
    fun testUserRecalcEnergyEmission_DailyTargetAircon() {
        // Test the specific case where energy daily 3 (aircon target) is completed.
        userDailiesProgress.energyDailies.d3.t2 = true
        val recalculated = userRecalcEnergyEmission(energyFootprint)
        val original = userEnergyEmission(energyFootprint)
        assertNotEquals(original, recalculated, 0.001f)
    }
    @Test
    fun testUserRecalcEnergyEmission_vampire(){
        userDailiesProgress.energyDailies.d1.t2 = true
        userDailiesProgress.energyDailies.d2.t2 = true
        userDailiesProgress.energyDailies.d3.t2 = true
        val adjusted = adjustEnergyEmission()
        val emissionWithAllTrue = userRecalcEnergyEmission(adjusted)
        // Re-fetch the original, unmodified energy footprint for a fair comparison
        val unmodifiedEnergyFootprint = EnergyFootprint(
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
        val emissionWithAllFalse = userEnergyEmission(unmodifiedEnergyFootprint)  // Use userEnergyEmission

        assertNotEquals(emissionWithAllFalse, emissionWithAllTrue, 0.001f)

    }

    @Test
    fun testUserRecalcCarbonFootprint_WithAdjustedComponents() {
        //Test overall footprint change after completing ALL dailies.
        userDailiesProgress.waterDailies.d1.t2 = true
        userDailiesProgress.waterDailies.d2.t2 = true
        userDailiesProgress.waterDailies.d3.t2 = true
        userDailiesProgress.energyDailies.d1.t2 = true
        userDailiesProgress.energyDailies.d2.t2 = true
        userDailiesProgress.energyDailies.d3.t2 = true
        userDailiesProgress.transpoDailies.d1.t2 = true
        userDailiesProgress.transpoDailies.d2.t2 = true
        userDailiesProgress.transpoDailies.d3.t2 = true
        userDailiesProgress.foodDailies.d1.t2 = true
        userDailiesProgress.foodDailies.d2.t2 = true
        userDailiesProgress.foodDailies.d3.t2 = true
        userDailiesProgress.wasteDailies.d1.t2 = true
        userDailiesProgress.wasteDailies.d2.t2 = true
        userDailiesProgress.wasteDailies.d3.t2 = true

        val initialCarbonFootprint = userRecalcCarbonFootprint(
            household = 1,
            waterComponent = waterFootprint,
            energyComponent = energyFootprint,
            transpoComponent = transpoFootprint,
            foodComponent = foodFootprint,
            wasteComponent = wasteFootprint
        )
        val initialTotal = initialCarbonFootprint.total


        val recalculatedCarbonFootprint = userRecalcCarbonFootprint(
            household = 1,
            waterComponent = adjustWaterEmission(),       // Adjusted
            energyComponent = adjustEnergyEmission(),      // Adjusted
            transpoComponent = adjustTranspoEmission(),    // Adjusted
            foodComponent = adjustFoodEmission(),         // Adjusted
            wasteComponent = adjustWasteEmission()        // Adjusted
        )

        assertNotEquals(initialTotal, recalculatedCarbonFootprint.total, 0.001f)

    }
}