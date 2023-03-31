package trinh.vov.service.smoothie;

import trinh.vov.model.entity.item.Smoothie;

public interface SmoothieService {
    boolean checkSellSmoothie(int quantity, Smoothie smoothie);
}
