package GDSC.hw01.Test05;  // 소스 코드가 위치한 패키지를 선언합니다.

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // 예외처리

        try {
            zero(10, 0);  // zero 함수를 호출하고, 10을 0으로 나누려고 시도합니다.
        } catch (ArithmeticException e) {  // ArithmeticException 예외를 잡습니다.
            System.out.println("ArithmeticException 발생: " + e.getMessage()); // 예외 메시지를 출력합니다.
        }

        // Optional

        Optional<String> optsj = Optional.of("135");  // "135" 값을 포함하는 Optional 객체를 생성합니다.
        Optional<String> optsj2 = Optional.ofNullable(null);  // null 값을 포함하는 Optional 객체를 생성합니다.
        Optional<String> emptyopt = Optional.empty();  // 값이 없는 빈 Optional 객체를 생성합니다.

        System.out.println(optsj.isPresent()); // Optional 객체의 값이 존재하는지 여부를 확인하고 출력합니다. (true)
        System.out.println(optsj);  // Optional 객체를 출력합니다. (옵셔널 값이 있으면 해당 값을 포함한 문자열을 출력)
        System.out.println(optsj.get());  // Optional 객체의 값을 가져와서 출력합니다. ("135" 출력)

        List<String> it = Arrays.asList(
                "C", "Java", "C++", "Python", "Kotlin");
        Optional<List<String>> itlist = Optional.of(it);  // 문자열 리스트를 포함하는 Optional 객체를 생성합니다.

        int sum = itlist
                .map(List::size)  // Optional 객체의 값을 변환하고자 할 때 사용하는 map 함수를 사용해 리스트의 크기를 가져옵니다.
                .orElse(0);  // 만약 값이 존재하지 않으면 0을 반환합니다.

        System.out.println(sum);  // 리스트의 크기를 출력합니다.
    }

    // 예외를 던지는 zero 함수 정의
    public static void zero(int a, int b) throws ArithmeticException {
        if (b == 0) {  // 두 번째 인수가 0일 때
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");  // 예외를 던집니다.
        }
        int result = a / b;  // 나눈 결과를 계산합니다.
        System.out.println("나눈 결과: " + result);  // 결과를 출력합니다.
    }
}
