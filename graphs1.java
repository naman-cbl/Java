// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;



class HelloWorld {
    static class Edge{
    int src;
    int nbr;
    int wt;
    Edge(int src, int nbr, int wt){
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
        }
    }
    
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int des,String ans, boolean[] visited){
        
        if(src==des){
            System.out.println(ans);
            return;
        }
        visited[src] = true;
        
        for(Edge e: graph[src]){
            if(!visited[e.nbr]){
                printAllPath(graph,e.nbr,des,ans+e.nbr,visited);
            }
        }
        visited[src] = false;
        return;
    }

    public static boolean checkPath(ArrayList<Edge>[] graph, int src, int des, boolean[] visited){
        if(src==des){
            return true;
        }
        visited[src] = true;
        
        for(Edge e: graph[src]){
            if(!visited[e.nbr]){
                if(checkPath(graph,e.nbr,des,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = 7;
        
        ArrayList<Edge>[] graph = new ArrayList[v];
        
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0,1,3));
        graph[1].add(new Edge(1,0,3));
        
        graph[0].add(new Edge(0,2,6));
        graph[2].add(new Edge(2,0,6));
        
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,2,1));
        
        graph[1].add(new Edge(1,3,4));
        graph[3].add(new Edge(3,1,4));
        
        graph[1].add(new Edge(1,4,5));
        graph[4].add(new Edge(4,1,5));
        
        graph[4].add(new Edge(4,5,5));
        graph[5].add(new Edge(5,4,5));
        
        graph[5].add(new Edge(5,6,6));
        graph[6].add(new Edge(6,5,6));
        
        graph[4].add(new Edge(4,6,1));
        graph[6].add(new Edge(6,4,1));
        
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            visited[i] = false;
        }
        
        // boolean result = checkPath(graph,2,4,visited);
        // System.out.println(result);
        printAllPath(graph,0,6,"0",visited);
       
    }
}