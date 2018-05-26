import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Draw extends Canvas {
	private JFrame frame = null;
	private Canvas canvas = null;
	private BufferedImage map = null;

	BufferStrategy bufferStrategy;
	private final int tile_X = 8, tile_Y = 8, tile_R = 100, tile_C = 100;
	private final int tile_Total = tile_R * tile_C;
	private final int map_Size = tile_X * tile_Y * tile_Total;
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	
	public static int view_x = 0, view_y = 0;
	
	private JLabel ground;
	
	final String title = "Battle";
    final int width = 1200;
    final int height = width / 16 * 9;

	public Draw() {
		//Load the first map
		
		/*frame = new JFrame(title);
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);
		
		frame.setSize(width, height);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setVisible(true);
	    
	    canvas = new Canvas();;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	    canvas.setSize(width, height);
	    canvas.setBackground(Color.WHITE);
	    canvas.setVisible(true);
	    canvas.setFocusable(false);
	    
	    panel.add(canvas);
	    
	    frame.add(canvas);

	    canvas.createBufferStrategy(3);
	    
	    bufferStrategy = canvas.getBufferStrategy();
	    
	    canvas.requestFocus();
	    
	    canvas.addKeyListener(new ButtonHandler()); */
	    
	    
		// Makes a new window, with the name " Basic game ".
		frame = new JFrame(title);
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(null);
		ground = new JLabel("Apple");
		ground.setFont(new Font("Serif", Font.PLAIN, 36));
		ground.setForeground(Color.MAGENTA);

//		frame.add(ground);

		canvas = new Canvas();
		canvas.setBounds(0, 0, width, height);
		canvas.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		// this will make the frame not re-sizable
		frame.setResizable(false);
		frame.setVisible(true);
		// this will add the canvas to our frame
		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		// This will make sure the canvas has focus, so that it can take input
		// from mouse/keyboard
		canvas.requestFocus();
		// this will set the background to black
		//canvas.setBackground(Color.black);
		// This will add our button handler to our program
		canvas.addKeyListener(new ButtonHandler());
		frame.add(ground);
		
	}

	@Override
	public Dimension getPreferredSize() {
		return (map == null) ? new Dimension(this.WIDTH, this.HEIGHT) : new Dimension(map.getWidth(), map.getHeight());
	}
	
	//DRAWS THE VIEW
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.drawRect(0, 0, width, height);
		
		
	}
	
	//DRAWS EVERYTHING
	public void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		paint(g);
		draw_player_in_view(g);
		g.dispose();
		bufferStrategy.show();
	}
	
	//DRAWS THE PLAYER
	protected void draw_player_in_view(Graphics2D g) {
		g.setColor(Color.white);
		
		if (Instances.player.getCount() == 0) {
			g.setColor(Color.BLACK);
	        g.drawString("Your first battle begins!", width/2, height/2);
	        g.drawString("Practice writing each answer and record which letter you pick", width/2, height/3);
	        g.drawString("Press space to begin", width/2, height-height/4);
		} else {
			
		g.setColor(Color.black);
		g.drawString(Instances.player.getQuestion() + ": Choose your word", width/2, height/8);
		
		g.drawString(Instances.player.getOption(0), width/4, height/2);
        g.drawString(Instances.player.getOption(1), width/2, height/4);
        g.drawString(Instances.player.getOption(2), width/4*3, height/2);
        g.drawString(Instances.player.getOption(3), width/2, height/4*3);

		}
		
				
        
		
		//g.drawString(Instances.player.getQuestion(), 100, 100);
		
		//g.drawString(Instances.player.getOption(0))
		
		
		
		
		
		
		
	}
}