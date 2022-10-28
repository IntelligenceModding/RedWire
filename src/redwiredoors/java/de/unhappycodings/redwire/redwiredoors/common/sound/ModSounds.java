package de.unhappycodings.redwire.redwiredoors.common.sound;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import de.unhappycodings.redwire.redwiredoors.common.registration.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final RegistryObject<SoundEvent> BIG_SLIDING_DOOR_CLOSE =
            Registration.SOUND_EVENTS.register("tile.door.big_sliding_door.close",
                    () -> new SoundEvent(new ResourceLocation(RedwireDoors.MOD_ID, "tile.door.big_sliding_door.close")));

    public static final RegistryObject<SoundEvent> BIG_SLIDING_DOOR_OPEN =
            Registration.SOUND_EVENTS.register("tile.door.big_sliding_door.open",
                    () -> new SoundEvent(new ResourceLocation(RedwireDoors.MOD_ID, "tile.door.big_sliding_door.open")));

    public static final RegistryObject<SoundEvent> PLAYER_SENSOR_CLICK_ON =
            Registration.SOUND_EVENTS.register("tile.door.player_sensor.on",
                    () -> new SoundEvent(new ResourceLocation(RedwireDoors.MOD_ID, "tile.door.player_sensor.on")));

    public static final RegistryObject<SoundEvent> PLAYER_SENSOR_CLICK_OFF =
            Registration.SOUND_EVENTS.register("tile.door.player_sensor.off",
                    () -> new SoundEvent(new ResourceLocation(RedwireDoors.MOD_ID, "tile.door.player_sensor.off")));

    public static void register() {
    }

}
