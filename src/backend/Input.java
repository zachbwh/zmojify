package backend;

import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Input {
	public Hashtable<String, Emoji> emojis = new Hashtable<String, Emoji>();
	
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
				
				if (!(this.emojis.containsKey(emojiChar))) {
					this.emojis.put(emojiChar, new Emoji(emojiChar));
				}
				if (emojiElement.getAttribute("type").equals("tts")) {
					this.emojis.get(emojiChar).setCLDRShortName(emojiElement.getTextContent());
					this.emojis.get(emojiChar).addKeyword(emojiElement.getTextContent());
				} else {
					String[] keywordArray = emojiElement.getTextContent().split(" \\| ");
					this.emojis.get(emojiChar).addKeywords(keywordArray);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
