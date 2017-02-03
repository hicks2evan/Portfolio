/**
 * Lab 7
 * @author Evan
 *
 */
public class EncoderTest {
	public static void main(String[] args) {
		SubstitutionCipher test1 = new SubstitutionCipher(8);
		System.out.println(test1.encode("abcdefg"));
		
		ShuffleCipher test2 = new ShuffleCipher(1);
		System.out.println(test2.encode("abcdefg"));
	}

}
