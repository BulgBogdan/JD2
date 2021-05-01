package people;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Person {

    private int id;
    private String name;
    private String surname;
    private int age;

}