package tech.dreamworld.mygba.cpu.instruction;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.memory.MemoryInterface;

public final class ARM_CP {

	public static void execute(ARM7TDMI cpu, MemoryInterface memory,
			int opcode) {
	}

	final static String InstructionName = "[ cp ]";

	public static String disassemble(ARM7TDMI cpu, MemoryInterface memory,
			int opcode, int offset) {
		return InstructionName;
	}
}
