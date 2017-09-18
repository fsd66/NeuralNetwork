package net.fsd66.neuralnet.nodes;

public class InputNode extends Node {

    public InputNode(double value) {
        super(value);
    }

    public InputNode() {
        this(0.0);
    }

    @Override
    public double getValue() {
        return super.getBias();
    }

    @Override
    public void setBias(double bias) {
        super.setBias(bias);
        super.setValue(bias);
    }

    @Override
    protected void setValue(double value) {
        super.setValue(value);
        super.setBias(value);
    }

    @Override
    public void calculateValue() {
        return;  /* Do nothing */
    }
}
