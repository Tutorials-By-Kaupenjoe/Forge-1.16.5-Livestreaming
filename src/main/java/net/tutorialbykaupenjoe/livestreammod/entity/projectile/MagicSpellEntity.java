package net.tutorialbykaupenjoe.livestreammod.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;
import net.tutorialbykaupenjoe.livestreammod.entity.ModEntityTypes;

public class MagicSpellEntity extends AbstractArrowEntity {

    public MagicSpellEntity(EntityType<? extends MagicSpellEntity> entityEntityType, World world) {
        super(ModEntityTypes.MAGIC_SPELL.get(), world);
    }

    public MagicSpellEntity(World world, LivingEntity shooter) {
        super(ModEntityTypes.MAGIC_SPELL.get(), shooter, world);
    }

    public IPacket<?> createSpawnPacket() {
        Entity entity = this.getShooter();
        return new SSpawnObjectPacket(this, entity == null ? 0 : entity.getEntityId());
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.AIR);
    }
}
