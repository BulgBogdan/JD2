package Person_Address;

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
    private int id_address;

}
