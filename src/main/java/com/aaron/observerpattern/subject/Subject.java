package com.aaron.observerpattern.subject;

import com.aaron.observerpattern.observer.Observer;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
