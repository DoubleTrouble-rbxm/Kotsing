package org.example


import io.github.oshai.kotlinlogging.KotlinLogging
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent
import org.example.commands.Connect
import org.example.commands.Ping
import org.example.commands.Play
import org.example.commands.Say


val logger = KotlinLogging.logger {}
fun main() {
    logger.info { "Preparing for the start..." }
    val client = createClient(Config)
    client.addEventListener(LeaveChannel(), Ping(), Say(), Ready(), Connect(), Play())
    val opemGuild = client.awaitReady().guilds[0]
    opemGuild.updateCommands().addCommands(
        Commands.slash("ping", "Replies with \"Pong!\""),
        Commands.slash("say", "Replies with provided text").addOption(OptionType.STRING, "text", "Text to say"),
        Commands.slash("connect", "Connects to your voice channel"),
        Commands.slash("play", "Plays your song").addOption(OptionType.STRING, "url", "URL to the song")
    ).queue()
}

fun createClient(config: Config): JDA {
    logger.info {"Creating a bot..."}
    return JDABuilder.create(config.token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.MESSAGE_CONTENT).build()
}