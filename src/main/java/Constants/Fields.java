package Constants;

public enum Fields {
	URL("url"), API_KEY("apiKey");

	private final String fields;

	Fields(String fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return this.fields;
	}
}
