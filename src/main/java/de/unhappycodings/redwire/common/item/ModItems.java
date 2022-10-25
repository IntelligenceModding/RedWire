package de.unhappycodings.redwire.common.item;

import de.unhappycodings.redwire.common.registration.Registration;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<LinkingCardItem> LINKING_CARD = Registration.ITEMS.register("linking_card", LinkingCardItem::new);

    public static void register() {
    }

}
