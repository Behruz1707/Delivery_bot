package bot.handler.menu;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class SaladHandler {

    @SneakyThrows
    public static void caesar(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/caesar.png")));
        sendPhoto.setCaption("Цезарь \n" +
                "\n" +
                "Куриное филе (Halal), сыр пармезан, помидоры черри, сухари, салатные листья айсберг, соус цезарь \n" +
                "\n" +
                "Цена: 26 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void greek(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/greek.png")));
        sendPhoto.setCaption("Греческий \n" +
                "\n" +
                "Салат из сочных салатных листьев, помидоров, маслин, свежих огурцов и сыра фетакса, приправленный лимонным соусом и соусом базилик \n" +
                "\n" +
                "Цена: 25 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void sesame(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/sesame.png")));
        sendPhoto.setCaption("Сезам \n" +
                "\n" +
                "Сочные листья салата айсберг и кусочки нежнейшего куриного филе (Halal), посыпанные кунжутом, в аппетитном соусе терияки \n" +
                "\n" +
                "Цена: 22 000  сум");
        bot.execute(sendPhoto);
    }

}
