Unofficial Google Developer Console API
===================

This is still work in progress.
This is intended to be a Java API for accessing data from Google Play Developer Console.
This has been done in making Andlytics (https://github.com/AndlyticsProject/andlytics), an android app that lets you see stats from Dev Console.
In fact, all the original code is taken straight from Andlytics except with all android dependencies removed.

Sample usage as shown in [test][1]:
```java
// ...
accountName = "yourAccount@email.com";
password = "yourpassword";

// Initial log-in setup ...
DevConsole console = DevConsoleV2.createForAccountAndPassword(accountName, password);

// Requst the data ...
List<AppInfo> appInfo = console.getAppInfo();

// Code below just prints a bunch of values retrieved.
println("Number of apps: " + appInfo.size());

AppInfo app = appInfo.get(0); // Get first app
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

stats.calcAll(); // Convinience method to calc some common stats
println("Average Rating: " + stats.getAvgRating());
println("Ratings count: " + stats.getRatingCount());
println("Total Downloads: " + stats.getTotalDownloads());
```
[1]: https://github.com/xiaochuanyu/DeveloperConsoleAPI/blob/master/Test/src/com/github/devconsole/test/Main.java
