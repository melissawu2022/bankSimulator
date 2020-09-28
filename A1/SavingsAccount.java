public class SavingsAccount extends Account {

    public SavingsAccount(Customer customer) {
        super(customer);
    }

    public void deposit(double amt) {
        if (amt > 0) {
            double fees = 0;
            balance += amt - fees;
            addTransaction((byte)0, amt, fees);
        }
        else {
            System.out.println("You entered a negative number less than 0.");
        }
    }

    public void withdraw(double amt) {
        //overdraft if amount will make balance < 0
        double fees = 0.0;
        if (((balance - amt) < 0) && (amt > 0)) {
            if (customer instanceof Senior) {
                Senior s = (Senior) customer;
                if (s.vipSenior() == true) {
                    if (amt <= 100) {
                        fees = 0;
                    }
                    else if (amt >= 100 && amt <= 455) {
                        fees = s.getOverdraftPenalty();
                    }
                    else {
                        System.out.println("Your balance is not high enough for a withdrawal.");
                    }
                }
                fees = s.getCheckCharge() + s.getOverdraftPenalty();
            }

            else if (customer instanceof Adult) {
                if (0 >= amt && amt <= 455) {
                    Adult a = (Adult) customer;
                    fees = a.getCheckCharge() + a.getOverdraftPenalty();
                }
                else {
                    System.out.println("Your balance is not high enough for a withdrawal.");
                }
            }

            else if (customer instanceof Student) {
                System.out.println("You are not eligible for a withdrawal");
            }

            balance -= amt - fees;
            addTransaction((byte)1, amt, fees);
        }

        else if (((balance - amt) > 0) && (amt > 0)) {
            if (customer instanceof Senior) {
                Senior s = (Senior) customer;
                if (s.vipSenior() == true) {
                    fees = 0;
                }
                fees = s.getCheckCharge();
            }

            else if (customer instanceof Adult) {
                Adult a = (Adult) customer;
                if (0 >= amt && amt <= 455) {
                    fees = a.getCheckCharge();
                }
            }

            else if (customer instanceof Student) {
                Student st = (Student) customer;
                fees = st.getCheckCharge();
            }

            balance -= amt - fees;
            addTransaction((byte)1, amt, fees);
        }
        else if (amt < 0) { System.out.println("You entered a negative number less than 0."); }
    }



    public void addInterest() {
        double fees = 0.0;
        if (customer instanceof Senior) {
            Senior s = (Senior) customer;
            if (s.vipSenior() == true) {
                fees = s.getSavingsInterest();
            }
            fees = s.getSavingsInterest();
        }

        else if (customer instanceof Adult) {
            Adult a = (Adult) customer;
            fees = a.getSavingsInterest();
        }
        else if (customer instanceof Student) {
            Student st = (Student) customer;
            fees = st.getSavingsInterest();
        }
        balance += fees;
    }
}
