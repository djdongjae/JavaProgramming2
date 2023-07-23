package this_is_java.ch12.sec03.exam05;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Member {
    private final String id = "2";
    @NonNull private String name;
    private int age;
}