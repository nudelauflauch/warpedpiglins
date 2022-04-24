package net.stehschnitzel.enderpiglins.client.render.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.stehschnitzel.enderpiglins.common.entities.WarpedPiglin;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class WarpedPiglinRenderer extends GeoEntityRenderer<WarpedPiglin> {
    public WarpedPiglinRenderer(EntityRendererManager renderManager) {
        super(renderManager, new WarpedPiglinModel());

    }

    @Override
    public void render(WarpedPiglin entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int packedLight) {
        stack.pushPose();
        stack.translate(1, 1, 1);

        if (entity.isBaby()) {
            stack.scale(0.3F, 0.3F, 0.3F);
        }
        //if (mainHand != null) {
        //    Minecraft.getInstance().getItemRenderer().renderStatic(mainHand, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, packedLight, 0, stack, buffer);
        //}
        stack.popPose();

        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);
    }
}

