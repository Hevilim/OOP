abstract class Circuit {

    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getPower() {
        double V = getPotentialDiff();
        return V * V / getResistance();
    }

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }
}

class Resistor extends Circuit {

    private double resistance;
    private double potentialDifference;

    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0;
    }

    public double getResistance() { return resistance; }
    public double getPotentialDiff() { return potentialDifference; }

    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }
}

class Series extends Circuit {

    private Circuit c1;
    private Circuit c2;

    public Series(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double getResistance() {
        return c1.getResistance() + c2.getResistance();
    }

    public double getPotentialDiff() {
        return c1.getPotentialDiff() + c2.getPotentialDiff();
    }

    public void applyPotentialDiff(double V) {
        double I = V / getResistance();
        c1.applyPotentialDiff(I * c1.getResistance());
        c2.applyPotentialDiff(I * c2.getResistance());
    }
}

class Parallel extends Circuit {

    private Circuit c1;
    private Circuit c2;

    public Parallel(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public double getResistance() {
        return 1.0 / (1.0 / c1.getResistance() + 1.0 / c2.getResistance());
    }

    public double getPotentialDiff() {
        return c1.getPotentialDiff();
    }

    public void applyPotentialDiff(double V) {
        c1.applyPotentialDiff(V);
        c2.applyPotentialDiff(V);
    }
}
