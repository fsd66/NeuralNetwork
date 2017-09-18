package net.fsd66.neuralnet.generators;

import net.fsd66.neuralnet.Layer;
import net.fsd66.neuralnet.NetworkDefinition;
import net.fsd66.neuralnet.NeuralNetwork;
import net.fsd66.neuralnet.nodes.InputNode;
import net.fsd66.neuralnet.nodes.Neuron;
import net.fsd66.neuralnet.nodes.SigmoidNeuron;

import java.util.Random;

public class SigmoidGenerator {
    public static NeuralNetwork generateSigmoidNetwork(NetworkDefinition definition) {
        NeuralNetwork network = new NeuralNetwork();

        SigmoidGenerator.generateInputs(network, definition.getInputs());

        for(int i : definition.getLayers()) {
            SigmoidGenerator.generateHiddenLayer(network, i);
        }

        SigmoidGenerator.generateOutputLayer(network, definition.getOutputs()); /* Generate output layer */
        return network;
    }

    private static void generateInputs(NeuralNetwork network, int numberOfInputs) {
        Layer layer = new Layer();
        for(int i = 0; i < numberOfInputs; i++) {
            layer.addNode(new InputNode());
        }
        network.getLayers().add(layer);
    }

    private static void generateHiddenLayer(NeuralNetwork network, int numberOfNodes) {
        Layer layer = new Layer();
        for(int i = 0; i < numberOfNodes; i++) {
            layer.addNode(new SigmoidNeuron());
        }
        network.getLayers().add(layer);
    }

    private static void generateOutputLayer(NeuralNetwork network, int numberOfNodes) {
        Layer layer = new Layer();
        for(int i = 0; i < numberOfNodes; i++) {
            layer.addNode(new Neuron());
        }
        network.getLayers().add(layer);
    }
}
