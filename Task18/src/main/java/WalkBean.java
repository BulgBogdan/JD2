import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class WalkBean {

    private Walk walk;

    public void walk() {
        walk.walk();
    }
}
