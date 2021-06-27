package HibernateTasks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("W")
@Entity
@Table(name = "WORKTASK")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task {

    @Column(name = "cost")
    private String cost;
}
