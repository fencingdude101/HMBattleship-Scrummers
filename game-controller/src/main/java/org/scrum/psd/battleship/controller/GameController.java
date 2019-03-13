package org.scrum.psd.battleship.controller;

import org.scrum.psd.battleship.controller.dto.Color;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;
import org.scrum.psd.battleship.controller.dto.ShotResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameController {
	
    public static ShotResult checkIsHit(Collection<Ship> ships, Position shot) {
        if (ships == null) {
            throw new IllegalArgumentException("ships is null");
        }

        if (shot == null) {
            throw new IllegalArgumentException("shot is null");
        }

        ShotResult shotResult = new ShotResult();
        
        for (Ship ship : ships) {
            for (Position position : ship.getPositions()) {
                if (position.equals(shot)) {
                	position.setHit(true);
                	shotResult.setHit(true);
                	shotResult.setShipHit(ship);
                    return shotResult;
                }
            }
        }

        return shotResult;
    }
    
    
    public static Collection<Ship> getRemainingShips(Collection<Ship> ships){
    	List<Ship> remainingShips = new ArrayList<>();
    	
    	for (Ship ship : ships) {
            if(!ship.isSunk()){
            	remainingShips.add(ship);
            }
        }
    	return remainingShips;
    }
    
    public static boolean checkGameLost(Collection<Ship> ships) {
        
    	boolean lost = true;

        for (Ship ship : ships) {
            
        	if (ship.isSunk() == false) {
        		
        		lost = false;
        		
        	}
        	
        }

        return lost;
    }

    public static List<Ship> initializeShips() {
        return Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE),
                new Ship("Battleship", 4, Color.RED),
                new Ship("Submarine", 3, Color.CHARTREUSE),
                new Ship("Destroyer", 3, Color.YELLOW),
                new Ship("Patrol Boat", 2, Color.ORANGE));
    }

    public static boolean isShipValid(Ship ship) {
        return ship.getPositions().size() == ship.getSize();
    }

    public static Position getRandomPosition(int size) {
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(size)];
        int number = random.nextInt(size);
        Position position = new Position(letter, number);
        return position;
    }
}
