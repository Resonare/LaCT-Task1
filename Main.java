import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enum State { FIRST_LANGUAGE, SECOND_LANGUAGE, FINAL }
        State currentState = State.FIRST_LANGUAGE;

        ArrayList<String> lang1 = new ArrayList<>();
        ArrayList<String> lang2 = new ArrayList<>();
        ArrayList<String> langFinal = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите цепочки первого языка, при вводе отделяйте цепочки новой строкой.");
        System.out.println("Для перехода к вводу цепочек второго языка оставьте пустую строку и нажмите Enter");

        while (currentState != State.FINAL) {
            String input = sc.nextLine();
            if (currentState == State.FIRST_LANGUAGE) {
                if (input == "") {
                    if (lang1.size() < 1) {
                        System.out.println("Необходимо ввести хотя бы одну цепочку первого языка!");
                        continue;
                    }

                    currentState = State.SECOND_LANGUAGE;

                    System.out.println("Введите цепочки второго языка, при вводе отделяйте цепочки новой строкой.");
                    System.out.println("Для перехода к выводу результата оставьте пустую строку и нажмите Enter");

                    continue;
                }

                lang1.add(input);
            } else if (currentState == State.SECOND_LANGUAGE){
                if (input == "") {
                    if (lang2.size() < 1) {
                        System.out.println("Необходимо ввести хотя бы одну цепочку второго языка!");
                        continue;
                    }

                    currentState = State.FINAL;

                    System.out.println("Результат:");

                    continue;
                }

                lang2.add(input);
            }
        }

        for (String str1: lang1) {
            for (String str2: lang2) {
                langFinal.add(str1 + str2);
            }
        }

        System.out.println(langFinal);
    }
}