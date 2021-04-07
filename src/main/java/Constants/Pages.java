package Constants;

public enum Pages {
	CONFIG("Config");

	private final String pages;

	Pages(String pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return this.pages;
	}
}
