import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class DownloadMap {

	  static JFrame frame = new JFrame("");
	  static JTextField text = new JTextField(20);
	
	  public static void main(String args[]) {
		  
			frame.setSize(500, 75);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
	        text.setSize(450, 30);
	        text.setVisible(true);
	        frame.add(text);
	        
	        
			  text.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        System.out.println(text.getText());
				        //text.setEditable(false);
				        get(text.getText());
				        text.setText("");
				        //text.setEditable(true);
				}
		});
	  }
	  
	  public static void get(String path) {
		  String name = path.split("/")[path.split("/").length -1];
		  try {
				 URL link = new URL(path);
				 InputStream in = new BufferedInputStream(link.openStream());
				 ByteArrayOutputStream out = new ByteArrayOutputStream();
				 byte[] buf = new byte[1024];
				 int n = 0;
				 while (-1!=(n=in.read(buf)))
				 {
				    out.write(buf, 0, n);
				 }
				 out.close();
				 in.close();
				 byte[] response = out.toByteArray();
		 
				 FileOutputStream fos = new FileOutputStream(name);
				 fos.write(response);
				 fos.close();
				 
				 System.out.println("Finished");
			  
		  } catch (Exception e) {}
	}
	
}
