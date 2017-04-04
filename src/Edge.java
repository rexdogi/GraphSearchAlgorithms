/**
 * Created by Paulius on 3/28/2017.
 */
public class Edge {

    private Node start;
    private Node end;
    private int weight;

    public Edge(Node parentNode, Node childNode) {
        this.start = parentNode;
        this.end = childNode;
    }

    public Edge(Node parentNode, Node childNode, int weight) {
        this.start = parentNode;
        this.end = childNode;
        this.weight = weight;
    }

    public Node getStarttNode() {
        return start;
    }

    public Node getEndNode() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}
