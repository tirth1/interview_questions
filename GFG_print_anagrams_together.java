/*

Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

Note: The finial output will be in lexicographic order.

Example 1:
  Input:
    N = 5
    words[] = {act,god,cat,dog,tac}
  Output:
    act cat tac 
    god dog
  Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

Example 2:
  Input:
    N = 3
    words[] = {no,on,is}
  Output: 
    no on
    is
  Explanation: There are 2 groups of anagrams "no", "on" make group 1. "is" makes group 2. 

Your Task:
The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are anagrams.

Expected Time Complexity: O(N*|S|*log|S|), where |S| is the length of the strings.
Expected Auxiliary Space: O(N*|S|), where |S| is the length of the strings.

Constraints:
1<=N<=100
1<=|S|<=10

*/


class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        
        for(String s : string_list) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for(char ch : s.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
            
            if(!map.containsKey(freq)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(freq, list);
            } else {
                List<String> list = map.get(freq);
                list.add(s);
                map.put(freq, list);
            }
        }
        
        for(List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}
