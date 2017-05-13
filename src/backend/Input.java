package backend;

import java.io.File;
import java.util.Hashtable;

// import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Input {
	public Hashtable<String, Emoji> emojis = new Hashtable<String, Emoji>();

	public Hashtable<String, String> _commands = new Hashtable<String, String>();
	
	public void buildEmojiHashtable(String filepath) {
		try {
			/* System.out.println(filepath);
			ClassLoader cl = this.getClass(). getClassLoader();
			System.out.println("1");
			File inputFile = new File(cl.getResource(filepath).getFile());
			System.out.println("2"); */
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
	public void chooseQuery(String[] inputArgs) {
		this._commands.put("-s", 				"-s");
		this._commands.put("--search",			"-s");
		this._commands.put("-z",				"-z");
		this._commands.put("--zmojify-search",	"-z");
		this._commands.put("-h",				"-h");
		this._commands.put("--help",			"-h");
		this._commands.put("-l",				"-l");
		this._commands.put("--list-languages",	"-l");
		
		String query = _commands.get(inputArgs[0]);
		switch(query) {
		case "-s":
			if (inputArgs.length == 3) {
				String language = inputArgs[1];;
				String filepath = "languages/" + language + ".xml";
				this.buildEmojiHashtable(filepath);
				String search = inputArgs[2];
				Search searchInstance = new Search();
				searchInstance.keywordSearch(this.emojis, search);
				searchInstance.printFoundEmojis();
			}
			break;
		case "-z":
			if (inputArgs.length == 3) {
				String language = inputArgs[1];;
				String filepath = "languages/" + language + ".xml";
				this.buildEmojiHashtable(filepath);
				String search = inputArgs[2];
				Search searchInstance = new Search();
				searchInstance.zmojiSearch(this.emojis, search);
				searchInstance.printFoundEmojis();
			}
			break;
		case "-h":
			System.out.println("usage:  java -jar zmojify.jar <operation> <language> <query>");
			System.out.println("operations:");
			System.out.println("	java -jar zmojify.jar {-h --help}");
			System.out.println("	java -jar zmojify.jar {-s --search} <language> <query>");
			System.out.println("	java -jar zmojify.jar {-z --zmojify-search} <language> <query>");
			System.out.println("	java -jar zmojify.jar {-l --list-languages}");
			break;
		case "-l":
			File langFolder = new File("languages/");
			File[] langFileList = langFolder.listFiles();
			String[] splitFilename;
			for (int i = 0; i < langFileList.length; i++) {
				if (langFileList[i].isFile()) {
					splitFilename = langFileList[i].getName().split("\\.");
					System.out.println(splitFilename[0]);
				}
			}
			break;
		}
	}
}
