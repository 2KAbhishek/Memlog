package com.iam2kabhishek.memlog

data class MoodInfo (val moodId: String, val moodName: String) {
    override fun toString(): String {
        return moodName
    }
}

data class MemoryInfo (var mood: MoodInfo, var memoryTitle: String, var memoryDetails: String)

