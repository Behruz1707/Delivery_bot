package bot.command_enum;


import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum CommandEnum {
    START("/start"),
    HELP("/help");
    public final String value;

    CommandEnum(String value) {
        this.value = value;
    }

    private static final Map<String, CommandEnum> MAP = Arrays.stream(CommandEnum.values())
            .collect(Collectors.toMap(CommandEnum::getValue, commandEnum -> commandEnum));

    @SneakyThrows
    public static CommandEnum of(String command){
        final CommandEnum commandEnum = MAP.get(command);
        if(commandEnum == null){
            throw new IllegalAccessException("Unsupported command.");
        }
        return commandEnum;
    }
}
