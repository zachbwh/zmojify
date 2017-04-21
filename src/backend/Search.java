package backend;

import java.util.Hashtable;
import java.util.Set;

public class Search {
	public void keywordSearch(Hashtable<String, Emoji> emojiList, String search) {
		Set<String> keys = emojiList.keySet();
		for (String s: keys) {
			if (emojiList.get(s).keywordsContainWord(search)) {
				emojiList.get(s).printEmojiChar();
				System.out.println("\n");
			}
		}
	}
}
