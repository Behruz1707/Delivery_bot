package bot.handler;

import bot.handler.menu.BeverageHandler;
import bot.handler.menu.BurgerHandler;
import bot.handler.menu.SaladHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class CallbackQueryHandler {
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        if (callbackQuery.getData().equals("classic")) {
            BurgerHandler.classicBurger(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("cheese")) {
            BurgerHandler.cheeseBurger(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("barbeque")) {
            BurgerHandler.barbequeBurger(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("double")) {
            BurgerHandler.doubleBurger(callbackQuery.getMessage(), bot);
        }

        else if (callbackQuery.getData().equals("caesar")) {
            SaladHandler.caesar(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("sesame")) {
            SaladHandler.sesame(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("greek")) {
            SaladHandler.greek(callbackQuery.getMessage(), bot);
        }

        else if (callbackQuery.getData().equals("montella")){
            BeverageHandler.montella(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("fanta")) {
            BeverageHandler.fanta(callbackQuery.getMessage(), bot);
        } else if (callbackQuery.getData().equals("sprite")) {
            BeverageHandler.sprite(callbackQuery.getMessage(), bot);
        }

    }



}
