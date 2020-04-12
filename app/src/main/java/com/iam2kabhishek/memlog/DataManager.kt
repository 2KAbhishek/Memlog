package com.iam2kabhishek.memlog

object DataManager {
    val moods = HashMap<String, MoodInfo>()
    val memories = ArrayList<MemoryInfo>()

    init {
        initMoods()
        initNotes()
    }
    
    private fun initMoods(){
        var mood = MoodInfo("happy", "☺ Happy ☺")
        moods[mood.moodId] = mood
        mood = MoodInfo("sad", "☹️ Sad ☹️")
        moods[mood.moodId] = mood
    }

    private fun initNotes(){
        var mood = MoodInfo("happy", "☺ Happy ☺")
        var memory = MemoryInfo(mood, "Title1", "This is a memory")
        mood = MoodInfo("sad", "☹️ Sad ☹️")
        memory = MemoryInfo(mood, "Title2", "This is a memory")
        memory = MemoryInfo(mood, "Title3", "This is a memory")
    }
}