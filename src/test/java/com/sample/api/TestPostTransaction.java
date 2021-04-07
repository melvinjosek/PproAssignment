package com.sample.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.PostTransactionHelper;
import model.PostTransactionResponse;
import model.Transaction;

public class TestPostTransaction {
	PostTransactionHelper postTran;

	@BeforeClass
	public void init() {
		postTran = new PostTransactionHelper();
	}

	@Test
	public void testSuccessTran() {
		Transaction tran = new Transaction();
		tran.setAmount(1000);
		tran.setCountryCode("DE");
		tran.setCurrency("EUR");
		PostTransactionResponse postResp = postTran.postTransaction(tran);
		assertEquals(postResp.getResponseCode(), "0");
		assertNotNull(postResp.getData().get(0).getSessionId());
		assertNotNull(postResp.getData().get(0).getOrderId());
		assertEquals(postResp.getData().get(0).getAmount().intValue(), 1000);
		assertEquals(postResp.getData().get(0).getMessage(), "Transaction succeeded");
		assertEquals(postResp.getData().get(0).getStatus().booleanValue(), true);
	}

	@Test
	public void testInvalidAmount() {
		Transaction tran = new Transaction();
		tran.setAmount(1001);
		tran.setCountryCode("DE");
		tran.setCurrency("EUR");
		PostTransactionResponse postResp = postTran.postTransaction(tran);
		assertEquals(postResp.getAdditionalProperties().get("error"), "Amount not allowed");
	}

	@Test
	public void testInvalidCurrency() {
		Transaction tran = new Transaction();
		tran.setAmount(1000);
		tran.setCountryCode("DE");
		tran.setCurrency("AUD");
		PostTransactionResponse postResp = postTran.postTransaction(tran);
		assertEquals(postResp.getAdditionalProperties().get("error"), "Currency not allowed on selected country");
	}

	@Test
	public void testInvalidCountry() {
		Transaction tran = new Transaction();
		tran.setAmount(1000);
		tran.setCountryCode("DEN");
		tran.setCurrency("EUR");
		PostTransactionResponse postResp = postTran.postTransaction(tran);
		assertEquals(postResp.getAdditionalProperties().get("error"), "Country not allowed");
	}
}
