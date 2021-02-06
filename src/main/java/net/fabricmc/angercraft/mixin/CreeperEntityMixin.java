package net.fabricmc.angercraft.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin extends HostileEntity  {

    public CreeperEntityMixin(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    public void tickMovement() {
        if (this.isAlive()) {
            boolean bl = this.isAffectedByDaylight();
            if (bl) {
                this.setOnFireFor(8);
            }
        }
        super.tickMovement();
    }
}
