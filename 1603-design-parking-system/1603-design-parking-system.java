class ParkingSystem {
    int bigSlots = 0;
    int mediumSlots = 0;
    int smallSlots = 0;
    public ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1)
        {
            if(bigSlots == 0)
                return false;
            bigSlots--;
        }
        else if(carType == 2)
        {
            if(mediumSlots == 0)
                return false;
            mediumSlots--;
        }
        else if(carType == 3)
        {
            if(smallSlots == 0)
                return false;
            smallSlots--;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */