package dynamic_beat_17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	public int score = 0;
	
	//결과
	boolean musicEnd = false;
	public String rank;

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public  Music result = new Music("resultmusic.mp3", false);
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
			}
			
			if(!note.isProceeded())
			{ noteList.remove(i);
			  i--;
			}	
			else{
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawImage(blueFlareImage, 440, 300, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.setColor(new Color(0xFE2DD2));
		g.drawString(Integer.toString(score), 565, 702);

		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);

			

	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/KeyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/KeyPadBasic.png")).getImage();

	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
		if(musicEnd) {
			if(score <= 10000) rank = "F"; 
			else if(score <= 50000) rank = "C"; 
			else if(score <= 70000) rank = "B"; 
			else if(score <= 100000) rank = "A"; 
			else if(score <= 130000) rank = "S"; 
		}
	}
	
	public void close() {
		gameMusic.close();
		result.start();
		musicEnd = true;
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME *1000;
			int gap = 125;
			beats = new Beat[]{
					new Beat(startTime+ gap *1, "S"),
					new Beat(startTime+ gap *3, "D"),
					new Beat(startTime+ gap *5, "S"),
					new Beat(startTime+ gap *7, "J"),
					new Beat(startTime+ gap *9, "K"),
					new Beat(startTime+ gap *11, "L"),
					new Beat(startTime+ gap *13, "S"),
					new Beat(startTime+ gap *15, "D"),
					new Beat(startTime+ gap *18, "L"),
					new Beat(startTime+ gap *20, "J"),
					new Beat(startTime+ gap *22, "K"),
					new Beat(startTime+ gap *24, "L"),
					new Beat(startTime+ gap *26, "S"),
					new Beat(startTime+ gap *28, "D"),
					new Beat(startTime+ gap *32, "Space"),
					new Beat(startTime+ gap *34, "S"),
					new Beat(startTime+ gap *36, "F"),
					new Beat(startTime+ gap *38, "J"),
					new Beat(startTime+ gap *40, "J"),
					new Beat(startTime+ gap *42, "D"),
					new Beat(startTime+ gap *44, "S"),
					new Beat(startTime+ gap *46, "D"),
					new Beat(startTime+ gap *48, "S"),
					new Beat(startTime+ gap *50, "J"),
					new Beat(startTime+ gap *52, "K"),
					new Beat(startTime+ gap *54, "L"),
					new Beat(startTime+ gap *56, "S"),
					new Beat(startTime+ gap *58, "D"),
					new Beat(startTime+ gap *60, "L"),
					new Beat(startTime+ gap *62, "J"),
					new Beat(startTime+ gap *64, "K"),
					new Beat(startTime+ gap *66, "L"),
					new Beat(startTime+ gap *68, "S"),
					new Beat(startTime+ gap *70, "D"),
					new Beat(startTime+ gap *72, "Space"),
					new Beat(startTime+ gap *74, "S"),
					new Beat(startTime+ gap *76, "F"),
					new Beat(startTime+ gap *78, "J"),
					new Beat(startTime+ gap *80, "J"),
					new Beat(startTime+ gap *82, "D"),
					new Beat(startTime+ gap *84, "L"),
					new Beat(startTime+ gap *86, "S"),
					new Beat(startTime+ gap *88, "D"),
					new Beat(startTime+ gap *90, "L"),
					new Beat(startTime+ gap *92, "J"),
					new Beat(startTime+ gap *94, "K"),
					new Beat(startTime+ gap *96, "L"),
					new Beat(startTime+ gap *98, "S"),
					new Beat(startTime+ gap *100, "D"),
					new Beat(startTime+ gap *102, "Space"),
					new Beat(startTime+ gap *104, "S"),
					new Beat(startTime+ gap *106, "F"),
					new Beat(startTime+ gap *108, "J"),
					new Beat(startTime+ gap *110, "K"),
					new Beat(startTime+ gap *111, "S"),
					new Beat(startTime+ gap *113, "D"),
					new Beat(startTime+ gap *115, "S"),
					new Beat(startTime+ gap *117, "J"),
					new Beat(startTime+ gap *119, "K"),
					new Beat(startTime+ gap *121, "L"),
					new Beat(startTime+ gap *123, "S"),
					new Beat(startTime+ gap *125, "D"),
					new Beat(startTime+ gap *128, "L"),
					new Beat(startTime+ gap *130, "J"),
					new Beat(startTime+ gap *132, "K"),
					new Beat(startTime+ gap *134, "L"),
					new Beat(startTime+ gap *136, "S"),
					new Beat(startTime+ gap *138, "D"),
					new Beat(startTime+ gap *142, "Space"),
					new Beat(startTime+ gap *144, "S"),
					new Beat(startTime+ gap *146, "F"),
					new Beat(startTime+ gap *148, "J"),
					new Beat(startTime+ gap *150, "J"),
					new Beat(startTime+ gap *152, "D"),
					new Beat(startTime+ gap *154, "S"),
					new Beat(startTime+ gap *156, "D"),
					new Beat(startTime+ gap *158, "S"),
					new Beat(startTime+ gap *160, "J"),
					new Beat(startTime+ gap *162, "K"),
					new Beat(startTime+ gap *164, "L"),
					new Beat(startTime+ gap *166, "S"),
					new Beat(startTime+ gap *168, "D"),
					new Beat(startTime+ gap *170, "L"),
					new Beat(startTime+ gap *172, "J"),
					new Beat(startTime+ gap *174, "K"),
					new Beat(startTime+ gap *176, "L"),
					new Beat(startTime+ gap *178, "S"),
					new Beat(startTime+ gap *180, "D"),
					new Beat(startTime+ gap *182, "Space"),
					new Beat(startTime+ gap *184, "S"),
					new Beat(startTime+ gap *186, "F"),
					new Beat(startTime+ gap *188, "J"),
					new Beat(startTime+ gap *190, "J"),
					new Beat(startTime+ gap *192, "D"),
					new Beat(startTime+ gap *194, "L"),
					new Beat(startTime+ gap *196, "S"),
					new Beat(startTime+ gap *198, "D"),
					new Beat(startTime+ gap *200, "L"),
					new Beat(startTime+ gap *202, "J"),
					new Beat(startTime+ gap *204, "K"),
					new Beat(startTime+ gap *206, "L"),
					new Beat(startTime+ gap *208, "S"),
					new Beat(startTime+ gap *210, "D"),
					new Beat(startTime+ gap *212, "Space"),
					new Beat(startTime+ gap *214, "S"),
					new Beat(startTime+ gap *216, "F"),
					new Beat(startTime+ gap *218, "J"),
					new Beat(startTime+ gap *220, "K"),
					new Beat(startTime+ gap *222, "Space"),
					new Beat(startTime+ gap *224, "S"),
					new Beat(startTime+ gap *226, "F"),
					new Beat(startTime+ gap *228, "J"),
					new Beat(startTime+ gap *230, "J"),
					new Beat(startTime+ gap *232, "D"),
					new Beat(startTime+ gap *234, "L"),
					new Beat(startTime+ gap *236, "S"),
					new Beat(startTime+ gap *238, "D"),
					new Beat(startTime+ gap *240, "L"),
					new Beat(startTime+ gap *242, "J"),
					new Beat(startTime+ gap *244, "K"),
					new Beat(startTime+ gap *246, "L"),
					new Beat(startTime+ gap *248, "S"),
					new Beat(startTime+ gap *250, "D"),
					new Beat(startTime+ gap *252, "Space"),
					new Beat(startTime+ gap *254, "S"),
					new Beat(startTime+ gap *256, "F"),
					new Beat(startTime+ gap *258, "J"),
					new Beat(startTime+ gap *260, "K"),
					new Beat(startTime+ gap *262, "S"),
					new Beat(startTime+ gap *263, "D"),
					new Beat(startTime+ gap *265, "S"),
					new Beat(startTime+ gap *267, "Space"),
					new Beat(startTime+ gap *269, "K"),
					new Beat(startTime+ gap *271, "L"),
					new Beat(startTime+ gap *273, "S"),
					new Beat(startTime+ gap *275, "D"),
					new Beat(startTime+ gap *278, "L"),
					new Beat(startTime+ gap *280, "J"),
					new Beat(startTime+ gap *282, "K"),
					new Beat(startTime+ gap *284, "L"),
					new Beat(startTime+ gap *286, "S"),
					new Beat(startTime+ gap *288, "D"),
					new Beat(startTime+ gap *282, "Space"),
					new Beat(startTime+ gap *284, "S"),
					new Beat(startTime+ gap *286, "F"),
					new Beat(startTime+ gap *288, "J"),
					new Beat(startTime+ gap *290, "J"),
					new Beat(startTime+ gap *292, "D"),
					new Beat(startTime+ gap *294, "S"),
					new Beat(startTime+ gap *296, "D"),
					new Beat(startTime+ gap *298, "S"),
					new Beat(startTime+ gap *300, "J"),
					new Beat(startTime+ gap *302, "Space"),
					new Beat(startTime+ gap *304, "L"),
					new Beat(startTime+ gap *306, "S"),
					new Beat(startTime+ gap *308, "D"),
					new Beat(startTime+ gap *310, "L"),
					new Beat(startTime+ gap *312, "J"),
					new Beat(startTime+ gap *314, "K"),
					new Beat(startTime+ gap *316, "L"),
					new Beat(startTime+ gap *318, "S"),
					new Beat(startTime+ gap *320, "D"),
					new Beat(startTime+ gap *322, "Space"),
					new Beat(startTime+ gap *324, "S"),
					new Beat(startTime+ gap *326, "F"),
					new Beat(startTime+ gap *328, "J"),
					new Beat(startTime+ gap *330, "J"),
					new Beat(startTime+ gap *332, "D"),
					new Beat(startTime+ gap *334, "L"),
					new Beat(startTime+ gap *336, "Space"),
					new Beat(startTime+ gap *338, "D"),
					new Beat(startTime+ gap *340, "L"),
					};
	}
		if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard")) {
			// 많게는 3000개
			int startTime = 200;
			int gap = 125;
			beats = new Beat[]{new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 14, "S"),
					new Beat(startTime + gap * 18, "D"),
					new Beat(startTime + gap * 22, "S"),
					new Beat(startTime + gap * 26, "D"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 34, "K"),
					new Beat(startTime + gap * 38, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 46, "J"),
					new Beat(startTime + gap * 50, "K"),
					new Beat(startTime + gap * 54, "J"),
					new Beat(startTime + gap * 56, "K"),
					new Beat(startTime + gap * 60, "Space"),
					new Beat(startTime + gap * 64, "Space"),
					new Beat(startTime + gap * 68, "S"),
					new Beat(startTime + gap * 70, "L"),
					new Beat(startTime + gap * 72, "D"),
					new Beat(startTime + gap * 74, "K"),
					new Beat(startTime + gap * 76, "S"),
					new Beat(startTime + gap * 78, "L"),
					new Beat(startTime + gap * 80, "D"),
					new Beat(startTime + gap * 82, "K"),
					new Beat(startTime + gap * 84, "J"),
					new Beat(startTime + gap * 86, "K"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "F"),
					new Beat(startTime + gap * 90, "Space"),
					new Beat(startTime + gap * 90, "J"),
					new Beat(startTime + gap * 94, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 98, "D"),
					new Beat(startTime + gap * 100, "K"),
					new Beat(startTime + gap * 104, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 112, "D"),
					new Beat(startTime + gap * 116, "K"),
					new Beat(startTime + gap * 120, "D"),
					new Beat(startTime + gap * 124, "Space"),
					new Beat(startTime + gap * 128, "Space"),
					new Beat(startTime + gap * 130, "J"),
					new Beat(startTime + gap * 134, "F"),
					new Beat(startTime + gap * 138, "J"),
					new Beat(startTime + gap * 142, "F"),
					new Beat(startTime + gap * 146, "J"),
					new Beat(startTime + gap * 150, "F"),
					new Beat(startTime + gap * 152, "K"),
					new Beat(startTime + gap * 154, "J"),
					new Beat(startTime + gap * 158, "F"),
					new Beat(startTime + gap * 160, "Space"),
					new Beat(startTime + gap * 164, "S"),
					new Beat(startTime + gap * 166, "L"),
					new Beat(startTime + gap * 168, "D"),
					new Beat(startTime + gap * 170, "K"),
					new Beat(startTime + gap * 172, "S"),
					new Beat(startTime + gap * 174, "L"),
					new Beat(startTime + gap * 176, "D"),
					new Beat(startTime + gap * 178, "K"),
					new Beat(startTime + gap * 180, "J"),
					new Beat(startTime + gap * 182, "K"),
					new Beat(startTime + gap * 184, "L"),
					new Beat(startTime + gap * 186, "J"),
					new Beat(startTime + gap * 190, "K"),
					new Beat(startTime + gap * 194, "J"),
					new Beat(startTime + gap * 198, "K"),
					new Beat(startTime + gap * 202, "J"),
					new Beat(startTime + gap * 206, "K"),
					new Beat(startTime + gap * 210, "J"),
					new Beat(startTime + gap * 214, "K"),
					new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 220, "D"),
					new Beat(startTime + gap * 224, "S"),
					new Beat(startTime + gap * 228, "D"),
					new Beat(startTime + gap * 232, "S"),
					new Beat(startTime + gap * 236, "D"),
					new Beat(startTime + gap * 240, "J"),
					new Beat(startTime + gap * 244, "K"),
					new Beat(startTime + gap * 246, "L"),
					new Beat(startTime + gap * 248, "F"),
					new Beat(startTime + gap * 250, "Space"),
					new Beat(startTime + gap * 252, "J"),
					new Beat(startTime + gap * 256, "D"),
					new Beat(startTime + gap * 260, "K"),
					new Beat(startTime + gap * 264, "D"),
					new Beat(startTime + gap * 268, "K"),
					new Beat(startTime + gap * 272, "D"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 280, "D"),
					new Beat(startTime + gap * 284, "K"),
					new Beat(startTime + gap * 288, "D"),
					new Beat(startTime + gap * 292, "Space"),
					new Beat(startTime + gap * 294, "Space"),
					new Beat(startTime + gap * 298, "J"),
					new Beat(startTime + gap * 302, "F"),
					new Beat(startTime + gap * 306, "J"),
					new Beat(startTime + gap * 310, "F"),
					new Beat(startTime + gap * 314, "J"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 322, "K"),
					new Beat(startTime + gap * 326, "J"),
					new Beat(startTime + gap * 330, "D"),
					new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 334, "D"),
					new Beat(startTime + gap * 336, "S"),
					new Beat(startTime + gap * 338, "D"),
					new Beat(startTime + gap * 340, "S"),
					new Beat(startTime + gap * 342, "D"),
					new Beat(startTime + gap * 346, "J"),
					new Beat(startTime + gap * 350, "K"),
					new Beat(startTime + gap * 354, "J"),
					new Beat(startTime + gap * 358, "K"),
					new Beat(startTime + gap * 362, "J"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 370, "J"),
					new Beat(startTime + gap * 374, "K"),
					new Beat(startTime + gap * 378, "S"),
					new Beat(startTime + gap * 382, "D"),
					new Beat(startTime + gap * 386, "S"),
					new Beat(startTime + gap * 390, "D"),
					new Beat(startTime + gap * 394, "S"),
					new Beat(startTime + gap * 398, "D"),
					new Beat(startTime + gap * 402, "J"),
					new Beat(startTime + gap * 406, "K"),
					new Beat(startTime + gap * 410, "L"),
					new Beat(startTime + gap * 414, "F"),
					new Beat(startTime + gap * 418, "Space"),
					new Beat(startTime + gap * 422, "J"),
					new Beat(startTime + gap * 426, "F"),
					new Beat(startTime + gap * 430, "K"),
					new Beat(startTime + gap * 434, "D"),
					new Beat(startTime + gap * 438, "K"),
					new Beat(startTime + gap * 442, "D"),
					new Beat(startTime + gap * 446, "K"),
					new Beat(startTime + gap * 450, "D"),
					new Beat(startTime + gap * 452, "K"),
					new Beat(startTime + gap * 454, "D"),
					new Beat(startTime + gap * 456, "Space"),
					new Beat(startTime + gap * 460, "Space"),
					new Beat(startTime + gap * 462, "J"),
					new Beat(startTime + gap * 466, "F"),
					new Beat(startTime + gap * 470, "J"),
					new Beat(startTime + gap * 474, "F"),
					new Beat(startTime + gap * 478, "J"),
					new Beat(startTime + gap * 482, "F"),
					new Beat(startTime + gap * 486, "K"),
					new Beat(startTime + gap * 490, "J"),
					new Beat(startTime + gap * 492, "D"),
					new Beat(startTime + gap * 496, "S"),
					new Beat(startTime + gap * 500, "D"),
					new Beat(startTime + gap * 504, "S"),
					new Beat(startTime + gap * 508, "D"),
					new Beat(startTime + gap * 512, "S"),
					new Beat(startTime + gap * 514, "Space"),
					new Beat(startTime + gap * 518, "S"),
					new Beat(startTime + gap * 520, "L"),
					new Beat(startTime + gap * 524, "D"),
					new Beat(startTime + gap * 526, "K"),
					new Beat(startTime + gap * 528, "S"),
					new Beat(startTime + gap * 530, "L"),
					new Beat(startTime + gap * 532, "D"),
					new Beat(startTime + gap * 534, "K"),
					new Beat(startTime + gap * 536, "J"),
					new Beat(startTime + gap * 538, "K"),
					new Beat(startTime + gap * 540, "L"),
					new Beat(startTime + gap * 542, "D"),
					new Beat(startTime + gap * 544, "K"),
					new Beat(startTime + gap * 546, "S"),
					new Beat(startTime + gap * 548, "L"),
					new Beat(startTime + gap * 550, "D"),
					new Beat(startTime + gap * 552, "S"),
					new Beat(startTime + gap * 556, "D"),
					new Beat(startTime + gap * 560, "S"),
					new Beat(startTime + gap * 564, "D"),
					new Beat(startTime + gap * 568, "S"),
					new Beat(startTime + gap * 572, "D"),
					new Beat(startTime + gap * 576, "J"),
					new Beat(startTime + gap * 580, "K"),
					new Beat(startTime + gap * 582, "L"),
					new Beat(startTime + gap * 584, "F"),
					new Beat(startTime + gap * 585, "Space"),
					new Beat(startTime + gap * 586, "J"),
					new Beat(startTime + gap * 590, "F"),
					new Beat(startTime + gap * 594, "K"),
					new Beat(startTime + gap * 598, "D"),
					new Beat(startTime + gap * 602, "K"),
					new Beat(startTime + gap * 606, "D"),
					new Beat(startTime + gap * 608, "K"),
					new Beat(startTime + gap * 610, "D"),
					new Beat(startTime + gap * 614, "K"),
					new Beat(startTime + gap * 618, "D"),
					new Beat(startTime + gap * 620, "Space"),
					new Beat(startTime + gap * 624, "Space"),
					new Beat(startTime + gap * 628, "J"),
					new Beat(startTime + gap * 632, "F"),
					new Beat(startTime + gap * 636, "J"),
					new Beat(startTime + gap * 640, "F"),
					new Beat(startTime + gap * 644, "J"),
					new Beat(startTime + gap * 648, "F"),
					new Beat(startTime + gap * 652, "K"),
					new Beat(startTime + gap * 656, "J"),
					new Beat(startTime + gap * 658, "Space"),
					new Beat(startTime + gap * 660, "Space"),
					new Beat(startTime + gap * 664, "J"),
					new Beat(startTime + gap * 668, "F"),
					new Beat(startTime + gap * 670, "J"),
					new Beat(startTime + gap * 674, "F"),
					new Beat(startTime + gap * 678, "J"),
					new Beat(startTime + gap * 682, "F"),
					new Beat(startTime + gap * 686, "K"),
					new Beat(startTime + gap * 690, "J"),
					new Beat(startTime + gap * 692, "D"),
					new Beat(startTime + gap * 696, "S"),
					new Beat(startTime + gap * 700, "D"),
					new Beat(startTime + gap * 704, "S"),
					new Beat(startTime + gap * 708, "D"),
					new Beat(startTime + gap * 712, "S"),
					new Beat(startTime + gap * 716, "D"),
					new Beat(startTime + gap * 720, "J"),
					new Beat(startTime + gap * 724, "K"),
					new Beat(startTime + gap * 728, "J"),
					new Beat(startTime + gap * 732, "K"),
					new Beat(startTime + gap * 736, "J"),
					new Beat(startTime + gap * 740, "K"),
					new Beat(startTime + gap * 744, "J"),
					new Beat(startTime + gap * 748, "K"),
					new Beat(startTime + gap * 752, "S"),
					new Beat(startTime + gap * 756, "D"),
					new Beat(startTime + gap * 760, "S"),
					new Beat(startTime + gap * 764, "D"),
					new Beat(startTime + gap * 768, "S"),
					new Beat(startTime + gap * 772, "D"),
					new Beat(startTime + gap * 776, "J"),
					new Beat(startTime + gap * 780, "K"),
					new Beat(startTime + gap * 782, "L"),
					new Beat(startTime + gap * 784, "F"),
					new Beat(startTime + gap * 785, "Space"),
					new Beat(startTime + gap * 786, "J"),
					new Beat(startTime + gap * 790, "F"),
					new Beat(startTime + gap * 794, "K"),
					new Beat(startTime + gap * 798, "D"),
					new Beat(startTime + gap * 802, "K"),
					new Beat(startTime + gap * 806, "D"),
					new Beat(startTime + gap * 808, "K"),
					new Beat(startTime + gap * 810, "D"),
					new Beat(startTime + gap * 814, "K"),
					new Beat(startTime + gap * 818, "D"),
					new Beat(startTime + gap * 820, "Space"),
					new Beat(startTime + gap * 824, "Space"),
					new Beat(startTime + gap * 828, "J"),
					new Beat(startTime + gap * 832, "F"),
					new Beat(startTime + gap * 836, "J"),
					new Beat(startTime + gap * 840, "F"),
					new Beat(startTime + gap * 844, "J"),
					new Beat(startTime + gap * 848, "F"),
					new Beat(startTime + gap * 852, "K"),
					new Beat(startTime + gap * 856, "J"),
					new Beat(startTime + gap * 860, "Space"),
					new Beat(startTime + gap * 864, "Space"),
					new Beat(startTime + gap * 868, "S"),
					new Beat(startTime + gap * 870, "L"),
					new Beat(startTime + gap * 872, "D"),
					new Beat(startTime + gap * 874, "K"),
					new Beat(startTime + gap * 876, "S"),
					new Beat(startTime + gap * 878, "L"),
					new Beat(startTime + gap * 880, "D"),
					new Beat(startTime + gap * 882, "K"),
					new Beat(startTime + gap * 884, "J"),
					new Beat(startTime + gap * 886, "K"),
					new Beat(startTime + gap * 888, "L"),
					new Beat(startTime + gap * 890, "D"),
					new Beat(startTime + gap * 892, "K"),
					new Beat(startTime + gap * 894, "S"),
					new Beat(startTime + gap * 896, "L"),
					new Beat(startTime + gap * 900, "Space"),
					new Beat(startTime + gap * 902, "Space"),
					new Beat(startTime + gap * 906, "Space"),
					new Beat(startTime + gap * 912, "J"),
					new Beat(startTime + gap * 916, "F"),
					new Beat(startTime + gap * 920, "J"),
					new Beat(startTime + gap * 924, "F"),
					new Beat(startTime + gap * 928, "J"),
					new Beat(startTime + gap * 928, "F"),
					new Beat(startTime + gap * 932, "L"),
					new Beat(startTime + gap * 932, "S"),
					new Beat(startTime + gap * 936, "J"),
					new Beat(startTime + gap * 936, "F"),
					new Beat(startTime + gap * 940, "L"),
					new Beat(startTime + gap * 940, "S"),
					new Beat(startTime + gap * 944, "J"),
					new Beat(startTime + gap * 944, "F"),
					new Beat(startTime + gap * 948, "L"),
					new Beat(startTime + gap * 948, "S"),
					new Beat(startTime + gap * 952, "D"),
					new Beat(startTime + gap * 952, "K"),
					new Beat(startTime + gap * 956, "D"),
					new Beat(startTime + gap * 956, "K"),
					new Beat(startTime + gap * 960, "Space"),
					new Beat(startTime + gap * 964, "Space")
			};
		}
		else if(titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[]{
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[]{
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Bensound - Energy") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[]{
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Bensound - Energy") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[]{
					new Beat(startTime, "Space"),
			};
		}
		int i =0;
		gameMusic.start();
		while(i< beats.length && !isInterrupted()){
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void judge(String input) {
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if(!judge.equals("NONE")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/flare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Late.png")).getImage();
	         score += 100;
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Good.png")).getImage();
			score += 300;
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Great.png")).getImage();
			score += 500;
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Perfect.png")).getImage();
			score += 300;
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Early.png")).getImage();
			score += 100;
		}
	}
	
	
}
