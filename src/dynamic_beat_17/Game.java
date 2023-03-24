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
		g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 440, 300, null);
		g.drawImage(judgeImage, 460, 420, null);
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
			int startTime = 1000;
			beats = new Beat[]{
					new Beat(startTime, "Space"),
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
