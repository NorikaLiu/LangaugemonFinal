import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;

public class Battle {
	
	private volatile boolean running = true;
	private int option = -1;
	
	final String title = "Battle";
    final int width = 1200;
    final int height = width / 16 * 9;

	public Battle() {
		
	}
	
	public void startBattle() {
		//Creating the frame.
	    JFrame frame = new JFrame(title);

	    frame.setSize(width, height);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setVisible(true);

	    //Creating the canvas.
	    Canvas canvas = new Canvas();

	    canvas.setSize(width, height);
	    canvas.setBackground(Color.WHITE);
	    canvas.setVisible(true);
	    canvas.setFocusable(false);


	    //Putting it all together.
	    frame.add(canvas);

	    canvas.createBufferStrategy(3);

	    BufferStrategy bufferStrategy;
	    Graphics graphics;
	    
	    canvas.requestFocus();
		
		//Capture keyboard
		canvas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				switch (key.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						option = 0;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_UP:
						option = 1;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_RIGHT:
						option = 2;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_DOWN:
						option = 3;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_SPACE:
						running = false;
						System.out.println(key.getKeyCode());
						break;
					default:
						System.out.println("Select a different option: " + key.getKeyCode() + " is invalid...");
				}
			}
			public void keyReleased(KeyEvent key) {
				switch (key.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						option = 0;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_UP:
						option = 1;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_RIGHT:
						option = 2;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_DOWN:
						option = 3;
						running = false;
						System.out.println(key.getKeyCode());
						break;
					case KeyEvent.VK_SPACE:
						running = false;
						System.out.println(key.getKeyCode());
						break;
					default:
						System.out.println("Select a different option: " + key.getKeyCode() + " is invalid...");
				}
			}
		});
		
		bufferStrategy = canvas.getBufferStrategy();
	    graphics = bufferStrategy.getDrawGraphics();
	    
		while (running) {
			graphics.setColor(Color.WHITE);
	         graphics.fillRect(0, 0, width, height);
	        graphics.setColor(Color.BLACK);
	        graphics.drawString("Your first battle begins!", width/2, height/2);
	        graphics.drawString("Press space to begin", width/2, height-height/4);
	       bufferStrategy.show();
	    	if (!running) break;
	    }
	    
	    //Start quiz
	    //FILL THESE ARRAYS WITH THE OPTIONS AND THE QUESTIONS
	    //display explample
	    /********************************************************\
		*
		*			Moon: Question, choose your thing
		*
		
		*
		*					[ANSWERUP]
		*
		*
		*	[ANSWERLEFT]					[ANSWERRIGHT]
		*
		*
		*					[ANSWERDOWN]
		*
		*
		*
		\********************************************************/
	    //bufferStrategy = canvas.getBufferStrategy();
	    //graphics = bufferStrategy.getDrawGraphics();
	    int problems = 10;
	    String[] questions = new String[problems];
		int[] answers = new int[problems];
		String[][] options = new String[4][problems];
		
		int correct = 0;
		
	    for (int i = 0; i < problems; i++) {
	    	running = true;
	    	option = -1;
	    	while (running) {
	    		graphics.setColor(Color.WHITE);
		        graphics.fillRect(0, 0, width, height);
		
		        graphics.setColor(Color.BLACK);
		        graphics.drawString(questions[i] + ": Choose your word", width/2, height/8);
		        graphics.drawString(options[0][i], width/4, height/2);
		        graphics.drawString(options[1][i], width/2, height/4);
		        graphics.drawString(options[2][i], width/4*3, height/2);
		        graphics.drawString(options[3][i], width/2, height/4*3);
		        bufferStrategy.show();
		    	if (!running) break;
		    }
		    if (option == answers[i]) {
		    	correct++;
		    	System.out.println("CORRECT");
		    } else System.out.println("INCORRECT");
	    }
	    
	    //DISPLAY END GAME FRAME
	    //TELL THEM HOW MANY correct OUT OF problems AND SAY THE END
	    battleComplete();
	    credits();
	    System.out.println("correct: " + correct + " / " + problems);
	}
	
	public void battleComplete() {
		//replace the canvas with battle complete and display end credits
	}
	public void credits() {
		//Show last canvas of names and stuff
	}
	
	public static void main (String[] args) {
		Battle b = new Battle();
		b.startBattle();
	}
	
}