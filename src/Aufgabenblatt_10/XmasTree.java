package Aufgabenblatt_10;

/**
 * Zeichnet einen Tannenbaum gegebener Gr��e
 * ohne die Verwendung von Schleifen, sondern
 * mittels Rekursion.
 * 
 * @author [Ihr Name]
 */
public class XmasTree {

	// Globale Variable f�r die Gr��e des Tannenbaums
	private static int size;
	
	public static void main(String[] args) {
//		size = In.readInt("Wie gro� soll Ihr Tannenbaum sein? ");
		size = 4;
		System.out.println("Frohe Weihnachten!\n");

		// Ausgabe mit Schleifen
		System.out.println(treeWithLoops(size)); 	
		// Ausgabe mit Rekursion
		// (1) Baumkrone ausgeben
		System.out.println(treeTop(0));
		
		// (2) TODO: Teil (d): Baumstamm ausgeben
		System.out.println(indent(size-1) +"||" );
		
	}
	
	/**
	 * Erzeugt einen Baum mithilfe von Schleifen 
	 * (ohne Rekursion, zum "Aufw�rmen"). 
	 * 
	 * @param n Gr��e des Baums
	 * @return der Baum als String
	 */
	private static String treeWithLoops(int n) {
		String tree = "";

		// TODO: (1) Baumkrone mit Schleife
		for(int i = 0; i < n; i++) {
			for (int j = n-i; j > 0; j--) {
				tree += " ";
			}
			for(int j = 0; j <= i; j++) {
				tree += "/";
			}
			for(int j = 0; j <= i; j++) {
				tree += "\\";
			}
			tree += "\n";
		}
		// TODO: (2) Baumstamm mit Schleife
		for (int i = 0; i < n; i++) {
			tree += " ";
		}
		tree += "|";
		tree += "|";
		return tree;
	}

	
	/**
	 * Erzeugt rekursiv einen String aus n Leerzeichen.
	 * 
	 * @param n die L�nge des Strings
	 * @return String aus n Leerzeichen
	 */
	private static String indent(int n) {
		String s = " ";
		// TODO: Teil (a)
		if(n == 1) {
			return " ";
		}
		return s + indent(n-1);
	}
	

	/**
	 * Erzeugt rekursiv die unterste Zeile der Krone
	 * eines Weihnachtsbaums der Gr��e n. Der String
	 * besteht aus n-mal '/' gefolgt von n-mal '\'.
	 * 
	 * @param n die Eingabel�nge
	 * @return String wie oben beschrieben
	 */
	private static String bottomRow(int n) {
		String s = "";
		
		// TODO: Teil (b)
		s = bottomRowLeft(s, n) + bottomRowRight(s, n);;

		return s;
	}

	private static String bottomRowLeft(String s, int n) {
		if(n == 0) {
			return "";
		}
		s += "/" + bottomRowLeft(s, n-1);

		return s;
	}
	private static String bottomRowRight(String s, int n) {
		if(n == 0) {
			return "";
		}
		s += "\\" + bottomRowRight(s, n-1);

		return s;
	}

	/**
	 * Erzeugt rekursiv die Baumkrone
	 * eines Weihnachtsbaums der Gr��e n.
	 * 
	 * @param n die Gr��e des Baums
	 * @return Baumkrone als String
	 */
	private static String treeTop(int n) {
		String s = "";		

		// TODO: Teil (c)
		if(n==size) return bottomRow(n);
			s = indent(size-n) +bottomRow(n) + "\n" +treeTop(n + 1) ;
		return s;
	}
	
}
