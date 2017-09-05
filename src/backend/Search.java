package backend;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Search {
	ArrayList<Emoji> _foundEmojis = new ArrayList<Emoji>();
	ArrayList<Emoji> _foundExactEmojis = new ArrayList<Emoji>();
	
	public void printFoundEmojis() {
		for (Emoji emoji: _foundEmojis) {
			System.out.println(emoji.getEmojiChar());
		}
	}

	public String stringFoundEmojis() {
		String foundEmojisString = "";
		for (Emoji emoji: _foundEmojis) {
			foundEmojisString = foundEmojisString + "\n" + emoji.getEmojiChar();
		}
		System.out.println(foundEmojisString);
		return foundEmojisString;
	}
	
	public void zmojiSearch(Hashtable<String, Emoji> emojiList, String search) {
		keywordPerfectMatch(emojiList, search);
		keywordSearch(emojiList, search);
	}
	
	public void keywordSearch(Hashtable<String, Emoji> emojiList, String search) {
		Set<String> keys = emojiList.keySet();
		for (String s: keys) {
			if (emojiList.get(s).keywordsContainWord(search) && !_foundExactEmojis.contains(emojiList.get(s))) {
				_foundEmojis.add(emojiList.get(s));
			}
		}
	}
	public void keywordPerfectMatch(Hashtable<String, Emoji> emojiList, String search) {
		Set<String> keys = emojiList.keySet();
		for (String s: keys) {
			if (emojiList.get(s).keywordContainsExactWord(search)) {
				_foundExactEmojis.add(emojiList.get(s));
				_foundEmojis.add(emojiList.get(s));
			}
		}
	}
}
