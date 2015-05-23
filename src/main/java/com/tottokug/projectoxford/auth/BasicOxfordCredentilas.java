package com.tottokug.projectoxford.auth;

public class BasicOxfordCredentilas implements OxfordCredentials {

	private String subscriptionKey;

	public BasicOxfordCredentilas(String subscriptKey) {
		this.subscriptionKey = subscriptKey;
	}

	@Override
	public String getSubscriptionKey() {
		return this.subscriptionKey;
	}

}
