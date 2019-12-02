package tech.dreamworld.mygba.memory;

public final class PaletteMemory extends MemoryManager_16_32 {

	public PaletteMemory() {
		// 调色板 1K
		super("Palette RAM", 0x400);
	}

}
