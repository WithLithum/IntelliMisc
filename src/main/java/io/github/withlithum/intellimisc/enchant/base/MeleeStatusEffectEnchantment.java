package io.github.withlithum.intellimisc.enchant.base;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enchantment that inflicts status effect to the target.
 */
public class MeleeStatusEffectEnchantment extends BaseEnchantment {
    public static final class Builder {
        private int effectDurationBase;
        private int effectLevelAmplifier;
        private boolean isTreasure;
        private boolean isCursed;
        private int maxLevel;
        private final List<EquipmentSlot> slotTypes = new ArrayList<>();
        private EnchantmentTarget target;
        private StatusEffect effect;
        private Rarity rarity;

        public Builder effectDurationBase(int value) {
            effectDurationBase = value;
            return this;
        }

        public Builder effectLevelAmplifier(int value) {
            effectLevelAmplifier = value;
            return this;
        }

        public Builder treasure() {
            isTreasure = true;
            return this;
        }

        public Builder cursed() {
            isCursed = true;
            return this;
        }

        public Builder rarity(Rarity value) {
            rarity = value;
            return this;
        }

        public Builder target(EnchantmentTarget value) {
            this.target = value;
            return this;
        }

        public Builder maxLevel(int value) {
            this.maxLevel = value;
            return this;
        }

        public Builder statusEffect(StatusEffect effect) {
            this.effect = effect;
            return this;
        }

        public Builder slot(EquipmentSlot value) {
            slotTypes.add(value);
            return this;
        }

        public MeleeStatusEffectEnchantment build() {
            return new MeleeStatusEffectEnchantment(
                    rarity,
                    target,
                    slotTypes.toArray(new EquipmentSlot[0]),
                    effect,
                    effectDurationBase,
                    effectLevelAmplifier,
                    isTreasure,
                    isCursed,
                    maxLevel
            );
        }
    }

    private final StatusEffect effect;

    /**
     * Backing field of {@code effectDurationBase()}.
     */
    private final int internalEffectDurationBase;

    /**
     * Backing field of {@code effectLevelAmplifier()}.
     */
    private final int internalEffectLevelAmplifier;

    public MeleeStatusEffectEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes, StatusEffect effect,
                                        int effectDurationBase, int effectLevelAmplifier, boolean isTreasure, boolean isCursed,
                                        int maxLevel) {
        super(weight, type, slotTypes, isTreasure, isCursed, maxLevel);
        this.effect = effect;
        this.internalEffectDurationBase = effectDurationBase;
        this.internalEffectLevelAmplifier = effectLevelAmplifier;
    }

    public int effectDurationBase() {
        return internalEffectDurationBase;
    }

    public int effectLevelAmplifier() {
        return internalEffectLevelAmplifier;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(effect,
                    effectDurationBase() * (2 * level),
                    (level * effectLevelAmplifier()) - 1));
        }

        super.onTargetDamaged(user, target, level);
    }
}
