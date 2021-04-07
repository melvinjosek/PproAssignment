package com.sample.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import frameworkPackage.ExtentTestManager;
import helper.GetOrderHelper;
import helper.PostTransactionHelper;
import model.Order;
import model.Transaction;

public class TestGetOrder {
	GetOrderHelper getOrder;
	@BeforeClass
	public void init() {
		getOrder = new GetOrderHelper();
	}

	@Test
	public void testInvalidOrder() {
		Order respOrder = getOrder.getOrder("425139");
		assertEquals(respOrder.getAdditionalProperties().get("error").toString(),"Order Id not valid");
	}
	@Test
	public void testValidOrder() {
		Transaction tran = new Transaction();
		tran.setAmount(1000);
		tran.setCountryCode("DE");
		tran.setCurrency("EUR");
		PostTransactionHelper postTran = new PostTransactionHelper();
		String orderId = postTran.postTransaction(tran).getData().get(0).getOrderId().toString();
		ExtentTestManager.getTest().log(Status.INFO,"Order Id :"+orderId);
		Order respOrder = getOrder.getOrder(orderId);
		assertNotNull(respOrder.getOrderId());
		assertEquals(respOrder.getTransactionStatus(),"Pending");
	}
}
