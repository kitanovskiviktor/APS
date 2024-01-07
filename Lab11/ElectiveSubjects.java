package Lab11;

/*
On one university there are mandatory and elective subjects. For each subject you are given, a list of subjects that need to be passed in order to be
eligible for that subject is given. Find the next available subject for you, if you know what is the last subject that you have passed.

Input: In the first line you are given a single integer N representing the number of elements. In the following N lines you are given the IDs of the subjects.
In the following line you are given a single integer M representing the number of dependences between the subjects. In the following M lines you are given a
list of IDs separated with a single white space. Starting from the second ID to the last ID you have the subjects that you need to pass in order to be able to
take the subjected defined with the first ID in this line. In the last line you are given the last subject that you have passed.

Output: The output should contain a single ID representing the next available subject.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;

class Graph<E> {

    int num_nodes;
    GraphNode<E> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes, E[] list) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, list[i]);
    }

    @SuppressWarnings("unchecked")
    public Graph(int num_nodes) {
        this.num_nodes = num_nodes;
        adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
        for (int i = 0; i < num_nodes; i++)
            adjList[i] = new GraphNode<E>(i, null);
    }

    int adjacent(int x, int y) {

        return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
    }

    void addEdge(int x, int y) {
        if (!adjList[x].containsNeighbor(adjList[y])) {
            adjList[x].addNeighbor(adjList[y]);
        }
    }

    void deleteEdge(int x, int y) {
        adjList[x].removeNeighbor(adjList[y]);
    }

    public int findIndex(String element){

        for(int i = 0; i < adjList.length; i++){
            if(adjList[i].getInfo().equals(element)){
                return i;
            }
        }
        return -1;

    }

    public void addEdgeUpdated(String line){

        String pom[] = line.split(" ");

        int host = findIndex(pom[0]);
        for(int i = 1; i < pom.length; i++){
            int neigh = findIndex(pom[i]);
            if(host != -1 && neigh != -1){
                this.addEdge(host,neigh);
            }
            else{
                System.out.println("Ne moze da go najde hostot");
            }
        }



    }


    void dfsVisit(Stack<Integer> s, int i, boolean[] visited){
        if(!visited[i]){
            visited[i] = true;

            Iterator<GraphNode<E>> it = adjList[i].getNeighbors().iterator();
            while(it.hasNext()){
                dfsVisit(s, it.next().getIndex(), visited);
            }
            s.push(i);
        }
    }

    void topological_sort_dfs(String find){
        boolean visited[] = new boolean[num_nodes];
        for(int i=0;i<num_nodes;i++){
            visited[i] = false;
        }

        Stack<Integer> s = new Stack<Integer>();

        boolean flag = false;
        for(int i=0;i<num_nodes;i++){
            dfsVisit(s,i,visited);
        }

        Stack<Integer> ns = new Stack<Integer>();
        while(!s.isEmpty()){
            ns.push(s.pop());
        }

        while(!ns.isEmpty()){
            GraphNode<E> prev = adjList[ns.pop()];
            if(prev.getInfo().equals(find)){
                System.out.println(adjList[ns.pop()].getInfo());
            }
        }
    }

    @Override
    public String toString() {
        String ret = new String();
        for (int i = 0; i < this.num_nodes; i++)
            ret += i + ": " + adjList[i] + "\n";
        return ret;
    }

}


class GraphNode<E> {
    private int index;
    private E info;
    private LinkedList<GraphNode<E>> neighbors;

    public GraphNode(int index, E info) {
        this.index = index;
        this.info = info;
        neighbors = new LinkedList<GraphNode<E>>();
    }

    boolean containsNeighbor(GraphNode<E> o){
        return neighbors.contains(o);
    }

    void addNeighbor(GraphNode<E> o){
        neighbors.add(o);
    }


    void removeNeighbor(GraphNode<E> o){
        if(neighbors.contains(o))
            neighbors.remove(o);
    }


    @Override
    public String toString() {
        String ret= "INFO:"+info+" SOSEDI:";
        for(int i=0;i<neighbors.size();i++)
            ret+=neighbors.get(i).info+" ";
        return ret;

    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        GraphNode<E> pom = (GraphNode<E>)obj;
        return (pom.info.equals(this.info));
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public LinkedList<GraphNode<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
        this.neighbors = neighbors;
    }
}

public class ElectiveSubjects {


    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(input.readLine());

        Graph<String> graph = new Graph<>(number);

        for(int i=0; i<number; i++) {
            String inputLine = input.readLine();
            graph.adjList[i].setInfo(inputLine);
        }

        int numberOfDependences = Integer.parseInt(input.readLine());

        for(int i=0; i<numberOfDependences; i++) {
            String inputLine = input.readLine();
            graph.addEdgeUpdated(inputLine);
        }

        String nextElectiveSubject = input.readLine();
        graph.topological_sort_dfs(nextElectiveSubject);

    }
}
