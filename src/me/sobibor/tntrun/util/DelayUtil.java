package me.sobibor.tntrun.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Рейдж 17.07.2021
 * @project TNTRUN2
 */
public class DelayUtil {

    private static final Map<UUID, Long> slimeCD = Maps.newHashMap();

    public static boolean hasCountdown(UUID user) {
        Long data = slimeCD.get(user);
        return data != null && data > System.currentTimeMillis();
    }

    public static void setCountdown(UUID user, int val) {
        slimeCD.put(user, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(val));
    }

    public static long getSecondsLeft(UUID user) {
        return TimeUnit.SECONDS.toSeconds(slimeCD.get(user) - System.currentTimeMillis());
    }
}
