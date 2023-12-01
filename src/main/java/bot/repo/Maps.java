package bot.repo;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Maps {
    public static Map<Long, Steps> USER_STEPS = new HashMap<>();

}
