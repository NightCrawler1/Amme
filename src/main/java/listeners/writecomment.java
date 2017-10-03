package listeners;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static net.dv8tion.jda.core.OnlineStatus.ONLINE;

/**
 * Butler´s JDA BOT
 * <p>
 * By LordLee at 29.09.2017 08:15
 * <p>
 * <p>
 * <p>
 * Contributors for this class:
 * - github.com/zekrotja
 * <p>
 * © DARK DEVS 2017
 */
public class writecomment extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getMessage().getMentionedUsers().size() < 1) return;
        if (event.getAuthor().isBot()) return;
        if (event.getGuild().getOwner().getUser().getId().equals("221905671296253953")) return;
        User ment = event.getMessage().getMentionedUsers().get(0);
        OnlineStatus us = event.getGuild().getMember(ment).getOnlineStatus();
        if (!us.equals(ONLINE)){
            Message msg = event.getChannel().sendMessage("Hey, " + event.getAuthor().getAsMention() + " " + event.getMessage().getMentionedUsers().get(0).getAsMention() + " is " + us + " you can wait long to get an Answer!").complete();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg.delete().queue();
        }
    }
}