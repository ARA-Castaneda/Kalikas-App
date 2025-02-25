package com.example.kalikasapp.ui.theme.navigation.footprint_screens

import java.util.Locale

const val sequestrationRate = 4.000f
/*
baseline ~ 4.4 tonnes CO2 per hectare (ha) per year
divided by 1.1 (gha) equivalent of 1 tropical natural forests (ha)
*/

data class Triple(
    var t1: String,
    var t2: String,
    var t3: String
)

data class Tuple(
    var t1: Int,
    var t2: Boolean
)

data class EcoFootprint(
    var croplandGha: Float = 0.3f,
    var grazingGha: Float = 0.0f,
    var forestGha: Float = 0.1f,
    var aquaGha: Float = 0.2f,
    var builtlandGha: Float = 0.1f,
    var carbonGha: Float = 0.0f,

    var ecoGha: Float = 0.0f,
    var biocapacity: Float = 0.4f,
    var countriesNeeded: Float = 0.0f
)

data class CarbonFootprint(
    var water: Float = 0.000f,
    var energy: Float = 0.000f,
    var transpo: Float = 0.000f,
    var food: Float = 0.000f,
    var waste: Float = 0.000f,
    var total: Float = 0.000f
)

data class WaterFootprint(
    var household: Int = 1,

    var showerDuration: String = "11-30 mins",
    var sinkDuration: String = "under 5 mins",
    var toiletUsage: String = "always",

    var dishesContrib: Triple = Triple(
        "everyday", "handwash", "2 loads"
    ),

    var laundryContrib: Triple = Triple(
        "every week", "own", "4 loads"
    )
)

data class EnergyFootprint(
    var tvsetCountUnplugged: Tuple = Tuple(1, false),
    var desktopCountUnplugged: Tuple = Tuple(1, false),
    var laptopCountUnplugged: Tuple = Tuple(1, false),
    var smartphoneCountUnplugged: Tuple = Tuple(1, false),
    var tabletCountUnplugged: Tuple = Tuple(1, false),
    var electricfanCountUnplugged: Tuple = Tuple(1, false),
    var airconCountUnplugged: Tuple = Tuple(0, false),
    var lightbulbCountUnplugged: Tuple = Tuple(4, false),

    var refrigeratorCountUnplugged: Tuple = Tuple(0, true),
    var microwaveCountUnplugged: Tuple = Tuple(1, true),
    var stoveCountUnplugged: Tuple = Tuple(0, true),
    var toasterCountUnplugged: Tuple = Tuple(0, true),
    var ricecookerCountUnplugged: Tuple = Tuple(1, true),

    var dispenserCountUnplugged: Tuple = Tuple(0, true),
    var kettleCountUnplugged: Tuple = Tuple(1, true),
    var washingmachineCountUnplugged: Tuple = Tuple(0, true),
    var dryerCountUnplugged: Tuple = Tuple(0, true)
)

data class TranspoFootprint(
    var walkBicycle: Boolean = false,
    var carDuration: String = "60 mins",
    var jeepneyDuration: String = "30 mins",
    var busDuration: String = "30 mins",
    var trainDuration: String = "30 mins",
    var puvDuration: String = "0 mins",
    var motorcycleDuration: String = "60 mins",
    var tricycleDuration: String = "0 mins"
)

data class FoodFootprint(
    var beefServings: String = "2-3x per week",
    var chickenServings: String = "4-6x per week",
    var porkServings: String = "4-6x per week",
    var seafoodServings: String = "2-3x per week",
    var eggServings: String = "2-3x per week",
    var milkServings: String = "2-3x per week",
    var cheeseServings: String = "2-3x per week",

    var riceServings: String = "2-3x per day",
    var fruitServings: String = "everyday",
    var vegetableServings: String = "everyday",
    var wheatServings: String = "4-6x per week",

    var processedServings: String = "4-6x per week"
)

data class WasteFootprint(
    var organicWeight: String = "1-2 kg",
    var recycledOrganic: String = "none",

    var paperWeight: String = "less than 1 kg",
    var recycledPaper: String = "none",

    var plasticWeight: String = "less than 1 kg",
    var recycledPlastic: String = "none",

    var nonbioWeight: String = "less than 1 kg",
    var recycledNonBio: String = "none"
)

// Calculated per individual per year (gha)
fun userEcoFootprint(
    carbonComponent: CarbonFootprint
): EcoFootprint {
    var userEcoFootprint = EcoFootprint()

    // converted kgs to metric tonnes
    var carbonPerYear = (carbonComponent.total) * 12.000f
    carbonPerYear /= 1000.00f

    // converted metric tonnes of CO2 to global hectares (gha)
    userEcoFootprint.carbonGha = carbonPerYear / sequestrationRate

    // Total Ecological Footprint is sum of all gha components
    userEcoFootprint.ecoGha = userEcoFootprint.croplandGha + userEcoFootprint.grazingGha +
            userEcoFootprint.forestGha + userEcoFootprint.aquaGha +
            userEcoFootprint.builtlandGha + userEcoFootprint.carbonGha

    // Total Countries Needed to sustain lifestyle is EcologicalFootprint/Biocapacity
    userEcoFootprint.countriesNeeded = (userEcoFootprint.ecoGha) / (userEcoFootprint.biocapacity)

    // global hectares per year (individual)
    return userEcoFootprint
}

// Calculated per individual per month
fun userCarbonFootprint(
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

// Calculated per individual per month
fun userWaterEmission(
    userHousehold: Int,
    userWaterFootprint: WaterFootprint
): Float {
    var waterEmission: Float

    var showerLiters = showerDurationMap.getOrElse(key = userWaterFootprint.showerDuration) { 0.00f }
    var sinkLiters = sinkDurationMap.getOrElse(key = userWaterFootprint.sinkDuration) { 0.00f }
    var toiletLiters = toiletUsageMap.getOrElse(key = userWaterFootprint.toiletUsage) { 0.00f }

    var dishesCompositeLiters = dishesContribMap.getOrElse(key = userWaterFootprint.dishesContrib) { 0.00f }
    var dishesLiters = dishesCompositeLiters / userHousehold.toFloat()
    var laundryCompositeLiters = laundryContribMap.getOrElse(key = userWaterFootprint.laundryContrib) { 0.00f }
    var laundryLiters = laundryCompositeLiters / userHousehold.toFloat()

    var totalLiters = ((showerLiters + sinkLiters + toiletLiters + dishesLiters + laundryLiters) / 1000.00f)
    var litersEmission = totalLiters * 0.70f
    // Energy needed to supply 1 cubic meter 0.70 (in kWh)

    // Emission factor for kWh is 0.65
    waterEmission = litersEmission * 0.65f
    waterEmission = String.format(Locale.US, "%.3f", waterEmission).toFloat()

    // kgs CO2 water emission per month (individual)
    return waterEmission
}

// Calculated per household per month
fun userEnergyEmission(
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
            electricityContribMap.getOrElse(key = "electricfan") { 0.000f }
    var airconEmission = userEnergyFootprint.airconCountUnplugged.t1 *
            electricityContribMap.getOrElse(key = "aircon") { 0.000f }
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

// Calculated per individual per month
fun userTranspoEmission(
    userTranspoFootprint: TranspoFootprint
): Float {
    var transpoEmission: Float

    var carEmission = transpoContribMap.getOrElse(key = "car - " +
            userTranspoFootprint.carDuration) { 0.000f }
    var jeepneyEmission = transpoContribMap.getOrElse(key = "jeepney - " +
            userTranspoFootprint.jeepneyDuration) { 0.000f }
    var busEmission = transpoContribMap.getOrElse(key = "bus - " +
            userTranspoFootprint.busDuration) { 0.000f }
    var trainEmission = transpoContribMap.getOrElse(key = "train - " +
            userTranspoFootprint.trainDuration) { 0.000f }
    var puvEmission = transpoContribMap.getOrElse(key = "puv - " +
            userTranspoFootprint.puvDuration) { 0.000f }
    var motorcycleEmission = transpoContribMap.getOrElse(key = "motorcycle - " +
            userTranspoFootprint.motorcycleDuration) { 0.000f }
    var tricycleEmission = transpoContribMap.getOrElse(key = "tricycle - " +
            userTranspoFootprint.tricycleDuration) { 0.000f }

    transpoEmission = carEmission + jeepneyEmission + busEmission + trainEmission +
            puvEmission + motorcycleEmission + tricycleEmission
    transpoEmission = String.format(Locale.US, "%.3f", transpoEmission).toFloat()

    // kgs CO2 transportation emission per month (individual)
    return transpoEmission
}

// Calculated per individual per month
fun userFoodEmission(
    userFoodFootprint: FoodFootprint
): Float {
    var foodEmission: Float

    var beefEmission = foodContribMap.getOrElse(key = "beef - " +
            userFoodFootprint.beefServings) { 0.000f }
    var chickenEmission = foodContribMap.getOrElse(key = "chicken - " +
            userFoodFootprint.chickenServings) { 0.000f }
    var porkEmission = foodContribMap.getOrElse(key = "pork - " +
            userFoodFootprint.porkServings) { 0.000f }
    var seafoodEmission = foodContribMap.getOrElse(key = "seafood - " +
            userFoodFootprint.seafoodServings) { 0.000f }
    var eggEmission = foodContribMap.getOrElse(key = "egg - " +
            userFoodFootprint.eggServings) { 0.000f }
    var milkEmission = foodContribMap.getOrElse(key = "milk - " +
            userFoodFootprint.milkServings) { 0.000f }
    var cheeseEmission = foodContribMap.getOrElse(key = "cheese - " +
            userFoodFootprint.cheeseServings) { 0.000f }
    var riceEmission = foodContribMap.getOrElse(key = "rice - " +
            userFoodFootprint.riceServings) { 0.000f }
    var fruitEmission = foodContribMap.getOrElse(key = "fruit - " +
            userFoodFootprint.fruitServings) { 0.000f }
    var vegetableEmission = foodContribMap.getOrElse(key = "vegetable - " +
            userFoodFootprint.vegetableServings) { 0.000f }
    var wheatEmission = foodContribMap.getOrElse(key = "wheat - " +
            userFoodFootprint.wheatServings) { 0.000f }
    var processedEmission = foodContribMap.getOrElse(key = "processed - " +
            userFoodFootprint.processedServings) { 0.000f }

    foodEmission = (beefEmission + chickenEmission + porkEmission + seafoodEmission +
            eggEmission + milkEmission + cheeseEmission +
            riceEmission + fruitEmission + vegetableEmission + wheatEmission +
            processedEmission) * 4.0f
    foodEmission = String.format(Locale.US, "%.3f", foodEmission).toFloat()

    // kgs CO2 food emission per month (individual)
    return foodEmission
}

// Calculated per household per month
fun userWasteEmission(
    userWasteFootprint: WasteFootprint
): Float {
    var wasteEmission: Float

    var organicThrown = wasteWeightsMap.getOrElse(key = "organic - " +
            userWasteFootprint.organicWeight) { 0.00f }
    var paperThrown = wasteWeightsMap.getOrElse(key = "paper - " +
            userWasteFootprint.paperWeight) { 0.00f }
    var plasticThrown = wasteWeightsMap.getOrElse(key = "plastic - " +
            userWasteFootprint.plasticWeight) { 0.00f }
    var nonbioThrown = wasteWeightsMap.getOrElse(key = "nonbio - " +
            userWasteFootprint.nonbioWeight) { 0.00f }

    var organicBaseEmission = organicThrown * (wasteBaselinesMap.getOrElse(key = "organicBaseline") { 0.000f })
    var paperBaseEmission = paperThrown * (wasteBaselinesMap.getOrElse(key = "paperBaseline") { 0.000f })
    var plasticBaseEmission = plasticThrown * (wasteBaselinesMap.getOrElse(key = "plasticBaseline") { 0.000f })
    var nonbioBaseEmission = nonbioThrown * (wasteBaselinesMap.getOrElse(key = "nonbioBaseline") { 0.000f })

    var organicRecycled = wasteAlternativesMap.getOrElse(key = "organic - " +
            userWasteFootprint.recycledOrganic) { 0.000f }
    var paperRecycled = wasteAlternativesMap.getOrElse(key = "paper - " +
            userWasteFootprint.recycledPaper) { 0.000f }
    var plasticRecycled = wasteAlternativesMap.getOrElse(key = "plastic - " +
            userWasteFootprint.recycledPlastic) { 0.000f }
    var nonbioRecycled = wasteAlternativesMap.getOrElse(key = "nonbio - " +
            userWasteFootprint.recycledNonBio) { 0.000f }

    var organicEmission = organicBaseEmission - (organicThrown * organicRecycled)
    var paperEmission = paperBaseEmission - (paperThrown * paperRecycled)
    var plasticEmission = plasticBaseEmission - (plasticThrown * plasticRecycled)
    var nonbioEmission = nonbioBaseEmission - (nonbioThrown * nonbioRecycled)

    wasteEmission = organicEmission + paperEmission +
            plasticEmission + nonbioEmission
    wasteEmission = String.format(Locale.US, "%.3f", wasteEmission).toFloat()

    // kgs CO2 waste emission per month (household)
    return wasteEmission
}
