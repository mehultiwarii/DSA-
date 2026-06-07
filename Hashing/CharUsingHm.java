import java.util.*;
public class CharUsingHm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String");
        String n = sc.nextLine();
        char minchar=' ';
        int minFreq = Integer.MAX_VALUE;
        char maxchar = ' ';
        int maxFreq = Integer.MIN_VALUE;



        //creation of the hashmap
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<n.length();i++){
            map.put(n.charAt(i), map.getOrDefault(n.charAt(i), 0)+1);
        }
        //print the map
        for(Map.Entry<Character, Integer> entry : map.entrySet() ){
            System.out.println(entry.getKey() + " -> "+ entry.getValue());
            //misc-> counting max/min frequent in HashMap
            if(entry.getValue()> maxFreq){
                maxchar = entry.getKey();
                maxFreq = entry.getValue();
            }
            if(entry.getValue()<minFreq){
                minchar = entry.getKey();
                minFreq = entry.getValue();
            }

            
        }
        System.out.println("The minimum is "+minchar+" -> "+minFreq);
        System.out.println("The maximum is "+maxchar+" -> "+maxFreq);
        // System.out.println("enter number of questions");
        // int query = sc.nextInt();
        // while(query-->0){
        //     System.out.println("Enter the char of your choice");
        //     char c = sc.next().charAt(0);
        //     System.out.println(map.getOrDefault(c, 0));
        // }
    }
    
}

//in java:- an unordered map is hashmap and ordered map is treeMap, the ordered map which is tree map store and fetch in O(log n) in all cases  and in unordered map it is O(1) best+average/ O(N) in worst case