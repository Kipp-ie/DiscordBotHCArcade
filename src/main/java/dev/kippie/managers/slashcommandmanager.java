package dev.kippie.managers;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class slashcommandmanager extends ListenerAdapter {
    public void onGuildReady(GuildReadyEvent event) {
        Dotenv dotenv = Dotenv.load();
        String avatar_enabled = dotenv.get("AVATAR");
        String fact_enabled = dotenv.get("FACT");
        String nokia_enabled = dotenv.get("NOKIA");
        String ping_enabled = dotenv.get("PING");
        String wyr_enabled = dotenv.get("WYR");
        String dog_enabled = dotenv.get("DOG");
        String cat_enabled = dotenv.get("CAT");
        String sadcat_enabled = dotenv.get("SADCAT");
        String alert_enabled = dotenv.get("ALERT");
        String ship_enabled = dotenv.get("SHIP");
        String drip_enabled = dotenv.get("DRIP");
        String rps_enabled = dotenv.get("RPS");
        String ticket_enabled = dotenv.get("TICKET_SYSTEM");
        String meme_enabled = dotenv.get("MEME");
        String moderation_enabled = dotenv.get("MODERATION");
        String lyrics_enabled = dotenv.get("LYRICS");
        String quote_enabled = dotenv.get("QUOTE");
        String pickuplines_enabled = dotenv.get("PICKUPLINES");
        String jail_enabled = dotenv.get("JAIL");
        String petpet_enabled = dotenv.get("PETPET");
        List<CommandData> commands = new ArrayList<>();

        if (avatar_enabled.equals("true")) {
            commands.add(Commands.slash("avatar", "Get someones avatar!")
                    .addOption(OptionType.USER, "user", "Mention a user you want to grab the avatar from", true));
        }
        if (fact_enabled.equals("true")) {
            commands.add(Commands.slash("fact", "Post a random fact."));
        }
        if (nokia_enabled.equals("true")) {
            commands.add(Commands.slash("nokia", "Turn yourself/someone into a Nokia?")
                    .addOption(OptionType.USER, "user", "Mention a user you want to turn into a Nokia", true));
        }
        if (ping_enabled.equals("true")) {
            commands.add(Commands.slash("ping", "Test the Bot"));
        }
        if (wyr_enabled.equals("true")) {
            commands.add(Commands.slash("wyr", "Post a would you rather"));
        }
        if (dog_enabled.equals("true")) {
            commands.add(Commands.slash("dog", "Get a random dog picture"));
        }
        if (cat_enabled.equals("true")) {
            commands.add(Commands.slash("cat", "Get a random cat picture"));
        }
        if (sadcat_enabled.equals("true")) {
            commands.add(Commands.slash("sadcat", "Generate a sad cat meme!")
                    .addOption(OptionType.STRING, "text", "Give the text for the sad cat meme.", true));
        }
        if (alert_enabled.equals("true")) {
            commands.add(Commands.slash("alert", "Generate a alert meme")
                    .addOption(OptionType.STRING, "text", "Give the text for the Alert.", true));
        }
        if (ship_enabled.equals("true")) {
            commands.add(Commands.slash("ship", "Make 2 users fall in love ;)")
                    .addOption(OptionType.USER, "user1", "Give a user who falls in love with user 2", true)
                    .addOption(OptionType.USER, "user2", "Give a user who falls in love with user 1", true));
        }
        if (drip_enabled.equals("true")) {
            commands.add(Commands.slash("drip", "Drippify someone")
                    .addOption(OptionType.USER, "user", "Choose someone to drippify", true));
        }
        if (rps_enabled.equals("true")) {
            commands.add(Commands.slash("rps", "Play Rock Paper Scissors against a bot!")
                    .addOptions(
                            new OptionData(OptionType.STRING, "choice", "Choose rock, paper op sciccors", true)
                                    .addChoice("Rock", "rock")
                                    .addChoice("Paper", "paper")
                                    .addChoice("Scissors", "scissors")
                    ));

        }
        if (ticket_enabled.equals("true")) {
            commands.add(Commands.slash("ticket", "Open a ticket"));
            commands.add(Commands.slash("add", "Add another user to a ticket")
                    .addOption(OptionType.USER, "user", "Choose a user to add to the ticket", true));

        }
        if (meme_enabled.equals("true")) {
            commands.add(Commands.slash("meme", "Generate a random meme"));
        }
        if (moderation_enabled.equals("true")) {
            commands.add(Commands.slash("kick", "Kick an user if you have the permissions.")
                    .addOption(OptionType.USER, "user", "Choose the user to kick.", true)
                    .addOption(OptionType.STRING, "reason", "Give a reason to DM the kicked user.", true));
            commands.add(Commands.slash("ban", "Ban an user if you have the permissions.")
                    .addOption(OptionType.USER, "user", "Choose the user to ban.", true)
                    .addOption(OptionType.STRING, "reason", "Give a reason to DM the banned user.", true)
                    .addOption(OptionType.INTEGER, "duration", "Give the amount of days to ban this user.", true));
            commands.add(Commands.slash("timeout", "Timeout an user if you have the permissions.")
                    .addOption(OptionType.USER, "user", "Choose the user to give a timeout.", true)
                    .addOption(OptionType.STRING, "reason", "Give a reason to DM the timeouted user.", true)
                    .addOption(OptionType.INTEGER, "duration", "Give the amount of hours to timeout this user.", true));
        }
        if (lyrics_enabled.equals("true")) {
            commands.add(Commands.slash("lyrics", "Get lyrics from a song.")
                    .addOption(OptionType.STRING, "song", "Song name."));
        }
        if (quote_enabled.equals("true")) {
            commands.add(Commands.slash("quote", "Generate a quote!")
                    .addOption(OptionType.USER, "user", "Give the user of who the quote should be", true)
                    .addOption(OptionType.STRING, "quote", "Give the text that should be used in the quote.", true));
        }
        if (pickuplines_enabled.equals("true")) {
            commands.add(Commands.slash("pickuplines", "Generate a random pickup line!"));
        }
        if (jail_enabled.equals("true")) {
            commands.add(Commands.slash("jail", "Put someone in jail!")
                    .addOption(OptionType.USER, "user", "Choose the user you want to put in jail!", true));
        }
        if (petpet_enabled.equals("true")) {
            commands.add(Commands.slash("petpet", "Turn someone into a petpet gif!")
                    .addOption(OptionType.USER, "user", "Choose the user you want to turn into a petpet gif!", true));
        }

        event.getGuild().updateCommands().addCommands(commands).queue();
    }
}
