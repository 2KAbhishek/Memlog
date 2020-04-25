package com.iam2kabhishek.memlog

object DataManager {
    val moods = HashMap<String, MoodInfo>()
    val memories = ArrayList<MemoryInfo>()

    init {
        initMoods()
        initMemories()
    }
    
    private fun initMoods(){
        var mood = MoodInfo("happy", "\uD83D\uDE04")
        moods[mood.id] = mood
        mood = MoodInfo("sad", "\uD83D\uDE14️")
        moods[mood.id] = mood
        mood = MoodInfo("angry", "\uD83D\uDE20")
        moods[mood.id] = mood
    }

    private fun initMemories(){
        memories.add(MemoryInfo(moods["happy"]!!, "Test1", "Test1"))
        memories.add(MemoryInfo(moods["sad"]!!, "Test2", "Test2"))
        memories.add(MemoryInfo(moods["angry"]!!, "Test3", "Test3"))
    }
}