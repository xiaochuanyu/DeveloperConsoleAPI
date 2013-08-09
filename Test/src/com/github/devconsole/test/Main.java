package com.github.devconsole.test;

import java.util.List;
import java.util.Scanner;

import com.github.devconsole.console.DevConsole;
import com.github.devconsole.console.v2.DevConsoleV2;
import com.github.devconsole.model.AppDetails;
import com.github.devconsole.model.AppInfo;
import com.github.devconsole.model.AppStats;

public class Main {

	public static void main(String[] args) {
		String accountName;
		String password;

		Scanner s = new Scanner(System.in);
		
		System.out.print("Username:");
		accountName = s.next();
		System.out.print("Password:");
		password = s.next();
		
		s.close();
		
		println("==========Logging in and grabbing data=============");
		DevConsole console = DevConsoleV2.createForAccountAndPassword(accountName, password);
		List<AppInfo> appInfo = console.getAppInfo();
		println("===================================================");
		println("");
		println("Number of apps: " + appInfo.size());
		
		AppInfo app = appInfo.get(0);
		println("Name : " + app.getName());
		println("Developer name: " + app.getDeveloperName());
		println("Icon URL : " + app.getIconUrl());
		println("Package: " + app.getPackageName());

		AppDetails details = app.getDetails();
		println("Description:\n" + details.getDescription());
		println("Change Log: " + details.getChangelog());
		println("Last Store Update: " + details.getLastStoreUpdate());

		AppStats stats = app.getLatestStats();
		println("Active Installs: " + stats.getActiveInstalls());
		println("Ratings 1: " + stats.getRating1());
		println("Ratings 2: " + stats.getRating2());
		println("Ratings 3: " + stats.getRating3());
		println("Ratings 4: " + stats.getRating4());
		println("Ratings 5: " + stats.getRating5());
		
		stats.calcAll();
		println("Average Rating: " + stats.getAvgRating());
		println("Ratings count: " + stats.getRatingCount());
		println("Total Downloads: " + stats.getTotalDownloads());

	}

	private static <T> void println(T t) {
		System.out.println(t);
	}
}
