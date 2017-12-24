package ds;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class Graph {
  static class Node {
    public int data;

    public Node(int data) {
      this.data = data;
    }
  }

  Map<Node, List<Node>> ajdacancyList = new HashMap<Node, List<Node>>();

  public void addUnDirectedEdge(Node source, Node destination) {
    if(ajdacancyList.get(source) == null) {
      ajdacancyList.put(source, new ArrayList<Node>());
    }

    ajdacancyList.get(source).add(destination);

    if(ajdacancyList.get(destination) == null) {
      ajdacancyList.put(destination, new ArrayList<Node>());
    }

    ajdacancyList.get(destination).add(source);
  }

  public static Graph buildUnDirectedGraph() {
    Graph graph = new Graph();

    Node v0 = new Node(0);
    Node v1 = new Node(1);
    Node v2 = new Node(2);
    Node v3 = new Node(3);
    Node v4 = new Node(4);
    graph.addUnDirectedEdge(v0, v1);
    graph.addUnDirectedEdge(v0, v4);
    graph.addUnDirectedEdge(v1, v2);
    graph.addUnDirectedEdge(v1, v3);
    graph.addUnDirectedEdge(v1, v4);
    graph.addUnDirectedEdge(v2, v3);
    graph.addUnDirectedEdge(v3, v4);
    return graph;
  }

  public void printBFS() {
    List<Node> bfsQueue = new ArrayList<Node>();
    Map<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();

    Node firstNode = (Node)ajdacancyList.keySet().toArray()[0];
    bfsQueue.add(firstNode);
    visitedMap.put(firstNode, true);

    System.out.println(bfsQueue.get(0).data);
    while (!bfsQueue.isEmpty()) {
      Node parent = bfsQueue.get(0);
      List<Node> children = ajdacancyList.get(parent);

      // if we have not visited this any of child visit them
      for(Node child: children) {
        if(visitedMap.get(child) == null) {
          bfsQueue.add(child);
          visitedMap.put(child, true);

          System.out.println(child.data);
        }
      }

      bfsQueue.remove(parent);
    }
  }

  public void printDFS() {
      Map<Node, Boolean> visitedMap = new HashMap<Node, Boolean>();
      Node firstNode = (Node)ajdacancyList.keySet().toArray()[0];

      recurseForDFS(firstNode, visitedMap);
  }

  private void recurseForDFS(Node firstNode, Map<Node, Boolean> visitedMap) {
    if(visitedMap.get(firstNode) == null) {
      visitedMap.put(firstNode, true);
      System.out.println(firstNode.data);

      for(Node child: ajdacancyList.get(firstNode)) {
        recurseForDFS(child, visitedMap);
      }
    }
  }

  public static void main(String[] args) {
    Graph graph = Graph.buildUnDirectedGraph();
    // graph.printBFS();
    graph.printDFS();
  }
}
