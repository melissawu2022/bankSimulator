abstract class Customer {
    //attributes/instance variables
    static int lastCustomerNumber = 9999;
    private int customerNumber;
    protected String customerName;
    private int age;


    //Constructor
    public Customer(String customerName, int age, int customerNumber) {
        this.customerName = customerName;
        this.age = age;
        this.customerNumber = lastCustomerNumber++;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getAge() {
        return this.age;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public void setcustomerName(String custName) {
        this.customerName = custName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean equals(Customer other) {
        if (customerNumber == other.customerNumber && customerName == other.customerName && age == other.age)
            return true;
        return false;
    }

    public String toString() {
        String s;
        s = customerNumber + " , " + customerName + " , " + age;
        return s;
     }

     abstract public double getSavingsInterest();

     abstract public double getCheckInterest();

     abstract public double getCheckCharge();
}
