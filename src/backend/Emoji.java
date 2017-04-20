package backend;

public class Emoji {
	private final String _cldrShortName;
	private final String[] _unicodeCode;
	private final String[] _keywords;
	private int _totalUses;
	
	public Emoji(String cldrShortName, String[] unicodeCode, String[] keywords) {
		this._cldrShortName = cldrShortName;
		this._unicodeCode = unicodeCode;
		this._keywords = keywords;
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
}
