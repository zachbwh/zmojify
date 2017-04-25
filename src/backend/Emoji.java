package backend;

import java.util.ArrayList;

public class Emoji {
	private String _cldrShortName;
	private final String _emojiChar;
	// private final String[] _unicodeCode;
	private ArrayList<String> _keywords = new ArrayList<String>();
	private int _totalUses;
	
	public Emoji(String emojiChar) {
		// this._cldrShortName = cldrShortName;
		// this._unicodeCode = unicodeCode;
		this._emojiChar = emojiChar;
		// _keywords.add(cldrShortName);
	}
	public Emoji(String emojiChar, ArrayList<String> keywords) {
		this._emojiChar = emojiChar;
		this._keywords = keywords;
	}
	
	public void setCLDRShortName(String cldrShortName) {
		this._cldrShortName = cldrShortName;
	}
	
	public void assignTotalUses(int n) {
		/*
		 * To be used when reading from the history file to set the total uses for a given emoji
		 */
		this._totalUses = n;
	}
	
	public void incrementTotalUses() {
		this._totalUses++;
	}
	
	public String getEmojiName() {
		return this._cldrShortName;
	}
	
	/* public void printEmojiCode() {
		for (int i = 0; i < _unicodeCode.length; i++) {
			System.out.print("\\u" + this._unicodeCode[i] + " ");
		}
		// System.out.print("\n");
	} */
	
	public String getEmojiChar() {
		return this._emojiChar;
	}
	
	public boolean keywordsContainWord(String word) {
		for (int i = 0; i < this._keywords.size(); i++) {
			if (_keywords.get(i).toLowerCase().startsWith(word.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	/* public void addKeywords(ArrayList<String> keywords) {
		for(String str: keywords) {
			if(!this._keywords.contains(str)) {
				this._keywords.add(str);
			}
		}
	} */
	
	public void addKeywords(String[] keywords) {
		for (int i = 0; i < keywords.length; i++) {
			if (!this._keywords.contains(keywords[i])) {
				this._keywords.add(keywords[i]);
				System.out.println(keywords[i]);
			}
		}
	}
	public void addKeyword(String keyword) {
		if(!this._keywords.contains(keyword)) {
			this._keywords.add(keyword);
		}
	}
	
	public void printKeywords() {
		for (String s: this._keywords) {
			System.out.print(s + ", ");
		}
	}
}
