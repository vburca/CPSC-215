/**
 * @author Vlad Burca, Pauline Lake
 * @version 04-14-2011
 * 
 * File: L11Driver.java
 */


public class L11Driver {
  
  public static void main(String args[]) {

    Entry<String, String> e;
    HashTableDictionary<String,String> h = 
      new HashTableDictionary<String,String>();

    // We use city names as keys and airport codes as values.
    String keys[] = { "Boston", "Chicago", "Chicago", "Frankfurt am Main", 
      "Hartford", "London", "London", "London", "Newark", "New York", 
      "New York", "Paris", "Paris", "San Francisco", "Tokyo", "Tokyo" };
    String values[] = { "BOS", "MDW", "ORD", "FRA", "BDL", "LGW", "LHR", 
      "STN", "EWR", "JFK", "LGA", "CDG", "ORY", "SFO", "HND", "NRT" };

    // We print the input list first.
    System.out.println("Input list:");
    System.out.println();
    for (int i = 0; i < keys.length; i++)
      System.out.println(values[i] + " - " + keys[i]);

    // Insert the given items.
    for (int i = 0; i < keys.length; i++)
      h.put(keys[i], values[i]);

    e = h.get("London");
    System.out.println();
    System.out.println("There are three major airports in London, and ");
    System.out.println("get(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");

    // Remove one airport in London.
    System.out.println();
    System.out.println("After removing the entry (" + e.getKey() + ", " + 
      e.getValue() + ")");                    
    e = h.remove(e);
    e = h.get("London");
    System.out.println("get(London) gives the key-value pair (" + 
      e.getKey() + ", " + e.getValue() + ")");
    

    System.out.println();
    System.out.println();
   
    System.out.println("ITERATORS: ");
    
    //Test of entrySet()
    
    Iterator<Entry<String, String>> i_entrySet = h.entrySet().iterator();
    System.out.println("entrySet Iterator: ");
    while (i_entrySet.hasNext()) {
    	System.out.print(i_entrySet.next().getValue() + ' ');
    }    	
    System.out.println();
    
    //Test of getAll()
    
    Iterator<Entry<String, String>> i_getAll = h.getAll("London").iterator();
    System.out.println("getAll(London) Iterator: ");
    while (i_getAll.hasNext()) {
    	System.out.print(i_getAll.next().getValue() + ' ');
    }    	
    System.out.println();
    
    //Test of removeAll()
    
    Iterator<Entry<String, String>> i_removeAll = h.removeAll("London").iterator();
    System.out.println("removeAll(London) Iterator: ");
    while (i_removeAll.hasNext()) {
    	System.out.print(i_removeAll.next().getValue() + ' ');
    }    	
    System.out.println();
    
    //Check of the Dictionary after removeAll()
    
    Iterator<Entry<String, String>> i_entrySet_remove = h.entrySet().iterator();
    System.out.println("entrySet Iterator (without London): ");
    while (i_entrySet_remove.hasNext()) {
    	System.out.print(i_entrySet_remove.next().getValue() + ' ');
    }    	
    System.out.println();

  }

}
