package com.aaron.observerpattern.subject;

public interface Subject {
    void registerObserver();
    void removeObserver();
    void notifyObservers();
}
