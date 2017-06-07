package com.jigokusaru.testmod.proxy;

import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.init.ModTools;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders(){
		
		ModItems.registerRenders();
		ModTools.registerRenders();
		ModBlocks.registerRenders();
		
	}
}
