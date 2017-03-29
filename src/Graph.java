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
        nodeStack.push(nodes.get(0));
    }

    public void depthFirstSearch() {
        nodeStack.forEach(node -> {
            visit();
        });
    }

    public void visit() {
        System.out.println("Visited: " + nodeStack.peek().getName());
        visitedNodes.add(nodeStack.peek());
    }

    public Node getUnvisitedNode() {
        return nodeStack.peek().getEdgeNodes().stream().filter(node -> !visitedNodes.contains(node)).findFirst().orElse(null);
    }

}
