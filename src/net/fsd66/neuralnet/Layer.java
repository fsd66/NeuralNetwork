package net.fsd66.neuralnet;

import net.fsd66.neuralnet.nodes.Node;

import java.util.LinkedList;

public class Layer {
    private LinkedList<Node> nodes;

    public Layer() {
        this.nodes = new LinkedList<>();
    }

    public LinkedList<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node neuron) {
        this.nodes.add(neuron);
    }

    public void linkNodesFromLayer(Layer layer) {
        for(Node n1 : nodes) {
            for(Node n2 : layer.getNodes()) {
                n1.connectFromNode(n2);
            }
        }
    }

    public void calculateValues() {
        for(Node n : nodes) {
            n.calculateValue();
        }
    }

    public double[] getValues() {
        double[] output = new double[nodes.size()];

        for(int i = 0; i < output.length; i++) {
            output[i] = nodes.get(i).getValue();
        }
        return output;
    }
}
