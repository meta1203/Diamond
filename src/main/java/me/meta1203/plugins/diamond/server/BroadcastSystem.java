package me.meta1203.plugins.diamond.server;

import java.util.List;

public class BroadcastSystem {
	private List<String> peerAddresses;
	
	public BroadcastSystem(List<String> peers) {
		peerAddresses = peers;
	}
	
	public void addPeer(String addr) {
		if (this.peerAddresses.contains(addr)) {
			return;
		}
		this.peerAddresses.add(addr);
	}
	
	public void sendData() {
		
	}
}
