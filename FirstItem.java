package fr.mattmouss.SwitchRail.item;

import fr.mattmouss.SwitchRail.SwitchRailMod;
import net.minecraft.item.Item;

public class FirstItem extends Item {
    public FirstItem() {
        super(new Properties()
                .group(SwitchRailMod.setup.itemGroup)
                .maxStackSize(1));
        setRegistryName("firstitem");
    }
}
