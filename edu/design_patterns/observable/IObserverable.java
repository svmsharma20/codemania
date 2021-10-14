package edu.design_patterns.observable;

public interface IObserverable {

  void register(IObserver observer);

  void unregister(IObserver observer);

  void notifyObserver();
}
