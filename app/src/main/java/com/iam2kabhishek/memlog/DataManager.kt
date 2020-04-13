package com.iam2kabhishek.memlog

object DataManager {
    val moods = HashMap<String, MoodInfo>()
    val memories = ArrayList<MemoryInfo>()

    init {
        initMoods()
        initNotes()
    }
    
    private fun initMoods(){
        var mood = MoodInfo("happy", "☺")
        moods[mood.id] = mood
        mood = MoodInfo("sad", "☹️")
        moods[mood.id] = mood
    }

    private fun initNotes(){
        var mood = MoodInfo("happy", "☺")
        var memory = MemoryInfo(mood, "Title1", "This is a memory")
        memories.add(memory)
        mood = MoodInfo("sad", "☹️")
        memory = MemoryInfo(mood, "Title2", "This is a memory")
        memories.add(memory)
        memory = MemoryInfo(mood, "Title3", "This is a memory")
        memories.add(memory)
    }
}