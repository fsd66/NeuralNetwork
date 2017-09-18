package net.fsd66.neuralnet.nodes;

public class SigmoidNeuron extends Neuron {
    @Override
    public void calculateValue() {
        super.calculateValue();
        this.setValue(sigmoidFunction(this.getValue()));
    }

    private double sigmoidFunction(double z) {
        return 1 / (1 + Math.exp(-z));
    }
}
