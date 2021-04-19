package net.test.mod;



import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;

import net.minecraft.sound.SoundEvent;
import net.minecraft.block.Block;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class TestMod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(ItemGroup.MISC));
    
    public static final Block FABRIC_BLOCK = new FabricBlock();
    public static final Identifier MY_SOUND_ID = new Identifier("testmod:calculated");
    public static SoundEvent MY_SOUND_EVENT = new SoundEvent(MY_SOUND_ID);
    public static final String MODID = "testmod";


  
    @Override
    public void onInitialize(){
        Registry.register(Registry.ITEM, new Identifier(MODID,"fabric_item"), FABRIC_ITEM);

        Registry.register(Registry.BLOCK,new Identifier(MODID,"fabric_block"), FABRIC_BLOCK);

        Registry.register(Registry.SOUND_EVENT, TestMod.MY_SOUND_ID, MY_SOUND_EVENT);

        Registry.register(Registry.ITEM,new Identifier(MODID,"fabric_block"),new BlockItem(FABRIC_BLOCK, new Item.Settings().group(ItemGroup.MISC).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).snack().meat().statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*3),0.5f).build())));

        Registry.register(Registry.ITEM,new Identifier(MODID,"gunpowder_pickaxe"),new GunPowderPickaxe(new GunPowderMaterial(),20,1.2F,new Item.Settings().group(ItemGroup.TOOLS)));
   
    }


  
}