import java.lang.*;
import java.util.*;
public class FrequencyHashMap {
    public static Map<String, Integer> findFrequency(List<String> list)
    {
        Map<String, Integer> frequency=new HashMap<>();
        for(String item:list)
        {
            if(frequency.containsKey(item))
            {
                int count=frequency.get(item);
                frequency.put(item,count+1);
            }
            else {
                frequency.put(item,1);
            }
        }
        return frequency;
    }
    public static void main(String[] args)
    {
        List<String> fruits=Arrays.asList("apple","banana","apple","watermelon");
        Map<String, Integer>result=findFrequency(fruits);
        for(String key:result.keySet())
        {
            System.out.println(key+ ":"+ result.get(key));
        }
    }
}
