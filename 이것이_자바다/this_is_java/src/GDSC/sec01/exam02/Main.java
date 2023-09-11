package GDSC.sec01.exam02;

public class Main {
    public static void main(String[] args) {
        int score = 0;
        char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }

        char a = 'g';
        String name = "";
        switch (a) {
            case 'g': name += 'g';
            case 'd': name += 'd';
            case 's': name += 's';
            case 'c': name += 'c';
            break;
        }

        System.out.println(name);

        int i = 0;
        for (int k = 0; k < 10; k++) {
            i += k;
        }
        System.out.println(i);
    }
}
