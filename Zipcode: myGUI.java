/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;


public class myGUI extends javax.swing.JFrame {
	List<String> statesArray= Arrays.asList ("AL", "AK","AZ","AR","CA","CO","CT","DE","FL","GA",
					"HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA",
					"MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM",
					"NY","NC","ND","OH","OK","OR","PA","RI","SC","SD",
					"TN","TX","UT","VT","VA","WA","WV","WI","WY");
    /**
     * Creates new form myGUI
     */
    public myGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        ZipLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        Calculate = new javax.swing.JButton();
        Distance = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Craigslist Search Engine");

        ZipLabel1.setText("Your Zipcode");

        jLabel2.setText("Other Zipcode");

        jLabel3.setText("State");

        jLabel4.setText("Item Search");

        Calculate.setText("Calculate");
        Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateActionPerformed(evt);
            }
        });

        Distance.setText("Distance");

        jButton1.setText("Search Craigslist");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Calculate the distrance below:");

        jLabel5.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(47, 47, 47))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(86, 86, 86)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addComponent(jButton1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(ZipLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(134, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Calculate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Distance, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calculate)
                    .addComponent(Distance, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>                        
/**
 * Takes in the action for the search craigslist button to querty the information
 * 
 * @param evt
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
       	String cityInput = jTextField5.getText().toLowerCase().replaceAll("\\s","");//city
       	String stateInput = jTextField3.getText().toUpperCase().replaceAll("\\s","");//state
       	String searchInput = jTextField4.getText().toLowerCase().replaceAll("\\s","");//item search

       	Database.createCityLists();//create the list of cities of the state
       	
       	boolean errorFound=false;
       	try{
       		errorFound=false;
       		if(!cityInput.equals("") && !stateInput.equals("") && !searchInput.equals("")){
       		
       			if(Database.cityArray.contains(cityInput)){//ifcity array is found, return no error
       				errorFound=false;
       			}
       			else{
       				errorFound=true;
       				JOptionPane.showMessageDialog(null, "City does not exist in Craigslist Database, please Re-enter!");
       			}
       			//if error found, stop the search and let user fix issue
       			if(stateInput.length()!=2){
       				errorFound=true;
       			JOptionPane.showMessageDialog(null,"Invalid State Length, Please Re-Enter");
       			}
       			else if (!statesArray.contains(stateInput)){
       				errorFound=true;
       				JOptionPane.showMessageDialog(null, "Invalid State Abbreviations");
       			}
       		}
       		else{
       			errorFound=true;
       			JOptionPane.showMessageDialog(null, "Missing either city, state, or item fields!");
       		}
       	}catch(Exception e){
       		errorFound=true;
       		System.out.println("Error");
       	}finally{
       		
       		if(!errorFound)
       			Database.createCraigslistDatabase(cityInput, stateInput, searchInput);
       	}
    }                                           
/**
 * 	return the miles in 2 decimal places
 * 
 * @param d	the number
 * @return	the decimal place in 2 digit
 */
    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
}    

/**
 * 	Calculate the distance between two given point
 *     
 * @param evt
 */
    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	Distance.setText("Distance");
    	String text1=jTextField1.getText();
    	String text2=jTextField2.getText();
    	try{
    		if(text1.equals("")){
    			JOptionPane.showMessageDialog(null, "Invalid zipcode 1");
    		}
    		if(text2.equals("")){
    			JOptionPane.showMessageDialog(null, "Invalid zipcode 2");
    		}
    	}catch(Exception e){
    		System.out.println("Did not enter zipcode field");
    	}
    	
    	try{
    		int zip1 = Integer.parseInt(text1);
    		int zip2 = Integer.parseInt(text2);
  
    		if(zip1 >=100 && zip1<100000){
    			if(zip2 >=100 && zip2 <100000){
    				zipcode.zipSearch(zip1,zip2);
    				if(zipcode.found1 == false){
    				}
    				if(zipcode.found2 == false){
    				}
    			}
    			else{
    				JOptionPane.showMessageDialog(null, "Invalid zip code 2 entry, need min 3 digit and max 5 digit field");
    				zipcode.found2=false;
    			}
    		}//if
    		else{
    			JOptionPane.showMessageDialog(null, "Invalid zip code 1 entry, need min 3 digit and max 5 digit field");
    			zipcode.found1=false;
    		}
    		double lat1=roundTwoDecimals(zipcode.lat1),  lng1=roundTwoDecimals(zipcode.lon1), lat2=roundTwoDecimals(zipcode.lat2), lng2=roundTwoDecimals(zipcode.lon2);   
    		double earthRadius = 3958.75;
    		double dLat = Math.toRadians(lat2-lat1);
    		double dLng = Math.toRadians(lng2-lng1);
    		double sindLat = Math.sin(dLat / 2);
    		double sindLng = Math.sin(dLng / 2);
    		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
    		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    		double dist = earthRadius * c;
    		if(zipcode.found1==true && zipcode.found2==true){
    			Distance.setText(roundTwoDecimals(dist) + " in miles.");
    		}
    	}catch(Exception e){
    		System.out.println("Invalid zip information");
    		JOptionPane.showMessageDialog(null, "Invalid zip information, require digits between 3-5 in length");
    	}
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(myGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton Calculate;
    private javax.swing.JLabel Distance;
    private javax.swing.JLabel ZipLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration                   
   
}
