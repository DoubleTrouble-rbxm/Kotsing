package org.example

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import dev.lavalink.youtube.YoutubeAudioSourceManager
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Ready : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        AudioSourceManagers.registerRemoteSources(playerManager, youtube::class.java)
        youtube.useOauth2(Config.youtubeToken, true)
    }

    companion object {
        val playerManager: AudioPlayerManager = DefaultAudioPlayerManager()
        val youtube: YoutubeAudioSourceManager = YoutubeAudioSourceManager(true)
    }
}