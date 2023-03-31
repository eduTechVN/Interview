package trinh.vov.service.item;

import trinh.vov.model.dto.request.item.ItemReDto;
import trinh.vov.model.dto.response.item.ItemResDto;

import java.util.List;

public interface ItemService {
    void addItem(List<ItemReDto> itemDto);

    List<ItemResDto> getItems();

    void updateItem(String id, ItemReDto itemRe);
}
