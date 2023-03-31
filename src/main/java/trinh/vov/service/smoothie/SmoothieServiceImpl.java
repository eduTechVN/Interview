package trinh.vov.service.smoothie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import trinh.vov.constants.Commons;
import trinh.vov.model.entity.item.Item;
import trinh.vov.model.entity.item.Smoothie;
import trinh.vov.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmoothieServiceImpl implements SmoothieService{

    private final ItemRepository itemRepository;

    public boolean checkSellSmoothie(int quantity, Smoothie smoothie) {
        List<Item> items = itemRepository.findAll();

        Integer sumFruit = items.stream().filter(fruit -> fruit.getName().equals(smoothie))
                .map(Item::getQuantity).reduce(0, (a, b) -> a + b);

        Integer ices = items.stream().filter(ice -> ice.getName().equals(Commons.ICE))
                .map(Item::getQuantity).reduce(0, (a, b) -> a + b);

        Integer milks = items.stream().filter(milk -> milk.getName().equals(Commons.MILK))
                .map(Item::getQuantity).reduce(0, (a, b) -> a + b);

        Integer sugars = items.stream().filter(sugar -> sugar.getName().equals(Commons.SUGAR))
                .map(Item::getQuantity).reduce(0, (a, b) -> a + b);

        Inventory inventory = SmoothieFactory.calculateSmoothie(smoothie,quantity, sumFruit, ices, milks, sugars);


        return true;
    }
}
