/**
 * @author 	Alex Zhang;
 *		Vlad Burca.
 * @version 05 - 02 - 2011.
 * File Name: DoubleRainbow.java
 */

import java.util.*;

public class DoubleRainbow {

	/**	
	 *	Declaring global variables	
	 */
	private TreeMap indexMap, horizonMap;	

	/**
	 *	Constructor method for DoubleRainbow.
	 *	Instantiates two TreeMap Objects (indexMap, horizonMap).
	 *	Creates nLepr JumpingLeprechaun Objects, by calling the JumpingLeprechaun constructor
	 *	and putting each element, as a (index,JumpingLeprechaun) pair, in the TreeMap indexMap.
	 *	Creates the TreeMap horizonMap by using an Iterator through the TreeMap indexMap and
	 *	putting in horizonMap the pairs (horizon, JumpingLeprechaun).
	 *
	 *	@param nLepr the number of Leprechauns that will be created
	 */
	public DoubleRainbow(int nLepr) {
		indexMap = new TreeMap();
		horizonMap = new TreeMap();
		
		for (int i = 1; i <= nLepr; i++) {
			indexMap.put(i, new JumpingLeprechaun(nLepr, i));
		}
		
		Iterator i = indexMap.entrySet().iterator();
		
 		while (i.hasNext()) {
 			Map.Entry e = (Map.Entry)i.next();
 			JumpingLeprechaun jl = (JumpingLeprechaun)e.getValue();
 			horizonMap.put(jl.getHorizon(), jl);
 		}	
	}
	
	/**
	 *	iterate method for DoubleRainbow.
	 *	Method that makes each JumpingLeprechaun Object jump, by removing it first
	 *	from the TreeMap horizonMap, calling the JumpingLeprechaun's jump method,
	 * 	inserting it back into the horizonMap and calling the JumpingLeprechaun's steal
	 *	method. 
	 */
 	public void iterate() {
 		Random r = new Random();
 		Random r2 = new Random(1);
 		
		JumpingLeprechaun[] removed = new JumpingLeprechaun[2];
		int j = 0;

 		Iterator i = indexMap.entrySet().iterator();
 		
 		while (i.hasNext()) {
 			Map.Entry e = (Map.Entry)i.next();
 			JumpingLeprechaun jl = (JumpingLeprechaun)e.getValue();

			if(jl.getGold() <= 0.0)
			{ 			
	 			removed[j] = (JumpingLeprechaun)horizonMap.remove(jl.getHorizon());
				System.out.println("Removed " + jl.visualize());
				j++;
			}
			else
			{
	 			horizonMap.remove(jl.getHorizon());
	 			jl.jump(r.nextDouble() * Math.pow((-1), r2.nextInt()));
	 			horizonMap.put(jl.getHorizon(), jl);
	 			jl.steal(horizonMap);
			}
		}
		for (j = 0; j < removed.length && removed[j] != null; j++)
		{
			indexMap.remove(removed[j].getIndex());
		}
 	}

	/**
	 *	Checks to see if there is only one winner left
	 *
	 *	@return true if no winner, false otherwise
	 */
	public boolean noWinner()
	{
		return indexMap.size() > 1;
	}
	
	/**
	 *	toString method for DoubleRainbow.
	 *	Method that returns a String representation of the horizonMap (Tree.Map).
	 *
	 *	@return String - a String representation of the horizonMap;
	 */
	public String toString() {
		String s = "";
		Iterator i = horizonMap.entrySet().iterator();
		
		while (i.hasNext()) {
			Map.Entry e = (Map.Entry)i.next();
			JumpingLeprechaun jl = (JumpingLeprechaun)e.getValue();
			s = s + jl.visualize() + "\n";
		}
		return s;
	}
		
	/**
	 *	main method for DoubleRainbow.
	 *	The main method of the class, that prompts for the number of leprechauns and number of 
	 *	iterations from the user.
	 *	It simulates it iteration and prints it, using the toString method of the DoubleRainbow class.
	 */
	public static void main(String args[]) {
		if (args.length < 2)
			System.out.println("Usage: java DoubleRainbow nLeprechauns nIterations");
		else {
			DoubleRainbow drb = new DoubleRainbow(Integer.parseInt(args[0]));
			int itNum = Integer.parseInt(args[1]);
			System.out.println(drb + "\n");
			while(drb.noWinner()) {
				drb.iterate();			// While there is more than one Leprechaun
				System.out.println(drb + "\n");
			}
/*			for (int i = 0; i < itNum; i++) {	// For set number of iterations
				drb.iterate();
				System.out.println(drb + "\n");
			}*/
		}
	}
		

}

