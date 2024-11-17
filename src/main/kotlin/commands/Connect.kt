package org.example.commands

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.example.AudioPlayerSendHandler
import org.example.GuildMusicManager
import org.example.Ready
import org.example.TrackScheduler

class Connect : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "connect") {
            if (event.member?.voiceState?.inAudioChannel() == false) {
                event.reply("Join a voice channel first!")
            } else {
                run {
                    val player: AudioPlayer = Ready.playerManager.createPlayer()
                    audioConnection(event, player)
                }
            }
        }
    }

    fun audioConnection(event: SlashCommandInteractionEvent, player: AudioPlayer) {
        val vcChannel: AudioChannelUnion? = event.member?.voiceState?.channel
        val audioManager = event.guild?.audioManager
        audioManager?.openAudioConnection(vcChannel)
        val trackScheduler: TrackScheduler = TrackScheduler(player)
        player.addListener(trackScheduler)
    }
}