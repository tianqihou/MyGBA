package tech.dreamworld.mygba.cpu.instruction;

import tech.dreamworld.mygba.cpu.ARM7TDMI;
import tech.dreamworld.mygba.memory.MemoryInterface;
import tech.dreamworld.mygba.util.Hex;

public final class ARM_13 {

	public static void execute(ARM7TDMI cpu, MemoryInterface memory,
			int opcode) {
		if (!ARMState.isPreconditionSatisfied(cpu, opcode))
			return;

		cpu.generateSoftwareInterrupt(cpu.getCurrentPC());
	}

	final static String InstructionName = "swi";

	public static String disassemble(ARM7TDMI cpu, MemoryInterface memory,
			int opcode, int offset) {
		String cond = ARMState.getPreconditionSuffix(opcode);

		return InstructionName + cond + " "
				+ Hex.toHexString(opcode & 0x00FFFFFF, Hex.Bit_24);
	}

}
