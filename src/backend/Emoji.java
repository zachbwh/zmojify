package backend;

public class Emoji {
	private final String _cldrShortName;
	private final String _emojiChar;
	private final String[] _unicodeCode;
	private final String[] _keywords;
	private int _totalUses;
	
	public Emoji(String cldrShortName, String[] unicodeCode, String[] keywords, String emojiChar) {
		this._cldrShortName = cldrShortName;
		this._unicodeCode = unicodeCode;
		this._keywords = keywords;
		this._emojiChar = emojiChar;
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
	
	public void printEmojiName() {
		System.out.print(this._cldrShortName);
	}
	
	public void printEmojiCode() {
		for (int i = 0; i < _unicodeCode.length; i++) {
			System.out.print("\\u" + this._unicodeCode[i] + " ");
		}
		// System.out.print("\n");
	}
	
	public void printEmojiChar() {
		System.out.print(_emojiChar);
	}
	
	public boolean keywordsContainWord(String word) {
		for (int i = 0; i < this._keywords.length; i++) {
			if (_keywords[i].startsWith(word)) {
				return true;
			}
		}
		return false;
	}
}
