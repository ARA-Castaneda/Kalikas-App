package com.example.kalikasapp.ui.theme.navigation.benchmark_screens

// list of water benchmark questions
val waterBenchmarks = listOf(
    // questions for ScreenA
    "How many people\nin your household?",
    "How long do you\ntake a shower?",
    "How long do you\nleave your sink\nrunning each day" +
            "\n(while brushing\nor shaving)?",
    "Do you flush for\neach toilet use?",
    // questions for ScreenB
    "How often do you\nwash your dishes?",
    "How do you wash\nyour dishes?",
    "How many loads of\ndishes per wash?\n(1 load is around" +
            "\n12 plates, cutlery,\nbowls, etc.)",
    // question/s for ScreenC
    "How often do you\ndo laundry?",
    "How do you do\nyour laundry?",
    "How many loads of\nclothes per wash?\n(1 load is around" +
            "\n15 shirts, shorts,\nand socks)"
)
// options for each water benchmark
// waterOpts1 requires counter button
val waterOpts2 = listOf(
    "under 5 mins",
    "5-10 mins",
    "11-30 mins",
    "over 30 mins"
)
val waterOpts3 = listOf(
    "under 5 mins",
    "5-10 mins",
    "11-15 mins",
    "over 15 mins"
)
val waterOpts4 = listOf(
    "always",
    "sometimes"
)
val waterOpts5 = listOf(
    "everyday",
    "every other day",
    "every week"
)
val waterOpts6 = listOf(
    "dishwasher",
    "handwash"
)
val waterOpts7 = listOf(
    "1 load",
    "2 loads",
    "3 loads",
    "4 loads",
    "more than 4 loads"
)
val waterOpts8 = listOf(
    "every other day",
    "every week",
    "every 2 weeks",
    "every 3 weeks",
    "every month"
)
val waterOpts9 = listOf(
    "own washing machine",
    "laundromat service"
)
val waterOpts10 = listOf(
    "1 load",
    "2 loads",
    "3 loads",
    "4 loads",
    "more than 4 loads"
)

// list of energy benchmark questions
val energyBenchmarks = listOf(
    // questions for ScreenA
    "TV set",
    "Desktop or\nComputer",
    "Laptop",
    "Smartphone",
    "Tablet",
    // questions for ScreenB
    "Electric Fan",
    "Airconditioner",
    "Lightbulbs or\nLamps",
    // questions for ScreenC,
    "Refrigerator",
    "Microwave\nOven",
    "Electric Stove",
    "Oven Toaster",
    "Rice Cooker",
    // questions for ScreenD,
    "Water Dispenser",
    "Water Kettle",
    "Washing Machine",
    "Laundry Dryer"
)
// options for each water benchmark
// energyOpts all require counter buttons

// list of transpo benchmark questions
val transpoBenchmarks = listOf(
    // questions for ScreenA
    "Car (Grab,\ninDrive, etc.)",
    "Motorcycle (Angkas,\nJoyRide, etc.)",
    "Jeepney",
    "Train",
    // questions for Screen B
    "Bus",
    "Point-to-Point\n(PUV)",
    "Tricycle"
)
// options for each transpo benchmark
val transpoOpts = listOf(
    "mode not used",
    "less than 30 mins",
    "30 mins to 1 hour",
    "1 hour to 2 hours",
    "2 hours to 3 hours",
    "more than 3 hours"
)

// list of food benchmark questions
val foodBenchmarks = listOf(
    // questions for ScreenA
    "Beef",
    "Chicken",
    "Pork",
    "Fish and\nSeafood",
    // questions for ScreenB
    "Eggs",
    "Milk",
    "Cheese",
    "Packed Goods\nor Junk Foods",
    // questions for ScreenC
    "Rice",
    "Fruits",
    "Vegetables",
    "Wheats and\nGrains"
)
// options for each food benchmark
val foodOpts = listOf(
    "never",
    "every other week",
    "once a week",
    "2-3x per week",
    "4-6x per week",
    "everyday",
    "2-3x per day",
    "more than 3x a day"
)

// list of waste benchmark questions
val wasteBenchmarks = listOf(
    // questions for ScreenA
    "How much organic\nwaste does your\nhousehold throw\naway per week\n" +
            "(food leftovers,\ngarden waste, etc.)?",
    "How much of\norganic waste\ndo you use in\ncompost pits?",
    // questions for ScreenB
    "How much paper\nwaste does your\nhousehold throw\naway per week\n" +
            "(newspaper, receipts,\npaper wraps, etc.)?",
    "How much of\npaper waste\ndo you recycle?",
    // questions for ScreenC
    "How much plastic\nwaste does your\nhousehold throw\naway per week\n" +
            "(plastic bottles,\npackaging, etc.)?",
    "How much of\nplastic waste\ndo you recycle?",
    // questions for ScreenD
    "How much other\nnon-biodegradable\nwaste does your\nhousehold throw\naway per week\n" +
            "(e-waste, rubber,\naluminum cans,\nglass, etc.)?",
    "How much of\nnon-bio waste\ndo you recycle?"
)
// options for each waste benchmark
val wasteWeightOpts = listOf(
    "less than 1 kg",
    "almost 1 kg",
    "1-2 kg",
    "2-3 kg",
    "3-5 kg",
    "more than 5 kg"
)
val wasteRecycledOpts = listOf(
    "none",
    "less than half",
    "half",
    "almost all",
    "all"
)

// controllers for default water footprint
fun waterBenchQ1(count: Int) {
    benchmarkWaterFootprint.household = count
}
fun waterBenchQ2(selected: String) {
    benchmarkWaterFootprint.showerDuration = selected
}
fun waterBenchQ3(selected: String) {
    benchmarkWaterFootprint.sinkDuration = selected
}
fun waterBenchQ4(selected: String) {
    benchmarkWaterFootprint.toiletUsage = selected
}
fun waterBenchQ5(selected: String) {
    benchmarkWaterFootprint.dishesContrib.t1 = selected
}
fun waterBenchQ6(selected: String) {
    benchmarkWaterFootprint.dishesContrib.t2 = selected
}
fun waterBenchQ7(selected: String) {
    benchmarkWaterFootprint.dishesContrib.t3 = selected
}
fun waterBenchQ8(selected: String) {
    benchmarkWaterFootprint.laundryContrib.t1 = selected
}
fun waterBenchQ9(selected: String) {
    if (selected == "own washing machine") {
        benchmarkWaterFootprint.laundryContrib.t2 = "own"
    } else {
        benchmarkWaterFootprint.laundryContrib.t2 = "laundromat"
    }
}
fun waterBenchQ10(selected: String) {
    benchmarkWaterFootprint.laundryContrib.t3 = selected
}

// controllers for default energy footprint
fun energyBenchQ1(count: Int) {
    benchmarkEnergyFootprint.tvsetCountUnplugged.t1 = count
}
fun energyBenchQ2(count: Int) {
    benchmarkEnergyFootprint.desktopCountUnplugged.t1 = count
}
fun energyBenchQ3(count: Int) {
    benchmarkEnergyFootprint.laptopCountUnplugged.t1 = count
}
fun energyBenchQ4(count: Int) {
    benchmarkEnergyFootprint.smartphoneCountUnplugged.t1 = count
}
fun energyBenchQ5(count: Int) {
    benchmarkEnergyFootprint.tabletCountUnplugged.t1 = count
}
fun energyBenchQ6(count: Int) {
    benchmarkEnergyFootprint.electricfanCountUnplugged.t1 = count
}
fun energyBenchQ7(count: Int) {
    benchmarkEnergyFootprint.airconCountUnplugged.t1 = count
}
fun energyBenchQ8(count: Int) {
    benchmarkEnergyFootprint.lightbulbCountUnplugged.t1 = count
}
fun energyBenchQ9(count: Int) {
    benchmarkEnergyFootprint.refrigeratorCountUnplugged.t1 = count
}
fun energyBenchQ10(count: Int) {
    benchmarkEnergyFootprint.microwaveCountUnplugged.t1 = count
}
fun energyBenchQ11(count: Int) {
    benchmarkEnergyFootprint.stoveCountUnplugged.t1 = count
}
fun energyBenchQ12(count: Int) {
    benchmarkEnergyFootprint.toasterCountUnplugged.t1 = count
}
fun energyBenchQ13(count: Int) {
    benchmarkEnergyFootprint.ricecookerCountUnplugged.t1 = count
}
fun energyBenchQ14(count: Int) {
    benchmarkEnergyFootprint.dispenserCountUnplugged.t1 = count
}
fun energyBenchQ15(count: Int) {
    benchmarkEnergyFootprint.kettleCountUnplugged.t1 = count
}
fun energyBenchQ16(count: Int) {
    benchmarkEnergyFootprint.washingmachineCountUnplugged.t1 = count
}
fun energyBenchQ17(count: Int) {
    benchmarkEnergyFootprint.dryerCountUnplugged.t1 = count
}

// controllers for default transpo footprint
fun transpoBenchQ1(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.carDuration = newSelected
}
fun transpoBenchQ2(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.motorcycleDuration = newSelected
}
fun transpoBenchQ3(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.jeepneyDuration = newSelected
}
fun transpoBenchQ4(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.trainDuration = newSelected
}
fun transpoBenchQ5(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.busDuration = newSelected
}
fun transpoBenchQ6(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.puvDuration = newSelected
}
fun transpoBenchQ7(selected: String) {
    var newSelected = ""

    newSelected = when (selected) {
        "mode not used" -> "0 mins"
        "less than 30 mins" -> "30 mins"
        "30 mins to 1 hour" -> "60 mins"
        "1 hour to 2 hours" -> "90 mins"
        "2 hours to 3 hours" -> "150 mins"
        "more than 3 hours" -> "200 mins"
        else -> "0 mins"
    }

    benchmarkTranspoFootprint.tricycleDuration = newSelected
}

// controllers for default food footprint
fun foodBenchQ1(selected: String) {
    benchmarkFoodFootprint.beefServings = selected
}
fun foodBenchQ2(selected: String) {
    benchmarkFoodFootprint.chickenServings = selected
}
fun foodBenchQ3(selected: String) {
    benchmarkFoodFootprint.porkServings = selected
}
fun foodBenchQ4(selected: String) {
    benchmarkFoodFootprint.seafoodServings = selected
}
fun foodBenchQ5(selected: String) {
    benchmarkFoodFootprint.eggServings = selected
}
fun foodBenchQ6(selected: String) {
    benchmarkFoodFootprint.milkServings = selected
}
fun foodBenchQ7(selected: String) {
    benchmarkFoodFootprint.cheeseServings = selected
}
fun foodBenchQ8(selected: String) {
    benchmarkFoodFootprint.processedServings = selected
}
fun foodBenchQ9(selected: String) {
    benchmarkFoodFootprint.riceServings = selected
}
fun foodBenchQ10(selected: String) {
    benchmarkFoodFootprint.fruitServings = selected
}
fun foodBenchQ11(selected: String) {
    benchmarkFoodFootprint.vegetableServings = selected
}
fun foodBenchQ12(selected: String) {
    benchmarkFoodFootprint.wheatServings = selected
}

// controllers for default waste footprint
fun wasteBenchQ1(selected: String) {
    benchmarkWasteFootprint.organicWeight = selected
}
fun wasteBenchQ2(selected: String) {
    benchmarkWasteFootprint.recycledOrganic = selected
}
fun wasteBenchQ3(selected: String) {
    benchmarkWasteFootprint.paperWeight = selected
}
fun wasteBenchQ4(selected: String) {
    benchmarkWasteFootprint.recycledPaper = selected
}
fun wasteBenchQ5(selected: String) {
    benchmarkWasteFootprint.plasticWeight = selected
}
fun wasteBenchQ6(selected: String) {
    benchmarkWasteFootprint.recycledPlastic = selected
}
fun wasteBenchQ7(selected: String) {
    benchmarkWasteFootprint.nonbioWeight = selected
}
fun wasteBenchQ8(selected: String) {
    benchmarkWasteFootprint.recycledNonBio = selected
}
