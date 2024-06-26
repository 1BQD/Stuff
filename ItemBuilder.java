package de.bqd1.example;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {
    private ItemMeta itemMeta;
    private ItemStack itemStack;
    public ItemBuilder(Material mat){
        itemStack = new ItemStack(mat);
        itemMeta = itemStack.getItemMeta();
    }
    public ItemBuilder setDisplayname(String s){
        itemMeta.setDisplayName(s);
        return this;
    }
    public ItemBuilder setLocalizedName(String s){
        itemMeta.setLocalizedName(s);
        return this;
    }
    public ItemBuilder setLore(String... s){
        itemMeta.setLore(Arrays.asList(s));
        return this;
    }
    public ItemBuilder setUnbreakable(boolean s){
        itemMeta.setUnbreakable(s);
        return this;
    }
    public ItemBuilder addItemFlags(ItemFlag... s){
        itemMeta.addItemFlags(s);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment ench, int level) {
        itemStack.addEnchantment(ench, level);
        return this;
    }

    public ItemBuilder setSkullOwner(String playerName) {
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwner(playerName);
        return this;
    }

    public ItemBuilder setGlowing(boolean glowing) {
        if (glowing) {
            itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            itemMeta.removeEnchant(Enchantment.ARROW_INFINITE);
            itemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }





    @Override
    public String toString() {
        return "ItemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

