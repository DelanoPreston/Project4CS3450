import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {
	Image img;
	float scale = 1;
	public MyJPanel(){
		this.setBackground(Color.WHITE);
	}
	
	public void setImage(Image in){
		img = in;
	}
	
	public void setScale(float in){
		scale = in;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(img != null){
			//Graphics2D g2 = (Graphics2D) g;
			int newWidth = (int)(img.getWidth(this) * scale);
			System.out.println(newWidth);
			int newHeight = (int)(img.getHeight(this) * scale);
			System.out.println(newHeight);
	        g.drawImage(img, 0, 0, newWidth, newHeight,this);
		}
		else{
			System.out.println("Image not initialized yet");
		}
	}
}
