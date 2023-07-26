package CoffeeComplete;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;

    private List<String> orderedFood;
    private List<String> orderedDrinks;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        orderedFood = new ArrayList<>();
        orderedDrinks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addOrderedFood(String food) {
        orderedFood.add(food);
    }

    public void addOrderedDrink(String drink) {
        orderedDrinks.add(drink);
    }

    public List<String> getOrderedFood() {
        return orderedFood;
    }

    public List<String> getOrderedDrinks() {
        return orderedDrinks;
    }
}
