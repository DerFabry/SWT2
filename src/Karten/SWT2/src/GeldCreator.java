package Karten.SWT2.src;

public class GeldCreator extends Spielablauf {

	public Karte SpieleKarteAus(int id) throws ArrayIndexOutOfBoundsException, Exception {

		if (id != 3) {
			if (id < 0 || id > 13)
				throw new ArrayIndexOutOfBoundsException("id kleiner als 0 oder größer als 13 (GeldCreator)");
			else
				throw new Exception("falscher creator");
		}

		if (id == 3){
			return new Beute();
		}
		return null;

	}

}
