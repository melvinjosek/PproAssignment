package frameworkPackage;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiCall {

	protected Response response ;
	protected RequestSpecification reqSpecification ;
	
	
	public static void setUpLog() {
		
	}

	public void cleanUpLog() {		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement el = JsonParser.parseString(StringEscapeUtils.unescapeHtml4(response.body().asString()));
		LogCollapsed("Response Body","<pre>"+StringEscapeUtils.unescapeHtml4(gson.toJson(el))+"<//pre>");
		Log("Response Headers : "+"<pre>"+response.headers()+"<//pre>");		
		Log("Response Status : "+"<pre>"+response.statusCode()+" "+response.getStatusLine()+"<//pre>");	
		Log("Response Time(ms) : "+"<pre>"+response.timeIn(TimeUnit.MILLISECONDS)+"<//pre>");			
	}

	public static void Log(String message) {
		ExtentTestManager.getTest().log(Status.INFO, message);
	}
	
	public static void LogCollapsed(String text,String message) {
		ExtentTestManager.getTest().createNode(text).log(Status.INFO,message);
	}

	public static void Log(Status status, String message) {
		ExtentTestManager.getTest().log(status, message);
	}

}
