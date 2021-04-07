package model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"orderId",
"sessionId",
"amount",
"status",
"message"
})
public class Datum {

@JsonProperty("orderId")
private Integer orderId;
@JsonProperty("sessionId")
private String sessionId;
@JsonProperty("amount")
private Integer amount;
@JsonProperty("status")
private Boolean status;
@JsonProperty("message")
private String message;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("orderId")
public Integer getOrderId() {
return orderId;
}

@JsonProperty("orderId")
public void setOrderId(Integer orderId) {
this.orderId = orderId;
}

@JsonProperty("sessionId")
public String getSessionId() {
return sessionId;
}

@JsonProperty("sessionId")
public void setSessionId(String sessionId) {
this.sessionId = sessionId;
}

@JsonProperty("amount")
public Integer getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Integer amount) {
this.amount = amount;
}

@JsonProperty("status")
public Boolean getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(Boolean status) {
this.status = status;
}

@JsonProperty("message")
public String getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(String message) {
this.message = message;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
