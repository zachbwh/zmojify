package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Input {
	public ArrayList<String> emojiList = new ArrayList<String>();
	public Hashtable<String, Emoji> emojis = new Hashtable<String, Emoji>();
	
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
	public void buildEmojiHashtable() {
		for(String s: this.emojiList) {
			String[] lineArray = s.split("\\s+");
			int counter = 0;
			ArrayList<String> unicodeCode = new ArrayList<String>();
			ArrayList<String> keywords = new ArrayList<String>();
			String cldrShortName = "";
			String emojiChar = "";
			for (int i = 0; i < lineArray.length; i++) {
				if (lineArray[i].equals(";") || lineArray[i].equals("#")) {
					counter++;
				} else if (counter == 0) {
					unicodeCode.add(lineArray[i]);
				} else if (counter == 2) {
					emojiChar = emojiChar + lineArray[i];
					counter++;
				} else if (counter > 2) {
					cldrShortName = cldrShortName + " " + lineArray[i];
					keywords.add(lineArray[i]);
				}

				// System.out.print(lineArray[i] + " ");
			}
			// System.out.print("\n");
			String[] unicodeCodeArray = new String[unicodeCode.size()];
			unicodeCodeArray = unicodeCode.toArray(unicodeCodeArray);
			String[] keywordsArray = new String[keywords.size()];
			keywordsArray = keywords.toArray(keywordsArray);
			Emoji e = new Emoji(cldrShortName, unicodeCodeArray, keywordsArray, emojiChar);
			this.emojis.put(cldrShortName, e);
		}
		/* Set<String> keys = this.emojis.keySet();
		for (String s: keys) {
			// System.out.println(s + ":");
			emojis.get(s).printEmojiName();
			emojis.get(s).printEmojiChar();
			emojis.get(s).printEmojiCode();
			System.out.println("");
		} */
	}
}
