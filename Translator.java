import java.util.HashMap;

public class Translator{
	private HashMap<String, Character> morseDict = new HashMap<>();
	private char[] letters;
	private String[] morse;

	public Translator(){}
	
	public String[] encode(String s){
		if (letters == null && morse == null){
			createReverseMorseDict();
			System.out.println("Se creo el diccionario inverso"); ////
		}
		else {
			System.out.println("Ya existen los diccionarios"); ////
		}
		String temp = s.toUpperCase();
		System.out.println("Uppercase: " + temp); ////
		String[] codedMsg = new String[temp.length()];

		for (int i = 0; i<temp.length(); i++){
			boolean stop = false;
			for (int j = 0; j<letters.length&&!stop; j++){
				if (temp.charAt(i) == letters[j]){
					codedMsg[i] = morse[j];
					stop = true;
				}
			}
		}
		System.out.println("message coded to: ");
		String m = "";
		for (int i = 0; i<codedMsg.length; i++){
			m += codedMsg[i] + "\n";
		}
		System.out.println(m);
		return codedMsg;
	}

	public String decode(String[] morseMsg){
		if (morseDict == null)
			createMorseDict();
		String decodedMsg = "";

		for (int i = 0; i<morseMsg.length; i++){
			decodedMsg += morseDict.get(morseMsg[i]);
		}
		return decodedMsg;
	}

	private void createMorseDict(){
		morseDict.put(".-", 'A');
		morseDict.put("-...", 'B');
		morseDict.put("-.-.", 'C');
		morseDict.put("-..", 'D');
		morseDict.put(".", 'E');
		morseDict.put("..-.", 'F');
		morseDict.put("--.", 'G');
		morseDict.put("....", 'H');
		morseDict.put("..", 'I');
		morseDict.put(".---", 'J');
		morseDict.put("-.-", 'K');
		morseDict.put(".-..", 'L');
		morseDict.put("--", 'M');
		morseDict.put("-.", 'N');
		morseDict.put("---", 'O');
		morseDict.put(".--.", 'P');
		morseDict.put("--.-", 'Q');
		morseDict.put(".-.", 'R');
		morseDict.put("...", 'S');
		morseDict.put("-", 'T');
		morseDict.put("..-", 'U');
		morseDict.put("...-", 'V');
		morseDict.put(".--", 'W');
		morseDict.put("-..-", 'X');
		morseDict.put("-.--", 'Y');
		morseDict.put("--..", 'Z');
		morseDict.put("/", ' ');
	}
	private void createReverseMorseDict(){
		letters = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '
		};

		morse = new String[]{
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
			".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", 
			"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/"
		};

	}
}
