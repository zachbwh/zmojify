package backend;

import java.io.FileNotFoundException;
import java.util.Set;

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
			//inpute.initialiseEmojiList(emojiFilepath);
			// inpute.printEmojiList();
			// inpute.buildEmojiHashtable();
			// inpute.intialiseEmojiListXml("languages/en.xml");
			// inpute.printEmojiList();
			inpute.buildEmojiHashtable("languages/en.xml");
			Set<String> keys = inpute.emojis.keySet();
			/* for(String s: keys) {
				System.out.println(inpute.emojis.get(s).getEmojiChar() + "\t" + inpute.emojis.get(s).getEmojiName());
				inpute.emojis.get(s).printKeywords();
				System.out.print("\n");
			} */
			/* if (args.length > 1) {
				String search = args[1];
				searche.keywordSearch(inpute.emojis, search);
			}*/
		} catch (Exception e) {
			System.out.println(emojiFilepath + " file not found. or file I/O error occured");
		}
		
	}

}
