package car;

// Class used for testing the car super class itself
class TestCar extends Car {
    public TestCar() {
        nrDoors = 2;
        enginePower = 5;
        modelName = "Test 473658235343623458432654325";
        StopEngine();
    }
    
    @Override
    public double speedFactor() {
        return 1;
    }
}
