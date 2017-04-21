package backend;

import java.io.FileNotFoundException;

public class CLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String query = args[0];
		//String search = args[1];
		if (args.length > 1) {
			// String search = args[1];
			// System.out.println("hello");
		}
		// String search = args[1];
		if (args.length > 2) {
			String max = args[2];
		}
		final String emojiFilepath = "emoji-test.txt";
		
		Input inpute = new Input();
		Search searche = new Search();
		try {
			inpute.initialiseEmojiList(emojiFilepath);
			// inpute.printEmojiList();
			inpute.buildEmojiHashtable();
			if (args.length > 1) {
				String search = args[1];
				searche.keywordSearch(inpute.emojis, search);
			}
		} catch (Exception e) {
			System.out.println(emojiFilepath + " file not found. or file I/O error occured");
		}
		
	}

}
