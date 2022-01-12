package org.example.model;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.OptionalInt;

@Gson.TypeAdapters
@Value.Immutable
public abstract class Task {

    public abstract OptionalInt id();
    public abstract String title();
    public abstract String description();
    public abstract boolean isFinished();

}
