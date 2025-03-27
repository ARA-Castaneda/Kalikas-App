package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

import com.example.kalikasapp.ui.theme.navigation.footprint_screens.EnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.FoodFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.TranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WasteFootprint
import com.example.kalikasapp.ui.theme.navigation.footprint_screens.WaterFootprint
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class BenchmarkDataDefinitionsTest {

    @Test
    fun testWaterBenchmarksNotEmpty() {
        assertFalse(waterBenchmarks.isEmpty())
    }

    @Test
    fun testWaterOptsNotEmpty() {
        assertFalse(waterOpts2.isEmpty())
        assertFalse(waterOpts3.isEmpty())
        assertFalse(waterOpts4.isEmpty())
        assertFalse(waterOpts5.isEmpty())
        assertFalse(waterOpts6.isEmpty())
        assertFalse(waterOpts7.isEmpty())
        assertFalse(waterOpts8.isEmpty())
        assertFalse(waterOpts9.isEmpty())
        assertFalse(waterOpts10.isEmpty())
    }

    @Test
    fun testEnergyBenchmarksNotEmpty() {
        assertFalse(energyBenchmarks.isEmpty())
    }

    @Test
    fun testTranspoBenchmarksNotEmpty() {
        assertFalse(transpoBenchmarks.isEmpty())
    }

    @Test
    fun testTranspoOptsNotEmpty() {
        assertFalse(transpoOpts.isEmpty())
    }

    @Test
    fun testFoodBenchmarksNotEmpty() {
        assertFalse(foodBenchmarks.isEmpty())
    }

    @Test
    fun testFoodOptsNotEmpty() {
        assertFalse(foodOpts.isEmpty())
    }

    @Test
    fun testWasteBenchmarksNotEmpty() {
        assertFalse(wasteBenchmarks.isEmpty())
    }

    @Test
    fun testWasteOptsNotEmpty() {
        assertFalse(wasteWeightOpts.isEmpty())
        assertFalse(wasteRecycledOpts.isEmpty())
    }
}


class WaterBenchmarkControllerTest {

    private lateinit var waterFootprint: WaterFootprint // Using real WaterFootprint

    @Before
    fun setup() {
        waterFootprint = WaterFootprint() // Instantiate real WaterFootprint
        benchmarkWaterFootprint = waterFootprint // Assuming benchmarkWaterFootprint is globally accessible and mutable
    }

    @Test
    fun testWaterBenchQ1() {
        waterBenchQ1(3)
        assertEquals(3, waterFootprint.household)
    }

    @Test
    fun testWaterBenchQ2() {
        waterBenchQ2("5-10 mins")
        assertEquals("5-10 mins", waterFootprint.showerDuration)
    }

    @Test
    fun testWaterBenchQ3() {
        waterBenchQ3("11-15 mins")
        assertEquals("11-15 mins", waterFootprint.sinkDuration)
    }

    @Test
    fun testWaterBenchQ4() {
        waterBenchQ4("sometimes")
        assertEquals("sometimes", waterFootprint.toiletUsage)
    }

    @Test
    fun testWaterBenchQ5() {
        waterBenchQ5("every other day")
        assertEquals("every other day", waterFootprint.dishesContrib.t1)
    }

    @Test
    fun testWaterBenchQ6() {
        waterBenchQ6("dishwasher")
        assertEquals("dishwasher", waterFootprint.dishesContrib.t2)
    }

    @Test
    fun testWaterBenchQ7() {
        waterBenchQ7("3 loads")
        assertEquals("3 loads", waterFootprint.dishesContrib.t3)
    }

    @Test
    fun testWaterBenchQ8() {
        waterBenchQ8("every 2 weeks")
        assertEquals("every 2 weeks", waterFootprint.laundryContrib.t1)
    }

    @Test
    fun testWaterBenchQ9_OwnWashingMachine() {
        waterBenchQ9("own washing machine")
        assertEquals("own", waterFootprint.laundryContrib.t2)
    }

    @Test
    fun testWaterBenchQ9_Laundromat() {
        waterBenchQ9("laundromat service")
        assertEquals("laundromat", waterFootprint.laundryContrib.t2)
    }

    @Test
    fun testWaterBenchQ10() {
        waterBenchQ10("more than 4 loads")
        assertEquals("more than 4 loads", waterFootprint.laundryContrib.t3)
    }
}


class EnergyBenchmarkControllerTest {

    private lateinit var energyFootprint: EnergyFootprint // Using real EnergyFootprint

    @Before
    fun setup() {
        energyFootprint = EnergyFootprint() // Instantiate real EnergyFootprint
        benchmarkEnergyFootprint = energyFootprint
    }

    @Test
    fun testEnergyBenchQ1() {
        energyBenchQ1(2)
        assertEquals(2, energyFootprint.tvsetCountUnplugged.t1)
    }

    @Test
    fun testEnergyBenchQ8() {
        energyBenchQ8(5)
        assertEquals(5, energyFootprint.lightbulbCountUnplugged.t1)
    }

    // ... Add tests for all energyBenchQ functions ...
    @Test
    fun testEnergyBenchQ17() {
        energyBenchQ17(1)
        assertEquals(1, energyFootprint.dryerCountUnplugged.t1)
    }
}


class TranspoBenchmarkControllerTest {

    private lateinit var transpoFootprint: TranspoFootprint // Using real TranspoFootprint

    @Before
    fun setup() {
        transpoFootprint = TranspoFootprint() // Instantiate real TranspoFootprint
        benchmarkTranspoFootprint = transpoFootprint
    }

    @Test
    fun testTranspoBenchQ1_ModeNotUsed() {
        transpoBenchQ1("mode not used")
        assertEquals("0 mins", transpoFootprint.carDuration)
    }

    @Test
    fun testTranspoBenchQ1_LessThan30Mins() {
        transpoBenchQ1("less than 30 mins")
        assertEquals("30 mins", transpoFootprint.carDuration)
    }

    @Test
    fun testTranspoBenchQ1_MoreThan3Hours() {
        transpoBenchQ1("more than 3 hours")
        assertEquals("200 mins", transpoFootprint.carDuration)
    }

    // ... Add tests for all transpoBenchQ functions with different options ...
    @Test
    fun testTranspoBenchQ7_30MinsTo1Hour() {
        transpoBenchQ7("30 mins to 1 hour")
        assertEquals("60 mins", transpoFootprint.tricycleDuration)
    }
}


class FoodBenchmarkControllerTest {

    private lateinit var foodFootprint: FoodFootprint // Using real FoodFootprint

    @Before
    fun setup() {
        foodFootprint = FoodFootprint() // Instantiate real FoodFootprint
        benchmarkFoodFootprint = foodFootprint
    }

    @Test
    fun testFoodBenchQ1() {
        foodBenchQ1("once a week")
        assertEquals("once a week", foodFootprint.beefServings)
    }

    // ... Add tests for all foodBenchQ functions ...
    @Test
    fun testFoodBenchQ12() {
        foodBenchQ12("everyday")
        assertEquals("everyday", foodFootprint.wheatServings)
    }
}


class WasteBenchmarkControllerTest {

    private lateinit var wasteFootprint: WasteFootprint // Using real WasteFootprint

    @Before
    fun setup() {
        wasteFootprint = WasteFootprint() // Instantiate real WasteFootprint
        benchmarkWasteFootprint = wasteFootprint
    }

    @Test
    fun testWasteBenchQ1() {
        wasteBenchQ1("1-2 kg")
        assertEquals("1-2 kg", wasteFootprint.organicWeight)
    }

    @Test
    fun testWasteBenchQ2() {
        wasteBenchQ2("half")
        assertEquals("half", wasteFootprint.recycledOrganic)
    }

    // ... Add tests for all wasteBenchQ functions ...
    @Test
    fun testWasteBenchQ8() {
        wasteBenchQ8("all")
        assertEquals("all", wasteFootprint.recycledNonBio)
    }
}