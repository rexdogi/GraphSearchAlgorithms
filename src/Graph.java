import java.util.*;

/**
 * Created by Paulius on 3/28/2017.
 */
public class Graph {

    private ArrayList<Node> nodes;
    private Stack<Node> nodeStack = new Stack<>();
    private Queue<Node> nodeQueue = new LinkedList<>();
    private ArrayList<Node> visitedNodes = new ArrayList<>();

    public Graph(ArrayList<Node> nodes) {
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
        System.out.println("Visited: " + nodeStack.peek().getName());
        depthFirstSearch();
    }

    public void startBreadthFirstSearch() {
        reinitialize();
        nodeQueue.add(nodes.get(0));
        System.out.println("Visited: " + nodeQueue.peek().getName());
        breadthFirstSearch();
    }

    private void breadthFirstSearch() {
        Node nextNode = nodeQueue.peek();
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
        visitedNodes.add(nodeStack.peek());
        Node nextNode = getUnvisitedNode();
        if(nextNode != null) {
            markVisitedStack();
        } else {
            nodeStack.pop();
        }
        if(!nodeStack.empty()) {
            depthFirstSearch();
        }
    }

    private void markVisitedQueue() {
        nodeQueue.add(getUnvisitedNode());
        System.out.println("Visited: " + nodeQueue.peek().getName());
    }

    private void markVisitedStack() {
        nodeStack.push(getUnvisitedNode());
        System.out.println("Visited: " + nodeStack.peek().getName());
    }

    public Node getUnvisitedNode() {
        return nodeStack.peek().getEdgeNodes().stream().filter(node -> !visitedNodes.contains(node)).findFirst().orElse(null);
    }

}
