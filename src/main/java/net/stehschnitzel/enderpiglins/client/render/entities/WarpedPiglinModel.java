package net.stehschnitzel.enderpiglins.client.render.entities;

import net.minecraft.entity.monster.piglin.PiglinAction;
import net.minecraft.util.ResourceLocation;
import net.stehschnitzel.enderpiglins.WarpedPiglinMain;
import net.stehschnitzel.enderpiglins.common.entities.WarpedPiglin;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class WarpedPiglinModel extends AnimatedGeoModel<WarpedPiglin> {
    @Override
    public ResourceLocation getModelLocation(WarpedPiglin object) {
        return new ResourceLocation(WarpedPiglinMain.MOD_ID, "geo/warped_piglin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WarpedPiglin object) {
        return new ResourceLocation(WarpedPiglinMain.MOD_ID, "textures/warped_piglin.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WarpedPiglin animatable) {
        return new ResourceLocation(WarpedPiglinMain.MOD_ID, "animations/warped_piglin.animation.json");
    }

    @Override
    public void setLivingAnimations(WarpedPiglin entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        if (entity.getArmPose() != PiglinAction.ADMIRING_ITEM) {
            super.setLivingAnimations(entity, uniqueID, customPredicate);
            IBone head = this.getAnimationProcessor().getBone("head");
            assert customPredicate != null;
            EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
