package com.xiao.devconsole.test;

import java.util.List;
import java.util.Scanner;

import com.xiao.devconsole.console.DevConsole;
import com.xiao.devconsole.console.v2.DevConsoleV2;
import com.xiao.devconsole.model.AppDetails;
import com.xiao.devconsole.model.AppInfo;
import com.xiao.devconsole.model.AppStats;

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
		
		System.out.println("==========Logging in and grabbing data=============");
		DevConsole console = DevConsoleV2.createForAccountAndPassword(accountName, password);
		List<AppInfo> appInfo = console.getAppInfo();
		System.out.println("===================================================");
		System.out.println("");
		System.out.println("Number of apps: " + appInfo.size());
		
		AppInfo app = appInfo.get(0);
		System.out.println("Name : " + app.getName());
		System.out.println("Developer name: " + app.getDeveloperName());
		System.out.println("Icon URL : " + app.getIconUrl());
		System.out.println("Package: " + app.getPackageName());

		AppDetails details = app.getDetails();
		System.out.println("Description:\n" + details.getDescription());
		System.out.println("Change Log: " + details.getChangelog());
		System.out.println("Last Store Update: " + details.getLastStoreUpdate());

		AppStats stats = app.getLatestStats();
		System.out.println("Active Installs: " + stats.getActiveInstalls());
		System.out.println("Ratings 1: " + stats.getRating1());
		System.out.println("Ratings 2: " + stats.getRating2());
		System.out.println("Ratings 3: " + stats.getRating3());
		System.out.println("Ratings 4: " + stats.getRating4());
		System.out.println("Ratings 5: " + stats.getRating5());
		
		stats.calcAll();
		System.out.println("Average Rating: " + stats.getAvgRating());
		System.out.println("Ratings count: " + stats.getRatingCount());
		System.out.println("Total Downloads: " + stats.getTotalDownloads());

	}

}
