package bot.handler;

import bot.repo.BasketRepo;
import bot.repo.Maps;
import bot.repo.ProductRepo;
import bot.repo.Steps;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class CallbackQueryHandler {
    @SneakyThrows
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String data = callbackQuery.getData();
        if (data.startsWith("+")) {
            incrementQuantity(callbackQuery, bot);
        } else if (data.startsWith("-")) {
            decrementQuantity(callbackQuery, bot);
        } else if (data.startsWith("basket")) {
            addToBasket(callbackQuery, bot);
            Maps.USER_STEPS.put(callbackQuery.getMessage().getChatId(), Steps.MENU);
        }

    }

    @SneakyThrows
    private static void addToBasket(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String[] params = callbackQuery.getData().split(";");
        BasketRepo.add(
                callbackQuery.getMessage().getChatId(), Long.parseLong(params[1]), Integer.parseInt(params[2]));
        SendMessage sendMessage =
                new SendMessage(callbackQuery.getMessage().getChatId().toString(),
                        "Product \"" + ProductRepo.PRODUCT_LIST.get(Integer.parseInt(params[1]) - 1).getName() +
                                "\" successfully added to the basket✅");
        bot.execute(sendMessage);
        ButtonUtilsOfMenu.back(callbackQuery.getMessage(), bot);
    }

    @SneakyThrows
    private static void incrementQuantity(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String[] params = callbackQuery.getData().split(";");
        InlineKeyboardMarkup inlineKeyboardMarkup = ButtonUtilsOfMenu.buildProductMarkup(
                Integer.parseInt(params[1]) + 1,
                Integer.parseInt(params[2])
        );

        EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                .replyMarkup(inlineKeyboardMarkup)
                .messageId(callbackQuery.getMessage().getMessageId())
                .chatId(callbackQuery.getMessage().getChatId())
                .inlineMessageId(callbackQuery.getInlineMessageId())
                .build();
        bot.execute(editMessageReplyMarkup);

    }

    private static void decrementQuantity(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) throws Exception {
        String[] params = callbackQuery.getData().split(";");
        if (!params[1].equals("1")) {
            InlineKeyboardMarkup markup = ButtonUtilsOfMenu.buildProductMarkup(
                    Integer.parseInt(params[1]) - 1,
                    Integer.parseInt(params[2])
            );

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .replyMarkup(markup)
                    .inlineMessageId(callbackQuery.getInlineMessageId())
                    .build();
            bot.execute(editMessageReplyMarkup);
        }
    }


}
