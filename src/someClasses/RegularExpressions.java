package someClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    public static void main(String[] args) {

        System.out.println("Task 1");
        String email1 = "aa@alissa.ru";
        String email2 = "a-aa123@aliss_a.ru";
        System.out.println("Function 1");
        System.out.println(isEmail1(email1));
        System.out.println(isEmail1(email2));
        System.out.println("Function 2");
        System.out.println(isEmail2(email1));
        System.out.println(isEmail2(email2));
        System.out.println();


        System.out.println("Task 2");
        String text = """
                Вот есть текст. Он был написан в 15:11  , и его предназначение - содержать в себе время. Например , такое:
                14:45. Или такое: 08:09. А вот это вот совсем не время    , но тоже нужно: 44:12. И вот это: 12:67. А ещё
                вот это вот: 56:98. Такой вот текст :0
                """;
        time(text);
        System.out.println();

        System.out.println("Task 3");
        System.out.println(deleteSpace(text));

        System.out.println("Task 4");
        System.out.println(changeWords("Какая-то сине-зеленовая трава"));
        System.out.println();

        System.out.println("Task 5");
        System.out.println(cat("Кот шел по жороге, которая вела к КОТЕЛЬНОЙ. У КОТЕЛЬНОЙ неспешно прогуливался антрекот на вечер. Но пока он не был антрекотом, он был простым быком"));
        System.out.println();

        System.out.println("Task 6");
        System.out.println(cat2("Кот шел по жороге, которая вела к КОТЕЛЬНОЙ. У КОТЕЛЬНОЙ неспешно прогуливался антрекот на вечер. Но пока он не был антрекотом, он был простым быком"));
        System.out.println();

        System.out.println("Task 7");
        System.out.println(increasingNumbers("У меня 2 яблока и -4 банана"));
    }

    private static boolean isEmail1(String s) {
        Pattern email = Pattern.compile("[a-z]+@[a-z]+\\.[a-z]{2,4}");
        Matcher m = email.matcher(s);
        return m.matches();
    }

    private static boolean isEmail2(String s) {
        Pattern email = Pattern.compile("[a-z\\d\\-_]+@[a-z\\d\\-_]+\\.[a-z]{2,4}");
        Matcher m = email.matcher(s);
        return m.matches();
    }

    // private static boolean isEmail3(String s) {
        // Pattern email = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\\(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*)@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])");
        // Matcher m = email.matcher(s);
        // return m.matches();
   // }

    private static void time(String s) {
        Pattern time = Pattern.compile("(\\d\\d):(\\d\\d)");
        Matcher m = time.matcher(s);
        while (m.find()) {
            if (Integer.parseInt(m.group(1)) < 24 && Integer.parseInt(m.group(2)) < 60)
                System.out.println(m.group(0) + " - It is time");
            else
                System.out.println(m.group(0) + " - It is not time");
        }
    }

    private static String deleteSpace(String s) {
        return s.replaceAll("\\s+,", ",");
    }

    private static String changeWords(String s) {
        return s.replaceAll("([а-яА-Я]+)-([а-яА-Я]+)", "$2-$1");
    }

    private static int cat(String s) {
        Pattern cat = Pattern.compile("[Кк][Оо][Тт]");
        Matcher m = cat.matcher(s);
        int c = 0;
        while (m.find()) {
            c = c + 1;
        }
        return c;
    }

    private static int cat2(String s) {
        Pattern cat = Pattern.compile("(^|\\s)[Кк][Оо][Тт]\\b");
        Matcher m = cat.matcher(s);
        int c = 0;
        while (m.find()) {
            c = c + 1;
        }
        return c;
    }

    private static String increasingNumbers(String s) {
        Pattern numbers = Pattern.compile("-?\\d+");
        Matcher m = numbers.matcher(s);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            int n = Integer.parseInt(m.group()) + 1;
            String replacement = Integer.toString(n);
            m.appendReplacement(sb,  replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }

}
