package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import com.example.kalikasapp.ui.theme.navigation.landing_screens.userChallengesProgress

// user Footprint Challenges variables
// used by ChallengesTracker() n/3 challenges done
var waterChallengesDone = 0
var energyChallengesDone = 0
var transpoChallengesDone = 0
var foodChallengesDone = 0
var wasteChallengesDone = 0

// user challenges tracker data class
// alpha = challenge upper threshold
// done = completed dailies count
data class ProgressTuple(
    var alpha: Int = 0,
    var done: Int = 0
)

// challenges Triple per category
// total 5 Challenges Triple entry per user
data class ChallengesTriple(
    var c1: ProgressTuple = ProgressTuple(0, 0),
    var c2: ProgressTuple= ProgressTuple(0, 0),
    var c3: ProgressTuple = ProgressTuple(0, 0)
)

// Water footprint logger challenges
val waterLoggerChallenges = listOf(
    // alpha/1
    "Reuse greywater 1x\nthis week",
    // alpha/5
    "Less than 20 mins\nshower for 5 days",
    // alpha/7
    "Turn off unused\nfaucet for 7 days"
)

// Energy footprint logger challenges
val energyLoggerChallenges = listOf(
    // alpha/1
    "Less ventilation 1x\n this week",
    // alpha/5
    "Choose natural\nlight for 5 days",
    // alpha/7
    "Unplug unused\ndevices for 7 days"
)

// Transpo footprint logger challenges
val transpoLoggerChallenges = listOf(
    // alpha/3
    "No carpool 3x\nthis week",
    // alpha/3
    "No motorcycle 3x\nthis week",
    // alpha/7
    "Choose to walk\nmore for 7 days"
)

// Food footprint logger challenges
val foodLoggerChallenges = listOf(
    // alpha/3
    "Less beef 3x\nthis week",
    // alpha/5
    "No processed or\njunkfood for 5 days",
    // alpha/7
    "At least 1 veggie\nmeal for 7 days"
)

// Waste footprint logger challenges
val wasteLoggerChallenges = listOf(
    // alpha/3
    "Recyle waste 3x\nthis week",
    // alpha/5
    "Avoid plastic\npackaging for 5 days",
    // alpha/7
    "No spoiled or\nleftovers for 7 days"
)

// Water footprint challenges progress counter
val waterLoggerChallengesCounter = mapOf(
    "Reuse greywater 1x\nthis week" to 1,
    "Less than 20 mins\nshower for 5 days" to 5,
    "Turn off unused\nfaucet for 7 days" to 7
)

// Energy footprint challenges progress counter
val energyLoggerChallengesCounter = mapOf(
    "Less ventilation 1x\n this week" to 1,
    "Choose natural\nlight for 5 days" to 5,
    "Unplug unused\ndevices for 7 days" to 7
)

// Transpo footprint challenges progress counter
val transpoLoggerChallengesCounter = mapOf(
    "No carpool 3x\nthis week" to 3,
    "No motorcycle 3x\nthis week" to 3,
    "Choose to walk\nmore for 7 days" to 7
)

// Food footprint challenges progress counter
val foodLoggerChallengesCounter = mapOf(
    "Less beef 3x\nthis week" to 3,
    "No processed or\njunkfood for 5 days" to 5,
    "At least 1 veggie\nmeal for 7 days" to 7
)

// Waste footprint challenges progress counter
val wasteLoggerChallengesCounter = mapOf(
    "Recyle waste 3x\nthis week" to 3,
    "Avoid plastic\npackaging for 5 days" to 5,
    "No spoiled or\nleftovers for 7 days" to 7
)

fun userWaterChallengesCounter(dailiesProgress: DailiesProgress, challengesProgress: ChallengesProgress) {
    if (dailiesProgress.waterDailies.d1.t2) {
        getWaterChallengeProperty(dailiesProgress.waterDailies.d1.t1)
    } else { resetWaterChallengeProperty(dailiesProgress.waterDailies.d1.t1) }

    if (dailiesProgress.waterDailies.d2.t2) {
        getWaterChallengeProperty(dailiesProgress.waterDailies.d2.t1)
    } else { resetWaterChallengeProperty(dailiesProgress.waterDailies.d2.t1) }

    if (dailiesProgress.waterDailies.d3.t2) {
        getWaterChallengeProperty(dailiesProgress.waterDailies.d3.t1)
    } else { resetWaterChallengeProperty(dailiesProgress.waterDailies.d3.t1) }
}

fun userEnergyChallengesCounter(dailiesProgress: DailiesProgress, challengesProgress: ChallengesProgress) {
    if (dailiesProgress.energyDailies.d1.t2) {
        getEnergyChallengeProperty(dailiesProgress.energyDailies.d1.t1)
    } else { resetEnergyChallengeProperty(dailiesProgress.energyDailies.d1.t1) }

    if (dailiesProgress.energyDailies.d2.t2) {
        getEnergyChallengeProperty(dailiesProgress.energyDailies.d2.t1)
    } else { resetEnergyChallengeProperty(dailiesProgress.energyDailies.d2.t1) }

    if (dailiesProgress.energyDailies.d3.t2) {
        getEnergyChallengeProperty(dailiesProgress.energyDailies.d3.t1)
    } else { resetEnergyChallengeProperty(dailiesProgress.energyDailies.d3.t1) }
}

fun userTranspoChallengesCounter(dailiesProgress: DailiesProgress, challengesProgress: ChallengesProgress) {
    if (dailiesProgress.transpoDailies.d1.t2) {
        getTranspoChallengeProperty(dailiesProgress.transpoDailies.d1.t1)
    } else { resetTranspoChallengeProperty(dailiesProgress.transpoDailies.d1.t1) }

    if (dailiesProgress.transpoDailies.d2.t2) {
        getTranspoChallengeProperty(dailiesProgress.transpoDailies.d2.t1)
    } else { resetTranspoChallengeProperty(dailiesProgress.transpoDailies.d2.t1) }

    if (dailiesProgress.transpoDailies.d3.t2) {
        getTranspoChallengeProperty(dailiesProgress.transpoDailies.d3.t1)
    } else { resetTranspoChallengeProperty(dailiesProgress.transpoDailies.d3.t1) }
}

fun userFoodChallengesCounter(dailiesProgress: DailiesProgress, challengesProgress: ChallengesProgress) {
    if (dailiesProgress.foodDailies.d1.t2) {
        getFoodChallengeProperty(dailiesProgress.foodDailies.d1.t1)
    } else { resetFoodChallengeProperty(dailiesProgress.foodDailies.d1.t1) }

    if (dailiesProgress.foodDailies.d2.t2) {
        getFoodChallengeProperty(dailiesProgress.foodDailies.d2.t1)
    } else { resetFoodChallengeProperty(dailiesProgress.foodDailies.d2.t1) }

    if (dailiesProgress.foodDailies.d3.t2) {
        getFoodChallengeProperty(dailiesProgress.foodDailies.d3.t1)
    } else { resetFoodChallengeProperty(dailiesProgress.foodDailies.d3.t1) }
}

fun userWasteChallengesCounter(dailiesProgress: DailiesProgress, challengesProgress: ChallengesProgress) {
    if (dailiesProgress.wasteDailies.d1.t2) {
        getWasteChallengeProperty(dailiesProgress.wasteDailies.d1.t1)
    } else { resetWasteChallengeProperty(dailiesProgress.wasteDailies.d1.t1) }

    if (dailiesProgress.wasteDailies.d2.t2) {
        getWasteChallengeProperty(dailiesProgress.wasteDailies.d2.t1)
    } else { resetWasteChallengeProperty(dailiesProgress.wasteDailies.d2.t1) }

    if (dailiesProgress.wasteDailies.d3.t2) {
        getWasteChallengeProperty(dailiesProgress.wasteDailies.d3.t1)
    } else { resetWasteChallengeProperty(dailiesProgress.wasteDailies.d3.t1) }
}

// Auxiliary functions for mapping daily targets to challenges
fun getWaterChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> userChallengesProgress.waterChallenges.c1.done += 1
        "c2" -> userChallengesProgress.waterChallenges.c2.done += 1
        "c3" -> userChallengesProgress.waterChallenges.c3.done += 1
        else -> userChallengesProgress.waterChallenges.c1.done += 0
    }
}
fun resetWaterChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> if (userChallengesProgress.waterChallenges.c1.done != 0) {
            userChallengesProgress.waterChallenges.c1.done -= 1
        }
        "c2" -> if (userChallengesProgress.waterChallenges.c2.done != 0) {
            userChallengesProgress.waterChallenges.c2.done -= 1
        }
        "c3" -> if (userChallengesProgress.waterChallenges.c3.done != 0) {
            userChallengesProgress.waterChallenges.c3.done -= 1
        }
        else -> userChallengesProgress.waterChallenges.c1.done += 0
    }
}

fun getEnergyChallengeProperty(challengeProperty: String) {
    return when (challengeProperty) {
        "c1" -> userChallengesProgress.energyChallenges.c1.done += 1
        "c2" -> userChallengesProgress.energyChallenges.c2.done += 1
        "c3" -> userChallengesProgress.energyChallenges.c3.done += 1
        else -> userChallengesProgress.energyChallenges.c1.done += 0
    }
}
fun resetEnergyChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> if (userChallengesProgress.energyChallenges.c1.done != 0) {
            userChallengesProgress.energyChallenges.c1.done -= 1
        }
        "c2" -> if (userChallengesProgress.energyChallenges.c2.done != 0) {
            userChallengesProgress.energyChallenges.c2.done -= 1
        }
        "c3" -> if (userChallengesProgress.energyChallenges.c3.done != 0) {
            userChallengesProgress.energyChallenges.c3.done -= 1
        }
        else -> userChallengesProgress.energyChallenges.c1.done += 0
    }
}

fun getTranspoChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> userChallengesProgress.transpoChallenges.c1.done += 1
        "c2" -> userChallengesProgress.transpoChallenges.c2.done += 1
        "c3" -> userChallengesProgress.transpoChallenges.c3.done += 1
        else -> userChallengesProgress.transpoChallenges.c1.done += 0
    }
}
fun resetTranspoChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> if (userChallengesProgress.transpoChallenges.c1.done != 0) {
            userChallengesProgress.transpoChallenges.c1.done -= 1
        }
        "c2" -> if (userChallengesProgress.transpoChallenges.c2.done != 0) {
            userChallengesProgress.transpoChallenges.c2.done -= 1
        }
        "c3" -> if (userChallengesProgress.transpoChallenges.c3.done != 0) {
            userChallengesProgress.transpoChallenges.c3.done -= 1
        }
        else -> userChallengesProgress.transpoChallenges.c1.done += 0
    }
}

fun getFoodChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> userChallengesProgress.foodChallenges.c1.done += 1
        "c2" -> userChallengesProgress.foodChallenges.c2.done += 1
        "c3" -> userChallengesProgress.foodChallenges.c3.done += 1
        else -> userChallengesProgress.foodChallenges.c1.done += 0
    }
}
fun resetFoodChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> if (userChallengesProgress.foodChallenges.c1.done != 0) {
            userChallengesProgress.foodChallenges.c1.done -= 1
        }
        "c2" -> if (userChallengesProgress.foodChallenges.c2.done != 0) {
            userChallengesProgress.foodChallenges.c2.done -= 1
        }
        "c3" -> if (userChallengesProgress.foodChallenges.c3.done != 0) {
            userChallengesProgress.foodChallenges.c3.done -= 1
        }
        else -> userChallengesProgress.foodChallenges.c1.done += 0
    }
}

fun getWasteChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> userChallengesProgress.wasteChallenges.c1.done += 1
        "c2" -> userChallengesProgress.wasteChallenges.c2.done += 1
        "c3" -> userChallengesProgress.wasteChallenges.c3.done += 1
        else -> userChallengesProgress.wasteChallenges.c1.done += 0
    }
}
fun resetWasteChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" -> if (userChallengesProgress.wasteChallenges.c1.done != 0) {
            userChallengesProgress.wasteChallenges.c1.done -= 1
        }
        "c2" -> if (userChallengesProgress.wasteChallenges.c2.done != 0) {
            userChallengesProgress.wasteChallenges.c2.done -= 1
        }
        "c3" -> if (userChallengesProgress.wasteChallenges.c3.done != 0) {
            userChallengesProgress.wasteChallenges.c3.done -= 1
        }
        else -> userChallengesProgress.wasteChallenges.c1.done += 0
    }
}

// Auxiliary function for updating challenge counters
fun waterChallengesCounter() {
    if (
        userChallengesProgress.waterChallenges.c1.alpha ==
        userChallengesProgress.waterChallenges.c1.done
        ) {
        waterChallengesDone += 1
    }

    if (
        userChallengesProgress.waterChallenges.c2.alpha ==
        userChallengesProgress.waterChallenges.c2.done
    ) {
        waterChallengesDone += 1
    }

    if (
        userChallengesProgress.waterChallenges.c2.alpha ==
        userChallengesProgress.waterChallenges.c2.done
    ) {
        waterChallengesDone += 1
    }
}

fun energyChallengesCounter() {
    if (
        userChallengesProgress.energyChallenges.c1.alpha ==
        userChallengesProgress.energyChallenges.c1.done
    ) {
        energyChallengesDone += 1
    }

    if (
        userChallengesProgress.energyChallenges.c2.alpha ==
        userChallengesProgress.energyChallenges.c2.done
    ) {
        energyChallengesDone += 1
    }

    if (
        userChallengesProgress.energyChallenges.c3.alpha ==
        userChallengesProgress.energyChallenges.c3.done
    ) {
        energyChallengesDone += 1
    }
}

fun transpoChallengesCounter() {
    if (
        userChallengesProgress.transpoChallenges.c1.alpha ==
        userChallengesProgress.transpoChallenges.c1.done
    ) {
        transpoChallengesDone += 1
    }

    if (
        userChallengesProgress.transpoChallenges.c2.alpha ==
        userChallengesProgress.transpoChallenges.c2.done
    ) {
        transpoChallengesDone += 1
    }

    if (
        userChallengesProgress.transpoChallenges.c3.alpha ==
        userChallengesProgress.transpoChallenges.c3.done
    ) {
        transpoChallengesDone += 1
    }
}

fun foodChallengesCounter() {
    if (
        userChallengesProgress.foodChallenges.c1.alpha ==
        userChallengesProgress.foodChallenges.c1.done
    ) {
        foodChallengesDone += 1
    }

    if (
        userChallengesProgress.foodChallenges.c2.alpha ==
        userChallengesProgress.foodChallenges.c2.done
    ) {
        foodChallengesDone += 1
    }

    if (
        userChallengesProgress.foodChallenges.c3.alpha ==
        userChallengesProgress.foodChallenges.c3.done
    ) {
        foodChallengesDone += 1
    }
}

fun wasteChallengesCounter() {
    if (
        userChallengesProgress.wasteChallenges.c1.alpha ==
        userChallengesProgress.wasteChallenges.c1.done
    ) {
        wasteChallengesDone += 1
    }

    if (
        userChallengesProgress.wasteChallenges.c2.alpha ==
        userChallengesProgress.wasteChallenges.c2.done
    ) {
        wasteChallengesDone += 1
    }

    if (
        userChallengesProgress.wasteChallenges.c3.alpha ==
        userChallengesProgress.wasteChallenges.c3.done
    ) {
        wasteChallengesDone += 1
    }
}
