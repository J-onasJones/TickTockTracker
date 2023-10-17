package dev.jonasjones.ticktocktracker.util;

import java.util.concurrent.TimeUnit;

public class TimeConverter {
    public static String convertMillisToDuration(long millis) {
        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder duration = new StringBuilder();
        if (days > 0) {
            duration.append(days).append(" Days, ");
        }
        if (hours > 0 || days > 0) {
            if (hours == 1) {
                duration.append(hours).append(" Hour, ");
            } else {
                duration.append(hours).append(" Hours, ");
            }
        }
        if (minutes > 0 || hours > 0 || days > 0) {
            if (minutes == 1) {
                duration.append(minutes).append(" Minute, ");
            } else {
                duration.append(minutes).append(" Minutes, ");
            }
        }
        if (seconds > 0 || minutes > 0 || hours > 0 || days > 0) {
            if (seconds == 1) {
                duration.append(seconds).append(" Second");
            } else {
                duration.append(seconds).append(" Seconds");
            }
        }

        return duration.toString();
    }
}
