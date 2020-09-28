abstract class Customer {
    //attributes/instance variables
    static int lastCustomerNumber = 9999;
    private int customerNumber;
    protected String customerName;
    private int age;


    /** Creates a new instance of Customer */
    public Customer(String customerName, int age) {
        this.customerName = customerName;
        this.age = age;
        this.customerNumber = lastCustomerNumber++;
    }

    /*******************************************
    * Returns customer's name
    * @return String customer's name
    */
    public String getCustomerName() {
        return this.customerName;
    }

    /*******************************************
    * Returns customer's age
    * @return int customer's age
    */
    public int getAge() {
        return this.age;
    }

    /*******************************************
    * Returns customer's number
    * @return int customer's number
    */
    public int getCustomerNumber() {
        return this.customerNumber;
    }

    /*******************************************
    * Changes customer's name
    * pre: name must be a not null string
    * post: customer's name changes to <name>
    * @param String name New name
    */
    public void setcustomerName(String custName) {
        this.customerName = custName;
    }

    /*******************************************
    * Changes customer's age
    * pre: age must be a valid integer
    * post: customer's age changes to <age>
    * @param Int age New age
    */
    public void setAge(int age) {
        this.age = age;
    }

    /*******************************************
    * Changes customer's number
    * pre: customerNumber must be a valid integer
    * post: customer's number changes to <customerNumber>
    * @param Int customerNumber New customerNumber
    */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }


    /*******************************************
    * Compares if two customers are the same
    * @return Boolean value
    */
    public boolean equals(Customer other) {
        if (customerNumber == other.customerNumber && customerName == other.customerName && age == other.age)
            return true;
        return false;
    }

    /*******************************************
    * Converts Customer object to a String object
    * @return String customer information as String object
    */
    public String toString() {
        return "Customer Number: " + customerNumber + ", Customer name: " + customerName + ", Customer age: " + age;

     }

     //abstract methods
     abstract public double getSavingsInterest();

     abstract public double getCheckInterest();

     abstract public double getCheckCharge();
}
