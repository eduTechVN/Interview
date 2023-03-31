package trinh.vov.model.dto.request.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import trinh.vov.model.entity.item.Unit;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
public class ItemReDto {

    @Length(max = 255)
    private String name;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @NonNull
    private Integer quantity;
}
