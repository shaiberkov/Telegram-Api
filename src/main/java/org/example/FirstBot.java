package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

public class FirstBot extends TelegramLongPollingBot {
   private Api api;
   public FirstBot() {
       this.api = new Api();
   }
    @Override
    public String getBotUsername() {
        return "Shai2024";
    }
    public String getBotToken() {
        return "6957061792:AAEop0IlgEq5JeI1QkswZj8WLclAs8mlU7o";
    }



    @Override
    public void onUpdateReceived(Update update) {
    String text = update.getMessage().getText();
    String message1 = this.api.sendMessage( text+"האם ביקשו להזכיר לעשות פעולה כלשהי ואם כן תירשום לי" +
            " את הפעולה לביצוע  ואת הזמן המבוקש וביניהם AAAA ואל תכתוב שום מילה מעבר לפורמט הזה שציינתי. את הזמן תכתוב רק כמספר, לא עם המילה שניות, דקות, שעות וכו'");
        System.out.println(message1);
    if (message1 != null){
        String [] answer=message1.split("AAAA");


        try {
            Thread.sleep(Long.parseLong(answer[1].trim()) * 1000);
            long chatId = update.getMessage().getChatId();
            SendMessage message = new SendMessage( String.valueOf(chatId),answer[0]);
            execute(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    //Integer asInt=Integer.parseInt(text);


    }


}
