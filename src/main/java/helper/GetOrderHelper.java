package helper;

import Constants.Fields;
import Constants.Pages;
import frameworkPackage.DataBlock;
import frameworkPackage.ApiCall;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import model.Order;

public class GetOrderHelper extends ApiCall{
	String apiKey;

	public GetOrderHelper() {
		RestAssured.baseURI = DataBlock.readCsvValue(Pages.CONFIG.toString(), "", Fields.URL.toString());
		apiKey = DataBlock.readCsvValue(Pages.CONFIG.toString(), "", Fields.API_KEY.toString());
	}

	public Order getOrder(String orderId) {
		reqSpecification = RestAssured
				.given().header("api_key", apiKey).contentType(ContentType.JSON).queryParam("orderId", orderId);
		response = reqSpecification.get().andReturn();
		cleanUpLog();
		return response.as(Order.class, ObjectMapperType.JACKSON_2);
	}
}
