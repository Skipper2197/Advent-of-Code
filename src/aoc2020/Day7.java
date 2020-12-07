package aoc2020;

import java.util.ArrayList;
import java.util.HashMap;

public class Day7 extends AOCPuzzle {

	public static HashMap<String, ArrayList<BagInfo>> bags = new HashMap<>();
	
	public Day7() {
		super(7);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void solvePuzzle(ArrayList<String> input) {
		// TODO Auto-generated method stub
		
		
		
		for(String s : input) {
			String[] firstSplit = s.substring(0, s.length()-1).split("bags contain");
			String outerBag = firstSplit[0].trim();
			String[] innerBags = firstSplit[1].split(",");
			
			ArrayList<BagInfo> bagInfos = new ArrayList<>();
			for(String bag : innerBags) {
				bag = bag.replace("bags", "").replace("bag", "").trim();
				int index = bag.trim().indexOf(" ");
				String numberStr = bag.substring(0, index);
				if(!numberStr.equalsIgnoreCase("no")) {
					BagInfo bagInfo = new BagInfo();
					bagInfo.quantity = Integer.parseInt(bag.substring(0, index));
					bagInfo.bagColor = bag.substring(index+1);
					bagInfos.add(bagInfo);
				}
				
			}
			
			bags.put(outerBag, bagInfos);
		}
		
		int count = 0;
		for(String bag : bags.keySet()) {
			if(containsGoldBag(bag)) {
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(countBags("shiny gold")-1);
	}
	
	public int countBags(String bag) {
		int count = 1;
		
		ArrayList<BagInfo> bagsList = bags.get(bag);
		
		for(BagInfo bagInfo : bagsList) {
			count += (bagInfo.quantity * countBags(bagInfo.bagColor));
		}
		
		return count;
	}
	
	public boolean containsGoldBag(String bag) {
		
		for(BagInfo nextBag : bags.get(bag)) {
			if(nextBag.bagColor.equalsIgnoreCase("shiny gold")) {
				return true;
			}
		}
		
		for(BagInfo nextBag : bags.get(bag)) {
			if(containsGoldBag(nextBag.bagColor)) {
				return true;
			}
		}
		return false;
		
	}
	
	public static class BagInfo {
		public int quantity;
		public String bagColor;
	}

}
