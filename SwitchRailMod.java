package fr.mattmouss.SwitchRail;


import fr.mattmouss.SwitchRail.blocks.ModBlock;
import fr.mattmouss.SwitchRail.blocks.Switch;
import fr.mattmouss.SwitchRail.item.FirstItem;
import fr.mattmouss.SwitchRail.setup.ClientProxy;
import fr.mattmouss.SwitchRail.setup.IProxy;
import fr.mattmouss.SwitchRail.setup.ModSetup;
import fr.mattmouss.SwitchRail.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.logging.Logger;

@Mod(SwitchRailMod.MODID)
public class SwitchRailMod {

    public static IProxy proxy = DistExecutor.runForDist(()->()-> new ClientProxy(),()->()->new ServerProxy());

    public static final String MODID = "switchrail";

    public static ModSetup setup = new ModSetup();

    public static final Logger logger =  Logger.getLogger(MODID);

    public SwitchRailMod (){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);



    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();

        proxy.init();

    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().register(new Switch());
        }


        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> blockRegistryEvent) {
            Item.Properties properties =new Item.Properties()
                    .group(setup.itemGroup)
                    .maxStackSize(64);
            blockRegistryEvent.getRegistry().register(new BlockItem(ModBlock.FIRSTSWITCH,properties).setRegistryName("switch"));
            blockRegistryEvent.getRegistry().register(new FirstItem());
        }
    }
}
