import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 15, 3, 20);
        int sumOfSquares = numbers.stream()
                .filter(n -> n >= 10)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("1) კვადრატების ჯამი: " + sumOfSquares);

        List<String> words = Arrays.asList("Java", "apple", "JavaScript", "banana", "John");
        List<String> jWordsUpperCase = words.stream()
                .filter(word -> word.startsWith("J"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2) J-ზე დაწყებული სიტყვები დიდ ასოებზე: " + jWordsUpperCase);

        List<String> fruits = Arrays.asList("apple", "orange", "banana", "grape", "apple");
        Set<String> sortedFruits = fruits.stream()
                .sorted()
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println("3) დასორტირებული ხილი სეტში: " + sortedFruits);

        List<Human> people = Arrays.asList(
                new Human("Giorgi", 20),
                new Human("Levani", 25),
                new Human("Ana", 12),
                new Human("Nika", 18)
        );
        boolean levaniExists = people.stream()
                .filter(human -> human.getAge() >= 15)
                .anyMatch(human -> human.getName().equals("Levani"));
        System.out.println("4) არსებობს Levani: " + levaniExists);


        List<Integer> numberList = Arrays.asList(10, 5, 8, 12, 3, 7, 3);
        Integer secondSmallest = numberList.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("5) მეორე ყველაზე მცირე: " + secondSmallest);

        Integer secondLargest = numberList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("5) მეორე ყველაზე დიდი: " + secondLargest);


    }
}
