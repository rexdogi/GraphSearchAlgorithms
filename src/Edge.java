/**
 * Created by Paulius on 3/28/2017.
 */
public class Edge {

    private Node parentNode;
    private Node childNode;
    private int weight;

    public Edge(Node parentNode, Node childNode) {
        this.parentNode = parentNode;
        this.childNode = childNode;
    }

    public Edge(Node parentNode, Node childNode, int weight) {
        this.parentNode = parentNode;
        this.childNode = childNode;
        this.weight = weight;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Node getChildNode() {
        return childNode;
    }

    public int getWeight() {
        return weight;
    }
}
