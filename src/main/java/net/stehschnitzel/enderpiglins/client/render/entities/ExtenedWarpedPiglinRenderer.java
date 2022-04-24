package net.stehschnitzel.enderpiglins.client.render.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.stehschnitzel.enderpiglins.common.entities.WarpedPiglin;
import software.bernie.example.client.DefaultBipedBoneIdents;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;

import javax.annotation.Nullable;

public class ExtenedWarpedPiglinRenderer extends ExtendedGeoEntityRenderer<WarpedPiglin> {

    protected ExtenedWarpedPiglinRenderer(EntityRendererManager renderManager) {
        super(renderManager, new WarpedPiglinModel());
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String boneName, WarpedPiglin currentEntity) {
        return null;
    }

    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, WarpedPiglin currentEntity) {
        if (boneName == DefaultBipedBoneIdents.LEFT_HAND_BONE_IDENT) {
            return mainHand;
        }
        return null;
    }

    @Override
    protected ItemCameraTransforms.TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        return ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND;
    }

    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, WarpedPiglin currentEntity) {
        return null;
    }

    @Override
    protected void preRenderItem(MatrixStack stack, ItemStack item, String boneName, WarpedPiglin currentEntity, IBone bone) {
        if (item == this.mainHand || item == this.offHand) {
            stack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            boolean shieldFlag = item.isShield(currentEntity) || item.getItem() instanceof ShieldItem;
            if (item == this.mainHand) {
                if (shieldFlag) {
                    stack.translate(0.0, 0.125, -0.25);
                }
            } else {
                if (shieldFlag) {
                    stack.translate(0, 0.125, 0.25);
                    stack.mulPose(Vector3f.YP.rotationDegrees(180));
                }
            }
        }
    }

    @Override
    protected void preRenderBlock(BlockState block, String boneName, WarpedPiglin currentEntity) {

    }

    @Override
    protected void postRenderItem(MatrixStack matrixStack, ItemStack item, String boneName, WarpedPiglin currentEntity, IBone bone) {

    }

    @Override
    protected void postRenderBlock(BlockState block, String boneName, WarpedPiglin currentEntity) {

    }

    @Nullable
    @Override
    protected EquipmentSlotType getEquipmentSlotForArmorBone(String boneName, WarpedPiglin currentEntity) {
        return null;
    }


}
