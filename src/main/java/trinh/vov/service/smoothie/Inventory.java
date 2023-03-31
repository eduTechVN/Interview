package trinh.vov.service.smoothie;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Inventory {
    private Integer sumFruit;
    private Integer ice;
    private Integer milk;
    private Integer sugar;
}
