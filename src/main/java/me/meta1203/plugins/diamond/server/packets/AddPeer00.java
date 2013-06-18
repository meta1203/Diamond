package me.meta1203.plugins.diamond.server.packets;

import java.io.IOException;
import java.io.InputStream;

public class AddPeer00 extends Packet {
	public String ip;
	private int maxlength = 32769;
	
	public AddPeer00(String ip) {
		this.ip = ip;
	}
	
	@Override
	public byte getId() {
		return 0;
	}
	
	@Override
	public Packet parsePacket(InputStream in) {
		byte[] buffer = new byte[maxlength];
		try {
			in.read(buffer);
			this.ip = ByteUtils.readString(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public byte[] genData() {
		return ByteUtils.strToBuffer(ip);
	}

}
