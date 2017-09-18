package net.fsd66.neuralnet.nodes;

import net.fsd66.neuralnet.Connection;

import java.util.LinkedList;

public abstract class Node {
    private LinkedList<Connection> inputConnections;
    private double value;
    private double bias;

    public Node(double bias) {
        inputConnections = new LinkedList<Connection>();
        this.bias = bias;
    }

    public Node() {
        this(0);
    }

    public void connectFromNode(Node node) {
        Connection c = new Connection(node, this);
        inputConnections.add(c);
    }

    public void resetConnections() {
        inputConnections = new LinkedList<Connection>();
    }

    public double getValue() {
        return value;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public abstract void calculateValue();

    public LinkedList<Connection> getInputConnections() {
        return inputConnections;
    }

    protected void setValue(double value) {
        this.value = value;
    }
}
