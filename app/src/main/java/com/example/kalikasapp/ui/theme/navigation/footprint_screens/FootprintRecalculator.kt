package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userEnergyFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userFoodFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userTranspoFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userWasteFootprint
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userWaterFootprint
import java.util.Locale

// for recalculating benchmarks
var userDailyMA = 0f        // recalculated daily carbon footprint
var userWeeklyMA = 0f       // average of 7 daily recalcs
var userMonthlyMA = 0f      // average of 4 weekly recalcs
var userYearlyMA = 0f       // average of 12 monthly recalcs

var userRecalcWaterFootprint = adjustWaterEmission()
var userRecalcEnergyFootprint = adjustEnergyEmission()
var userRecalcTranspoFootprint = adjustTranspoEmission()
var userRecalcFoodFootprint = adjustFoodEmission()
var userRecalcWasteFootprint = adjustWasteEmission()

// for recalculating Weekly Carbon Footprint
data class WeeklyMovingAverage(
    var daily1: Float? = null,
    var daily2: Float? = null,
    var daily3: Float? = null,
    var daily4: Float? = null,
    var daily5: Float? = null,
    var daily6: Float? = null,
    var daily7: Float? = null
)

// for recalculating Monthly Carbon Footprint
data class MonthlyMovingAverage(
    var weekly1: WeeklyMovingAverage? = null,
    var weekly2: WeeklyMovingAverage? = null,
    var weekly3: WeeklyMovingAverage? = null,
    var weekly4: WeeklyMovingAverage? = null
)

// for recalculating Yearly Carbon Fooprint
data class YearlyMovingAverage(
    var monthly1: MonthlyMovingAverage? = null,
    var monthly2: MonthlyMovingAverage? = null,
    var monthly3: MonthlyMovingAverage? = null,
    var monthly4: MonthlyMovingAverage? = null,
    var monthly5: MonthlyMovingAverage? = null,
    var monthly6: MonthlyMovingAverage? = null,
    var monthly7: MonthlyMovingAverage? = null,
    var monthly8: MonthlyMovingAverage? = null,
    var monthly9: MonthlyMovingAverage? = null,
    var monthly10: MonthlyMovingAverage? = null,
    var monthly11: MonthlyMovingAverage? = null,
    var monthly12: MonthlyMovingAverage? = null
)

// user dailies experience points tracker
data class DailiesExp(
    var waterExp: Float = maxDailyWaterExp,
    var energyExp: Float = maxDailyEnergyExp,
    var transpoExp: Float = maxDailyTranspoExp,
    var foodExp: Float = maxDailyFoodExp,
    var wasteExp: Float = maxDailyWasteExp,
)

// Recalculated per individual per month
fun userRecalcCarbonFootprint(
    household: Int,
    waterComponent: WaterFootprint,
    energyComponent: EnergyFootprint,
    transpoComponent: TranspoFootprint,
    foodComponent: FoodFootprint,
    wasteComponent: WasteFootprint
): CarbonFootprint {
    var userCarbonFootprint = CarbonFootprint()

    var waterCarbonContrib = userWaterEmission(household, waterComponent)
    var energyCarbonContrib = userEnergyEmission(energyComponent) / household.toFloat()
    var transpoCarbonContrib = userTranspoEmission(transpoComponent)
    var foodCarbonContrib = userFoodEmission(foodComponent)
    var wasteCarbonContrib = userWasteEmission(wasteComponent) / household.toFloat()

    // only energy footprint recalculation uses
    // different mapping function
    if (userDailiesProgress.energyDailies.d3.t2) {
        energyCarbonContrib = userRecalcEnergyEmission(energyComponent) / household.toFloat()
    }

    userCarbonFootprint.water = waterCarbonContrib
    userCarbonFootprint.energy = energyCarbonContrib
    userCarbonFootprint.transpo = transpoCarbonContrib
    userCarbonFootprint.food = foodCarbonContrib
    userCarbonFootprint.waste = wasteCarbonContrib
    userCarbonFootprint.total = waterCarbonContrib + energyCarbonContrib + transpoCarbonContrib +
            foodCarbonContrib + wasteCarbonContrib

    // kgs CO2 emissions per month (individual)
    return userCarbonFootprint
}

// Recalculated per household per month
fun userRecalcEnergyEmission(
    userEnergyFootprint: EnergyFootprint
): Float {
    var energyEmission: Float

    var tvsetEmission = userEnergyFootprint.tvsetCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "tvset") { 0.000f }
    var desktopEmission = userEnergyFootprint.desktopCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "desktop") { 0.000f }
    var laptopEmission = userEnergyFootprint.laptopCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "laptop") { 0.000f }
    var smartphoneEmission = userEnergyFootprint.smartphoneCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "smartphone") { 0.000f }
    var tabletEmission = userEnergyFootprint.tabletCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "tablet") { 0.000f }
    var electricfanEmission = userEnergyFootprint.electricfanCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "daily target fan") { 0.000f }
    var airconEmission = userEnergyFootprint.airconCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "daily target aircon") { 0.000f }
    var lightbulbEmission = userEnergyFootprint.lightbulbCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "lightbulb") { 0.000f }
    var refrigeratorEmission = userEnergyFootprint.refrigeratorCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "refrigerator") { 0.000f }
    var microwaveEmission = userEnergyFootprint.microwaveCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "microwave") { 0.000f }
    var stoveEmission = userEnergyFootprint.stoveCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "stove") { 0.000f }
    var toasterEmission = userEnergyFootprint.toasterCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "toaster") { 0.000f }
    var ricecookerEmission = userEnergyFootprint.ricecookerCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "ricecooker") { 0.000f }
    var dispenserEmission = userEnergyFootprint.dispenserCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "dispenser") { 0.000f }
    var kettleEmission = userEnergyFootprint.kettleCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "kettle") { 0.000f }
    var washingmachineEmission = userEnergyFootprint.washingmachineCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "washingmachine") { 0.000f }
    var dryerEmission = userEnergyFootprint.dryerCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "dryer") { 0.000f }

    var tvsetVampEmission = 0.000f
    if(!userEnergyFootprint.tvsetCountUnplugged.t2) {
        tvsetVampEmission = userEnergyFootprint.tvsetCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "tvsetVE") { 0.000f }
    }
    var desktopVampEmission = 0.000f
    if(!userEnergyFootprint.desktopCountUnplugged.t2) {
        desktopVampEmission = userEnergyFootprint.desktopCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "desktopVE") { 0.000f }
    }
    var laptopVampEmission = 0.000f
    if(!userEnergyFootprint.laptopCountUnplugged.t2) {
        laptopVampEmission = userEnergyFootprint.laptopCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "laptopVE") { 0.000f }
    }
    var smartphoneVampEmission = 0.000f
    if(!userEnergyFootprint.smartphoneCountUnplugged.t2) {
        smartphoneVampEmission = userEnergyFootprint.smartphoneCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "smartphoneVE") { 0.000f }
    }
    var tabletVampEmission = 0.000f
    if(!userEnergyFootprint.tabletCountUnplugged.t2) {
        tabletVampEmission = userEnergyFootprint.tabletCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "tabletVE") { 0.000f }
    }
    var electricfanVampEmission = 0.000f
    if(!userEnergyFootprint.electricfanCountUnplugged.t2) {
        electricfanVampEmission = userEnergyFootprint.electricfanCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "electricfanVE") { 0.000f }
    }
    var airconVampEmission = 0.000f
    if(!userEnergyFootprint.airconCountUnplugged.t2) {
        airconVampEmission = userEnergyFootprint.airconCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "airconVE") { 0.000f }
    }
    var lightbulbVampEmission = 0.000f
    if(!userEnergyFootprint.lightbulbCountUnplugged.t2) {
        lightbulbVampEmission = userEnergyFootprint.lightbulbCountUnplugged.t1 *
                electricityContribMap.getOrElse(key = "lightbulbVE") { 0.000f }
    }

    energyEmission = (tvsetEmission + tvsetVampEmission) + (desktopEmission + desktopVampEmission) +
            (laptopEmission + laptopVampEmission) + (smartphoneEmission + smartphoneVampEmission) +
            (tabletEmission + tabletVampEmission) + (electricfanEmission + electricfanVampEmission) +
            (airconEmission + airconVampEmission) + (lightbulbEmission + lightbulbVampEmission) +
            refrigeratorEmission + microwaveEmission + stoveEmission + toasterEmission +
            ricecookerEmission + dispenserEmission + kettleEmission +
            washingmachineEmission + dryerEmission
    energyEmission = String.format(Locale.US, "%.3f", energyEmission).toFloat()

    // kgs CO2 energy emission per month (household)
    return energyEmission
}

// Controller for readjusting water benchmarks
fun adjustWaterEmission(): WaterFootprint {
    var new = userWaterFootprint

    if (userDailiesProgress.waterDailies.d1.t2) {
        new.showerDuration = "daily target"
    }

    if (userDailiesProgress.waterDailies.d2.t2) {
        new.sinkDuration = "daily target"
    }

    if (userDailiesProgress.waterDailies.d3.t2) {
        new.toiletUsage = "daily target"
    }

    return new
}

// Controller for readjusting energy benchmarks
fun adjustEnergyEmission(): EnergyFootprint {
    var new = userEnergyFootprint

    if (userDailiesProgress.energyDailies.d1.t2) {
        new.tvsetCountUnplugged.t2 = true
        new.desktopCountUnplugged.t2 = true
        new.laptopCountUnplugged.t2 = true
        new.smartphoneCountUnplugged.t2 = true
        new.tabletCountUnplugged.t2 = true
        new.electricfanCountUnplugged.t2 = true
        new.airconCountUnplugged.t2 = true
    }

    if (userDailiesProgress.energyDailies.d2.t2) {
        new.lightbulbCountUnplugged.t1 = 0
        new.lightbulbCountUnplugged.t2 = true
    }

    // move to userRecalcCarbonFootprint function
    /*
    if (userDailiesProgress.energyDailies.d3.t2) {
        // pass to userRecalcEnergyEmission()
        new
    }
    */

    return new
}

// Controller for readjusting transpo benchmarks
fun adjustTranspoEmission(): TranspoFootprint {
    var new = userTranspoFootprint

    if (userDailiesProgress.transpoDailies.d1.t2) {
        if (new.carDuration == "0 mins") {
            new.carDuration = "0 mins"
        } else {
            new.carDuration = "0 mins"
            new.jeepneyDuration = (
                    new.jeepneyDuration.substring(0, 2).toInt() + 30
                    ).toString() + " mins"
        }
    }
    if (userDailiesProgress.transpoDailies.d2.t2) {
        new.walkBicycle = true
        if (new.jeepneyDuration == "0 mins") {
            new.jeepneyDuration = "0 mins"
        } else {
            new.jeepneyDuration = (
                    new.jeepneyDuration.substring(0, 2).toInt() - 30
                    ).toString() + " mins"
        }
    }
    if (userDailiesProgress.transpoDailies.d3.t2) {
        if (new.motorcycleDuration == "0 mins") {
            new.motorcycleDuration = "0 mins"
        } else {
            new.motorcycleDuration = "0 mins"
            new.jeepneyDuration = (
                    new.jeepneyDuration.substring(0, 2).toInt() + 30
                    ).toString() + " mins"
        }
    }

    return new
}

// Controller for readjusting food benchmarks
fun adjustFoodEmission(): FoodFootprint {
    var new = userFoodFootprint

    if (userDailiesProgress.foodDailies.d1.t2) {
        // reduced beef servings
        when (new.beefServings) {
            "every other week" -> new.beefServings = "never"
            "once a week" -> new.beefServings = "every other week"
            "2-3x per week" -> new.beefServings = "once a week"
            "4-6x per week" -> new.beefServings = "2-3x per week"
            "everyday" -> new.beefServings = "4-6x per week"
            "2-3x per day" -> new.beefServings = "everyday"
            "more than 3x a day" -> new.beefServings = "2-3x per day"
            else -> new.beefServings = "never"
        }
    }

    if (userDailiesProgress.foodDailies.d2.t2) {
        // reduced chicken servings
        when (new.chickenServings) {
            "every other week" -> new.chickenServings = "never"
            "once a week" -> new.chickenServings = "every other week"
            "2-3x per week" -> new.chickenServings = "once a week"
            "4-6x per week" -> new.chickenServings = "2-3x per week"
            "everyday" -> new.chickenServings = "4-6x per week"
            "2-3x per day" -> new.chickenServings = "everyday"
            "more than 3x a day" -> new.chickenServings = "2-3x per day"
            else -> new.chickenServings = "never"
        }

        // reduced pork servings
        when (new.porkServings) {
            "every other week" -> new.porkServings = "never"
            "once a week" -> new.porkServings = "every other week"
            "2-3x per week" -> new.porkServings = "once a week"
            "4-6x per week" -> new.porkServings = "2-3x per week"
            "everyday" -> new.porkServings = "4-6x per week"
            "2-3x per day" -> new.porkServings = "everyday"
            "more than 3x a day" -> new.porkServings = "2-3x per day"
            else -> new.porkServings = "never"
        }

        // reduced seafood servings
        when (new.seafoodServings) {
            "every other week" -> new.seafoodServings = "never"
            "once a week" -> new.seafoodServings = "every other week"
            "2-3x per week" -> new.seafoodServings = "once a week"
            "4-6x per week" -> new.seafoodServings = "2-3x per week"
            "everyday" -> new.seafoodServings = "4-6x per week"
            "2-3x per day" -> new.seafoodServings = "everyday"
            "more than 3x a day" -> new.seafoodServings = "2-3x per day"
            else -> new.seafoodServings = "never"
        }

        // reduced milk servings
        when (new.milkServings) {
            "every other week" -> new.milkServings = "never"
            "once a week" -> new.milkServings = "every other week"
            "2-3x per week" -> new.milkServings = "once a week"
            "4-6x per week" -> new.milkServings = "2-3x per week"
            "everyday" -> new.milkServings = "4-6x per week"
            "2-3x per day" -> new.milkServings = "everyday"
            "more than 3x a day" -> new.milkServings = "2-3x per day"
            else -> new.milkServings = "never"
        }

        // reduced cheese servings
        when (new.cheeseServings) {
            "every other week" -> new.cheeseServings = "never"
            "once a week" -> new.cheeseServings = "every other week"
            "2-3x per week" -> new.cheeseServings = "once a week"
            "4-6x per week" -> new.cheeseServings = "2-3x per week"
            "everyday" -> new.cheeseServings = "4-6x per week"
            "2-3x per day" -> new.cheeseServings = "everyday"
            "more than 3x a day" -> new.cheeseServings = "2-3x per day"
            else -> new.cheeseServings = "never"
        }
    }

    if (userDailiesProgress.foodDailies.d3.t2) {
        // reduced processed servings
        when (new.processedServings) {
            "every other week" -> new.processedServings = "never"
            "once a week" -> new.processedServings = "every other week"
            "2-3x per week" -> new.processedServings = "once a week"
            "4-6x per week" -> new.processedServings = "2-3x per week"
            "everyday" -> new.processedServings = "4-6x per week"
            "2-3x per day" -> new.processedServings = "everyday"
            "more than 3x a day" -> new.processedServings = "2-3x per day"
            else -> new.processedServings = "never"
        }
    }

    return new
}

// Controller for readjusting waste benchmarks
fun adjustWasteEmission(): WasteFootprint  {
    var new = userWasteFootprint

    if (userDailiesProgress.wasteDailies.d1.t2) {
        // reduced plastic weight
        when (new.plasticWeight) {
            "less than 1 kg" -> new.plasticWeight = "none"
            "almost 1 kg" -> new.plasticWeight = "less than 1 kg"
            "1-2 kg" -> new.plasticWeight = "almost 1 kg"
            "2-3 kg" -> new.plasticWeight = "1-2 kg"
            "3-5 kg" -> new.plasticWeight = "2-3 kg"
            "more than 5 kg" -> new.plasticWeight = "3-5 kg"
            "else" -> new.plasticWeight = "none"
        }
    }

    if (userDailiesProgress.wasteDailies.d2.t2) {
        // increased recycled paper
        when (new.recycledPaper) {
            "none" -> new.recycledPaper = "less than half"
            "less than half" -> new.recycledPaper = "half"
            "half" -> new.recycledPaper = "almost all"
            "almost all" -> new.recycledPaper = "all"
            else -> new.recycledPaper = "all"
        }

        // increased recycled plastic
        when (new.recycledPlastic) {
            "none" -> new.recycledPlastic = "less than half"
            "less than half" -> new.recycledPlastic = "half"
            "half" -> new.recycledPlastic = "almost all"
            "almost all" -> new.recycledPlastic = "all"
            else -> new.recycledPlastic = "all"
        }

        // increased recycled nonbio
        when (new.recycledNonBio) {
            "none" -> new.recycledNonBio = "less than half"
            "less than half" -> new.recycledNonBio = "half"
            "half" -> new.recycledNonBio = "almost all"
            "almost all" -> new.recycledNonBio = "all"
            else -> new.recycledNonBio = "all"
        }
    }

    if (userDailiesProgress.wasteDailies.d3.t2) {
        // reduced organic weight
        when (new.organicWeight) {
            "less than 1 kg" -> new.organicWeight = "none"
            "almost 1 kg" -> new.organicWeight = "less than 1 kg"
            "1-2 kg" -> new.organicWeight = "almost 1 kg"
            "2-3 kg" -> new.organicWeight = "1-2 kg"
            "3-5 kg" -> new.organicWeight = "2-3 kg"
            "more than 5 kg" -> new.organicWeight = "3-5 kg"
            "else" -> new.organicWeight = "none"
        }
    }

    return new
}
