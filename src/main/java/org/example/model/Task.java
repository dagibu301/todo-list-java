package org.example.model;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Task {

    public abstract int id();
    public abstract String title();
    public abstract String description();
    public abstract boolean isFinished();

}
