import java.util.ArrayList;

/**
 * Created by Paulius on 3/28/2017.
 */
public class Node {

    private String name;

    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Node> edgeNodes = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, Node node) {
        this.name = name;
        this.addEdge(node);
    }

    public void addEdge(Node node) {
        if(!this.edgeNodes.contains(node)) {
            this.edges.add(new Edge(this, node));
            this.edgeNodes.add(node);
            System.out.println("Edge has been added");
        } else {
            System.out.println("Edge already exists");
        }
    }
    public void addDirectedEdge(Node node) {
        if(!this.edgeNodes.contains(node)) {
            this.edges.add(new Edge(this, node));
            this.edgeNodes.add(node);
            node.addEdge(this);
        } else {
            System.out.println("Edge already exists");
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Node> getEdgeNodes() {
        return this.edgeNodes;
    }
}
