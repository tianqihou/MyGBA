package tech.dreamworld.mygba.cpu.instruction;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.memory.MemoryInterface;

public final class THUMB_Und {

	public static void execute(ARM7TDMI cpu, MemoryInterface memory,
			int opcode) {
		cpu.generateUndefinedInstructionInterrupt(cpu.getCurrentPC());
	}

	final static String InstructionName = "[ undefined ]";

	public static String disassemble(ARM7TDMI cpu, MemoryInterface memory,
			int opcode, int offset) {
		return InstructionName;
	}

}
