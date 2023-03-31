package trinh.vov.model.entity.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import trinh.vov.model.entity.BaseEntity;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "Item")
public class Item extends BaseEntity {
    @Column(name = "Name", unique = true)
    private String name;

    @Column(name = "Unit", unique = true)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(name = "Quantity", unique = true)
    private Integer quantity;
}
