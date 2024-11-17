package org.example

import io.github.oshai.kotlinlogging.KotlinLogging
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter


class LeaveChannel: ListenerAdapter() {
    override fun onGuildVoiceUpdate(event: GuildVoiceUpdateEvent) {
        if (event.channelLeft != null) {
            if (event.channelLeft!!.members.size == 1 && event.member.voiceState?.channel?.idLong != event.channelLeft!!.idLong) {
                logger.info { "Bot is alone in voice channel. Leaving..." }
                event.guild.audioManager.closeAudioConnection()
            }
        }
    }
}