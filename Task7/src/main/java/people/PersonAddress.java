package people;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class PersonAddress {

    private int id;
    private int person_id;
    private int address_id;

}
