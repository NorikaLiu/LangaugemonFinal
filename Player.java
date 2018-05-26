import javax.swing.JPanel;
import java.awt.Graphics;
public class Player {
	// variables which we will use
	private int x = Draw.HEIGHT, y = Draw.WIDTH, tile_X, tile_Y;
	private boolean left = false, right = false, up = false, down = false, space = false;
	private int walk_speed = 300, run_speed = 100;
	
	private boolean running = true;
	
	private int count = 0;
	
	// This is the class that holds the data. 
	// it has this string, this string, and this string.
	
	// the array of questions corresponds with certain number. 
	//when space is pressed, different numbers are used to correspond with different text.
	
	/* Example
	 * Initial: count equals 0
	 * if space is pressed count equals count + 1 (count = 1)
	 * 
	 * So...
	 * String[1] = Question 1 : what is your favorite fruit"
	 * 
	 * Answers[1][1] = Apple 
	 * Answers[1][2] = Banana
	 * Answers[1][3] = Orange
	 * Answers[1][4] = grape
	 * 
	 * the draw class takes information from this class with a retrieving method
	 * 
	 * getString : returns the String and draws it on the screen
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	private String[] questions = new String [11];
	private String [][] options = new String[11][4];

	public Player(int tile_X, int tile_Y) {
		this.tile_X = tile_X;
		this.tile_Y = tile_Y;
		this.x = 100;
		this.y = 100;
		Draw.view_x = x - Draw.WIDTH/2;
		Draw.view_y = y - Draw.HEIGHT/2;

		String one = "What does this translate to こにちは (konichwa)?";
		String two = "What does  りんご　(ringo)  translate to?";
		String three = "What does くろ　(kuro) translate to?";
		String four = "What does this しろ (shiro)　translate to?";
		String five =   "Which of the translation match \n"
				+ " with this english word banana";
		String six = "Which word is the translation of cream" ;
		String seven = "Which word is the translation of strawberry";
		String eight = "Which word is the translation of (nice to meet you) ";
		String nine = "Which word is the translation of butter";
		String ten = "Which word is the translation of goodbye";
		String eleven = "Answers: A,B,A,A,B,B,A,B,B,B";
		for (int i = 0; i < 11; i ++) {
			//questions[i] = "Question " +( i + 1);
			if (questions [i]==  questions [0]) {
				questions[i] = "Question " +( i + 1 )+ one;
				}	
				else if  (questions [i]==  questions [1]) {
					questions[i] = "Question " +( i + 1 )+ two;
					
				}
				else if  (questions [i]==  questions [2]) {
					questions[i] = "Question " +( i + 1 )+ three;
	 
				}
					else if  (questions [i]==  questions [3]) {
						questions[i] = "Question " +( i + 1 )+ four;
					}
					else if  (questions [i]==  questions [4]) {
						questions[i] = "Question " +( i + 1 )+ "Midway there!" + "\n" + five;
					}
					else if  (questions [i]==  questions [5]) {
						questions[i] = "Question " +( i + 1 ) + six;
					}
					else if  (questions [i]==  questions [6]) {
						questions[i] = "Question " +( i + 1 )+  seven;
					}
					else if  (questions [i]==  questions [7]) {
						questions[i] = "Question " +( i + 1 )+  eight;
					}
					else if  (questions [i]==  questions [8]) {
						questions[i] = "Question " +( i + 1 )+  nine;
					}
					else if  (questions [i]==  questions [9]) {
						questions[i] = "Question " +( i + 1 )+ ten;
					}
					else if  (questions [i]==  questions [10]) {
						questions[i] =  eleven;
					}
				
		//This sets up the options for the battle system
			
	for (int j = 0 ; j < 4; j ++) {
		
		if (questions [i]==  questions [0]) {
			options[0][j] = "A. Hi or B. Bye"; 
			options[1][j] = "A. Apple or B. Sushi"; 
			options[2][j] = "A. Black or B. White";; 
			options[3][j] = "A. Black or B. White";
			options[4][j] = "A. バナバナ or B. アッッル"; 
			options[5][j] =  "A. クリム or B. アサイゴ"; 
			options[6][j] =  "A. イチゴ or B. 一"; 
			options[7][j] = "A. はぎまま所 or B.　さよな";
			options[8][j] = "A. 端 or B. バタ"; 
			options[9][j] ="A. さよなら or B. こにちは"; 
			options[10][j] = "Thank you for playing"; 
			
		}
	}}}
	// These 4 functions are able to set the direction
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setRun(boolean space) {
		this.space = space;
		if (space) {
			count ++;
		}
		
	}

	// This function will return X as an int.
	public int getX() {
		return x;
	}

	// And this function will return Y as an int.
	public int getY() {
		return y;
	}

	public void update() {
		move();
	}

	// This function will move the player according to its direction and speed
	public void move() {
		int sleep = (space) ? this.run_speed : this.walk_speed;
		if (space) {
			x -= tile_X;
		} else if (right) {
			x += tile_X;
		} else if (up) {
			y -= tile_Y;
		} else if (down) {
			y += tile_Y;
		}
		wait(sleep);
	}

	public void wait(int length) {
		long time = System.currentTimeMillis();
		long finish = time + length;
		while (true) {
			time = System.currentTimeMillis();
			if (time >= finish)
				break;
		}

	}
	
	public String getQuestion() {
		return questions[count - 1];
	}
	
	public String getOption(int i) {
		return options[count - 1][i];
	}
	
	public int getCount() {
		return count;
	}
}

