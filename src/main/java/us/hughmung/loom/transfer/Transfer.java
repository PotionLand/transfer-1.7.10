package us.hughmung.loom.transfer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SideOnly(Side.CLIENT)
@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.7.10]")
public class Transfer {

    public static ExecutorService SERVICE;
    public static SimpleNetworkWrapper CHANNEL;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SERVICE = Executors.newCachedThreadPool();

        CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("loom:transfer");
        CHANNEL.registerMessage(InTransferRequest.Handler.class, InTransferRequest.class, 0, Side.CLIENT);
    }
}