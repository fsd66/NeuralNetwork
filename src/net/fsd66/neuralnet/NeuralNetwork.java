package net.fsd66.neuralnet;

import net.fsd66.neuralnet.nodes.InputNode;
import net.fsd66.neuralnet.nodes.Node;

import java.util.LinkedList;

public class NeuralNetwork {
    private LinkedList<Layer> layers;

    public NeuralNetwork() {
        layers = new LinkedList<Layer>();
    }

    public void connectLists() {
        if(layers.size() == 1) return;

        Layer temp = layers.getFirst();
        for(Layer currentLayer : layers) {
            if(layers.getFirst() != currentLayer) currentLayer.linkNodesFromLayer(temp);
            temp = currentLayer;
        }
    }

    public void resetConnections() {
        for(Layer currentLayer : layers) {
            for(Node nodes: currentLayer.getNodes()) {
                nodes.resetConnections();
            }
        }
    }

    public LinkedList<Layer> getLayers() {
        return layers;
    }
    
    public void calculateNetwork() {
        for(Layer currentLayer : layers) {
            currentLayer.calculateValues();
        }
    }

    public double[] getOutput() {        
        return layers.getLast().getValues();
    }

    public LinkedList<Connection> getAllConnections() {
        LinkedList<Connection> connections = new LinkedList<>();

        for(Layer l : layers) {
            for(Node n : l.getNodes()) {
                connections.addAll(n.getInputConnections());
            }
        }

        return connections;
    }

    public LinkedList<Node> getAllNodes() {
        LinkedList<Node> nodes = new LinkedList<>();

        for(Layer l : layers) {
            nodes.addAll(l.getNodes());
        }

        return nodes;
    }

    public int getNumberOfInputs() {
        return layers.getFirst().getNodes().size();
    }

    public int getNumberOfOutputs() {
        return layers.getLast().getNodes().size();
    }
}
