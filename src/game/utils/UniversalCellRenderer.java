package game.utils;

import java.util.Arrays;
import java.util.List;

import game.engine.TheCell;

public class UniversalCellRenderer implements Renderer {

	public List<Renderer> renderList;

	public UniversalCellRenderer(TheCell[][] allCellList) {
		renderList = Arrays.asList(new CellScreenRenderer(allCellList), new CellFileRenderer());

	}

	@Override
	public void rend() {

		renderList.forEach(x -> x.rend());
	}

}
