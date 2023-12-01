package bot.handler.menu;

import bot.handler.ButtonUtilsOfMenu;
import bot.repo.ProductRepo;
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
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 4));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/double.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(3).getName() +
                ProductRepo.PRODUCT_LIST.get(3).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(3).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void barbequeBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 3));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/barbeque.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(2).getName() + "\n\n" +
                ProductRepo.PRODUCT_LIST.get(2).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(2).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void cheeseBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 2));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/cheese.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(1).getName() + "\n\n" +
                ProductRepo.PRODUCT_LIST.get(1).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(1).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void classicBurger(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 1));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/burgers/classic.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(0).getName() + "\n\n" +
                ProductRepo.PRODUCT_LIST.get(0).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(0).getPrice() + " sum");
        bot.execute(sendPhoto);
    }
}
