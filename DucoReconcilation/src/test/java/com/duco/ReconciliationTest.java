package com.duco;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReconciliationTest {

	@Test
	public void numericInputs()
	{
		System.out.println("Numeric inputs test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		listA.add(54);
		listA.add(11);
		listA.add(28.33);
		listA.add(36.2);
		
		listB.add(111);
		listB.add(36.2);
		listB.add(11);
		listB.add(14.4);
		
		printItems("list A", listA);
		printItems("list B", listB);
				
		List<Object> expectedMatched = new ArrayList<Object>();
		expectedMatched.add(11);
		expectedMatched.add(11);
		expectedMatched.add(36.2);
		expectedMatched.add(36.2);

		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add(54);
		expectedUnmatched.add(28.33);
		expectedUnmatched.add(111);
		expectedUnmatched.add(14.4);
		
		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		//this also check the order of list objects
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	@Test
	public void duplicates()
	{
		System.out.println("Numeric duplicate test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		listA.add(54);
		listA.add(36.2);
		listA.add(36.2);
		listA.add(36.2);
		
		listB.add(111);
		listB.add(36.2);
		listB.add(36.2);
		listB.add(14.4);
		
		printItems("list A", listA);
		printItems("list B", listB);
		
		List<Object> expectedMatched = new ArrayList<Object>();
		expectedMatched.add(36.2);
		expectedMatched.add(36.2);
		expectedMatched.add(36.2);
		expectedMatched.add(36.2);
		
		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add(54);
		expectedUnmatched.add(36.2);
		expectedUnmatched.add(111);
		expectedUnmatched.add(14.4);
		
		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	
	@Test
	public void nonNumeric()
	{
		System.out.println("non numeric test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		listA.add("TRADE1");
		listA.add("TRADE2");
		listA.add("TRADE3");
		listA.add("TRDE4");
		
		listB.add("TRADE1");
		listB.add("TRAD2");
		listB.add("TRADE3");
		listB.add("TRADE4");
		
		printItems("list A", listA);
		printItems("list B", listB);
				
		List<Object> expectedMatched = new ArrayList<Object>();
		expectedMatched.add("TRADE1");
		expectedMatched.add("TRADE1");
		expectedMatched.add("TRADE3");
		expectedMatched.add("TRADE3");
		
		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add("TRADE2");
		expectedUnmatched.add("TRDE4");
		expectedUnmatched.add("TRAD2");
		expectedUnmatched.add("TRADE4");
		
		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	@Test
	public void mixed()
	{
		System.out.println("Numeric and non numeric test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		listA.add(1);
		listA.add(12.5);
		listA.add("TRADE3");
		listA.add("TRDE4");
		
		listB.add("TRADE1");
		listB.add(1);
		listB.add("TRADE3");
		listB.add(1);
		listB.add(48);
		
		printItems("list A", listA);
		printItems("list B", listB);
				
		List<Object> expectedMatched = new ArrayList<Object>();
		expectedMatched.add(1);
		expectedMatched.add(1);
		expectedMatched.add("TRADE3");
		expectedMatched.add("TRADE3");
		
		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add(12.5);
		expectedUnmatched.add("TRDE4");
		expectedUnmatched.add("TRADE1");
		expectedUnmatched.add(1);
		expectedUnmatched.add(48);
		
		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	@Test
	public void EmptyListA()
	{
		System.out.println("empty list A test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		
		listB.add(1);
		listB.add(1);
		
		printItems("list A", listA);
		printItems("list B", listB);
				
		List<Object> expectedMatched = new ArrayList<Object>();
		
		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add(1);
		expectedUnmatched.add(1);

		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	@Test
	public void EmptyListB()
	{
		System.out.println("empty list B test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
		
		listA.add(1);
		listA.add("ABC");
		
		printItems("list A", listA);
		printItems("list B", listB);
				
		List<Object> expectedMatched = new ArrayList<Object>();
		
		List<Object> expectedUnmatched = new ArrayList<Object>();
		expectedUnmatched.add(1);
		expectedUnmatched.add("ABC");

		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	@Test
	public void EmptyListAB()
	{
		System.out.println("empty list A and B test");
		List<Object> listA = new ArrayList<Object>();
		List<Object> listB = new ArrayList<Object>();
				
		printItems("list A", listA);
		printItems("list B", listB);
		
		List<Object> expectedMatched = new ArrayList<Object>();
		
		List<Object> expectedUnmatched = new ArrayList<Object>();

		ReconciledData result = Reconciliation.reconcileData(listA, listB);
		printItems("Matched", result.getMatchedList());
		printItems("Unmatched", result.getUnmatchedItems());
		
		Assert.assertEquals(expectedMatched, result.getMatchedList());
		Assert.assertEquals(expectedUnmatched, result.getUnmatchedItems());
	}
	
	private void printItems(String item, List<Object> dataList) {
		
		for(Object data:dataList) {
			System.out.println(item + ": "+data);
		}
	}
}
