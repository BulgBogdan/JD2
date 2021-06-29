package HibernateTasks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("H")
@Entity
@Table(name = "hometask")
public class HomeTask extends Task {

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Embedded
    private Address address;
}
