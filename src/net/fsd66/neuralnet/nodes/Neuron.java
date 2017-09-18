package net.fsd66.neuralnet.nodes;

import net.fsd66.neuralnet.Connection;

public class Neuron extends Node {

    @Override
    public void calculateValue() {
        this.setValue(this.getBias());
        for (Connection c : this.getInputConnections()) {
            this.setValue(this.getValue() + c.getOrigin().getValue() * c.getWeight());
        }
    }
}
