import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class GetURL {
	/**
	 * Obtain the HTML from a URL
	 * @param link URL
	 * @return 
	 */
    public static String getURL(String link){
		try {
			String html = "";
			URL url = new URL(link);
			URLConnection con = url.openConnection();
			
			InputStreamReader r = new InputStreamReader(con.getInputStream());
			//Read character by character
			while (true) {
				int ch = r.read();
				
				//Check EOF
				if (ch < 0){
					break;
				}
				//Append character to string
				html += (char) ch;
			}
			return html;
		}catch(Exception e){ }
		//Not found
		return "";
    }
}
