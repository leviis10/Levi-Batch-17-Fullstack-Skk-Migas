import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(List.of(
                "Pendanaan",
                "Terproteksi",
                "Untuk",
                "Dampak",
                "Berarti"
        ))); // output aenrktipBDPTUdmosu
        System.out.println(solution(List.of("Abc", "bCd"))); // bACcd
        System.out.println(solution(List.of("Oke", "One"))); // Oekn
    }

    private static String solution(List<String> words) {
        // create hashmap
        Map<Character, Integer> map = new HashMap<>();

        // loop over every char in the string and then map to the created map to track how many character is appeared
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            }
        }

        // sort hashmap by most appearance, uppercase word, and a-z
        List<Character> resultList = map.entrySet()
                .stream()
                .sorted((a, b) -> {
                    if (a.getValue() < b.getValue()) {
                        return 1; // swap
                    } else if (a.getValue() > b.getValue()) {
                        return -1; // do nothing
                    } else {
                        boolean aIsUpper = Character.isUpperCase(a.getKey());
                        boolean bIsUpper = Character.isUpperCase(b.getKey());
                        if (aIsUpper && !bIsUpper) {
                            return -1; // do nothing
                        }
                        if (!aIsUpper && bIsUpper) {
                            return 1; // swap
                        }
                        return a.getKey() - b.getKey();
                    }
                })
                .map(Map.Entry::getKey)
                .toList();

        // convert list into a string and then return it
        StringBuilder result = new StringBuilder();
        for (char letter : resultList) {
            result.append(letter);
        }
        return result.toString();
    }
}
