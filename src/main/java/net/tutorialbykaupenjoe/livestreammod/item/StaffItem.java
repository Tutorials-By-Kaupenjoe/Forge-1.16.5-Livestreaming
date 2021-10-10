package net.tutorialbykaupenjoe.livestreammod.item;

import net.minecraft.advancements.Advancement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.entity.projectile.MagicSpellEntity;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class StaffItem extends ShootableItem {
    public StaffItem(Properties properties) {
        super(properties);
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;

            if (!worldIn.isRemote) {
                int i = this.getUseDuration(stack) - timeLeft;
                float f = getArrowVelocity(i);

                MagicSpellEntity magicSpell = new MagicSpellEntity(worldIn, playerentity);
                magicSpell.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw,
                        0.0F, f * 3.0F, 1.0F);

                stack.damageItem(1, playerentity, (player) -> {
                    player.sendBreakAnimation(playerentity.getActiveHand());
                });

                worldIn.addEntity(magicSpell);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(entityIn instanceof PlayerEntity) {
            if(!worldIn.isRemote) {
                ServerPlayerEntity player = ((ServerPlayerEntity) entityIn);
                if(!stack.hasTag()) {
                    if(player.getAdvancements().getProgress(Advancement.Builder.builder().
                                    build(new ResourceLocation("story/lava_bucket"))).isDone()) {
                        CompoundNBT tag = new CompoundNBT();
                        tag.putBoolean(LivestreamMod.MOD_ID + ".hadAdvancement", true);
                        stack.setTag(tag);
                    }
                }
            }
        }

        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn,
                               List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if(stack.hasTag()) {
            if(stack.hasTag() && stack.getTag().getBoolean(LivestreamMod.MOD_ID + ".hadAdvancement")) {
                tooltip.add(new StringTextComponent("You are a poopyhead!"));
            }
        } else {
            tooltip.add(new StringTextComponent("The secrets of the Staff have not been revealed!"));
        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Here we can add effects on hit with this weapon to the target
        attacker.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60));
        target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 200, 2));
        return super.hitEntity(stack, target, attacker);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(itemstack);
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (itemStack) -> true;
    }

    @Override
    public int func_230305_d_() {
        return 15;
    }
}
