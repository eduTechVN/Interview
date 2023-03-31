package trinh.vov.model.dto.response.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import trinh.vov.model.entity.item.Item;
import trinh.vov.model.entity.item.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ItemResDto {

    private String id;

    private String name;

    private Unit unit;

    private Integer quantity;

    public static List<ItemResDto> fromItems(List<Item> items){
        if(items.isEmpty()){
            return new ArrayList<>();
        }

        return items.stream().map(item -> ItemResDto.builder()
                .id(item.getId())
                .name(item.getName())
                .unit(item.getUnit())
                .quantity(item.getQuantity()).build()
        ).collect(Collectors.toList());
    }
}
