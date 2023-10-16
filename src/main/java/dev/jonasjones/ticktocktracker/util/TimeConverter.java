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
            duration.append(String.format("%02d", hours)).append(" Hours,");
        }
        if (minutes > 0 || hours > 0 || days > 0) {
            duration.append(String.format("%02d", minutes)).append(" Minutes,");
        }
        duration.append(String.format("%02d", seconds)).append(" Seconds");

        return duration.toString();
    }
}
