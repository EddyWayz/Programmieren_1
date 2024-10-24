// Eduard Wayz

public class Pluralizer {
    public static void main(String[] args) {
        
        // Frägt nach dem Wort, von dem der Plural gebildet werden soll und speichert es in word.
        // Initialisiert output und setzt es auf "Fehler" (Fehler sollte nie ausgegeben werden, weil er ohne Fehler einfach überschrieben wird).
        String word = In.readString("Geben Sie bitte das Wort im Singular ein: ");
        String output = "Fehler";

        // Folgendes Swich-Case fängt alle unregelmäßigen Wörter ab und speichert den Plural jeweils in output. 
        // Groß geschriebene Wörter werden auch berücksichtigt.
        switch (word) {
        case "Man":
            output = "Men";
            break;
        case "man": 
            output = "men";
            break;
            
        case "Woman":
            output = "Women";
            break;
        case "woman":
            output = "women";
            break;
            
        case "Child":
            output = "Children";
            break;
        case "child":
            output = "children";
            break;
            
        case "Foot":
            output = "Feet";
            break;
        case "foot":
            output = "feet";
            break;
            
        case "Tooth":
            output = "Teeth";
            break;
        case "tooth":
            output = "teeth";
            break;
            
        case "Sheep":
            output = "Sheep";
            break;
        case "sheep":
            output = "sheep";
            break;
            
        case "Mouse":
            output = "Mice";
            break;
        case "mouse":
            output = "mice";
            break;
            
        case "Die":
            output = "Dice";
            break;
        case "die":
            output = "dice";
            break;
        default:
            // Hier landen wir nur, wenn es sich um ein regelmäßiges Wort handelt.
            // Speichert zuerst die Länge des Wortes in der neuen Variable wordLength.
            int wordLength = word.length();
            
            // Prüft, ob das Wort auf "-s","-x","-z","-sh","-ch" endet und hängt in diesem Fall ein "-es" an. 
            //Zudem wird das modifizierte Wort in output gespeichert. 
            if (word.endsWith("s") || word.endsWith("x") || word.endsWith("z") || word.endsWith("sh") || word.endsWith("ch")) { 
                output = word + "es";
            } 
            // Endet das Wort nicht auf die oben genannten Endungen, wird hier überprüft, ob  word auf "-y" endet, 
            // aber nicht auf "-ay","-ey","-oy","-uy". Trifft das ein, so wird der Plural mit "-ies" gebildet. 
            // (Beispiel: party -> parties, aber nicht boy)
            else if (word.endsWith("y") && !(word.endsWith("ay") || word.endsWith("ey") || word.endsWith("oy") || word.endsWith("uy"))) {
                output = word.substring(0,wordLength-1) + "ies";
            } 
            // Fällt das Wort in keine der oben beschriebenen Kategorien, so wird einfach ein "-s" ans Wort angehängt. 
            else {
                output = word + "s";
            }
            
        }
        // Zum Schluss wird output auf der Konsole ausgegeben.
        System.out.println("Der Plural von " + word + " ist " + output + ".");
    }
}
