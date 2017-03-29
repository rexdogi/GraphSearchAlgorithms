import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Paulius on 3/29/2017.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        node1.addEdge(node2);
        node2.addEdge(node3);
        nodes.addAll(Arrays.asList(node1,node2,node3));
        Graph graph = new Graph(nodes);
        graph.depthFirstSearch();
    }
}
