package com.aaron.observerpattern.subject;

public class ConcreteSubject implements Subject{

    private String state;

    @Override
    public void registerObserver() {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObservers() {

    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
