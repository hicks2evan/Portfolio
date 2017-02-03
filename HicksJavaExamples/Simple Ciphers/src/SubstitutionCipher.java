
public class SubstitutionCipher implements MessageEncoder {
	private int shift;
	
	public SubstitutionCipher(int someShift) {
		shift = someShift;
	}
	
	public String encode(String plainText) {
		for(int i = 0; i < plainText.length(); i++) {
			plainText = plainText.replace(plainText.charAt(i), makeShift(plainText.charAt(i)));
		}
		return plainText;
	}
	
	private char makeShift(char c) {
		char shifted = (char) (c + shift);
		return shifted;
	}

}
