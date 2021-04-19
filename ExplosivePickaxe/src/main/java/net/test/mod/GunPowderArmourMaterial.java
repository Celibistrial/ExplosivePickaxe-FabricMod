package net.test.mod;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class GunPowderArmourMaterial implements ArmorMaterial {
    @Override
    public int getDurability(EquipmentSlot slot) {
        return 500;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 500;
    }

    @Override
    public int getEnchantability() {
        return 500;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.GUNPOWDER);
    }

    @Override
    public String getName() {
        return "GunPowder";
    }

    @Override
    public float getToughness() {
        return 500;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
