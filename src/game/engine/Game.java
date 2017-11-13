package game.engine;

import game.utils.CellScreenRenderer;
import game.utils.LifeChecker;
import game.utils.SpeedLevel;
import game.utils.UniversalCellRenderer;
import game.utils.Utils;

public class Game {

	private CellManipulator manipulator;
	private int sizeOfCellMap;
	private SpeedLevel speed;
	private boolean isAtLeastOneCellAlive = true;

	public Game(int sizeOfCellMap, SpeedLevel level) {
		this.sizeOfCellMap = sizeOfCellMap;
		this.speed = level;
	}

	public void loadTheGame() {

		this.manipulator = new CellManipulator(new TheCell[this.sizeOfCellMap][this.sizeOfCellMap]);

	}

	public void getAllCellsStatus() {
		this.manipulator.getAllCellsStatus();
	}

	public int getSpeedLevel() {
		return Integer.sum(this.speed.ordinal(), 1);

	}

	/**
	 * 
	 * @param rowNumber
	 *            Minimum value is 1; Expected human number (starts with 1);
	 * @param comlumnNumber
	 *            Minimum value is 1; Expected human number (starts with 1);
	 * @throws Exception
	 *             Is thrown when the Cell's index is out of boundaries - < 1 or
	 *             > row/column length;
	 */

	public void makeCellAlive(int rowNumber, int comlumnNumber) {

		try {
			this.manipulator.makeSpecificCellAlive(rowNumber, comlumnNumber);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cell index was out of bounds. Please try again");
		}

	}

	public void startTheCycle() {

		new UniversalCellRenderer(manipulator.getCurrentCells()).rend();

		while (this.isAtLeastOneCellAlive) {

			this.manipulator.breedCells();

			Utils.delay(this.speed);
			new UniversalCellRenderer(manipulator.getCurrentCells()).rend();

			this.isAtLeastOneCellAlive = LifeChecker.checkIfAnyCellAlive(manipulator.getCurrentCells());

		}

	}

}
