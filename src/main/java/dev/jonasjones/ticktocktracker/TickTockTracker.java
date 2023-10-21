package dev.jonasjones.ticktocktracker;

import dev.jonasjones.ticktocktracker.util.TimeConverter;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static net.minecraft.server.command.CommandManager.literal;

public class TickTockTracker implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "ticktocktracker";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		final long startTime = System.currentTimeMillis();

		CommandRegistrationCallback.EVENT.register((dispatcher, environment) -> dispatcher.register(literal("uptime")
				.executes(context -> {
					context.getSource().sendFeedback(new LiteralText("Uptime: " + TimeConverter.convertMillisToDuration(System.currentTimeMillis() - startTime)), false);
					//context.getSource().sendMessage(Text.literal("Uptime: " + TimeConverter.convertMillisToDuration(System.currentTimeMillis() - startTime)));
					return 1;
				})));

	}
}