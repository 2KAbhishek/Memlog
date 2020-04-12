package com.iam2kabhishek.memlog

class DataManager {
    val moods = HashMap<String, MoodInfo>()
    val logs = ArrayList<LogInfo>()

    
    private fun initMoods(){
        var mood = MoodInfo("☺", "Happy")
        moods[mood.moodId] = mood
        mood = MoodInfo("☹", "Sad")
        moods[mood.moodId] = mood
    }
}