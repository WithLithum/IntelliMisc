package io.github.withlithum.intellimisc.item;

import io.github.withlithum.intellimisc.entity.IntelliArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IntelliArrow extends Item {
    public IntelliArrow(Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        var arrow = new IntelliArrowEntity(world, shooter);
        arrow.initFromStack(stack);
        return arrow;
    }
}
