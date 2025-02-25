package com.example.kalikasapp.ui.theme.navigation.footprint_screens

// Water Footprint shower duration to liters per month (rounded to 2 dp)
val showerDurationMap = mapOf(
    "under 5 mins" to 1059.92f,
    "5-10 mins" to 2119.83f,
    "11-30 mins" to 5299.58f,
    "over 30 mins" to 7949.37f
)

// Water Footprint sink duration to liters per month (rounded to 2 dp)
val sinkDurationMap = mapOf(
    "under 5 mins" to 635.95f,
    "5-10 mins" to 1271.90f,
    "11-15 mins" to 2066.84f,
    "over 15 mins" to 2384.81f
)

// Water Footprint toilet flush to liters per month (rounded to 2 dp)
val toiletUsageMap = mapOf(
    "always" to 847.93f,
    "sometimes" to 576.59f
)

// Water Footprint dishes duration, method, load to liters per month (rounded to 2 dp)
val dishesContribMap = mapOf(
    Triple("everyday", "dishwasher", "1 load") to 455.76f,
    Triple("everyday", "dishwasher", "2 loads") to 911.53f,
    Triple("everyday", "dishwasher", "3 loads") to 1367.29f,
    Triple("everyday", "dishwasher", "4 loads") to 1823.06f,
    Triple("everyday", "dishwasher", "more than 4 loads") to 2278.82f,
    Triple("everyday", "handwash", "1 load") to 2861.77f,
    Triple("everyday", "handwash", "2 loads") to 5723.54f,
    Triple("everyday", "handwash", "3 loads") to 8585.30f,
    Triple("everyday", "handwash", "4 loads") to 11447.07f,
    Triple("everyday", "handwash", "more than 4 loads") to 14308.84f,

    Triple("every other day", "dishwasher", "1 load") to 150.40f,
    Triple("every other day", "dishwasher", "2 loads") to 300.80f,
    Triple("every other day", "dishwasher", "3 loads") to 451.21f,
    Triple("every other day", "dishwasher", "4 loads") to 601.61f,
    Triple("every other day", "dishwasher", "more than 4 loads") to 752.01f,
    Triple("every other day", "handwash", "1 load") to 944.38f,
    Triple("every other day", "handwash", "2 loads") to 1888.77f,
    Triple("every other day", "handwash", "3 loads") to 2833.15f,
    Triple("every other day", "handwash", "4 loads") to 3777.53f,
    Triple("every other day", "handwash", "more than 4 loads") to 4721.92f,

    Triple("every week", "dishwasher", "1 load") to 65.11f,
    Triple("every week", "dishwasher", "2 loads") to 130.22f,
    Triple("every week", "dishwasher", "3 loads") to 195.33f,
    Triple("every week", "dishwasher", "4 loads") to 260.44f,
    Triple("every week", "dishwasher", "more than 4 loads") to 325.55f,
    Triple("every week", "handwash", "1 load") to 408.83f,
    Triple("every week", "handwash", "2 loads") to 817.65f,
    Triple("every week", "handwash", "3 loads") to 1226.47f,
    Triple("every week", "handwash", "4 loads") to 1635.30f,
    Triple("every week", "handwash", "more than 4 loads") to 2044.12f
)

// Water Footprint laundry duration, method, load to liters per month (rounded to 2 dp)
val laundryContribMap = mapOf(
    Triple("every other day", "own", "1 load") to 699.54f,
    Triple("every other day", "own", "2 loads") to 1399.09f,
    Triple("every other day", "own", "3 loads") to 2098.63f,
    Triple("every other day", "own", "4 loads") to 2798.18f,
    Triple("every other day", "own", "more than 4 loads") to 3497.71f,
    Triple("every other day", "laundromat", "1 load") to 594.61f,
    Triple("every other day", "laundromat", "2 loads") to 1189.22f,
    Triple("every other day", "laundromat", "3 loads") to 1783.84f,
    Triple("every other day", "laundromat", "4 loads") to 2378.45f,
    Triple("every other day", "laundromat", "more than 4 loads") to 2973.06f,

    Triple("every week", "own", "1 load") to 302.83f,
    Triple("every week", "own", "2 loads") to 605.67f,
    Triple("every week", "own", "3 loads") to 908.50f,
    Triple("every week", "own", "4 loads") to 1211.33f,
    Triple("every week", "own", "more than 4 loads") to 1514.16f,
    Triple("every week", "laundromat", "1 load") to 257.41f,
    Triple("every week", "laundromat", "2 loads") to 514.82f,
    Triple("every week", "laundromat", "3 loads") to 772.22f,
    Triple("every week", "laundromat", "4 loads") to 1029.63f,
    Triple("every week", "laundromat", "more than 4 loads") to 1287.04f,

    Triple("every 2 weeks", "own", "1 load") to 151.42f,
    Triple("every 2 weeks", "own", "2 loads") to 302.83f,
    Triple("every 2 weeks", "own", "3 loads") to 454.25f,
    Triple("every 2 weeks", "own", "4 loads") to 605.67f,
    Triple("every 2 weeks", "own", "more than 4 loads") to 757.08f,
    Triple("every 2 weeks", "laundromat", "1 load") to 128.70f,
    Triple("every 2 weeks", "laundromat", "2 loads") to 257.41f,
    Triple("every 2 weeks", "laundromat", "3 loads") to 386.11f,
    Triple("every 2 weeks", "laundromat", "4 loads") to 514.82f,
    Triple("every 2 weeks", "laundromat", "more than 4 loads") to 643.52f,

    Triple("every 3 weeks", "own", "1 load") to 113.56f,
    Triple("every 3 weeks", "own", "2 loads") to 227.13f,
    Triple("every 3 weeks", "own", "3 loads") to 340.69f,
    Triple("every 3 weeks", "own", "4 loads") to 454.25f,
    Triple("every 3 weeks", "own", "more than 4 loads") to 567.81f,
    Triple("every 3 weeks", "laundromat", "1 load") to 96.53f,
    Triple("every 3 weeks", "laundromat", "2 loads") to 193.06f,
    Triple("every 3 weeks", "laundromat", "3 loads") to 289.58f,
    Triple("every 3 weeks", "laundromat", "4 loads") to 386.11f,
    Triple("every 3 weeks", "laundromat", "more than 4 loads") to 482.64f,

    Triple("every month", "own", "1 load") to 75.71f,
    Triple("every month", "own", "2 loads") to 151.42f,
    Triple("every month", "own", "3 loads") to 227.12f,
    Triple("every month", "own", "4 loads") to 302.83f,
    Triple("every month", "own", "more than 4 loads") to 378.54f,
    Triple("every month", "laundromat", "1 load") to 64.35f,
    Triple("every month", "laundromat", "2 loads") to 128.70f,
    Triple("every month", "laundromat", "3 loads") to 193.06f,
    Triple("every month", "laundromat", "4 loads") to 257.41f,
    Triple("every month", "laundromat", "more than 4 loads") to 321.76f
)

// Energy Footprint device or appliance emission, vampire energy to monthly carbon (rounded to 3 dp)
val electricityContribMap = mapOf(
    "tvset" to 5.118f,
    "desktop" to 4.777f,
    "laptop" to 6.142f,
    "smartphone" to 0.409f,
    "tablet" to 0.205f,
    "electricfan" to 24.569f,
    "aircon" to 221.119f,
    "lightbulb" to 2.211f,

    "tvsetVE" to 0.778f,
    "desktopVE" to 4.873f,
    "laptopVE" to 0.287f,
    "smartphoneVE" to 0.205f,
    "tabletVE" to 0.225f,
    "electricfanVE" to 0.041f,
    "airconVE" to 1.843f,
    "lightbulbVE" to 0.123f,

    "refrigerator" to 78.620f,
    "microwave" to 5.118f,
    "stove" to 61.422f,
    "toaster" to 4.095f,
    "ricecooker" to 20.474f,

    "dispenser" to 49.137f,
    "kettle" to 3.071f,
    "washingmachine" to 28.391f,
    "dryer" to 17.062f
)

// Transpo Footprint vehicle, duration to monthly carbon (rounded to 3 dp)
val transpoContribMap = mapOf(
    "car - 0 mins" to 0.000f,
    "car - 30 mins" to 1.505f,
    "car - 60 mins" to 3.010f,
    "car - 90 mins" to 4.515f,
    "car - 150 mins" to 7.525f,
    "car - 200 mins" to 10.033f,

    "jeepney - 0 mins" to 0.000f,
    "jeepney - 30 mins" to 0.256f,
    "jeepney - 60 mins" to 0.513f,
    "jeepney - 90 mins" to 0.769f,
    "jeepney - 150 mins" to 1.282f,
    "jeepney - 200 mins" to 1.709f,

    "bus - 0 mins" to 0.000f,
    "bus - 30 mins" to 0.256f,
    "bus - 60 mins" to 0.512f,
    "bus - 90 mins" to 0.768f,
    "bus - 150 mins" to 1.281f,
    "bus - 200 mins" to 1.707f,

    "train - 0 mins" to 0.000f,
    "train - 30 mins" to 0.028f,
    "train - 60 mins" to 0.056f,
    "train - 90 mins" to 0.084f,
    "train - 150 mins" to 0.141f,
    "train - 200 mins" to 0.188f,

    "puv - 0 mins" to 0.000f,
    "puv - 30 mins" to 0.333f,
    "puv - 60 mins" to 0.666f,
    "puv - 90 mins" to 0.999f,
    "puv - 150 mins" to 1.665f,
    "puv - 200 mins" to 2.220f,

    "motorcycle - 0 mins" to 0.000f,
    "motorcycle - 30 mins" to 0.699f,
    "motorcycle - 60 mins" to 1.399f,
    "motorcycle - 90 mins" to 2.098f,
    "motorcycle - 150 mins" to 3.497f,
    "motorcycle - 200 mins" to 4.663f,

    "tricycle - 0 mins" to 0.000f,
    "tricycle - 30 mins" to 0.838f,
    "tricycle - 60 mins" to 1.675f,
    "tricycle - 90 mins" to 2.513f,
    "tricycle - 150 mins" to 4.188f,
    "tricycle - 200 mins" to 5.583f
)

// Food Footprint product, frequency to weekly carbon (rounded to 3 dp)
val foodContribMap = mapOf(
    "beef - never" to 0.000f,
    "beef - every other week" to 3.530f,
    "beef - once a week" to 7.060f,
    "beef - 2-3x per week" to 17.650f,
    "beef - 4-6x per week" to 35.300f,
    "beef - everday" to 49.420f,
    "beef - 2-3x per day" to 123.550f,
    "beef - more than 3x a day" to 247.100f,

    "chicken - never" to 0.000f,
    "chicken - every other week" to 0.494f,
    "chicken - once a week" to 0.987f,
    "chicken - 2-3x per week" to 2.468f,
    "chicken - 4-6x per week" to 4.935f,
    "chicken - everday" to 6.909f,
    "chicken - 2-3x per day" to 17.273f,
    "chicken - more than 3x a day" to 34.545f,

    "pork - never" to 0.000f,
    "pork - every other week" to 0.616f,
    "pork - once a week" to 1.231f,
    "pork - 2-3x per week" to 3.078f,
    "pork - 4-6x per week" to 6.155f,
    "pork - everday" to 8.617f,
    "pork - 2-3x per day" to 21.543f,
    "pork - more than 3x a day" to 43.085f,

    "seafood - never" to 0.000f,
    "seafood - every other week" to 0.682f,
    "seafood - once a week" to 1.363f,
    "seafood - 2-3x per week" to 3.408f,
    "seafood - 4-6x per week" to 6.815f,
    "seafood - everday" to 9.541f,
    "seafood - 2-3x per day" to 23.853f,
    "seafood - more than 3x a day" to 47.705f,

    "egg - never" to 0.000f,
    "egg - every other week" to 0.117f,
    "egg - once a week" to 0.234f,
    "egg - 2-3x per week" to 0.584f,
    "egg - 4-6x per week" to 1.168f,
    "egg - everday" to 1.635f,
    "egg - 2-3x per day" to 4.086f,
    "egg - more than 3x a day" to 8.173f,

    "milk - never" to 0.000f,
    "milk - every other week" to 0.378f,
    "milk - once a week" to 0.756f,
    "milk - 2-3x per week" to 1.890f,
    "milk - 4-6x per week" to 3.780f,
    "milk - everday" to 5.292f,
    "milk - 2-3x per day" to 13.230f,
    "milk - more than 3x a day" to 26.460f,

    "cheese - never" to 0.000f,
    "cheese - every other week" to 0.669f,
    "cheese - once a week" to 1.337f,
    "cheese - 2-3x per week" to 3.343f,
    "cheese - 4-6x per week" to 6.686f,
    "cheese - everday" to 9.361f,
    "cheese - 2-3x per day" to 23.402f,
    "cheese - more than 3x a day" to 46.805f,

    "rice - never" to 0.000f,
    "rice - every other week" to 0.306f,
    "rice - once a week" to 0.612f,
    "rice - 2-3x per week" to 1.530f,
    "rice - 4-6x per week" to 3.060f,
    "rice - everday" to 4.284f,
    "rice - 2-3x per day" to 10.710f,
    "rice - more than 3x a day" to 21.420f,

    "fruit - never" to 0.000f,
    "fruit - every other week" to 0.025f,
    "fruit - once a week" to 0.050f,
    "fruit - 2-3x per week" to 0.126f,
    "fruit - 4-6x per week" to 0.252f,
    "fruit - everday" to 0.353f,
    "fruit - 2-3x per day" to 0.882f,
    "fruit - more than 3x a day" to 1.764f,

    "vegetable - never" to 0.000f,
    "vegetable - every other week" to 0.042f,
    "vegetable - once a week" to 0.084f,
    "vegetable - 2-3x per week" to 0.210f,
    "vegetable - 4-6x per week" to 0.420f,
    "vegetable - everday" to 0.588f,
    "vegetable - 2-3x per day" to 1.470f,
    "vegetable - more than 3x a day" to 2.940f,

    "wheat - never" to 0.000f,
    "wheat - every other week" to 0.024f,
    "wheat - once a week" to 0.048f,
    "wheat - 2-3x per week" to 0.120f,
    "wheat - 4-6x per week" to 0.240f,
    "wheat - everday" to 0.336f,
    "wheat - 2-3x per day" to 0.840f,
    "wheat - more than 3x a day" to 1.680f,

    "processed - never" to 0.000f,
    "processed - every other week" to 0.200f,
    "processed - once a week" to 0.400f,
    "processed - 2-3x per week" to 1.000f,
    "processed - 4-6x per week" to 2.000f,
    "processed - everday" to 2.800f,
    "processed - 2-3x per day" to 7.000f,
    "processed - more than 3x a day" to 14.000f
)

// Waste Footprint weights of wastes per week (rounded to 2 dp)
val wasteWeightsMap = mapOf(
    "organic - less than 1 kg" to 0.50f,
    "organic - almost 1 kg" to 1.00f,
    "organic - 1-2 kg" to 2.00f,
    "organic - 2-3 kg" to 2.50f,
    "organic - 3-5 kg" to 4.00f,
    "organic - more than 5 kg" to 5.50f,

    "paper - less than 1 kg" to 0.50f,
    "paper - almost 1 kg" to 1.00f,
    "paper - 1-2 kg" to 2.00f,
    "paper - 2-3 kg" to 2.50f,
    "paper - 3-5 kg" to 4.00f,
    "paper - more than 5 kg" to 5.50f,

    "plastic - less than 1 kg" to 0.50f,
    "plastic - almost 1 kg" to 1.00f,
    "plastic - 1-2 kg" to 2.00f,
    "plastic - 2-3 kg" to 2.50f,
    "plastic - 3-5 kg" to 4.00f,
    "plastic - more than 5 kg" to 5.50f,

    "nonbio - less than 1 kg" to 0.50f,
    "nonbio - almost 1 kg" to 1.00f,
    "nonbio - 1-2 kg" to 2.00f,
    "nonbio - 2-3 kg" to 2.50f,
    "nonbio - 3-5 kg" to 4.00f,
    "nonbio - more than 5 kg" to 5.50f
)

// Waste Footprint baseline emission multipliers to kgs of waste per month (rounded to 3 dp)
val wasteBaselinesMap = mapOf(
    "organicBaseline" to 10.597f,
    "paperBaseline" to 5.138f,
    "plasticBaseline" to 12.000f,
    "nonbioBaseline" to 40.000f
)

// Waste Footprint avoided emission factors per month (rounded to 3 dp)
val wasteAlternativesMap = mapOf(
    "organic - none" to 0.000f,
    "organic - less than half" to 1.325f,
    "organic - half" to 2.649f,
    "organic - almost all" to 3.974f,
    "organic - all" to 5.299f,

    "paper - none" to 0.000f,
    "paper - less than half" to 1.083f,
    "paper - half" to 2.165f,
    "paper - almost all" to 3.248f,
    "paper - all" to 4.330f,

    "plastic - none" to 0.000f,
    "plastic - less than half" to 1.740f,
    "plastic - half" to 3.480f,
    "plastic - almost all" to 5.220f,
    "plastic - all" to 6.960f,

    "nonbio - none" to 0.000f,
    "nonbio - less than half" to 8.500f,
    "nonbio - half" to 17.000f,
    "nonbio - almost all" to 25.500f,
    "nonbio - all" to 34.000f,
)
