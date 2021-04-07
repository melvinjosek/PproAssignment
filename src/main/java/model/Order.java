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
"transaction_status"
})
public class Order {

@JsonProperty("orderId")
private Integer orderId;
@JsonProperty("transaction_status")
private String transactionStatus;
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

@JsonProperty("transaction_status")
public String getTransactionStatus() {
return transactionStatus;
}

@JsonProperty("transaction_status")
public void setTransactionStatus(String transactionStatus) {
this.transactionStatus = transactionStatus;
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