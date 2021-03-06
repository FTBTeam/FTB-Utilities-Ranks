package dev.ftb.mods.ftbranks;

import dev.ftb.mods.ftbranks.api.FTBRanksAPI;
import dev.ftb.mods.ftbranks.impl.FTBRanksAPIImpl;
import me.shedaniel.architectury.event.events.ChatEvent;
import me.shedaniel.architectury.event.events.CommandRegistrationEvent;
import me.shedaniel.architectury.event.events.LifecycleEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author LatvianModder
 */
public class FTBRanks {
	public static final String MOD_ID = "ftbranks";
	public static final Logger LOGGER = LogManager.getLogger("FTB Ranks");

	public FTBRanks() {
		FTBRanksAPI.INSTANCE = new FTBRanksAPIImpl();
		LifecycleEvent.SERVER_BEFORE_START.register(FTBRanksAPIImpl::serverAboutToStart);
		LifecycleEvent.SERVER_STARTED.register(FTBRanksAPIImpl::serverStarted);
		LifecycleEvent.SERVER_STOPPED.register(FTBRanksAPIImpl::serverStopped);
		LifecycleEvent.SERVER_WORLD_SAVE.register(FTBRanksAPIImpl::worldSaved);
		LifecycleEvent.SERVER_STARTING.register(FTBRanksAPIImpl::serverStarting);
		CommandRegistrationEvent.EVENT.register(FTBRanksCommands::register);
		// TODO: Register with LOWEST priority on forge
		ChatEvent.SERVER.register(FTBRanksAPIImpl::serverChat);
	}
}