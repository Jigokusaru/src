package com.jigokusaru.testmod.proxy;

import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders(){
		
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		
	}
}
