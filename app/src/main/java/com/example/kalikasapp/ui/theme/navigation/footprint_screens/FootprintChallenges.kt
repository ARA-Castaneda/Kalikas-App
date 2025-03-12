package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userChallengesProgress
import com.example.kalikasapp.ui.theme.navigation.landing_screens.userDailiesProgress

class ChallengesDone {
    var waterChallengesDone by mutableIntStateOf(0)
    var energyChallengesDone by mutableIntStateOf(0)
    var transpoChallengesDone by mutableIntStateOf(0)
    var foodChallengesDone by mutableIntStateOf(0)
    var wasteChallengesDone by mutableIntStateOf(0)
}
var userChallengesDone = ChallengesDone()

// user badges tracker data class
class BadgesDone {
    var waterBadgesDone by mutableStateOf(BadgesTriple(b1 = false, b2 = false, b3 = false))
    var energyBadgesDone by mutableStateOf(BadgesTriple(b1 = false, b2 = false, b3 = false))
    var transpoBadgesDone by mutableStateOf(BadgesTriple(b1 = false, b2 = false, b3 = false))
    var foodBadgesDone by mutableStateOf(BadgesTriple(b1 = false, b2 = false, b3 = false))
    var wasteBadgesDone by mutableStateOf(BadgesTriple(b1 = false, b2 = false, b3 = false))
}
var userBadgesDone = BadgesDone()

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

// Auxiliary functions for reflecting dailies changes to challenges
fun userWaterChallengesCounter(dailyTuple: DailyTuple) {
    when (dailyTuple) {
        userDailiesProgress.waterDailies.d1 ->
            if (dailyTuple.t2) {
                getWaterChallengeProperty(dailyTuple.t1)
            } else {
                resetWaterChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.waterDailies.d2 ->
            if (dailyTuple.t2) {
                getWaterChallengeProperty(dailyTuple.t1)
            } else {
                resetWaterChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.waterDailies.d3 ->
            if (dailyTuple.t2) {
                getWaterChallengeProperty(dailyTuple.t1)
            } else {
                resetWaterChallengeProperty(dailyTuple.t1)
            }

        else -> userChallengesDone.waterChallengesDone += 0
    }
}

fun userEnergyChallengesCounter(dailyTuple: DailyTuple) {
    when (dailyTuple) {
        userDailiesProgress.energyDailies.d1 ->
            if (dailyTuple.t2) {
                getEnergyChallengeProperty(dailyTuple.t1)
            } else {
                resetEnergyChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.energyDailies.d2 ->
            if (dailyTuple.t2) {
                getEnergyChallengeProperty(dailyTuple.t1)
            } else {
                resetEnergyChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.energyDailies.d3 ->
            if (dailyTuple.t2) {
                getEnergyChallengeProperty(dailyTuple.t1)
            } else {
                resetEnergyChallengeProperty(dailyTuple.t1)
            }

        else -> userChallengesDone.energyChallengesDone += 0
    }
}

fun userTranspoChallengesCounter(dailyTuple: DailyTuple) {
    when (dailyTuple) {
        userDailiesProgress.transpoDailies.d1 ->
            if (dailyTuple.t2) {
                getTranspoChallengeProperty(dailyTuple.t1)
            } else {
                resetTranspoChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.transpoDailies.d2 ->
            if (dailyTuple.t2) {
                getTranspoChallengeProperty(dailyTuple.t1)
            } else {
                resetTranspoChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.transpoDailies.d3 ->
            if (dailyTuple.t2) {
                getTranspoChallengeProperty(dailyTuple.t1)
            } else {
                resetTranspoChallengeProperty(dailyTuple.t1)
            }

        else -> userChallengesDone.transpoChallengesDone += 0
    }
}

fun userFoodChallengesCounter(dailyTuple: DailyTuple) {
    when (dailyTuple) {
        userDailiesProgress.foodDailies.d1 ->
            if (dailyTuple.t2) {
                getFoodChallengeProperty(dailyTuple.t1)
            } else {
                resetFoodChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.foodDailies.d2 ->
            if (dailyTuple.t2) {
                getFoodChallengeProperty(dailyTuple.t1)
            } else {
                resetFoodChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.foodDailies.d3 ->
            if (dailyTuple.t2) {
                getFoodChallengeProperty(dailyTuple.t1)
            } else {
                resetFoodChallengeProperty(dailyTuple.t1)
            }

        else -> userChallengesDone.foodChallengesDone += 0
    }
}

fun userWasteChallengesCounter(dailyTuple: DailyTuple) {
    when (dailyTuple) {
        userDailiesProgress.wasteDailies.d1 ->
            if (dailyTuple.t2) {
                getWasteChallengeProperty(dailyTuple.t1)
            } else {
                resetWasteChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.wasteDailies.d2 ->
            if (dailyTuple.t2) {
                getWasteChallengeProperty(dailyTuple.t1)
            } else {
                resetWasteChallengeProperty(dailyTuple.t1)
            }

        userDailiesProgress.wasteDailies.d3 ->
            if (dailyTuple.t2) {
                getWasteChallengeProperty(dailyTuple.t1)
            } else {
                resetWasteChallengeProperty(dailyTuple.t1)
            }

        else -> userChallengesDone.wasteChallengesDone += 0
    }
}

// Auxiliary functions for mapping daily targets to challenges
fun getWaterChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.waterChallenges.c1.done <
                userChallengesProgress.waterChallenges.c1.alpha
                ) {
                userChallengesProgress.waterChallenges.c1.done += 1
            }

        "c2" ->
            if (userChallengesProgress.waterChallenges.c2.done <
                userChallengesProgress.waterChallenges.c2.alpha
            ) {
                userChallengesProgress.waterChallenges.c2.done += 1
            }

        "c3" ->
            if (userChallengesProgress.waterChallenges.c3.done <
                userChallengesProgress.waterChallenges.c3.alpha
            ) {
                userChallengesProgress.waterChallenges.c3.done += 1
            }

        else ->
            userChallengesDone.waterChallengesDone += 0
    }
}
fun resetWaterChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.waterChallenges.c1.done != 0) {
                userChallengesProgress.waterChallenges.c1.done -= 1
            }

        "c2" ->
            if (userChallengesProgress.waterChallenges.c2.done != 0) {
                userChallengesProgress.waterChallenges.c2.done -= 1
            }

        "c3" ->
            if (userChallengesProgress.waterChallenges.c3.done != 0) {
                userChallengesProgress.waterChallenges.c3.done -= 1
            }

        else -> userChallengesDone.waterChallengesDone += 0
    }
}

fun getEnergyChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.energyChallenges.c1.done <
                userChallengesProgress.energyChallenges.c1.alpha
            ) {
                userChallengesProgress.energyChallenges.c1.done += 1
            }

        "c2" ->
            if (userChallengesProgress.energyChallenges.c2.done <
                userChallengesProgress.energyChallenges.c2.alpha
            ) {
                userChallengesProgress.energyChallenges.c2.done += 1
            }

        "c3" ->
            if (userChallengesProgress.energyChallenges.c3.done <
                userChallengesProgress.energyChallenges.c3.alpha
            ) {
                userChallengesProgress.energyChallenges.c3.done += 1
            }

        else ->
            userChallengesDone.energyChallengesDone += 0
    }
}
fun resetEnergyChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.energyChallenges.c1.done != 0) {
                userChallengesProgress.energyChallenges.c1.done -= 1
            }

        "c2" ->
            if (userChallengesProgress.energyChallenges.c2.done != 0) {
                userChallengesProgress.energyChallenges.c2.done -= 1
            }

        "c3" ->
            if (userChallengesProgress.energyChallenges.c3.done != 0) {
                userChallengesProgress.energyChallenges.c3.done -= 1
            }

        else -> userChallengesDone.energyChallengesDone += 0
    }
}

fun getTranspoChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.transpoChallenges.c1.done <
                userChallengesProgress.transpoChallenges.c1.alpha
            ) {
                userChallengesProgress.transpoChallenges.c1.done += 1
            }

        "c2" ->
            if (userChallengesProgress.transpoChallenges.c2.done <
                userChallengesProgress.transpoChallenges.c2.alpha
            ) {
                userChallengesProgress.transpoChallenges.c2.done += 1
            }

        "c3" ->
            if (userChallengesProgress.transpoChallenges.c3.done <
                userChallengesProgress.transpoChallenges.c3.alpha
            ) {
                userChallengesProgress.transpoChallenges.c3.done += 1
            }

        else ->
            userChallengesDone.transpoChallengesDone += 0
    }
}
fun resetTranspoChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.transpoChallenges.c1.done != 0) {
                userChallengesProgress.transpoChallenges.c1.done -= 1
            }

        "c2" ->
            if (userChallengesProgress.transpoChallenges.c2.done != 0) {
                userChallengesProgress.transpoChallenges.c2.done -= 1
            }

        "c3" ->
            if (userChallengesProgress.transpoChallenges.c3.done != 0) {
                userChallengesProgress.transpoChallenges.c3.done -= 1
            }

        else -> userChallengesDone.transpoChallengesDone += 0
    }
}

fun getFoodChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.foodChallenges.c1.done <
                userChallengesProgress.foodChallenges.c1.alpha
            ) {
                userChallengesProgress.foodChallenges.c1.done += 1
            }

        "c2" ->
            if (userChallengesProgress.foodChallenges.c2.done <
                userChallengesProgress.foodChallenges.c2.alpha
            ) {
                userChallengesProgress.foodChallenges.c2.done += 1
            }

        "c3" ->
            if (userChallengesProgress.foodChallenges.c3.done <
                userChallengesProgress.foodChallenges.c3.alpha
            ) {
                userChallengesProgress.foodChallenges.c3.done += 1
            }

        else ->
            userChallengesDone.foodChallengesDone += 0
    }
}
fun resetFoodChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.foodChallenges.c1.done != 0) {
                userChallengesProgress.foodChallenges.c1.done -= 1 }

        "c2" ->
            if (userChallengesProgress.foodChallenges.c2.done != 0) {
                userChallengesProgress.foodChallenges.c2.done -= 1
            }

        "c3" ->
            if (userChallengesProgress.foodChallenges.c3.done != 0) {
                userChallengesProgress.foodChallenges.c3.done -= 1
            }

        else -> userChallengesDone.foodChallengesDone += 0
    }
}

fun getWasteChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.wasteChallenges.c1.done <
                userChallengesProgress.wasteChallenges.c1.alpha
            ) {
                userChallengesProgress.wasteChallenges.c1.done += 1
            }

        "c2" ->
            if (userChallengesProgress.wasteChallenges.c2.done <
                userChallengesProgress.wasteChallenges.c2.alpha
            ) {
                userChallengesProgress.wasteChallenges.c2.done += 1
            }

        "c3" ->
            if (userChallengesProgress.wasteChallenges.c3.done <
                userChallengesProgress.wasteChallenges.c3.alpha
            ) {
                userChallengesProgress.wasteChallenges.c3.done += 1
            }

        else ->
            userChallengesDone.wasteChallengesDone += 0
    }
}
fun resetWasteChallengeProperty(challengeProperty: String) {
    when (challengeProperty) {
        "c1" ->
            if (userChallengesProgress.wasteChallenges.c1.done != 0) {
                userChallengesProgress.wasteChallenges.c1.done -= 1
            }

        "c2" ->
            if (userChallengesProgress.wasteChallenges.c2.done != 0) {
                userChallengesProgress.wasteChallenges.c2.done -= 1
            }

        "c3" ->
            if (userChallengesProgress.wasteChallenges.c3.done != 0) {
                userChallengesProgress.wasteChallenges.c3.done -= 1
            }

        else -> userChallengesDone.wasteChallengesDone += 0
    }
}

// Auxiliary function for updating challenge counters
fun waterChallengesCounter() {
    if (
        (userChallengesProgress.waterChallenges.c1.alpha ==
        userChallengesProgress.waterChallenges.c1.done) &&
        userChallengesDone.waterChallengesDone < 3 &&
        !userBadgesDone.waterBadgesDone.b1
        ) {
        userChallengesDone.waterChallengesDone += 1
        userBadgesDone.waterBadgesDone.b1 = true
    }

    if (
        (userChallengesProgress.waterChallenges.c2.alpha ==
        userChallengesProgress.waterChallenges.c2.done) &&
        userChallengesDone.waterChallengesDone < 3 &&
        !userBadgesDone.waterBadgesDone.b2
    ) {
        userChallengesDone.waterChallengesDone += 1
        userBadgesDone.waterBadgesDone.b2 = true
    }

    if (
        (userChallengesProgress.waterChallenges.c2.alpha ==
        userChallengesProgress.waterChallenges.c2.done) &&
        userChallengesDone.waterChallengesDone < 3 &&
        !userBadgesDone.waterBadgesDone.b3
    ) {
        userChallengesDone.waterChallengesDone += 1
        userBadgesDone.waterBadgesDone.b3 = true
    }
}

fun energyChallengesCounter() {
    if (
        (userChallengesProgress.energyChallenges.c1.alpha ==
        userChallengesProgress.energyChallenges.c1.done) &&
        userChallengesDone.energyChallengesDone < 3 &&
        !userBadgesDone.energyBadgesDone.b1
    ) {
        userChallengesDone.energyChallengesDone += 1
        userBadgesDone.energyBadgesDone.b1 = true
    }

    if (
        (userChallengesProgress.energyChallenges.c2.alpha ==
        userChallengesProgress.energyChallenges.c2.done) &&
        userChallengesDone.energyChallengesDone < 3 &&
        !userBadgesDone.energyBadgesDone.b2
    ) {
        userChallengesDone.energyChallengesDone += 1
        userBadgesDone.energyBadgesDone.b2 = true
    }

    if (
        (userChallengesProgress.energyChallenges.c3.alpha ==
        userChallengesProgress.energyChallenges.c3.done) &&
        userChallengesDone.energyChallengesDone < 3 &&
        !userBadgesDone.energyBadgesDone.b3
    ) {
        userChallengesDone.energyChallengesDone += 1
        userBadgesDone.energyBadgesDone.b3 = true
    }
}

fun transpoChallengesCounter() {
    if (
        (userChallengesProgress.transpoChallenges.c1.alpha ==
        userChallengesProgress.transpoChallenges.c1.done) &&
        userChallengesDone.transpoChallengesDone < 3 &&
        !userBadgesDone.transpoBadgesDone.b1
    ) {
        userChallengesDone.transpoChallengesDone += 1
        userBadgesDone.transpoBadgesDone.b1 = true
    }

    if (
        (userChallengesProgress.transpoChallenges.c2.alpha ==
        userChallengesProgress.transpoChallenges.c2.done) &&
        userChallengesDone.transpoChallengesDone < 3 &&
        !userBadgesDone.transpoBadgesDone.b2
    ) {
        userChallengesDone.transpoChallengesDone += 1
        userBadgesDone.transpoBadgesDone.b2 = true
    }

    if (
        (userChallengesProgress.transpoChallenges.c3.alpha ==
        userChallengesProgress.transpoChallenges.c3.done) &&
        userChallengesDone.transpoChallengesDone < 3 &&
        !userBadgesDone.transpoBadgesDone.b3
    ) {
        userChallengesDone.transpoChallengesDone += 1
        userBadgesDone.transpoBadgesDone.b3 = true
    }
}

fun foodChallengesCounter() {
    if (
        (userChallengesProgress.foodChallenges.c1.alpha ==
        userChallengesProgress.foodChallenges.c1.done) &&
        userChallengesDone.foodChallengesDone < 3 &&
        !userBadgesDone.foodBadgesDone.b1
    ) {
        userChallengesDone.foodChallengesDone += 1
        userBadgesDone.foodBadgesDone.b1 = true
    }

    if (
        (userChallengesProgress.foodChallenges.c2.alpha ==
        userChallengesProgress.foodChallenges.c2.done) &&
        userChallengesDone.foodChallengesDone < 3 &&
        !userBadgesDone.foodBadgesDone.b2
    ) {
        userChallengesDone.foodChallengesDone += 1
        userBadgesDone.foodBadgesDone.b2 = true
    }

    if (
        (userChallengesProgress.foodChallenges.c3.alpha ==
        userChallengesProgress.foodChallenges.c3.done) &&
        userChallengesDone.foodChallengesDone < 3 &&
        !userBadgesDone.foodBadgesDone.b3
    ) {
        userChallengesDone.foodChallengesDone += 1
        userBadgesDone.foodBadgesDone.b3 = true
    }
}

fun wasteChallengesCounter() {
    if (
        (userChallengesProgress.wasteChallenges.c1.alpha ==
        userChallengesProgress.wasteChallenges.c1.done) &&
        userChallengesDone.wasteChallengesDone < 3 &&
        !userBadgesDone.wasteBadgesDone.b1
    ) {
        userChallengesDone.wasteChallengesDone += 1
        userBadgesDone.wasteBadgesDone.b1 = true
    }

    if (
        (userChallengesProgress.wasteChallenges.c2.alpha ==
        userChallengesProgress.wasteChallenges.c2.done) &&
        userChallengesDone.wasteChallengesDone < 3 &&
        !userBadgesDone.wasteBadgesDone.b2
    ) {
        userChallengesDone.wasteChallengesDone += 1
        userBadgesDone.wasteBadgesDone.b2 = true
    }

    if (
        (userChallengesProgress.wasteChallenges.c3.alpha ==
        userChallengesProgress.wasteChallenges.c3.done) &&
        userChallengesDone.wasteChallengesDone < 3 &&
        !userBadgesDone.wasteBadgesDone.b3
    ) {
        userChallengesDone.wasteChallengesDone += 1
        userBadgesDone.wasteBadgesDone.b3 = true
    }
}
