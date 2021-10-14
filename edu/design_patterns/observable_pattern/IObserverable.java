package edu.design_patterns.observable_pattern;

public interface IObserverable {

  void register(IObserver observer);

  void unregister(IObserver observer);

  void notifyObserver();
}
