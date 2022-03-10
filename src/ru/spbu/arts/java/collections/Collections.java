package ru.spbu.arts.java.collections;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class Collections {

    public static void main(String[] args) throws Exception {

        System.out.println(count(1));
        System.out.println(count(5));

        System.out.println("-------------------------------");


        List<String> list1 = List.of("abc", "xyz", "ooo");

        // на экране появится
        //   Элементов в списке: 3
        //   abc
        //   xyz
        //   ooo
        printList(list1);

        // на экране появится
        //   Элементов в списке: 3
        //   1: abc
        //   2: xyz
        //   3: ooo
        printListWithIndices(list1);

        System.out.println("-------------------------------");


        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4); //aaa bbb ccc xxx yyy zzz
        // можно не проверять, что исходные списки не изменились, потому что List.of()
        // создает неизменяемый список. Но можно и проверить:
        System.out.println(list3); //aaa bbb ccc
        System.out.println(list4); //xxx yyy zzz

        System.out.println("-------------------------------");


        //созадем изменяемый список list5.
        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        //сначала чистая функция
        List<String> list5rev = reverseList(list5);
        //проверяем, что list5rev перевернутый, а list5 остался без изменений.
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        //теперь функция, которая меняет сам список
        reverseListInPlace(list5);
        //проверяем, что список действительно изменился
        System.out.println("list5 = " + list5);

        //я проделала то же самое, но только со списками с четным количеством элементов
        List<String> listR = new ArrayList<>(List.of("first", "second", "third", "last"));
        List<String> listRrev = reverseList(listR);
        System.out.println("listRrev = " + listRrev + ", but listR = " + listR);
        reverseListInPlace(listR);
        System.out.println("listR = " + listR);

        System.out.println("-------------------------------");


        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);

        System.out.println("ints = " + ints);
        //функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
        System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
        //функция должна удалить четные числа
        System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]

        // В этой части мы проделаем то же самое, но с функциями, которые изменяют переданные списки.
        // слово mutable означает "изменяемый", потому что в этой части мы будем использовать списки,
        // которые можно изменять.
        System.out.println(" ============= mutable lists =================== ");

        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts); //[22, 55, 88, 3]

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]

        System.out.println("-------------------------------");


        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile("src/textFiles/a.txt", hashSet);
        doReadWordsInFile("src/textFiles/a.txt", linkedHashSet);
        doReadWordsInFile("src/textFiles/a.txt", treeSet);

        //System.out.println(hashSet);
        //System.out.println(linkedHashSet);
        //System.out.println(treeSet);

    }

    private static List<Integer> count(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    private static void printList(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        list.forEach((s) -> System.out.println(s));
    }

    private static void printListWithIndices(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (int i = 0; i < list.size(); i++)
            System.out.println(i + ": " + list.get(i));
    }

    private static List<String> concatenateLists(List<String> list1, List<String> list2) {
        List<String> resultList = new ArrayList<>();
        for(String s: list1)
            resultList.add(s);
        for(String s: list2)
            resultList.add(s);
        return resultList;
    }

    private static List<String> reverseList(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
            resultList.add(list.get(i));
        return resultList;
    }

    private static void reverseListInPlace(List<String> list) {
        String s;
        for (int i = 0; i < list.size() / 2; i++) {
            s = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, s);
        }
    }

    private static List<Integer> filterEvenIndices(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            if (i%2 != 0)
                resList.add(list.get(i));
        return resList;
    }

    private static void mutableFilterEvenIndices(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            if (i % 2 == 0)
                list.set(i, null);
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) == null)
                list.remove(i);
            else
                i = i + 1;
        }
    }

    private static List<Integer> filterEven(List<Integer> list) {
        List<Integer> resList = new ArrayList<>();
        for (Integer i: list)
            if (i % 2 != 0)
                resList.add(i);
        return resList;
    }

    private static void mutableFilterEven(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) % 2 == 0)
                list.set(i, null);
        int i = 0;
        while (i < list.size()) {
                if (list.get(i) == null)
                    list.remove(i);
                else
                    i = i + 1;
        }
    }

    private static void doReadWordsInFile(String file, Set<String> result) throws IOException {
        Path txt = Path.of(file);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next();
                result.add(word.toLowerCase());
            }
        }
    }
}
