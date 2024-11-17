package org.example

import java.io.File

object Config {
    val token: String
    val botAloneTime: Long?
    val botMaster: Long?
    val youtubeToken: String?

    init {
        val fileName = "${System.getProperty("user.home")}${File.separator}kotsing.config.properties"
        val configFile = File(fileName)
        val configMap = HashMap<String, String>()
        configFile.forEachLine {
            if (it[0] != '#') {
                val split = it.split("=")
                configMap[split[0].trim().lowercase()] = split[1].trim()
            }
        }
        token = configMap["token"] ?: throw Exception("token not set")
        botAloneTime = configMap["botAloneTime"]?.toLongOrNull()
        botMaster = configMap["botMaster"]?.toLongOrNull()
        youtubeToken = configMap["youtubeToken"]
    }
}