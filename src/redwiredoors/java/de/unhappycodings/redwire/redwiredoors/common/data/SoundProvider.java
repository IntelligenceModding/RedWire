package de.unhappycodings.redwire.redwiredoors.common.data;

import de.unhappycodings.redwire.redwiredoors.common.sound.ModSounds;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundProvider extends SoundDefinitionsProvider {

    protected SoundProvider(DataGenerator generator, String modId, ExistingFileHelper helper) {
        super(generator, modId, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.BIG_SLIDING_DOOR_CLOSE.getId(), SoundDefinition.definition()
                .with(sound(ModSounds.BIG_SLIDING_DOOR_CLOSE.getId()).attenuationDistance(6)));
        add(ModSounds.BIG_SLIDING_DOOR_OPEN.getId(), SoundDefinition.definition()
                .with(sound(ModSounds.BIG_SLIDING_DOOR_OPEN.getId()).attenuationDistance(6)));

        add(ModSounds.PLAYER_SENSOR_CLICK_ON.getId(), SoundDefinition.definition()
                .with(sound(ModSounds.PLAYER_SENSOR_CLICK_ON.getId()).attenuationDistance(5)));
        add(ModSounds.PLAYER_SENSOR_CLICK_OFF.getId(), SoundDefinition.definition()
                .with(sound(ModSounds.PLAYER_SENSOR_CLICK_OFF.getId()).attenuationDistance(5)));
    }

}
