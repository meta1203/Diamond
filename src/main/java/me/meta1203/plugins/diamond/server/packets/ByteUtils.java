package me.meta1203.plugins.diamond.server.packets;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ByteUtils {
	public static byte[] concat(byte[] len, byte[] text)  {
		   int aLen = len.length;
		   int bLen = text.length;
		   byte[] C = Arrays.copyOf(len, len.length + text.length);
		   System.arraycopy(text, 0, C, aLen, bLen);
		   return C;
	}
	
	public static String readString(byte[] data) {
		short stringSize = ByteBuffer.wrap(Arrays.copyOfRange(data, 0, 2)).order(ByteOrder.BIG_ENDIAN).getShort();
		data = Arrays.copyOfRange(data, stringSize, data.length);
		return new String(Arrays.copyOfRange(data, 2, stringSize));
	}
	
	public static byte[] strToBuffer(String str) {
		byte[] len = ByteBuffer.allocate(2).putShort((short) str.length()).array();
		byte[] text = str.getBytes();
		return concat(len, text);
	}
	
	public static byte[] shortToBuffer(short shrt) {
		return ByteBuffer.allocate(2).putShort(shrt).array();
	}
	
	public static byte[] intToBuffer(int num) {
		return ByteBuffer.allocate(4).putInt(num).array();
	}
	
	public static byte[] doubleToBuffer(double val) {
		return ByteBuffer.allocate(8).putDouble(val).array();
	}
}
