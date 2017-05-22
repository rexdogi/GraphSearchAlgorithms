import java.util.ArrayList;

/**
 * Created by Paulius on 3/28/2017.
 */
public class Node<T> {

    private String name;
    private T object;
    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Node> edgeNodes = new ArrayList<>();

    public Node(String name, T object) {
        this.name = name;
        this.object = object;
    }

    public Node(String name, Node node, T object) {
        this.name = name;
        this.object = object;
        this.addEdge(node);
    }

    public void addEdge(Node node) {
        if(!this.edgeNodes.contains(node)) {
            this.edges.add(new Edge(this, node));
            this.edgeNodes.add(node);
            node.getEdgeNodes().add(this);
        }
    }

    public void addDirectedEdge(Node node) {
        if(!this.edgeNodes.contains(node)) {
            this.edges.add(new Edge(this, node));
            this.edgeNodes.add(node);
        } else {
            System.out.println("Edge already exists");
        }
    }

    public T getObject() {
        return this.object;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Node> getEdgeNodes() {
        return this.edgeNodes;
    }
}
