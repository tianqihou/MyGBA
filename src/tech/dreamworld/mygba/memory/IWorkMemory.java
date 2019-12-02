package tech.dreamworld.mygba.memory;

public final class IWorkMemory extends MemoryManager_8_16_32 {

	public IWorkMemory() {
		// 32K
		super("Internal Work RAM", 0x8000);
	}

}
