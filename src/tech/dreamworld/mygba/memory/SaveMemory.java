package tech.dreamworld.mygba.memory;

public final class SaveMemory extends MemoryManager_8 {

	public SaveMemory() {
		// 128K
		super("Save RAM", 0x20000);
	}

}
