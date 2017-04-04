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
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        node1.addEdge(node2);
        node1.addEdge(node4);
        node1.addEdge(node5);
        node1.addEdge(node7);
        node5.addEdge(node2);
        node5.addEdge(node7);
        node2.addEdge(node6);
        node6.addEdge(node3);
        node6.addEdge(node4);
        node3.addEdge(node8);


        nodes.addAll(Arrays.asList(node1,node2,node3));
        Graph graph = new Graph(nodes);
        graph.startBreadthFirstSearch();
        System.out.println();
        graph.startDepthFirstSearch();
    }
}
