package org.example.commands

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeSearchMusicProvider
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.example.Ready
import org.example.TrackScheduler

class Play : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "play") {
            if (event.member?.voiceState?.inAudioChannel() == false) {
                event.reply("Join a voice channel first!").queue()
            } else {
                if (event.getOption("url") == null) {
                    event.reply("Please provide correct prompt!").queue()
                } else run {
                    val player: AudioPlayer = Ready.playerManager.createPlayer()
                    Connect().audioConnection(event, player)
                }
            }
        }
    }
}