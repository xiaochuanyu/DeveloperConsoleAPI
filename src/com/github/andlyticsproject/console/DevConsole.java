package com.github.andlyticsproject.console;

import java.util.List;

import com.github.andlyticsproject.model.AppInfo;
import com.github.andlyticsproject.model.Comment;

public interface DevConsole {

	List<AppInfo> getAppInfo() throws DevConsoleException;

	List<Comment> getComments(String packageName, String developerId,
			int startIndex, int count, String displayLocale) throws DevConsoleException;

	Comment replyToComment(String packageName, String developerId,
			String commentUniqueId, String reply);

}
