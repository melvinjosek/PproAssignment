package Constants;

public enum DataCodes{
	NONE("");
	
	private final String dataCodes;

	DataCodes(String dataCodes) {
		this.dataCodes = dataCodes;
	}

	@Override
	public String toString() {
		return this.dataCodes;
	}
}
