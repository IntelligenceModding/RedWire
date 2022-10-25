package de.unhappycodings.redwire.redwirelampsandlighting.common.item;

import de.unhappycodings.redwire.redwirelampsandlighting.RedwireLampsAndLighting;
import de.unhappycodings.redwire.redwirelampsandlighting.common.registration.Registration;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> LUMINOUS_DUST =
            Registration.ITEMS.register("luminous_dust",
                    () -> new Item(new Item.Properties().tab(RedwireLampsAndLighting.creativeTab)));

    public static void register() {
    }

}