import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Paulius on 3/29/2017.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Node<Asmuo>> nodes = new ArrayList<>();

        try {
           nodes =  new FileRead("data.txt").readFile();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graph<Asmuo> graph = new Graph(nodes);
        System.out.println("Unidirected graph");
        System.out.println("BFS");
        graph.startBreadthFirstSearch(3);
        System.out.println();
        System.out.println("DFS");
        graph.startDepthFirstSearch();
        System.out.println();

        try {
            nodes =  new FileRead("data.txt", true).readFile();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("directed graph");
        graph = new Graph(nodes);
        System.out.println("BFS");
        graph.startBreadthFirstSearch(3);
        System.out.println();
        System.out.println("DFS");

        graph.startDepthFirstSearch();
        System.out.println();
    }
}
