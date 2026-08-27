package sealed;

// Sealed class allowing only specific subclasses
public sealed class Vehicle permits Car, Bike {}
