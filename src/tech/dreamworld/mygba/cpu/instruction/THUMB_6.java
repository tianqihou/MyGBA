package tech.dreamworld.mygba.cpu.instruction;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.memory.MemoryInterface;
import tech.dreamworld.mygba.util.Hex;

public final class THUMB_6 {

	public static void execute(ARM7TDMI cpu, MemoryInterface memory,
			int opcode) {
		// LDR Rd, [PC, #nn]
		int rdIndex = (opcode >>> 8) & 0x0007;
		int offset = (cpu.getPC() & 0xFFFFFFFC) + ((opcode & 0x00FF) << 2);
		cpu.setRegister(rdIndex, memory.loadWord(offset));
	}

	final static String InstructionName = "ldr";

	public static String disassemble(ARM7TDMI cpu, MemoryInterface memory,
			int opcode, int offset) {
		String rd = cpu.getRegisterName((opcode >>> 8) & 0x0007);
		String pc = cpu.getRegisterName(ARM7TDMI.PC);
		int off = (opcode & 0x00FF) << 2;

		return InstructionName + " " + rd + ", [" + pc + ", "
				+ Hex.toHexString(off, Hex.Bit_12) + "]";
	}

}
