package com.example.kalikasapp.ui.theme.navigation.landing_screens

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.kalikasapp.R

class LessonModule {
    // false = not added to favorite
    // true = added to favorite
    var favorite by mutableStateOf(false)
    var author: String = ""
    var title: String = ""
    var duration: String = ""
    var description: String = ""
    var tags: List<String>  = listOf("", "", "")
    var authorImage: Int = R.drawable.holderprofile
    var tagA: Color = Color.Gray
    var tagB: Color = Color.Gray
    var infoColor: Color = Color.Gray
    var cardColor: Color = Color.Gray
}

// Lesson subject tag colors
val enviSciTag = Color(0XFF5D8AA8)
val marineBioTag = Color(0XFF00798C)
val ecologyTag = Color(0XFFC94950)
val drrmTag = Color(0XFFFC7A12)
val earthSciTag = Color(0XFFA47149)
val pubPolicyTag = Color(0XFF8B6FC2)
val urbanStudTag = Color(0XFF3D3E40)
val agriTag = Color(0XFFD89B25)
val ruralDevTag = Color(0XFFC46288)

// Card colors for lesson information
val infoCardA = Color(0xFF6BBE83)
val infoCardB = Color(0XFF7CBF6F)
val infoCardC = Color(0XFFB4D9A5)
val infoCardD = Color(0XFF9CC26B)
val infoCardE = Color(0XFF60CA7A)
val infoCardF = Color(0XFF72BC90)

// Card colors for lesson summary
val lessonCardA = Color(0xFFA8D8D8)
val lessonCardB = Color(0XFFFFE1B2)
val lessonCardC = Color(0XFFF2E3C6)
val lessonCardD = Color(0XFFD3F1F8)
val lessonCardE = Color(0XFFE4D9F2)
val lessonCardF = Color(0XFFF9D4D0)

// initialize variables for lesson class
var lessonA = LessonModule()
var lessonB = LessonModule()
var lessonC = LessonModule()
var lessonD = LessonModule()
var lessonE = LessonModule()
var lessonF = LessonModule()
// create after populating local database
// var lessonsList = listOf(lessonA, lessonB, lessonC, lessonD, lessonE, lessonF)

// Controller for loading lessons details
fun loadLessons() {
    // temporary brute-force
    lessonA.author = "Marine Science Institute"
    lessonA.title = "INTRODUCTION TO MARINE BIODIVERSITY"
    lessonA.duration = "3 hrs"
    lessonA.description = "Explore marine ecosystems, species variety, and conservation efforts. " +
            "Learn the importance of biodiversity in oceans and how it supports ecological balance " +
            "and human survival."
    lessonA.tags = listOf("Envi Sci", "Marine Bio")
    lessonA.authorImage = R.drawable.holderprofile
    lessonA.tagA = enviSciTag
    lessonA.tagB = marineBioTag
    lessonA.infoColor = infoCardA
    lessonA.cardColor = lessonCardA

    lessonB.author = "Dr. Maria Delos Santos"
    lessonB.title = "UNDERSTANDING PHILIPPINE ECOSYSTEMS"
    lessonB.duration = "2 hrs"
    lessonB.description = "Discover the richness of Philippine ecosystems, their unique " +
            "biodiversity, challenges they face, and the vital role they play in sustaining life " +
            "and local livelihoods."
    lessonB.tags = listOf("Ecology", "Envi Sci")
    lessonB.authorImage = R.drawable.holderprofile
    lessonB.tagA = ecologyTag
    lessonB.tagB = enviSciTag
    lessonB.infoColor = infoCardB
    lessonB.cardColor = lessonCardB

    lessonC.author = "National Inst. of Geological Sciences"
    lessonC.title = "DRRM WITH GEOLOGICAL DATA"
    lessonC.duration = "3 hrs"
    lessonC.description = "Learn how geological data aids Disaster Risk Reduction and Management. " +
            "Understand hazards, risk mapping, and how to plan and respond to geologically-induced " +
            "disasters effectively."
    lessonC.tags = listOf("Disaster RRM", "Earth Sci")
    lessonC.authorImage = R.drawable.holderprofile
    lessonC.tagA = drrmTag
    lessonC.tagB = earthSciTag
    lessonC.infoColor = infoCardC
    lessonC.cardColor = lessonCardC

    lessonD.author = "Inst. of Environmental Science"
    lessonD.title = "REHABILITATION OF ECOSYSTEMS"
    lessonD.duration = "2 hrs"
    lessonD.description = "Understand strategies to restore degraded ecosystems. Learn ecological " +
            "principles, restoration techniques, and community roles in reviving natural habitats " +
            "for sustainable environmental recovery."
    lessonD.tags = listOf("Ecology", "Envi Sci")
    lessonD.authorImage = R.drawable.holderprofile
    lessonD.tagA = ecologyTag
    lessonD.tagB = enviSciTag
    lessonD.infoColor = infoCardD
    lessonD.cardColor = lessonCardD

    lessonE.author = "Prof. Juan Dela Cruz"
    lessonE.title = "MANAGING URBAN AIR POLLUTION"
    lessonE.duration = "2 hrs"
    lessonE.description = "Study sources, impacts, and mitigation of air pollution in urban areas. " +
            "Learn policies, technologies, and community actions to improve air quality " +
            "and public health."
    lessonE.tags = listOf("Public Policy", "Urban Studies")
    lessonE.authorImage = R.drawable.holderprofile
    lessonE.tagA = pubPolicyTag
    lessonE.tagB = urbanStudTag
    lessonE.infoColor = infoCardE
    lessonE.cardColor = lessonCardE

    lessonF.author = "Department of Agriculture"
    lessonF.title = "BASICS OF SUSTAINABLE AGRICULTURE"
    lessonF.duration = "3 hrs"
    lessonF.description = "Gain foundational knowledge of sustainable farming practices. " +
            "Learn techniques that balance productivity with environmental care, supporting " +
            "food security and long-term agricultural sustainability."
    lessonF.tags = listOf("Agriculture", "Rural Dev")
    lessonF.authorImage = R.drawable.holderprofile
    lessonF.tagA = agriTag
    lessonF.tagB = ruralDevTag
    lessonF.infoColor = infoCardF
    lessonF.cardColor = lessonCardF
}

// Controller for updating saved status of lessons
fun saveLesson(lessonX: LessonModule) {
    when (lessonX) {
        lessonA -> lessonA.favorite = true
        lessonB -> lessonB.favorite = true
        lessonC -> lessonC.favorite = true
        lessonD -> lessonD.favorite = true
        lessonE -> lessonE.favorite = true
        else -> lessonF.favorite = true
    }
}

// Controller for reverting saved status of lessons
fun unsaveLesson(lessonX: LessonModule) {
    when (lessonX) {
        lessonA -> lessonA.favorite = false
        lessonB -> lessonB.favorite = false
        lessonC -> lessonC.favorite = false
        lessonD -> lessonD.favorite = false
        lessonE -> lessonE.favorite = false
        else -> lessonF.favorite = false
    }
}
