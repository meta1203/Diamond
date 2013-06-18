package me.meta1203.plugins.diamond.server.packets;

import java.io.InputStream;

public abstract class Packet {
	public byte getId() {
		return 0;
	}
	public abstract Packet parsePacket(InputStream in);
	public abstract byte[] genData();
}
