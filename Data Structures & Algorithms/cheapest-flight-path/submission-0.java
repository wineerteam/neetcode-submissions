class Solution {

    public static class Edge{
        int src;
        int dest;
        int wt;
                      Edge(int s, int d, int w){
                        this.src=s;
                        this.dest=d;
                        this.wt=w;
                      }
    }
   public static class Info{
        int v;
        int cost;
        int stops;
        Info( int v, int c, int s){
            this.v=v;
            this.cost=c;
            this.stops=s;
        }
    }

    static  void createGraph(int [][] flights, ArrayList<Edge>[] graph, int src){

        for( int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        for( int i=0; i<flights.length; i++){
            int s=flights[i][0];
            int d=flights[i][1];
            int w =flights[i][2];
            
            Edge e=new Edge(s,d,w);
            graph[s].add(e);
                    }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<Edge> [] graph=new ArrayList[n];

            // create graph
            createGraph(flights,graph,src);
        // store the cost 
        int [] dist=new int [n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        // crate queue for the find neighour 
        Queue<Info> q=new LinkedList<>();

        q.add(new Info(src,0,0));

        while( !q.isEmpty()){

            Info curr=q.remove();
            
            // handle edge caseses

            if( curr.stops > k){
               continue;
            }

            // explore edge 

            for( int i=0; i<graph[curr.v].size(); i++){
                Edge e =graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int w=e.wt;

                /// apply midifed algo with condtions 
                if( dist[u] != Integer.MAX_VALUE && curr.cost+ w < dist[v] && curr.stops <= k){
                    dist[v] =curr.cost+w;
                    q.add(new Info(v,dist[v], curr.stops+1));
                } 
            }
        }

         if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        
         }
         else{
            return dist[dest];
         }



    }
}