package com.duco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reconcilation {

	//this function is accepting 2 list of data and returning datastructure of matched and unmatched items
	public static ReconciledData reconcileData(List<?> listA, List<?> listB)
	{
		ReconciledData result = new ReconciledData();

		//created 2 list for storing output data
		List<Object> matchedData = new ArrayList<Object>();
		List<Object> unmatchedData = new ArrayList<Object>();

		if(null != listA && !listA.isEmpty())
		{
			//iterating over list A to check matched data in list B
			Iterator<?> iterator = listA.iterator();
			while(iterator.hasNext())
			{
				//getting the next item from iterator
				Object listItem = iterator.next();

				//if the object not found then indexOf return -1
				if(listB.indexOf(listItem) != -1)
				{
					//if the match is found then add the item in the matchedData
					matchedData.add(listItem);

					//if we need only single matched item in the matchedData list to return then we need to remove below line
					//but as of now I have added as it is shown in the test cases
					matchedData.add(listB.get(listB.indexOf(listItem)));

					//and remove the item from listB so it is not matched again
					listB.remove(listItem);
				}
				else
				{
					//if data not matched then add in the unmatchedData list
					unmatchedData.add(listItem);
				}
			}
		}
		//the remaining items in the listB are all the unmatched items 
		//which should be added in unmatchedData list
		for(Object unmatchedItems:listB)
		{
			unmatchedData.add(unmatchedItems);
		}

		//add the lists and return
		result.setMatchedList(matchedData);
		result.setUnmatchedItems(unmatchedData);
		return result;
	}
}
