package bot.handler.menu;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class BurgerHandler {

    @SneakyThrows
    public static void doubleBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/double.png")));
        sendPhoto.setCaption("Дабл чикен чиз \n" +
                "\n" +
                "Мягкая булочка, две сочные куриные котлеты (Halal), сыр чеддер, свежие помидоры, маринованные огурцы, салатные листья айсберг, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 30 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void barbequeBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/barbeque.png")));
        sendPhoto.setCaption("Барбекю бургер \n" +
                "\n" +
                "Мягкая булочка, сочная куриная котлета (Halal) в фирменной панировке, свежие помидоры, салатные листья айсберг, соус майонез и аппетитный соус Барбекю \n" +
                "\n" +
                "Цена: 24 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void cheeseBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/cheese.png")));
        sendPhoto.setCaption("Чикен Чиз \n" +
                "\n" +
                "Мягкая булочка, сочная куриная котлета (Halal), сыр чеддер, свежие помидоры, салатные листья айсберг, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 23 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void classicBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/classic.png")));
        sendPhoto.setCaption("Классик \n" +
                "\n" +
                "Мягкая булочка, нежное куриное филе (Halal) в фирменной панировке, свежие помидоры, маринованные огурцы, салатные листья, соусы майонез и кетчуп \n" +
                "\n" +
                "Цена: 22 000  сум");
        bot.execute(sendPhoto);
    }
}
