package net.fsd66.neuralnet;

public class NetworkDefinition {
    private final int inputs;
    private final int[] layers;
    private final int outputs;

    public NetworkDefinition(int inputs, int outputs, int... layers) {
        this.inputs = inputs;
        this.layers = layers;
        this.outputs = outputs;
    }

    public int getInputs() {
        return inputs;
    }

    public int[] getLayers() {
        return layers;
    }

    public int getOutputs() {
        return outputs;
    }
}
