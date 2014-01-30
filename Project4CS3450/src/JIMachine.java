import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


class JIMachine extends JFrame implements ActionListener{
	Image img;// = new ImageIcon("Player.png").getImage();
	float zoom = 1;
	MyJPanel jp;
	private JButton Open, ZoomIn, Default ,ZoomOut, Quit;
	
	public JIMachine(){
		//this.setSize(800, 600);
		Container cp = getContentPane();
		cp.setLayout(null);//new BorderLayout());
		
		jp = new MyJPanel();
		jp.setBounds(0, 0, 794, 460);
		cp.add(jp);
		
		Open = new JButton("Open");
		cp.add(Open);
		Open.setBounds(0, 462,100,100);
		//cp.add(Open, BorderLayout.NORTH);
		
		ZoomIn = new JButton("ZoomIn");
		cp.add(ZoomIn);
		ZoomIn.setBounds(100, 462,242,100);
		//cp.add(ZoomIn, BorderLayout.EAST);
		
		Default = new JButton("100%");
		cp.add(Default);
		Default.setBounds(342, 462,100,100);
		//cp.add(Default, BorderLayout.CENTER);
		
		ZoomOut = new JButton("ZoomOut");
		cp.add(ZoomOut);
		ZoomOut.setBounds(442, 462,242,100);
		//cp.add(ZoomOut, BorderLayout.WEST);
		
		Quit = new JButton("Quit");
		cp.add(Quit);
		Quit.setBounds(684, 462,100,100);
		//cp.add(Quit, jp.add(Quit));
		
		Open.addActionListener(this);
		ZoomIn.addActionListener(this);
		Default.addActionListener(this);
		ZoomOut.addActionListener(this);
		Quit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Open")){
			//img = new ImageIcon("C:\\Test").getImage();
			
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showOpenDialog(this);
			
			File file = null;
			
			if (result == JFileChooser.APPROVE_OPTION) {
	            file = chooser.getSelectedFile();
	        }
			try {
				img = ImageIO.read(file);// new File("C:/Test.png"));
				jp.setImage(img);
				jp.repaint();
		    }
			catch (IOException ex) {
				System.out.println("bad");
		    }
			//paint(Graphics.this);
		}
		else if(e.getActionCommand().equals("ZoomIn")){
			zoom += .25f;
			System.out.println(zoom);
			jp.setScale(zoom);
			jp.repaint();
			//redraw
		}
		else if(e.getActionCommand().equals("100%")){
			zoom = 1f;
			System.out.println(zoom);
			jp.setScale(zoom);
			jp.repaint();
			//redraw
		}
		else if(e.getActionCommand().equals("ZoomOut")){
			
			zoom -= .25f;
			if(zoom <= 0)
				zoom = .25f;
			System.out.println(zoom);
			jp.setScale(zoom);
			jp.repaint();
			//redraw
		}
		else if(e.getActionCommand().equals("Quit")){
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		JIMachine frame = new JIMachine();//"Project4");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		//frame.add(new Frame());
		frame.setVisible(true);
	}
}
