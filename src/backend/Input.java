package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {
	public ArrayList<String> emojiList = new ArrayList<String>();
	
	public void initialiseEmojiList(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String s;
		
		while((s = br.readLine()) != null) {
			if(!s.startsWith("#") && !s.isEmpty()) {
				emojiList.add(s);
			}
		}
		fr.close();
	}
	
	public void printEmojiList() {
		for (String s: this.emojiList) {
			System.out.println(s);
		}
	}
}
