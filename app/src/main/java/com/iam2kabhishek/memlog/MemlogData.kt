package com.iam2kabhishek.memlog

class MoodInfo (val moodId: String, val moodName: String) {
    override fun toString(): String {
        return moodName
    }
}

class MemoryInfo (var mood: MoodInfo, var memoryTitle: String, var memoryDetails: String)

