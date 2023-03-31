package trinh.vov.service.smoothie;

import org.springframework.stereotype.Service;
import trinh.vov.constants.Commons;
import trinh.vov.exception.BadRequestException;

@Service
public class StrawberryService implements FruitService {

    @Override
    public Inventory calculateSmoothie(int quantity, int sumFruit, int ice, int milk, int sugar) {
        int totalStrawberryMl = (quantity * 3) * Commons.FIFTY;
        if(totalStrawberryMl > ((sumFruit * Commons.ONE_HUNDRED) / Commons.ONE_HUNDRED)){
            throw new BadRequestException("Strawberries don't enough to supply "+quantity+ " smoothie.");
        }

        if(ice < (Commons.THIRTY * (quantity * 3))){
            throw new BadRequestException("Ice don't enough to supply "+quantity+ " smoothie.");
        }

        if(milk < (Commons.TWENTY * (quantity * 3))){
            throw new BadRequestException("Milk don't enough to supply "+quantity+ " smoothie.");
        }

        if(sugar < (Commons.EIGHT * (quantity * 3))){
            throw new BadRequestException("Sugar don't enough to supply "+quantity+ " smoothie.");
        }

        Integer remainFruit = sumFruit - ((totalStrawberryMl * Commons.ONE_HUNDRED) / Commons.ONE_HUNDRED);
        Integer remainIce = ice - (Commons.THIRTY * (quantity * 3));
        Integer remainMilk = milk - (Commons.TWENTY * (quantity * 3));
        Integer remainSugar = sugar - (Commons.EIGHT * (quantity * 3));

        return Inventory.builder()
            .sumFruit(remainFruit)
            .ice(remainIce)
            .milk(remainMilk)
            .sugar(remainSugar)
            .build();
    }
}
