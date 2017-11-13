package game.utils;

import game.engine.TheCell;

public class CellScreenRenderer implements Renderer {

	private static String separatorLine;
	private TheCell[][] allCellList;

	public CellScreenRenderer(TheCell[][] allCellList) {

		this.allCellList = allCellList;

	}

	@Override
	public void rend() {

		separatorLine = Utils.makeSeparatorLine(allCellList);

		for (int i = 0; i < allCellList.length; i++) {

			System.out.println(separatorLine);

			for (int k = 0; k < allCellList.length; k++) {

				TheCell currentCell = allCellList[i][k];

				if (currentCell.getCellLifeStatus() == true) {
					System.out.print(" X |");
				} else {
					System.out.print(" O |");
				}
			}

		}

		System.out.println(separatorLine);

	}

}
