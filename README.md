##Unofficial Google Developer Console API

Java API for accessing data from Google Play Developer Console.

Code is pretty much copied from Andlytics (https://github.com/AndlyticsProject/andlytics), an android app that lets you see stats from Dev Console.

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
System.out.println("Number of apps: " + appInfo.size());

AppInfo app = appInfo.get(0); // Get first app
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

stats.calcAll(); // Convinience method to calc some common stats
System.out.println("Average Rating: " + stats.getAvgRating());
System.out.println("Ratings count: " + stats.getRatingCount());
System.out.println("Total Downloads: " + stats.getTotalDownloads());
```
[1]: https://github.com/xiaochuanyu/DeveloperConsoleAPI/blob/master/Test/src/com/github/devconsole/test/Main.java
