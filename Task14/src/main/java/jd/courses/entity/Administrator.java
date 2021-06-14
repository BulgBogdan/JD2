package jd.courses.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer id;

    @Column(name = "admin_name")
    private String name;

    @OneToMany(mappedBy = "admin")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "admin")
    private Set<Teacher> teachers = new HashSet<>();


}
