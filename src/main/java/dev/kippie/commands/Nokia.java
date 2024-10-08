package dev.kippie.commands;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Objects;

public class Nokia extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("nokia")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(Objects.requireNonNull(event.getOption("user")).getAsUser().getName() + " turned into a Nokia?");
            Dotenv dotenv = Dotenv.load();
            String color = dotenv.get("COLOR");
            embed.setColor(Color.decode(color));
            String name = dotenv.get("BOT_NAME");
            embed.setFooter(name);
            embed.setImage("https://api.popcat.xyz/nokia?image=" + event.getOption("user").getAsUser().getAvatarUrl());
            event.replyEmbeds(embed.build()).queue();
        }
    }
}
