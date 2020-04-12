package com.iam2kabhishek.memlog

data class MoodInfo (val id: String, val name: String) {
    override fun toString(): String {
        return name
    }
}

data class MemoryInfo (var mood: MoodInfo, var title: String, var details: String)

