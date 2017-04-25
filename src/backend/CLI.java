package backend;

import java.io.FileNotFoundException;
import java.util.Set;

public class CLI {

	public static void main(String[] args) {
		String query = args[0];
		String language = args[1];
		String search = args[2];
		String filepath = "languages/" + language + ".xml";
		Input inpute = new Input();
		Search searche = new Search();
		
		try {
			inpute.buildEmojiHashtable(filepath);
			Set<String> keys = inpute.emojis.keySet();
			/* for(String s: keys) {
				
			} */
			if (args.length > 1) {;
				searche.keywordSearch(inpute.emojis, search);
			}
		} catch (Exception e) {
			System.out.println(filepath + " file not found. or file I/O error occured");
		}
		
	}

}
