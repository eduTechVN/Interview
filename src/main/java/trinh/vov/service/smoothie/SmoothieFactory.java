package trinh.vov.service.smoothie;

import trinh.vov.model.entity.item.Smoothie;

public class SmoothieFactory {
    public static Inventory calculateSmoothie(Smoothie smoothie, int quantity, int sumFruit, int ice, int milk, int sugar) {
        if (smoothie.equals(Smoothie.BANANA)) {
            return new BananaService().calculateSmoothie(quantity, sumFruit, ice, milk, sugar);
        } else if (smoothie.equals(Smoothie.MANGO)) {
            return new MangoService().calculateSmoothie(quantity, sumFruit, ice, milk, sugar);
        } else if (smoothie.equals(Smoothie.STRAWBERRY)) {
            return new StrawberryService().calculateSmoothie(quantity, sumFruit, ice, milk, sugar);
        }
        return null;
    }
}
