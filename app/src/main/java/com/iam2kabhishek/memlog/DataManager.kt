package com.iam2kabhishek.memlog

class DataManager {
    val moods = HashMap<String, MoodInfo>()
    val memories = ArrayList<MemoryInfo>()

    init {
        initMoods()
    }
    
    private fun initMoods(){
        var mood = MoodInfo("happy", "☺ Happy ☺")
        moods[mood.moodId] = mood
        mood = MoodInfo("sad", "☹ Sad ☹")
        moods[mood.moodId] = mood
    }
}