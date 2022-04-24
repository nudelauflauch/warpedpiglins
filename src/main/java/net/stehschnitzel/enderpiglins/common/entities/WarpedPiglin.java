package net.stehschnitzel.enderpiglins.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinAction;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class WarpedPiglin extends PiglinEntity implements IAnimatable {
    protected AnimationFactory factory = new AnimationFactory(this);

    public WarpedPiglin(EntityType<? extends AbstractPiglinEntity> p_i231570_1_, World p_i231570_2_) {
        super(p_i231570_1_, p_i231570_2_);
        this.setImmuneToZombification(true);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, (double)0.35F).add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if (this.getArmPose() == PiglinAction.ADMIRING_ITEM) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ender_piglin.admire", true));
        } else if (this.getArmPose() == PiglinAction.ATTACKING_WITH_MELEE_WEAPON) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ender_piglin.attack", false));
        }
        else if (event.getLimbSwingAmount()  * event.getLimbSwingAmount() >= 0.003) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ender_piglin.move", true));
        } else if (this.isAggressive()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ender_piglin.agresiv.idle", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ender_piglin.idle", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<WarpedPiglin>(this, "main_controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
