package observer;

import base.Incident;

import java.util.*;

public class ObservedSubject {
    private List<observer.Observer> observers = new ArrayList<>();

    public void addObserver(observer.Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(observer.Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Incident incident) {
        for (observer.Observer observer : observers) {
            observer.update(incident);
        }
    }
}
