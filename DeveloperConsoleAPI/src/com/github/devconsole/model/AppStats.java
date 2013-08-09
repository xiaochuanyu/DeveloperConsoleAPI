
package com.github.devconsole.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppStats {

	private int totalDownloads;

	private int activeInstalls;

	private int numberOfComments;

	private Date requestDate;

	private Integer versionCode;

	private Integer rating1 = 0;

	private Integer rating2 = 0;

	private Integer rating3 = 0;

	private Integer rating4 = 0;

	private Integer rating5 = 0;

	private float avgRating;

	private int ratingCount;

	// TODO -- do we support diffs for this?
	private Integer numberOfErrors;

	public AppStats() {
	}

	/**
	 * Copy Constructor
	 *
	 * @param appStats a <code>AppStats</code> object
	 */
	public AppStats(AppStats appStats) {
		this.totalDownloads = appStats.totalDownloads;
		this.activeInstalls = appStats.activeInstalls;
		this.numberOfComments = appStats.numberOfComments;
		this.requestDate = appStats.requestDate;
		this.rating1 = appStats.rating1;
		this.rating2 = appStats.rating2;
		this.rating3 = appStats.rating3;
		this.rating4 = appStats.rating4;
		this.rating5 = appStats.rating5;
		this.avgRating = appStats.avgRating;
		this.ratingCount = appStats.ratingCount;
		this.versionCode = appStats.versionCode;
	}

	public void calcAll() {
		calcAvgRating();
		calcRatingCount();
	}

	public int getTotalDownloads() {
		return totalDownloads;
	}

	public void setTotalDownloads(int totalDownloads) {
		this.totalDownloads = totalDownloads;
	}

	public int getActiveInstalls() {
		return activeInstalls;
	}

	public void setActiveInstalls(int activeInstalls) {
		this.activeInstalls = activeInstalls;
	}

	public int getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


	public void setRating(Integer rating1, Integer rating2, Integer rating3, Integer rating4,
			Integer rating5) {
		this.rating1 = rating1;
		this.rating2 = rating2;
		this.rating3 = rating3;
		this.rating4 = rating4;
		this.rating5 = rating5;
	}

	public void addRating(int i, int value) {

		switch (i) {
			case 1:
				this.rating1 = value;
				break;
			case 2:
				this.rating2 = value;
				break;
			case 3:
				this.rating3 = value;
				break;
			case 4:
				this.rating4 = value;
				break;
			case 5:
				this.rating5 = value;
				break;

			default:
				break;
		}

	}

	public float getAvgRating() {

		return avgRating;

	}

	public void calcAvgRating() {

		float ratings = 0;
		float count = 0;

		for (int i = 1; i < 6; i++) {

			int value = 0;

			switch (i) {
				case 1:
					value = rating1;
					break;
				case 2:
					value = rating2;
					break;
				case 3:
					value = rating3;
					break;
				case 4:
					value = rating4;
					break;
				case 5:
					value = rating5;
					break;

				default:
					break;
			}

			ratings += i * value;
			count += value;
		}

		if (count < 1) {
			this.avgRating = 0;
		} else {
			this.avgRating = ratings / count;
		}
	}

	public int getRatingCount() {
		return ratingCount;
	}

	public void calcRatingCount() {
		this.ratingCount = rating1 + rating2 + rating3 + rating4 + rating5;

	}

	public String getRequestDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(getRequestDate());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activeInstalls;
		result = prime * result + numberOfComments;
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + totalDownloads;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppStats other = (AppStats) obj;
		if (activeInstalls != other.activeInstalls)
			return false;
		if (numberOfComments != other.numberOfComments)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (totalDownloads != other.totalDownloads)
			return false;
		return true;
	}

	public Integer getRating1() {
		return rating1;
	}

	public void setRating1(Integer rating1) {
		this.rating1 = rating1;
	}

	public Integer getRating2() {
		return rating2;
	}

	public void setRating2(Integer rating2) {
		this.rating2 = rating2;
	}

	public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
	}

	public Integer getRating4() {
		return rating4;
	}

	public void setRating4(Integer rating4) {
		this.rating4 = rating4;
	}

	public Integer getRating5() {
		return rating5;
	}

	public void setRating5(Integer rating5) {
		this.rating5 = rating5;
	}


	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setNumberOfErrors(Integer numberOfErrors) {
		this.numberOfErrors = numberOfErrors;
	}

	public Integer getNumberOfErrors() {
		return numberOfErrors;
	}

}
