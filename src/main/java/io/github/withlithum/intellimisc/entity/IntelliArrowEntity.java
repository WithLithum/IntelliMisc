package io.github.withlithum.intellimisc.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;

public class IntelliArrowEntity extends ArrowEntity {

    public IntelliArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
        this.setDamage(5.0f);
    }

    public IntelliArrowEntity(World world, LivingEntity shooter) {
        super(world, shooter);
        this.setDamage(5.0f);
    }
}
