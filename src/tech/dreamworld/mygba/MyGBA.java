package tech.dreamworld.mygba;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.dma.DirectMemoryAccess;
import tech.dreamworld.mygba.gfx.GFX;
import tech.dreamworld.mygba.memory.Memory;
import tech.dreamworld.mygba.time.Time;

public final class MyGBA {

	private ARM7TDMI cpu;
	private Memory memory;
	private DirectMemoryAccess dma;
	private GFX gfx;
	private Time time;

	private MyGBACore mygbaCore;
	private Thread ygbaThread;

	public MyGBA() {
		cpu = new ARM7TDMI();
		memory = new Memory();
		dma = new DirectMemoryAccess();
		gfx = new GFX();
		time = new Time();

		mygbaCore = new MyGBACore(cpu, memory, time);
		ygbaThread = null;

		setupConnections();
	}

	private void setupConnections() {
		cpu.connectToMemory(memory);
		memory.connectToDMA(dma);
		memory.connectToGraphics(gfx);
		memory.connectToTime(time);
		dma.connectToMemory(memory);
		gfx.connectToMemory(memory);
		time.connectToMemory(memory);
	}

	public ARM7TDMI getCPU() {
		return cpu;
	}

	public Memory getMemory() {
		return memory;
	}

	public DirectMemoryAccess getDMA() {
		return dma;
	}

	public GFX getGraphics() {
		return gfx;
	}

	public Time getTime() {
		return time;
	}

	public void reset() {
		cpu.reset();
		memory.reset();
		dma.reset();
		gfx.reset();
		time.reset();

		ygbaThread = null;

		System.gc();
	}

	public void run() {
		ygbaThread = new Thread(mygbaCore);
		ygbaThread.setPriority(Thread.NORM_PRIORITY);
		ygbaThread.start();
	}

	public void stop() {
		if (ygbaThread != null) {
			mygbaCore.stop();
			try {
				ygbaThread.join();
			} catch (InterruptedException e) {
			}
			ygbaThread = null;
		}
	}

	public boolean isReady() {
		return (memory.isBIOSLoaded() && memory.isROMLoaded());
	}

}
