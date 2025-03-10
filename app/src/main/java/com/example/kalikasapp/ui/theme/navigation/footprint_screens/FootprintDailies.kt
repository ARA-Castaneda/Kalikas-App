package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailies
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress

// user Footprint Daily Targets variables
// used by DailiesTracker()
var waterDailiesDone = 0        // accomplished water dailies for the day n/3
var energyDailiesDone = 0       // accomplished energy dailies for the day n/3
var transpoDailiesDone = 0      // accomplished transpo dailies for the day n/3
var foodDailiesDone = 0         // accomplished food dailies for the day n/3
var wasteDailiesDone = 0        // accomplished waste dailies for the day n/3

var maxDailyWaterExp = 60f      // water dailies accumulated exp - resets everyday
var maxDailyEnergyExp = 60f     // water dailies accumulated exp - resets everyday
var maxDailyTranspoExp = 60f    // water dailies accumulated exp - resets everyday
var maxDailyFoodExp = 60f       // water dailies accumulated exp - resets everyday
var maxDailyWasteExp = 60f      // water dailies accumulated exp - resets everyday

// user dailies tracker data class
data class DailiesTriple(
    // Tuple(chalengeIndex, status)
    var d1: DailyTuple = DailyTuple("", false),
    var d2: DailyTuple = DailyTuple("", false),
    var d3: DailyTuple = DailyTuple("", false)
)

// Water footprint logger dailies
val waterLoggerDailies = listOf(
    // recalculation of userWaterFootprint = WaterFootprint()
    // userWaterFootprint.showerDuration = "daily target"
    "Shower for 20 mins or less",
    // userWaterFootprint.sinkDuration = "daily target"
    "Turn off unused faucet",
    // userWaterFootprint.toiletUsage = "daily target"
    "Flush with recycled water"
)

// Energy footprint logger dailies
val energyLoggerDailies = listOf(
    // recalculation of userEnergyFootprint = EnergyFootprint()
    // userEnergyFootprint.tvsetCountUnplugged.t2 = true
    // userEnergyFootprint.desktopCountUnplugged.t2 = true
    // userEnergyFootprint.laptopCountUnplugged.t2 = true
    // userEnergyFootprint.smartphoneCountUnplugged.t2 = true
    // userEnergyFootprint.tabletCountUnplugged.t2 = true
    // userEnergyFootprint.electricfanCountUnplugged.t2 = true
    // userEnergyFootprint.airconCountUnplugged.t2 = true
    "Unplug unused appliances",
    // userEnergyFootprint.lightbulbCountUnplugged.t1 = 0
    // userEnergyFootprint.lightbulbCountUnplugged.t2 = true
    "Switch to natural light",
    // recalculate with userRecalcEnergyEmission()
    "Use natural ventilation"
)

// Transpo footprint logger dailies
val transpoLoggerDailies = listOf(
    // recalculation of userTranspoFootprint = TranspoFootprint()
    // userTranspoFootprint.carDuration = "0 mins"
    // if already 0, not recalculated
    // else assume public transport
    // userTranspoFootprint.jeepneyDuration = +30 mins
    "Do not use carpool",
    // userTranspoFootprint.walkBicycle = true
    // userTranspoFootprint.jeepneyDuration = -30 mins
    // if already 0, not recalculated
    "Walk to your destination",
    // userTranspoFootprint.motorcycleDuration = "0 mins"
    // if already 0, not recalculated
    // else assume public transport
    // userTranspoFootprint.jeepneyDuration = +30 mins
    "Do not use motorcycle taxi"
)

// Food footprint logger dailies
val foodLoggerDailies = listOf(
    // recalculation of userFoodFootprint = FoodFootprint()
    // userFoodFootprint.beefServings = -1 serving per week
    // if "never", not recalculated
    "Eat less beef today",
    // userFoodFootprint.chickenServings = -1 serving per week
    // userFoodFootprint.porkServings = -1 serving per week
    // userFoodFootprint.seafoodServings = -1 serving per week
    // userFoodFootprint.milkServings = -1 serving per week
    // userFoodFootprint.cheeseServings = -1 serving per week
    // if "never", not recalculated
    "Choose 1 vegetarian meal",
    // userFoodFootprint.processedServings = -1 serving per week
    // if "never", not recalculated
    "No junk foods today"
)

// Waste footprint logger dailies
val wasteLoggerDailies = listOf(
    // recalculation of userWasteFootprint = WasteFootprint()
    // userWasteFootprint.plasticWeight = -0.1 kg
    // if 0 kg, not recalculated
    "Do not use plastic containers",
    // userWasteFootprint.recycledPaper = +0.1 unit
    // userWasteFootprint.recycledPlastic = +0.1 unit
    // userWasteFootprint.recycledNonBio = +0.1 unit
    // if all recycled, not recalculated
    "Reuse packaging or bottles",
    // userWasteFootprint.organicWeight = -0.1 kg
    "Avoid having any leftovers"
)

// Water footprint logger rewarded exp
val waterLoggerExpMap = mapOf(
    "Shower for 20 mins or less" to 20f,
    "Turn off unused faucet" to 20f,
    "Use recycled water for flushing" to 20f
)

// Energy footprint logger rewarded exp
val energyLoggerExpMap = mapOf(
    "Unplug unused appliances" to 20f,
    "Switch to natural light" to 20f,
    "Use natural ventilation" to 20f
)

// Transpo footprint logger rewarded exp
val transpoLoggerExpMap = mapOf(
    "Do not use carpool" to 20f,
    "Walk to your destination" to 20f,
    "Do not use motorcycle taxi" to 20f
)

// Food footprint logger rewarded exp
val foodLoggerExpMap = mapOf(
    "Eat less beef today" to 20f,
    "Choose 1 vegetarian meal" to 20f,
    "No junk foods today" to 20f
)

// Waste footprint logger rewarded exp
val wasteLoggerExpMap = mapOf(
    "Do not use plastic containers" to 20f,
    "Reuse packaging or bottles" to 20f,
    "Avoid having any leftovers" to 20f
)

// Controller of water dailies counter
fun userWaterDailiesCounter(dailyTuple: DailyTuple, string: String) {
    when (string) {
        userDailiesProgress.waterDailies.d1.t1 ->
            if (!dailyTuple.t2) {
                if (waterDailiesDone == 0) {
                    waterDailiesDone
                    userDailiesProgress.waterDailies.d1.t2 = false
                } else {
                    waterDailiesDone -= 1
                    userDailiesProgress.waterDailies.d1.t2 = false
                }
            } else {
                waterDailiesDone += 1
                userDailiesProgress.waterDailies.d1.t2 = true
            }

        userDailiesProgress.waterDailies.d2.t1 ->
            if (!dailyTuple.t2) {
                if (waterDailiesDone == 0) {
                    waterDailiesDone
                    userDailiesProgress.waterDailies.d2.t2 = false
                } else {
                    waterDailiesDone -= 1
                    userDailiesProgress.waterDailies.d2.t2 = false
                }
            } else {
                waterDailiesDone += 1
                userDailiesProgress.waterDailies.d2.t2 = true
            }

        userDailiesProgress.waterDailies.d3.t1 ->
            if (!dailyTuple.t2) {
                if (waterDailiesDone == 0) {
                    waterDailiesDone
                    userDailiesProgress.waterDailies.d3.t2 = false
                } else {
                    waterDailiesDone -= 1
                    userDailiesProgress.waterDailies.d3.t2 = false
                }
            } else {
                waterDailiesDone += 1
                userDailiesProgress.waterDailies.d3.t2 = true
            }
    }
}

// Controller of energy dailies counter
fun userEnergyDailiesCounter(dailyTuple: DailyTuple, string: String) {
    when (string) {
        userDailiesProgress.energyDailies.d1.t1 ->
            if (!dailyTuple.t2) {
                if (energyDailiesDone == 0) {
                    energyDailiesDone
                    userDailiesProgress.energyDailies.d1.t2 = false
                } else {
                    energyDailiesDone -= 1
                    userDailiesProgress.energyDailies.d1.t2 = false
                }
            } else {
                energyDailiesDone += 1
                userDailiesProgress.energyDailies.d1.t2 = true
            }

        userDailiesProgress.energyDailies.d2.t1 ->
            if (!dailyTuple.t2) {
                if (energyDailiesDone == 0) {
                    energyDailiesDone
                    userDailiesProgress.energyDailies.d2.t2 = false
                } else {
                    energyDailiesDone -= 1
                    userDailiesProgress.energyDailies.d2.t2 = false
                }
            } else {
                energyDailiesDone += 1
                userDailiesProgress.energyDailies.d2.t2 = true
            }

        userDailiesProgress.energyDailies.d3.t1 ->
            if (!dailyTuple.t2) {
                if (energyDailiesDone == 0) {
                    energyDailiesDone
                    userDailiesProgress.energyDailies.d3.t2 = false
                } else {
                    energyDailiesDone -= 1
                    userDailiesProgress.energyDailies.d3.t2 = false
                }
            } else {
                energyDailiesDone += 1
                userDailiesProgress.energyDailies.d3.t2 = true
            }
    }
}

// Controller of transpo dailies counter
fun userTranspoDailiesCounter(dailyTuple: DailyTuple, string: String) {
    when (string) {
        userDailiesProgress.transpoDailies.d1.t1 ->
            if (!dailyTuple.t2) {
                if (transpoDailiesDone == 0) {
                    transpoDailiesDone
                    userDailiesProgress.transpoDailies.d1.t2 = false
                } else {
                    transpoDailiesDone -= 1
                    userDailiesProgress.transpoDailies.d1.t2 = false
                }
            } else {
                transpoDailiesDone += 1
                userDailiesProgress.transpoDailies.d1.t2 = true
            }

        userDailiesProgress.transpoDailies.d2.t1 ->
            if (!dailyTuple.t2) {
                if (transpoDailiesDone == 0) {
                    transpoDailiesDone
                    userDailiesProgress.transpoDailies.d2.t2 = false
                } else {
                    transpoDailiesDone -= 1
                    userDailiesProgress.transpoDailies.d2.t2 = false
                }
            } else {
                transpoDailiesDone += 1
                userDailiesProgress.transpoDailies.d2.t2 = true
            }

        userDailiesProgress.transpoDailies.d3.t1 ->
            if (!dailyTuple.t2) {
                if (transpoDailiesDone == 0) {
                    transpoDailiesDone
                    userDailiesProgress.transpoDailies.d3.t2 = false
                } else {
                    transpoDailiesDone -= 1
                    userDailiesProgress.transpoDailies.d3.t2 = false
                }
            } else {
                transpoDailiesDone += 1
                userDailiesProgress.transpoDailies.d3.t2 = true
            }
    }
}

// Controller of food dailies counter
fun userFoodDailiesCounter(dailyTuple: DailyTuple, string: String) {
    when (string) {
        userDailiesProgress.foodDailies.d1.t1 ->
            if (!dailyTuple.t2) {
                if (foodDailiesDone == 0) {
                    foodDailiesDone
                    userDailiesProgress.foodDailies.d1.t2 = false
                } else {
                    foodDailiesDone -= 1
                    userDailiesProgress.foodDailies.d1.t2 = false
                }
            } else {
                foodDailiesDone += 1
                userDailiesProgress.foodDailies.d1.t2 = true
            }

        userDailiesProgress.foodDailies.d2.t1 ->
            if (!dailyTuple.t2) {
                if (foodDailiesDone == 0) {
                    foodDailiesDone
                    userDailiesProgress.foodDailies.d2.t2 = false
                } else {
                    foodDailiesDone -= 1
                    userDailiesProgress.foodDailies.d2.t2 = false
                }
            } else {
                foodDailiesDone += 1
                userDailiesProgress.foodDailies.d2.t2 = true
            }

        userDailiesProgress.foodDailies.d3.t1 ->
            if (!dailyTuple.t2) {
                if (foodDailiesDone == 0) {
                    foodDailiesDone
                    userDailiesProgress.foodDailies.d3.t2 = false
                } else {
                    foodDailiesDone -= 1
                    userDailiesProgress.foodDailies.d3.t2 = false
                }
            } else {
                foodDailiesDone += 1
                userDailiesProgress.foodDailies.d3.t2 = true
            }
    }
}

// Controller of water dailies counter
fun userWasteDailiesCounter(dailyTuple: DailyTuple, string: String) {
    when (string) {
        userDailiesProgress.wasteDailies.d1.t1 ->
            if (!dailyTuple.t2) {
                if (wasteDailiesDone == 0) {
                    wasteDailiesDone
                    userDailiesProgress.wasteDailies.d1.t2 = false
                } else {
                    wasteDailiesDone -= 1
                    userDailiesProgress.wasteDailies.d1.t2 = false
                }
            } else {
                wasteDailiesDone += 1
                userDailiesProgress.wasteDailies.d1.t2 = true
            }

        userDailiesProgress.wasteDailies.d2.t1 ->
            if (!dailyTuple.t2) {
                if (wasteDailiesDone == 0) {
                    wasteDailiesDone
                    userDailiesProgress.wasteDailies.d2.t2 = false
                } else {
                    wasteDailiesDone -= 1
                    userDailiesProgress.wasteDailies.d2.t2 = false
                }
            } else {
                wasteDailiesDone += 1
                userDailiesProgress.wasteDailies.d2.t2 = true
            }

        userDailiesProgress.wasteDailies.d3.t1 ->
            if (!dailyTuple.t2) {
                if (wasteDailiesDone == 0) {
                    wasteDailiesDone
                    userDailiesProgress.wasteDailies.d3.t2 = false
                } else {
                    wasteDailiesDone -= 1
                    userDailiesProgress.wasteDailies.d3.t2 = false
                }
            } else {
                wasteDailiesDone += 1
                userDailiesProgress.wasteDailies.d3.t2 = true
            }
    }
}
