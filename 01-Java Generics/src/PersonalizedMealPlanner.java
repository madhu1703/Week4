import java.util.*;
interface MealPlan {
    String getMealType();
    String getDetails();
}
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
    public String getDetails() {
        return "Includes vegetables, grains, fruits, and dairy.";
    }
}
class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
    public String getDetails() {
        return "Excludes all animal products.";
    }
}
class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
    public String getDetails() {
        return "Low-carb, high-fat diet.";
    }
}
class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
    public String getDetails() {
        return "Rich in protein, good for muscle building.";
    }
}
class Meal<T extends MealPlan> {
    private T mealPlan;
    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    public T getMealPlan() {
        return mealPlan;
    }
    public void displayMealPlan() {
        System.out.println("Meal Type: " + mealPlan.getMealType());
        System.out.println("Details  : " + mealPlan.getDetails());
    }
}
class MealGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }
}
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealGenerator.generateMealPlan(new HighProteinMeal());
        System.out.println("Your Personalized Meal Plans:\n");
        vegMeal.displayMealPlan();
        System.out.println();
        veganMeal.displayMealPlan();
        System.out.println();
        ketoMeal.displayMealPlan();
        System.out.println();
        proteinMeal.displayMealPlan();
    }
}

