package GDSC.hw01.Test04;

import GDSC.hw01.Test02.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("오동재", 25));
        arrayList.add(new Person("이한길", 25));
        arrayList.add(new Person("방예혁", 15));

        for (Person person : arrayList) {
            person.introduce();
        }

        List<Person> result = arrayList.stream()
                .filter(person -> person.getAge() >= 20)
                .toList();

        System.out.println("\n나이가 20 이상\n");

        for (Person person : result) {
            person.introduce();
        }
    }
}
