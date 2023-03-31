package trinh.vov.service.smoothie;

public interface FruitService {
    Inventory calculateSmoothie(int quantity, int sumFruit, int ice, int milk, int sugar);
}
