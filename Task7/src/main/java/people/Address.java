package people;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Address {

    private int id;
    private String street;
    private int house;

}