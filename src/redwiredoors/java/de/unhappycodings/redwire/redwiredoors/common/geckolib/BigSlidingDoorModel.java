package de.unhappycodings.redwire.redwiredoors.common.geckolib;

import de.unhappycodings.redwire.redwiredoors.RedwireDoors;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BigSlidingDoorModel<T extends IAnimatable> extends AnimatedGeoModel<T> {

    @Override
    public ResourceLocation getModelResource(T object) {
        return new ResourceLocation(RedwireDoors.MOD_ID, "geo/models/big_sliding_door.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return new ResourceLocation(RedwireDoors.MOD_ID, "geo/textures/big_sliding_door");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(RedwireDoors.MOD_ID, "animations/models/big_sliding_door.animation.json");
    }
}
