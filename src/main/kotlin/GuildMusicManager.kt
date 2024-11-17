package org.example

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager


class GuildMusicManager(manager: AudioPlayerManager) {
    val player: AudioPlayer = manager.createPlayer()
    val scheduler: TrackScheduler = TrackScheduler(player)
    init {
        player.addListener(scheduler)
    }

    val sendHandler: AudioPlayerSendHandler
        get() = AudioPlayerSendHandler(player)
}