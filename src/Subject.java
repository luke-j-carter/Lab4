// Subject Interface (the Observable)
public interface Subject {
    void registerObserver(Observer observer);   // To register an observer
    void removeObserver(Observer observer);     // To remove an observer
    void notifyObservers();                     // To notify all observers
}

