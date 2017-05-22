import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Paulius on 5/21/2017.
 */
public class FileRead {

    private String filename;
    private Boolean directed = false;

    public FileRead(String filename, boolean directed) {
        this.filename = filename;
        this.directed = directed;
    }

    public FileRead(String filename) {
        this.filename = filename;
    }

    public ArrayList<Node<Asmuo>> readFile() throws IOException {
        ArrayList<Node<Asmuo>> nodes = new ArrayList<>();
        int adjacency[][] = null;
        BufferedReader read = new BufferedReader(new FileReader(filename));
        int length = 0;
        int index = 0;
        int adjIndex = 0;
        String line = null;
        while( (line = read.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            if(tokens.hasMoreTokens()) {
                if(length == 0) {
                    length = Integer.parseInt(tokens.nextToken());
                    adjacency = new int[length][length];
                } else if(index < length) {
                    nodes.add(new Node(tokens.nextToken(), new Asmuo(tokens.nextToken(), tokens.nextToken(), Integer.parseInt(tokens.nextToken()))));
                    index++;
                } else {
                   for(int i = 0; i < length; i++) {
                        adjacency[adjIndex][i] = Integer.parseInt(tokens.nextToken());
                   }
                    adjIndex++;
                }
            }
        }
        return setupRelations(nodes, adjacency, length);
    }

    public ArrayList<Node<Asmuo>> setupRelations(ArrayList<Node<Asmuo>> nodes, int adj[][], int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(adj[i][j] == 1) {
                    if(directed) {
                        nodes.get(i).addDirectedEdge(nodes.get(j));
                    } else {
                        nodes.get(i).addEdge(nodes.get(j));
                    }
                }
            }
        }
        return nodes;
    }
}
