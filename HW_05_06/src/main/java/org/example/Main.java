package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(
                makeMap(
                        new String[]{"Dima", "Masha"},
                        new int[]{23, 33}
                )
        );


        System.out.println(
                mostFrequentString(
                        List.of("один раз это один раз но только раз".split(" "))
                )
        );

        System.out.println(
                getWords(
                        List.of("alla", "student", "students", "al", "pass", "sap", "lalalala")
                )
        );

    }

    //Task 1
    public static Map<String, Integer> makeMap(String[] strings, int[] ints) {
        Map<String, Integer> result = new HashMap<>();
        if (strings == null || ints == null || strings.length != ints.length) {
            return result;
        }
        for (int i = 0; i < strings.length; i++) {
            result.put(strings[i], ints[i]);
        }
        return result;
    }

    //        Task 2
    public static String mostFrequentString(List<String> strings) {
        Map<String, Integer> words = new HashMap<>();
        for (String s: strings) {
            Integer count = words.get(s);
            if(count == null) {
                count = 0;
            }
            words.put(s,++count);
        }
        TreeMap<Integer, String> count = new TreeMap<>();
        for(Map.Entry<String, Integer> e: words.entrySet()) {
            count.put(e.getValue(), e.getKey());
        }
        return count.lastEntry().getValue();
    }


    //Task 3
public static Collection<List<String>> getWords(List<String> strings) {
    Map<String, List<String>> container = new HashMap<>();
    for (String s: strings) {
        Set<String> key = new TreeSet<>(
                Arrays.asList(
                        s.split("")
                )
        );
        String k = key.toString();
        List<String> values = container.get(k);
        if(values == null) {
            values = new ArrayList<>();
        }
        values.add(s);
        container.put(k, values);
    }
    return container.values();
}

}


