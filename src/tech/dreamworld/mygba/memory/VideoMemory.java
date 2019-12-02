package tech.dreamworld.mygba.memory;

public final class VideoMemory extends MemoryManager_16_32 {

	public VideoMemory() {
		// 96K
		super("Video RAM", 0x18000);
	}

	@Override
	public int getInternalOffset(int offset) {
		return ((offset & 0x00FFFFFF) % size);
	}

}
