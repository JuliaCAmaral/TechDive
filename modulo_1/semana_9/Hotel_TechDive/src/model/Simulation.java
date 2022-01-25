package model;

import view.HighLowSeasonEnum;

public class Simulation {

    private final int standardRooms;
    private final int premiumRooms;
    private final int supremeRooms;

    public Simulation() {
        this.standardRooms = (int) (Math.random() * 9 + 1);
        this.premiumRooms = (int) (Math.random() * (10 - this.standardRooms) + 1);
        this.supremeRooms = 10 - (this.standardRooms + this.premiumRooms);
    }

    public double getPrice(int period, HighLowSeasonEnum highOrLow) {
        double costStandardRooms = highOrLow.equals(HighLowSeasonEnum.HIGH_SEASON) ? this.standardRooms * RoomTypeEnum.STANDARD.getHighCost() : this.standardRooms * RoomTypeEnum.STANDARD.getLowCost();
        double costPremiumRooms  = highOrLow.equals(HighLowSeasonEnum.HIGH_SEASON) ? this.premiumRooms * RoomTypeEnum.PREMIUM.getHighCost() : this.premiumRooms * RoomTypeEnum.PREMIUM.getLowCost();
        double costSupremeRooms  = highOrLow.equals(HighLowSeasonEnum.HIGH_SEASON) ? this.supremeRooms * RoomTypeEnum.SUPREME.getHighCost() : this.supremeRooms * RoomTypeEnum.SUPREME.getLowCost();

        return period * (costStandardRooms + costPremiumRooms + costSupremeRooms);
    }

    public int getStandardRooms() {
        return standardRooms;
    }

    public int getPremiumRooms() {
        return premiumRooms;
    }

    public int getSupremeRooms() {
        return supremeRooms;
    }
}
