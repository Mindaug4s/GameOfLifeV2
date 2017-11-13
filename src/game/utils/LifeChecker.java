package game.utils;

import java.util.Arrays;

import game.engine.TheCell;

public class LifeChecker {

	public static boolean checkIfAnyCellAlive(TheCell[][] currentCells) {

		return Arrays.stream(currentCells).flatMap(Arrays::stream).anyMatch(x -> x.getCellLifeStatus() == true);
	}

}
