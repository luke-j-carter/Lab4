import java.util.ArrayList;
import java.util.List;

public class EconomicDataSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private EconomicData currentData;

    // Method to set the new data and notify observers
    public void setEconomicData(EconomicData newData) {
        this.currentData = newData;
        notifyObservers();  // Notify observers whenever the data changes
    }

    // Getter method for current data
    public EconomicData getEconomicData() {
        return currentData;
    }

    // Register a new observer
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer); // Add the observer to the list
    }

    // Remove an observer
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // Remove the observer from the list
    }

    // Notify all registered observers
    @Override
    public void notifyObservers() {
        if (currentData != null) {
            for (Observer observer : observers) {
                observer.update(currentData);  // Notify each observer with the current data
            }
        } else {
            System.out.println("No data available to notify observers.");
        }
    }
}
