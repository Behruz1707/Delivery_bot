package bot.handler;

import bot.handler.menu.BeverageHandler;
import bot.handler.menu.BurgerHandler;
import bot.handler.menu.SaladHandler;
import bot.model.Product;
import bot.repo.BasketRepo;
import bot.repo.Maps;
import bot.repo.ProductRepo;
import bot.repo.Steps;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) throws Exception {
        Steps steps = Maps.USER_STEPS.get(message.getChatId());
        User from = message.getFrom();
        if (message.getText().equals("\uD83D\uDECD Order")) {
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
            ButtonUtilsOfMenu.menuButtons(message, bot);

        } else if (message.getText().equals("⬅ Back") && steps.equals(Steps.MENU)) {
            CommandHandler.handleMessageSTART(message, bot);
            BasketRepo.BASKET_MAP = new HashMap<>();
        }

        // approving / clear / back
        else if (message.getText().equals("⬅ Back") && steps.equals(Steps.APPROVING)) {
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);
            ButtonUtilsOfMenu.back(message, bot);

        } else if (message.getText().equals("\uD83D\uDD04 Clear") && steps.equals(Steps.APPROVING)) {
            ButtonUtilsOfMenu.back(message, bot);
            BasketRepo.BASKET_MAP = new HashMap<>();
            Maps.USER_STEPS.put(message.getChatId(), Steps.MENU);

        }
        else if (message.getText().equals("Place an order ✅") && steps.equals(Steps.APPROVING)) {
//            Maps.USER_STEPS.put(message.getChatId(), Steps.CONTACT);
            ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("⬅ Back").build(),
                            KeyboardButton.builder().text("\uD83D\uDCF1 My number").requestContact(true).build()
                    )))
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("Confirm ✅").build()
                    )))
                    .build();
            replyKeyboardMarkup.setResizeKeyboard(true);
            SendMessage sendMessage1 = new SendMessage(message.getChatId().toString(), "Send your contact number \uD83D\uDCDE, we will call you as soon as our deliveryman will arrive.");
            sendMessage1.setReplyMarkup(replyKeyboardMarkup);
            bot.execute(sendMessage1);

        }
        else if (message.getText().equals("Confirm ✅")) {
//            Maps.USER_STEPS.put(message.getChatId(), Steps.LOCATION);
            ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("⬅ Back").build(),
                            KeyboardButton.builder().text("\uD83D\uDCCD My location").requestLocation(true).build()
                    )))
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("Ready ✅").build()
                    )))
                    .build();
            replyKeyboardMarkup.setResizeKeyboard(true);
            SendMessage sendMessage = new SendMessage(message.getChatId().toString(),
                    "Where to deliver? Send your location and we determine the nearest branch and delivery cost.");
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            bot.execute(sendMessage);
        } else if (message.getText().equals("Ready ✅")) {
            SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Thank you for choosing our products \uD83D\uDE0A❤️");
            bot.execute(sendMessage);
            CommandHandler.handleMessageSTART(message,bot);
        }

        // empty basket
        else if (message.getText().equals("\uD83D\uDCE5 Basket") && BasketRepo.BASKET_MAP.isEmpty()) {
            bot.execute(new SendMessage(message.getChatId().toString(), "Your basket is empty 😔"));

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

        // basket
        else if (message.getText().equals("\uD83D\uDCE5 Basket")) {
            Map<Long, Integer> map = BasketRepo.BASKET_MAP.get(message.getChatId());
            Set<Long> keys = map.keySet();
            StringBuilder data1 = new StringBuilder();
            int counter = 0;
            float overallSum = 0;
            for (Long key : keys) {
                counter++;
                Product byId = ProductRepo.getById(key);
                Integer quantity = map.get(key);
                float multiply = byId.getPrice() * quantity;
                data1.append(counter).append(". ").append(byId.getName()).append("\n").append(quantity).append(" x ")
                        .append(byId.getPrice()).append(" = ").append(multiply).append("\n\n");
                overallSum += multiply;
            }
            bot.execute(new SendMessage(message.getChatId().toString(),
                    "📥 Cart:\n\n" + data1 + "Total: " + overallSum + " sum"));

            approvingToOrder(message, bot);
        }
    }

    @SneakyThrows
    public static void approvingToOrder(final Message message, final TelegramLongPollingBot bot) {
        Maps.USER_STEPS.put(message.getChatId(), Steps.APPROVING);
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("⬅ Back").build(),
                        KeyboardButton.builder().text("Place an order ✅").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83D\uDD04 Clear").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Let's specify some details \uD83D\uDE0A");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }


}
