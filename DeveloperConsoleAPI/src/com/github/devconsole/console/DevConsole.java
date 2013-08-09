package com.github.devconsole.console;

import java.util.List;

import com.github.devconsole.model.AppInfo;
import com.github.devconsole.model.Comment;

public interface DevConsole {

	List<AppInfo> getAppInfo() throws DevConsoleException;

	List<Comment> getComments(String packageName, String developerId,
			int startIndex, int count, String displayLocale) throws DevConsoleException;

	Comment replyToComment(String packageName, String developerId,
			String commentUniqueId, String reply);

}
