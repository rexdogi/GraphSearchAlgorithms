import java.util.*;

/**
 * Created by Paulius on 3/28/2017.
 */
public class Graph<T> {

    private ArrayList<Node<T>> nodes;
    private Stack<Node<T>> nodeStack = new Stack<>();
    private Queue<Node<T>> nodeQueue = new LinkedList<>();
    private ArrayList<Node<T>> visitedNodes = new ArrayList<>();

    public Graph(ArrayList<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public void reinitialize() {
        nodeQueue.clear();
        nodeStack.clear();
        visitedNodes.clear();
    }

    public void startDepthFirstSearch() {
        reinitialize();
        nodeStack.push(nodes.get(0));
        System.out.println("Starting from " + nodeStack.peek().getName());
        System.out.println("Visited: " + nodeStack.peek().getName());
        depthFirstSearch();
    }

    public void startBreadthFirstSearch() {
        reinitialize();
        nodeQueue.add(nodes.get(0));
        System.out.println("Starting from " + nodeQueue.peek().getName());
        System.out.println("Visited: " + nodeQueue.peek().getName());
        breadthFirstSearch();
    }

    public void startDepthFirstSearch(int index) {
        reinitialize();
        nodeStack.push(nodes.get(index));
        System.out.println("Starting from " + nodeStack.peek().getName());
        System.out.println("Visited: " + nodeStack.peek().getName());
        depthFirstSearch();
    }

    public void startBreadthFirstSearch(int index) {
        reinitialize();
        nodeQueue.add(nodes.get(index));
        System.out.println("Starting from " + nodeQueue.peek().getName());
        System.out.println("Visited: " + nodeQueue.peek().getName());
        breadthFirstSearch();
    }

    private void breadthFirstSearch() {
        Node<T> nextNode = nodeQueue.peek();
        if(nextNode == null) return;
        nextNode.getEdgeNodes().forEach(node -> {
            if(!visitedNodes.contains(node)) {
                nodeQueue.add(node);
                visitedNodes.add(node);
                System.out.println("Visited: " + node.getName());
            }
        });
        visitedNodes.add(nextNode);
        nodeQueue.remove();
        if(!nodeQueue.isEmpty()) {
            breadthFirstSearch();
        }
    }

    private void depthFirstSearch() {
        if(!visitedNodes.contains(nodeStack.peek())) {
            visitedNodes.add(nodeStack.peek());
        }
        Node nextNode = getUnvisitedNode();
        if(nextNode != null) {
            nodeStack.push(getUnvisitedNode());
            System.out.println("Visited: " + nodeStack.peek().getName());
        } else {
            nodeStack.pop();
        }
        if(!nodeStack.empty()) {
            depthFirstSearch();
        }
    }


    public Node getUnvisitedNode() {
        return nodeStack.peek().getEdgeNodes().stream().filter(node -> !visitedNodes.contains(node)).findFirst().orElse(null);
    }

    // index from 0
    public void connectNode(Node<T> node, int endNodeIndex) {
        node.addEdge(node);
        node.addEdge(nodes.get(endNodeIndex));
    }

    public void connectNode(int startNodeIndex, int endNodeIndex) {
        nodes.get(startNodeIndex).addEdge(nodes.get(endNodeIndex));
    }

    public void addNode(Node<T> node) {
        if(!nodes.contains(node)) {
            nodes.add(node);
        }
    }


}
