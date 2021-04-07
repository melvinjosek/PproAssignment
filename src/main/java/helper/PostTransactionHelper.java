package helper;

import frameworkPackage.DataBlock;
import frameworkPackage.ApiCall;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import model.PostTransactionResponse;
import model.Transaction;

public class PostTransactionHelper extends ApiCall {
	String apiKey;

	public PostTransactionHelper() {
		RestAssured.baseURI = DataBlock.readCsvValue("Config", "", "url");
		apiKey = DataBlock.readCsvValue("Config", "", "apiKey");
	}

	public PostTransactionResponse postTransaction(Transaction tran) {
		reqSpecification = RestAssured.given().header("api_key", apiKey).contentType(ContentType.JSON).body(tran);
		response = reqSpecification.post().andReturn();
		cleanUpLog();
		return response.as(PostTransactionResponse.class, ObjectMapperType.JACKSON_2);
	}
}
