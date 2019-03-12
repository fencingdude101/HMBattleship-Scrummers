package org.scrum.psd.battleship.controller.dto;


public class ShotResult {
	
	private boolean isHit;
	private Ship shipHit;
	
	public boolean isHit() {
		return isHit;
	}
	
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
	
	public Ship getShipHit() {
		return shipHit;
	}
	
	public void setShipHit(Ship shipHit) {
		this.shipHit = shipHit;
	}

}
