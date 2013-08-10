package com.xiao.devconsole.console;

import java.util.List;

import com.xiao.devconsole.model.AppInfo;
import com.xiao.devconsole.model.Comment;

public interface DevConsole {

	List<AppInfo> getAppInfo() throws DevConsoleException;

	List<Comment> getComments(String packageName, String developerId,
			int startIndex, int count, String displayLocale) throws DevConsoleException;

	Comment replyToComment(String packageName, String developerId,
			String commentUniqueId, String reply);

}
