
public class ShuffleCipher implements MessageEncoder {
	private int n;
	
	public ShuffleCipher(int numberOfShuffles) {
		n = numberOfShuffles;
	}
	
	public String encode(String plainText) {
		for(int i = 0; i < n; i++) {
			plainText = shuffle(plainText);	
		}
		return plainText;
	}
	
	private String shuffle(String text) {
		int length = text.length();
		int halfLength = length/2;
		boolean noLastChar = false;
		int distance = halfLength;
		
		if(length%2==1)
		{
			noLastChar = true;
			distance++;
		}
	      
	    char input[] = text.toCharArray();
	    char output[] = new char[length];
	      
	    int evenCount = 0;
	    int oddCount = 1;
	    int count = 0;
	      
	      while (count < halfLength)
	      {
	         output[evenCount] = input[count];
	         output[oddCount] = input[count+distance];
	         
	         count++;
	         evenCount += 2;
	         oddCount += 2;
	      }
	      
	      if(noLastChar)
	      {
	         output[length-1] = input[halfLength]; 
	      }
	      
	      return new String(output);
	   }

}
