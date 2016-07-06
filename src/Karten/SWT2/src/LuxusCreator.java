package Karten.SWT2.src;

public class LuxusCreator extends Spielablauf {

	public Karte SpieleKarteAus(int id) throws Exception {
		if (id < 0 || id > 2) {
			if (id < 0 || id > 13)
				throw new ArrayIndexOutOfBoundsException("id nicht vorhanden (LuxusCreator)");
			else
				throw new Exception("falscher Creator");
		}

		if (id == 0) {
			return new SprechenderPapagei();
		} else if (id == 1) {
			return new Schatzkarte();

		} else if (id == 2) {
			return new Ausflugsboot();
		}

		return null;

	}

}
