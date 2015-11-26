package com.schulace.landminemod.proxy;

import com.schulace.landminemod.init.LandMineModBlocks;
import com.schulace.landminemod.init.LandMineModItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		LandMineModItems.registerRenders();
		LandMineModBlocks.registerRenders();
	}
	
}
