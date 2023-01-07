/*
 * Weighted Graph class for extra credit
 */
import java.util.*;
class WeightedGraph {
    /*
     * Following similar implementation for the graph class, we use a HashMap as our adjecency list
     */
  private Map<String, Map<String, Integer>> weightedGraph;

  // Constructor for Class
  public WeightedGraph() {
    weightedGraph = new HashMap<String, Map<String, Integer>>();
  }

  /*
   * Adding weighted edge for graph
   * Returns false is node does not exist, and true if edge is added to graph
   */
  public boolean addWeightedEdge(String from, String to, int weight) {
    if (!weightedGraph.containsKey(from) || !weightedGraph.containsKey(to)) {
      return false;
    }
    Map<String, Integer> neighboringNode = weightedGraph.get(from);
    neighboringNode.put(to, weight);

    return true;
  }

  /*
   * Add weighted edge from node "from" to "toList"
   */
  public boolean addWeightedEdges(String from, String[] tolist, int[] weightlist) {
    // Check to see if the 'tolist' and 'weightlist' have the same size
    if (tolist.length != weightlist.length) {
      return false;
    }

    // Check if the 'from' node exists in the graph
    if (!weightedGraph.containsKey(from)) {
      return false;
    }

    // Adding edges to the adjacency list
    Map<String, Integer> neighboringNode = weightedGraph.get(from);
    for (int i = 0; i < tolist.length; i++) {
      neighboringNode.put(tolist[i], weightlist[i]);
    }

    return true;
  }

  //Printing weighted graph, such that the nodes are sorted alphabetically
  public void printWeightedGraph() {
    // Sort the nodes alphabetically
    List<String> nodes = new ArrayList<String>(weightedGraph.keySet());
    Collections.sort(nodes);

    // Print the adjacency list for each node
    for (String node : nodes) {
      System.out.print(node + "  ");

      // Sorting neighbouring nodes alphabetically 
      Map<String, Integer> neighboringNode = weightedGraph.get(node);
      List<String> neighborNodes = new ArrayList<String>(neighboringNode.keySet());
      Collections.sort(neighborNodes);

      // Print the neighboringNode and their weights
      for (String neighbor : neighborNodes) {
        System.out.print(neighbor + " (" + neighboringNode.get(neighbor) + ") ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    WeightedGraph wg1 = new WeightedGraph();
    wg1.addWeightedEdge("A", "B",4);
    wg1.printWeightedGraph();
  }

}