package game.engine;

import java.util.ArrayList;
import java.util.List;

import game.utils.Coordinates;
import game.utils.NeighbourCellCoordinates;

public class CellStatusUpdater {

	private TheCell[][] allCellList;
	private int currentCellRowNumber;
	private int currentCellColumnNumber;
	private int numberOfAliveNeighbourCells;

	public CellStatusUpdater(TheCell[][] allCellList, int currentCellRowNumber, int currentCellColumnNumber) {

		this.allCellList = allCellList;
		this.currentCellRowNumber = currentCellRowNumber;
		this.currentCellColumnNumber = currentCellColumnNumber;
	}

	public boolean getUpdatedStatus() {

		boolean cellFinalStatus = false;

		boolean statusOfCurrentCell = allCellList[this.currentCellRowNumber][this.currentCellColumnNumber]
				.getCellLifeStatus();
		countAliveNeighbourCells();

		if (statusOfCurrentCell == true
				&& (this.numberOfAliveNeighbourCells == 2 || this.numberOfAliveNeighbourCells == 3)) {
			cellFinalStatus = true;
		}

		if (statusOfCurrentCell == false && this.numberOfAliveNeighbourCells == 3) {
			cellFinalStatus = true;
		}

		return cellFinalStatus;
	}

	private void countAliveNeighbourCells() {

		this.numberOfAliveNeighbourCells = (int) getNeighbourCellStatus().stream()
				.filter((x -> x.booleanValue() == true)).count();

	}

	private List<Boolean> getNeighbourCellStatus() {

		List<Boolean> neighbourStatusList = new ArrayList<>();

		for (Coordinates neighbour : NeighbourCellCoordinates.listOfCoordinates) {

			boolean cellStatus = false;

			try {
				cellStatus = allCellList[currentCellRowNumber + neighbour.row][currentCellColumnNumber
						+ neighbour.column].getCellLifeStatus();
			} catch (IndexOutOfBoundsException e) {

			}

			neighbourStatusList.add(cellStatus);

		}

		return neighbourStatusList;

	}

}
