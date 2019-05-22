package com.duco;

import java.util.List;

/* this is the data structure which is storing
 * list of matched data and unmatched items
 */
public class ReconciledData {

	private List<Object> matchedList;
	
	private List<Object> unmatchedItems;

	public List<Object> getMatchedList() {
		return matchedList;
	}

	public void setMatchedList(List<Object> matchedList) {
		this.matchedList = matchedList;
	}

	public List<Object> getUnmatchedItems() {
		return unmatchedItems;
	}

	public void setUnmatchedItems(List<Object> unmatchedItems) {
		this.unmatchedItems = unmatchedItems;
	}
}
