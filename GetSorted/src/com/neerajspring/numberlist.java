package com.neerajspring;

import java.io.Serializable;
import java.util.Arrays;

public class numberlist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numlist;
	private String sortedNumlist;
	private Integer changeNo;
	private Long timeTaken;

	public void setNumlist(String num){
		this.numlist = num;
	}
	public void setSortedNumlist(String list){
		this.sortedNumlist = list;
	}
	public void setChangeNo(Integer n){
		this.changeNo = n;
	}
	public void setTimeTaken(Long l){
		this.timeTaken = l;
	}
	public String getNumlist(){
		return numlist;
	}
	public String getSortedNumlist(){
		return sortedNumlist;}
	public Integer getChangeNo(){
		return changeNo;}
	public Long getTimeTaken(){
		return timeTaken;}
	
	public void sortList(){
		long startTime = System.nanoTime();
		//long startTime = System.currentTimeMillis();
		String[] numbers = this.numlist.split(",");
		String[] sortnumber = numbers.clone();
		Arrays.sort(sortnumber);
		String sorted = Arrays.toString(sortnumber);
		System.out.println(this.sortedNumlist);
		int swaps = 0;
		int b = 1;
		for (int a = 1;a<numbers.length;a++){
			if (numbers[a] == sortnumber[b])
			  b = b + 1;
		    else
			  swaps = swaps + 1;
			}

		long endTime = System.nanoTime();
		this.setChangeNo(swaps);
		this.setSortedNumlist(sorted);
		this.setTimeTaken(endTime-startTime);
		
         }
    @Override
    public String toString() {
        return "numberlist [Numlist=" + numlist + ", SortedNumlist=" + sortedNumlist
                + ", ChangeNo=" + changeNo + ", TimeTaken=" + timeTaken +  "]";
    }


}
