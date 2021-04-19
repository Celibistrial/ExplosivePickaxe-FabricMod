package net.test.mod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GunPowderPickaxe extends PickaxeItem {
    protected GunPowderPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {

        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {

            TntEntity tntEntity = new TntEntity(EntityType.TNT,world);
            user.sendMessage(new LiteralText(String.valueOf(user.getHorizontalFacing())), false);
            switch (String.valueOf(user.getHorizontalFacing())){
                case "south":
                    tntEntity.updatePosition(user.getX(), user.getY(),user.getZ()+2);
                    break;
                case "north":
                    tntEntity.updatePosition(user.getX(), user.getY(),user.getZ()-2);
                    break;
                case "west":
                    tntEntity.updatePosition(user.getX()-2, user.getY(),user.getZ());
                    break;
                case "east":
                    tntEntity.updatePosition(user.getX()+2, user.getY(),user.getZ());
                    break;

            }
            //itemStack.damage(2,0.7f, ServerPlayerEntity);
            Item item = itemStack.getItem();
            world.spawnEntity(tntEntity);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


}
