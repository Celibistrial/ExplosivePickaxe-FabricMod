package net.test.mod;



import java.util.Random;

import com.ibm.icu.impl.ICUService.Key;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FabricBlock extends Block {
    Random rand = new Random();
    public FabricBlock() {
        super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(2, 0.9f).requiresTool());

 
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("CALCULATED!!!"), false);
            int x = rand.nextInt(1000);
            String y = String.valueOf(x);
            player.sendMessage(new LiteralText(y), false);
            player.damage(DamageSource.FALL, 2F);
            world.playSound(null, pos, TestMod.MY_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);



        }
 
        return ActionResult.SUCCESS;
    }
}
