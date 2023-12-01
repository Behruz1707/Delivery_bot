package bot.handler;

import bot.handler.menu.BeverageHandler;
import bot.handler.menu.BurgerHandler;
import bot.handler.menu.SaladHandler;
import bot.repo.Maps;
import bot.repo.Steps;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TextHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        Steps steps = Maps.USER_STEPS.get(message.getChatId());
        if (message.getText().equals("\uD83D\uDECD Order")) {
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
            ButtonUtilsOfMenu.menuButtons(message, bot);

        } else if (message.getText().equals("⬅ Back") && steps.equals(Steps.MENU)) {
            CommandHandler.handleMessageSTART(message, bot);

        } else if (message.getText().equals("\uD83C\uDF54 Burgers")) {
            ButtonUtilsOfMenu.burgersButton(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.BURGERS);

        } else if (message.getText().equals("\uD83E\uDD57 Salads")) {
            ButtonUtilsOfMenu.saladsButton(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.SALADS);

        } else if (message.getText().equals("\uD83C\uDF79 Beverages")) {
            ButtonUtilsOfMenu.beverageButton(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.BEVERAGES);

        } else if (message.getText().equals("⬅ Back") &&
                (steps == Steps.BEVERAGES || steps == Steps.SALADS || steps == Steps.BURGERS)) {
            ButtonUtilsOfMenu.back(message, bot);
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
        }

        // burgers
        else if (message.getText().equals("Classic burger")) {
            BurgerHandler.classicBurger(message, bot);
        } else if (message.getText().equals("Chicken cheese-burger")) {
            BurgerHandler.cheeseBurger(message, bot);
        } else if (message.getText().equals("Barbeque burger")) {
            BurgerHandler.barbequeBurger(message, bot);
        } else if (message.getText().equals("Double chicken cheese-burger")) {
            BurgerHandler.doubleBurger(message, bot);
        }

        // salads
        else if (message.getText().equals("Caesar")) {
            SaladHandler.caesar(message, bot);
        } else if (message.getText().equals("Sesame")) {
            SaladHandler.sesame(message, bot);
        } else if (message.getText().equals("Greek")) {
            SaladHandler.greek(message, bot);
        }

        // beverages
        else if (message.getText().equals("Fanta")) {
            BeverageHandler.fanta(message, bot);
        } else if (message.getText().equals("Montella")) {
            BeverageHandler.montella(message, bot);
        } else if (message.getText().equals("Sprite")) {
            BeverageHandler.sprite(message, bot);
        }

        // back
        else if (message.getText().equals("⬅ Back")) {
            ButtonUtilsOfMenu.back(message, bot);
        }
    }


}
