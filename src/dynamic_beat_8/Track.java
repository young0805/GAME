package dynamic_beat_8;

public class Track {

	private String titleImage; // ���� �κ� �̹��� 
	private String startImage; // ���� ���� â ǥ�� �̹���
	private String gameImage; // �ش� ���� �������� �� ǥ�� �̹���
	private String startMusic; // ���� ���� â ����
	private String gmaeMusic; // �ش� ���� �������� �� ����
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGmaeMusic() {
		return gmaeMusic;
	}
	public void setGmaeMusic(String gmaeMusic) {
		this.gmaeMusic = gmaeMusic;
	}
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gmaeMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gmaeMusic = gmaeMusic;
	}

	
	
}
