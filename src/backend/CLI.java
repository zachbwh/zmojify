package backend;


public class CLI {

	public static void main(String[] args) {
		/* if (args.length > 0) {
			String language = args[1];;
			String filepath = "languages/" + language + ".xml";
		} */
		
		Input inpute = new Input();
		
		try {
			//inpute.buildEmojiHashtable(filepath);
			inpute.chooseQuery(args);
			
		} catch (Exception e) {
			System.out.println(" file not found. or file I/O error occured");
		}
		
	}

}
