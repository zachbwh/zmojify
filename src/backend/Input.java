package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Input {
	public ArrayList<String> emojiList = new ArrayList<String>();
	public Hashtable<String, Emoji> emojis = new Hashtable<String, Emoji>();
	
	public void initialiseEmojiList(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String s;
		
		while((s = br.readLine()) != null) {
			if(!s.startsWith("#") && !s.isEmpty()) {
				this.emojiList.add(s);
			}
		}
		fr.close();
	}
	
	public void intialiseEmojiListXml(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String s;
		int count = 0;
		
		while((s = br.readLine()) != null) {
			if(s.startsWith("		<annotation cp=")) {
				this.emojiList.add(s.trim());
				// System.out.println(s);
				count++;
			}
		}
		fr.close();
	}
	
	public void printEmojiList() {
		for (String s: this.emojiList) {
			System.out.println(s);
		}
	}
	/* public void buildEmojiHashtable() {
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
			Emoji e = new Emoji(cldrShortName, keywordsArray, emojiChar);
			this.emojis.put(cldrShortName, e);
		} */
		/* Set<String> keys = this.emojis.keySet();
		for (String s: keys) {
			// System.out.println(s + ":");
			emojis.get(s).printEmojiName();
			emojis.get(s).printEmojiChar();
			emojis.get(s).printEmojiCode();
			System.out.println("");
		}
	} */
	public void buildEmojiHashtable(String filepath) {
		try {
			File inputFile = new File(filepath);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nlist = doc.getElementsByTagName("annotation");
			
			
			
			for (int i = 0; i < nlist.getLength(); i++) {
				Node nNode = nlist.item(i);
				Element emojiElement = (Element)nNode;
				String emojiChar = emojiElement.getAttribute("cp");
				
				if (!this.emojis.contains(emojiChar)) {
					this.emojis.put(emojiChar, new Emoji(emojiChar));
				}
				if (emojiElement.getAttribute("type").equals("tts")) {
					this.emojis.get(emojiChar).setCLDRShortName(emojiElement.getTextContent());
					this.emojis.get(emojiChar).addKeyword(emojiElement.getTextContent());
				} else {
					String[] keywordArray = emojiElement.getTextContent().split(" \\| ");
					/* for (int j = 0; j < keywordArray.length; j++) {
						System.out.println(keywordArray[j]);
					} */
					this.emojis.get(emojiChar).addKeywords(keywordArray);
				}
				/* if (emojiElement.getAttribute("type").equals("tts")) {
					this.emojis.put(emojiChar, new Emoji(emojiChar, emojiElement.getTextContent()));
				} else if (this.emojis.contains(emojiChar)) {
					ArrayList<String> keywordArrayList = new ArrayList<String>();
					String[] keywordArray = emojiElement.getTextContent().split(" | ");
					for(int j = 0; j < keywordArray.length; j++) {
						keywordArrayList.add(keywordArray[j]);
					}
					this.emojis.get(emojiChar).
					// this.emojis.put(emojiChar, new Emoji(emojiChar, keywordArrayList));
				} */
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
