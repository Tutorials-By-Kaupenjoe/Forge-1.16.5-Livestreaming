package net.tutorialbykaupenjoe.livestreammod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.tutorialbykaupenjoe.livestreammod.entity.projectile.MagicSpellEntity;

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
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
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
