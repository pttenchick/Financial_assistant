package TelegramService;

import Config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

   final BotConfig config;

    public TelegramBot(BotConfig config){
        super(config.getToken());
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch(messageText){
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                   sendMessage(chatId, "Sorry, command not found");
            }


        }
    }

    private void startCommandReceived(long chatID, String name){
        String answer = "Hello, " + name + ", nice to meet you!";

        sendMessage(chatID, answer);
    }

    private  void sendMessage(Long chatID, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatID));
        message.setText(textToSend);

        try {
            execute(message);
        }
        catch (TelegramApiException e){

        }
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }



}
