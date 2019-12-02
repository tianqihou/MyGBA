package tech.dreamworld.mygba.memory;

public final class EWorkMemory extends MemoryManager_8_16_32 {

	public EWorkMemory() {
		// 256K
		super("External Work RAM", 0x40000);
	}

}
