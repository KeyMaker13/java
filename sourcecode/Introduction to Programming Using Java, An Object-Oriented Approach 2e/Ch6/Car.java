class Car {
    public Car(String make, String model, int year) {
	this.make = make;
	this.model = model;
	this.year = year;
	warranty = "None";
    }

    public void chooseWarranty(int mileage, int ageInMonths) {
	if (mileage <= 36000 && ageInMonths <= 36)
	    warranty = "Standard";
	else if (mileage <= 50000 && ageInMonths <= 72)
	    warranty = "Extended";
	else if (mileage <= 100000 && ageInMonths <= 84)
	    warranty = "Sucker";
	else
	    warranty = "None";
    }

    private String make;
    private String model;
    private int year;
    private String warranty;
}
