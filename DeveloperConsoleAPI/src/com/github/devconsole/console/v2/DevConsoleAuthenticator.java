package com.github.devconsole.console.v2;


import com.github.devconsole.console.DevConsoleException;

public interface DevConsoleAuthenticator {

	String getAccountName();

	// Use this when calling from a service. Won't launch any UIs
	SessionCredentials authenticateSilently(boolean invalidate) throws DevConsoleException;
}
