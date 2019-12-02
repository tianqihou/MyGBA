package tech.dreamworld.mygba.cpu.instruction;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.memory.MemoryInterface;
import tech.dreamworld.mygba.util.Hex;

public final class THUMB_17 {

	public static void execute(ARM7TDMI cpu, MemoryInterface memory,
			int opcode) {
		// SWI nn
		cpu.generateSoftwareInterrupt(cpu.getCurrentPC());
	}

	final static String InstructionName = "swi";

	public static String disassemble(ARM7TDMI cpu, MemoryInterface memory,
			int opcode, int offset) {
		int comment = opcode & 0x00FF;

		return InstructionName + " " + Hex.toHexString(comment, Hex.Byte);
	}

}
