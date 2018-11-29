import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class server{

	public static void main(String[] args) throws IOException{
		
		FileReader file= new FileReader("C:\\Users\\kinga5\\Documents\\Java\\Network Programming\\src\\dictionary.txt");
		
		Scanner input = new Scanner(file);
		
		String dictionary[] = new String[1000000];
		
		int count = 0;
		while(input.hasNext()){
			dictionary[count] = input.next();
			count++;
		}
		
		int random = (int)(Math.random() * 143091);
		
		System.out.println(dictionary[random]);
		
		String randomWord = removePunc(dictionary[random]);
		String words[] = new String[randomWord.length()];
		
		String firstWord[] = new String[randomWord.length()];
		
		char word[] = randomWord.toCharArray();
		for(int i = 0; i < randomWord.length(); i++){
			firstWord[i] = String.valueOf(word[i]);
		}
		
		System.out.println("Random Word: " + Arrays.toString(firstWord));
		
    	String blankArray[] = new String[randomWord.length()];
    	
    	for(int i = 0; i < randomWord.length(); i++){
    		if(word[i] == (' ')){
    			blankArray[i] = "     ";
    		}else{
    			blankArray[i] = "__ ";
    		}
    	}
    	System.out.println(Arrays.toString(blankArray));
    	
		ServerSocket s = new ServerSocket(6300);
		Socket s1 = s.accept();
		
		InputStream in = s1.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		OutputStream out = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		String message;
		char letter = 0;
		
		if((message = dis.readUTF()) != null){
			System.out.println(message);
			if(message.equals("ready")){
				dos.writeUTF(Arrays.toString(blankArray));
				while(true){
					if((message = dis.readUTF()) != null){
						System.out.println(message);
						char[] letters = message.toCharArray();
						letter = letters[0];
						String letterToString = String.copyValueOf(letters);
						for(int i = 0; i < words.length; i++){
							if(word[i] == letter){
	                    		words[i] = letterToString;
	                    	}if(words[i] == null){
                    			words[i] = "__ ";
                    		}if(i == (word.length - 1)){
                    			dos.writeUTF("Guess: " + Arrays.toString(words));
                    		}if(Arrays.equals(firstWord,words)){
                        		dos.writeUTF("win");
                        	}
						}
					}
				}
			}
		}
	}
	
	public static String removePunc(String s){
		
		String newString = "";
		s = s.toLowerCase();
		char [] c = s.toCharArray();
		
		for(int i = 0; i < c.length; i++){
			if(c[i] >= 'a' && c[i] <= 'z'){
				newString = newString + c[i];
			}
		}
		
		return newString;
		
	}

}



