import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.*;

import javax.swing.*;


public class Database extends JPanel implements ActionListener {
	static ArrayList<String> results = new ArrayList<String>();
	static ArrayList<String> cityArray = new ArrayList<String>();
	static ArrayList<String> imageArray = new ArrayList<String>();
	
	protected static JTextField textField;
    protected static JTextArea textArea;
    private final static String newline = "\n";
    
    static String theCity;
    static String craigslistCity;
    static String craigslistState;
	
    public Database(){
    	super(new GridBagLayout());
    	 
        textField = new JTextField(20);
        textField.addActionListener(this);
 
        textArea = new JTextArea(20, 100);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }
    
/**
 * create the database base on the city,state,item and search for the items
 *     
 * @param city		the city to search
 * @param state		the state to search
 * @param item		the item to search
 */
	public static void createCraigslistDatabase(String city, String state, String item){
		results.clear();
		cityArray.clear();
		craigslistCity=city+".craigslist.org";
		craigslistState=state;
		JOptionPane.showMessageDialog(null, "Searching Craigslist Database, Please wait!");
		String text = GetURL.getURL("http://"+craigslistCity);
		String areaID = getAreaID(text);
		text=GetURL.getURL("http://"+city+".craigslist.org/search/?areaID="+areaID+"&subAreaID=&query=subaru&catAbb=sss");
		getUrls(text,100);
		createAndShowGUI();
		getLink(text);
	}
/**
 * Retrieve the links of the craigslist html syntax
 * 	
 * @param craigsList	the source of the craigslist url
 * @return				the link string information
 */
	public static String getLink(String craigsList){
		Pattern getLink = Pattern.compile("<a\\s[^>]*href\\s*=\\s*\"([^\"]*).html\"");//link regex extraction
        Matcher getLinkValue = getLink.matcher(craigsList);
        if(getLinkValue.find()){//if found return the string information
            return getLinkValue.group(1);
        }else{
            return "0";
        }
	}
	
/**
 * Retrieve the postingID of the listing on craigslist
 * 	
 * @param craigSource	the source of the craigslist url	
 * @return				return the postingID information
 */
    public static String getId(String craigSource){
        Pattern postingId = Pattern.compile("postingID=(.*)\"");//postingID regex extraction
        Matcher idValue = postingId.matcher(craigSource);
        if(idValue.find()){//if found, return the postingID informations
            return idValue.group(1);
        }else{
            return "0";
        }
    }
	
/**
 * Retrieve the title of the page
 * 	
 * @param craigSource	the source of the craigslist url
 * @return				return the title of the page
 */
	public static String getTitle(String craigSource){
        Pattern title = Pattern.compile("<title>(.*)</title>");//title regex extraction
        Matcher titleValue = title.matcher(craigSource);
        if(titleValue.find()){//if found, return the title value
            return titleValue.group(1);
        }else{
            return "No Title";
        }
    }
/**
 * Get the area ID associated with the zone that is being query for craigslist search
 * 	
 * @param craigSource	the source of the craigslist url
 * @return				the area id value
 */
	public static String getAreaID(String craigSource){
        Pattern areaID = Pattern.compile("<input type=\"hidden\" name=\"areaID\" value=\"(.*)\">");//regex area id search
        Matcher areaValue = areaID.matcher(craigSource);
        if(areaValue.find()){//area found return the id value
            return areaValue.group(1);
        }else{//otherwise return zero for not found
            return "0";
        }
    }
/**
 * Returns the email information of the url
 * 	
 * @param craigSource	the source of the craigslist url
 * @return				return the information of emails
 */
	public static String getEmail(String craigSource){
        //Group 1 is the desired string
        Pattern email = Pattern.compile("var displayEmail = \"(.*)\";");//regex extracttion of email address
        Matcher emailValue = email.matcher(craigSource);
        if(emailValue.find()){//return the email information
            return emailValue.group(1);
        }else{//msg if not found
            return "No Contact Information";
        }
    }
/**
 * Returns the description information of the url
 * 	
 * @param craigSource	the source of the craigslist url
 * @return				the description information
 */
	 public static String getDescription(String craigSource){
		   Pattern description = Pattern.compile("<section id=\"postingbody\">\\s*(.*?)\\s*</section>",Pattern.DOTALL);//regex extraction of description
	        Matcher descriptionValue = description.matcher(craigSource);
	        if(descriptionValue.find()){
	            return descriptionValue.group(1).replaceAll("<.+?>", "");
	        }else{
	            return "No Description";
	        }
	    }
/**	 
 * Return the city information of the url
 * 
 * @param craigSource	the source of the craigslist url
 * @return				the city information
 */
	 public static String getCity(String craigSource){
	        Pattern city = Pattern.compile("Location: (.*)</li>");//regex extration of city
	        Matcher cityValue = city.matcher(craigSource);
	        if(cityValue.find()){//find the city 
	            return cityValue.group(1);//return the city string
	        }else{
	            return "0";
	        }
	    }
/**	 
 * Return the date information of the url
 * 
 * @param craigSource	the source of the craigslist url
 * @return				the date
 */
	 public static String getDate(String craigSource){
	        Pattern date = Pattern.compile("<date title=(.*)>(.*),"); //date regex extractor
	        Matcher dateValue = date.matcher(craigSource);//find matching data
	        if(dateValue.find()){//if fouund, return the 2nd group of regex
	            return dateValue.group(2);
	        }else{//otherwise return no date listed
	            return "No Date";
	        }
	    }
/**
 * Return the time information of the url
 * 
 * @param craigSource	the source of the craigslist url
 * @return				the time
 */
	 public static String getTime(String craigSource){
	        Pattern time = Pattern.compile("<date title=(.*),\\s*(.*)</date>");//time regex extractor
	        Matcher timeValue = time.matcher(craigSource);
	        if(timeValue.find()){//if fouund, return the 2nd group of regex
	            return timeValue.group(2);
	        }else{//otherwise return no date listed
	            return "No Time";
	        }
	    }
/**
 * Return the array of images of the url that was posted on the website
 *  
 * @param craigSource	the source of the craigslist url
 * @return				the arraylist of images
 */
	 public static ArrayList<String> getImage(String craigSource){
		 imageArray.clear();//erase old images in array
		 Pattern images = Pattern.compile("<img src=\"(.*?)\"");// image regex extraction
	     Matcher imageString = images.matcher(craigSource);
	     while(imageString.find()){//if multiple match is found
	    	 String text = imageString.group(1).replaceAll("/thumb","");//remove all the thumbnails of the picture and view full size
             imageArray.add(text);//adding multiple images to the array
	     }
	     return imageArray;       
	 }
/**
 * Return the result array of urls from the website that contains all the query of the search result
 * 	 
 * @param term		the source of the array of information/url
 * @param limit		the size of query : default is at 50
 * @return			the array of results from the query
 */
	 public static ArrayList<String> getUrls(String term, int limit){
	        Matcher m;
	        Pattern resultURL = Pattern.compile("<a\\s[^>]*href\\s*=\\s*\"([^\"]*).html\"");//url regex extractor
	        m = resultURL.matcher(term);
	        int i=0;
	        while(m.find() && i < limit){//if found add to result array
	            if(i%2==1){//skipping duplicate entries in html
	                results.add(m.group(1));
	            }
	            i++;//when limit of 50 is reach, stop
	        }
	        return results;
	    }
/**
 * Creates a list of city arrays that craigslist uses on the website
 * 	 
 * @return	the array list of cities that is searchable in craigslist
 */
	 public static ArrayList<String> createCityLists(){
		 	String term = GetURL.getURL("http://www.craigslist.org/about/sites");//list of all cities on main site
	        Matcher m;
	        Pattern resultURL = Pattern.compile("<a\\s[^>]*href\\s*=\\s*\"http://([^\"]*).craigslist.org\"");//regex for city listing on craigslist
	        m = resultURL.matcher(term);
	        while(m.find()){//if multiple city is found add to array
	                cityArray.add(m.group(1));
	        }
	        return cityArray;
	    }

/**
 * Get the search result from the list of urls that needs to be visited
 */
	public void actionPerformed(ActionEvent arg0) {
		
		String text = textField.getText();
		int num = Integer.parseInt(text);
		if(num>0 && num<=50){//selecting which item you want to view
			String url = GetURL.getURL("http://"+craigslistCity+results.get(num-1)+".html");
			String title= getTitle(url);//set the title of the page to view
			String description = getDescription(url);//set the description of the page to view
			String city = getCity(url);//set the city of the page to view
			String email = getEmail(url);//set the email of the page to view
			String state = craigslistState.toUpperCase();//set the state of the page to view
			String postID = getId(url);//set the postID of the page to view
			String date = getDate(url);//set the date of the page to view
			String time = getTime(url);//set the time of the page to view
			int zip = zipcode.cityStateSearch(city,craigslistState);
			getImage(url);//retrival of the images 
			String image="";
			for(String s : imageArray){
				image+=s+newline;//collecting all the images to print the links
			}
			String display = "Title: "+title +"\n"+"Description: "+description+"\n"+"City: "+city+"\n"+"State: "+state+ "\n" + 
					"Zipcode:"+zip+"\n"+"Email: "+email+"\n"+"Posting ID: "+postID+ "\n"+ "Date: "+date +"\n"+"Time: " +time +"\n"+"Images: \n"+image;
			JScrollPane scrollPane = new JScrollPane(new JLabel(display));
			scrollPane.setPreferredSize(new Dimension(600,600));
			JTextArea textArea = new JTextArea(display);
			Object message = scrollPane;
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setMargin(new Insets(5,5,5,5));
			scrollPane.getViewport().setView(textArea);
			message =scrollPane;
			JOptionPane.showMessageDialog(null, message);
		}
		else
			JOptionPane.showMessageDialog(null, "You did not select the numbers between 1-50, please re-select!");

	}
/**
 * This shows the GUI of all the available items that can be selected to view after the query result	
 */
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Links to urls you have selected, Enter the number you want to see.");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new Database());
        int i=0;
        for(String s: results){
        	String url = GetURL.getURL("http://"+craigslistCity+results.get(i)+".html");
        	i++;
			textArea.append(i+" : "+getTitle(url)+newline);
        }
        //Display the window.
        frame.setLocation(200, 200);
        frame.pack();
        frame.setVisible(true);
    }
}
