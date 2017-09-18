package net.fsd66.neuralnet;

import net.fsd66.neuralnet.nodes.Neuron;
import net.fsd66.neuralnet.nodes.Node;

public class Connection {
    private Node origin;
    private Node destination;
    private double weight;

    public Connection(Node origin, Node destination, double weight) {
        this.origin = origin;
        this.destination = destination;
    }

    public Connection(Node origin, Node destination) {
        this(origin, destination, 0);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node getOrigin() {
        return origin;
    }

    public Node getDestination() {
        return destination;
    }
}
