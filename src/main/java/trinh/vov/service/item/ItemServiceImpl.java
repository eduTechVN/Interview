package trinh.vov.service.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import trinh.vov.model.dto.request.item.ItemReDto;
import trinh.vov.model.dto.response.item.ItemResDto;
import trinh.vov.model.entity.item.Item;
import trinh.vov.repository.ItemRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    @Override
    public void addItem(List<ItemReDto> items) {
        log.info("Store ");
        if(items.isEmpty()){
            throw new NullPointerException("Fruit is not null.");
        }

        List<Item> itemEntity = items.stream().map(
                item -> Item.builder()
                        .name(item.getName()).unit(item.getUnit())
                        .quantity(item.getQuantity()).build())
                .collect(Collectors.toList());

        itemRepository.saveAll(itemEntity);
    }

    @Override
    public List<ItemResDto> getItems() {
        log.info("Get all item in system.");
        List<Item> items = itemRepository.findAll();
        return ItemResDto.fromItems(items);
    }

    @Override
    public void updateItem(String id, ItemReDto itemRe) {
        Item itemEntity = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Don't find" + id + " in system."));

        itemEntity.setName(itemRe.getName());
        itemEntity.setUnit(itemRe.getUnit());
        itemEntity.setQuantity(itemRe.getQuantity());

        itemRepository.save(itemEntity);
    }
}
