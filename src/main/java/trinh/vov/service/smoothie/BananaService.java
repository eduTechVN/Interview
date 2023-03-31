package trinh.vov.service.smoothie;

import trinh.vov.constants.Commons;
import trinh.vov.exception.BadRequestException;

public class BananaService implements FruitService {

    @Override
    public Inventory calculateSmoothie(int quantity, int sumFruit, int ice, int milk, int sugar) {
        int totalBananaMl = (quantity * 3) * Commons.FIFTY;

        if(totalBananaMl > ((sumFruit * Commons.ONE_HUNDRED) / Commons.ONE_HUNDRED_TWENTY)){
            throw new BadRequestException("Mango don't enough to supply "+quantity+ "smoothie.");
        }

        if(ice < (Commons.THIRTY * (quantity * 3))){
            throw new BadRequestException("Ice don't enough to supply "+quantity+ "smoothie.");
        }

        if(milk < (Commons.TWENTY * (quantity * 3))){
            throw new BadRequestException("Milk don't enough to supply "+quantity+ "smoothie.");
        }

        if(sugar < (Commons.EIGHT * (quantity * 3))){
            throw new BadRequestException("Sugar don't enough to supply "+quantity+ "smoothie.");
        }

        Integer remainFruit = sumFruit - ((totalBananaMl * Commons.ONE_HUNDRED_FORTY) / Commons.ONE_HUNDRED);
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
