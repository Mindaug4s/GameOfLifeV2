package game.utils;

public class Utils {

	static String makeSeparatorLine(Object[] allCellList) {

		String separatorLine = "\n";

		for (int i = 0; i < allCellList.length; i++) {
			separatorLine += "--- ";
		}
		return separatorLine;

	}

	public static void delay(SpeedLevel speed) {

		try {
			Thread.sleep(4000 - Integer.toUnsignedLong(speed.ordinal() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
