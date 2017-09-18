package net.fsd66.neuralnet.tests;

import net.fsd66.neuralnet.Connection;
import net.fsd66.neuralnet.NetworkDefinition;
import net.fsd66.neuralnet.NeuralNetwork;
import net.fsd66.neuralnet.generators.SigmoidGenerator;
import net.fsd66.neuralnet.nodes.Node;

import java.util.LinkedList;
import java.util.Random;

public class NetworkTest01 {
    public static void main(String[] args) {
        NeuralNetwork network = SigmoidGenerator.generateSigmoidNetwork(new NetworkDefinition(15, 2, 20));
        network.connectLists();
        Random r = new Random();
        for(Node n : network.getLayers().getFirst().getNodes()) {
            n.setBias(1);
        }

        LinkedList<Connection> connections = network.getAllConnections();
        for(Connection c : connections) {
            c.setWeight((r.nextDouble() * 10) - 5);
        }

        network.calculateNetwork();
        double[] output = network.getOutput();
        for(int i = 0; i < output.length; i++) {
            System.out.println("Value of output #" + i + ": " + output[i]);
        }
    }
}
