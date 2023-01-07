/*
 * CSDS 233 Assignment 6 
 * Author: Atreya Sridharan (axs2220)
 * Resources Used: Lecture Slides, Java Oracle Documentation 
 * Collaboraters: I want to thank my TA's for answering my doubts along with Timothy Cronin for helping me with the ideas
 */
import java.util.*;
class Graph{
    /**
     * Using a HashMap in order to store vertexs for the graph
     * It is easier to get vertexs from the map, as they are stored as different hashes
     */
    private Map<String, List<String>> mainGraph = new HashMap<String, List<String>>();

    /* 
    * Method to add Nodes to graph if there are no duplicates.
    * Method returns false is vertex already exsists
    */ 
   public boolean addNode(String name) {
        if (mainGraph.containsKey(name)) {
            return false;
        }
        mainGraph.put(name, new ArrayList<String>());
        return true;
    }

    /**
     * Method to add a list of vertexs to the graph, provided there are no duplicates
     */
   public boolean addNodes(String[] names) {
        boolean check = true;
        for (String name : names) {
            check = check & addNode(name);
        }
        return check;
    }

    /*
     * Method to add edges from one vertex to another
     * returns false is edge already exists
     */
   public boolean addEdge(String from, String to) {
        if (!mainGraph.containsKey(from) || !mainGraph.containsKey(to)){
            return false;
        }

        if (mainGraph.get(from).contains(to)){
            return false;
        }
        mainGraph.get(from).add(to);  mainGraph.get(to).add(from);
        return true;
    }

    /*
     * Adding a list of undirected edge from vertex to another in toList
     */
   public boolean addEdges(String from, String[] toList) {
        boolean check = true;
        for (String to : toList){
            check = check & addEdge(from, to);
        }
        return check;
    }

    /**
     * Removed vertexs from graph, provided vertex exsists
     * If vertex exists, edges connected to vertex will be removed
     */
   public boolean removeNode(String name) {
        if (!mainGraph.containsKey(name)){
            return false; 
        }
        for (String vertex : mainGraph.keySet()) {
            mainGraph.get(vertex).remove(name);
        }
        mainGraph.remove(name);
        return true;
    }

    /*
     * Removing vertexs from vertexList and their existing edges
     */
   public boolean removeNodes(String[] vertexList) {
        boolean check = true;
        for (String vertex : vertexList){
            check = check & removeNode(vertex);
        }
        return check;
    }

    /*
     * Method to print graph
     */
   public void printGraph() {
        // Sorting the vertexs alphabetically
        List<String> vertexs = new ArrayList<String>(mainGraph.keySet());
        Collections.sort(vertexs);

        for (String vertex : vertexs) {
            System.out.print(vertex + ": ");
            // Sort the neighboringNode of the node alphabetically
            List<String> neighboringNode = mainGraph.get(vertex);
            Collections.sort(neighboringNode);
            for (String neighbor : neighboringNode) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

    }
    /*
     * Implementation of DFS 
     */
    public String[] DFS(String from, String to, String neighborOrder) {
       
        if (!mainGraph.containsKey(from) || !mainGraph.containsKey(to)){
            return new String[0];
        }

        // Initializes the list and stack for DFS
        List<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(from);

        /*
         * HashSet is used to store all vertexVisited vertexs
         * HashSet is used in case a lot of vertexs need to be stored
         */
        Set<String> vertexVisitedNodes = new HashSet<String>();

        while (!stack.isEmpty()) {
            String vertex = stack.pop();

           
            if (vertexVisitedNodes.contains(vertex)){
                continue;
            }
            vertexVisitedNodes.add(vertex);


            list.add(vertex);
        

            
            if (vertex.equals(to)){
                break;
            }
            List<String> neighboringNode = mainGraph.get(vertex);
            if (neighborOrder.equals("alphabetical")) {
                Collections.sort(neighboringNode);
            } 
            else if (neighborOrder.equals("reverse")) {
                Collections.sort(neighboringNode, Collections.reverseOrder());
            }
            for (String neighbor : neighboringNode) {
                stack.push(neighbor);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    /*
     * Implementing BFS using String
     */
    String[] BFS(String from, String to, String neighborOrder) {
        
        if (!mainGraph.containsKey(from) || !mainGraph.containsKey(to)){
            return new String[0];
        }

        // Initializing resultList list and the queue for the BFS traversal
        List<String> resultList = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(from);

        /*
         * HashSet is used to store all vertexVisited vertexs
         * HashSet is used in case a lot of vertexs need to be stored
         */
        Set<String> vertexVisited = new HashSet<String>();

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            // Skip the vertex if it has already been vertexVisited
            if (vertexVisited.contains(vertex)){
                continue;
            }
            vertexVisited.add(vertex);

            resultList.add(vertex);

            if (vertex.equals(to)){
                break;
            }
            
            /*
             * Adding neighboringNode in order of alphabetical or reverse
             * Using Collections to sort the array
             */
            List<String> neighboringNode = mainGraph.get(vertex);
            if (neighborOrder.equals("alphabetical")) {
                Collections.sort(neighboringNode);
            } else if (neighborOrder.equals("reverse")) {
                Collections.sort(neighboringNode, Collections.reverseOrder());
            }
            for (String neighbor : neighboringNode) {
                queue.add(neighbor);
            }
        }

        return resultList.toArray(new String[resultList.size()]);
    }
    /*
     * finding shorted path using Djisktra's
     * Returns an empty array if the vertexs don't exist
     */
    String[] shortestPath(String from, String to) {
        
        if (!mainGraph.containsKey(from) || !mainGraph.containsKey(to))
            return new String[0];

        // Initializing the resultList list and the priority queue in order to implement Djikstra
        final String[] resultList = new String[mainGraph.size()];
        PriorityQueue<String> queue = new PriorityQueue<String>(mainGraph.size(), new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int index1 = 0;
                for (int i = 0; i < resultList.length; i++) {
                    if (resultList[i] != null && resultList[i].equals(a)) {
                        index1 = i;
                        break;
                    }
                }
                int index2 = 0;
                for (int i = 0; i < resultList.length; i++) {
                    if (resultList[i] != null && resultList[i].equals(b)) {
                        index2 = i;
                        break;
                    }
                }
                return index1 - index2;
            }
        });
        queue.add(from);

        /*
         * HashSet is used to store all vertexVisited vertexs
         * HashSet is used in case a lot of vertexs need to be stored
         */
        Set<String> vertexVisited = new HashSet<String>();

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            // Skip the vertex if it has already been vertexVisited
            if (vertexVisited.contains(vertex)){
                continue;
            }
            vertexVisited.add(vertex);

            for (int i = 0; i < resultList.length; i++) {
                if (resultList[i] == null) {
                    resultList[i] = vertex;
                    break;
                }
            }

            if (vertex.equals(to)){
                break;
            }

            // Add the neighboringNode of the vertex to the priority queue
            List<String> neighboringNode = mainGraph.get(vertex);
            for (String neighbor : neighboringNode) {
                queue.add(neighbor);
            }
        }

        // Returns the part of the resultList list that contains the shortest path
        int index = 0;
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] != null && resultList[i].equals(to)) {
                index = i;
                break;
            }
        }
        return Arrays.copyOfRange(resultList, 0, index + 1);
    }

    /*
     * Finding the second shortest path using priority queue
     * Returns empty array if vertexs do not exist
     */
    String[] secondShortestPath(String from, String to) {
        if (!mainGraph.containsKey(from) || !mainGraph.containsKey(to)){
            return new String[0];
        }

        // Initializes the list and the priority queue for Dijkstra's 
        // Similar done to what was done for shortest path
        final String[] resultList = new String[mainGraph.size()];
        PriorityQueue<String> queue = new PriorityQueue<String>(mainGraph.size(), new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int index1 = 0;
                for (int i = 0; i < resultList.length; i++) {
                    if (resultList[i] != null && resultList[i].equals(a)) {
                        index1 = i;
                        break;
                    }
                }
                int index2 = 0;
                for (int i = 0; i < resultList.length; i++) {
                    if (resultList[i] != null && resultList[i].equals(b)) {
                        index2 = i;
                        break;
                    }
                }
                return index1 - index2;
            }
        });
        queue.add(from);

        // Initializing variable to track of which vertexs have been vertexVisited
        Set<String> vertexVisited = new HashSet<String>();

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            // Skip the vertex if it has already been vertexVisited
            if (vertexVisited.contains(vertex))
                continue;
            vertexVisited.add(vertex);

            // Add the vertex to the resultList list
            for (int i = 0; i < resultList.length; i++) {
                if (resultList[i] == null) {
                    resultList[i] = vertex;
                    break;
                }
            }

            // Check if we have reached the target vertex
            if (vertex.equals(to)){
                break;
            }

            // Add the neighboringNode of the vertex to the priority queue
            // Check if we have reached the target vertex
            if (vertex.equals(to)){
                break;
            }

            // Add the neighboringNode of the vertex to the priority queue
            for (String neighbor : mainGraph.get(vertex)) {
                if (!vertexVisited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.addNode("A");
        g1.addNodes(new String[] { "B", "C", "D" });
        g1.addEdges("A", new String[] { "B", "C", "D" });
        System.out.println("Before Removal");
        g1.printGraph();
        System.out.print("After removal");
        g1.removeNode("A");
        g1.printGraph();
        g1.DFS("A", "B", "reverse");
        g1.BFS("A", "B", "reverse");
        g1.shortestPath("A", "B");

    }
}
