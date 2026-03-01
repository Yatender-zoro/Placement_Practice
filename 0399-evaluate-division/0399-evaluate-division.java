class Solution {

    class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    HashMap<String, List<Edge>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> eqn, double[] values, List<List<String>> q) {
        

        // yeh graph ka que hai isme hume a/b = 2 de rakha hai matlab a - b -> 2
        //jab hume a/c nikalna hoga tab hum a/b * b/c karenge usse humare paas a/c aa jayaga 
        // grpah representation hoga a-b-c> 2 * 3 = 6
        
        for (int i = 0; i < values.length; i++) {
            String a = eqn.get(i).get(0);
            String b = eqn.get(i).get(1);
            double val = values[i];

            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());

            map.get(a).add(new Edge(b, val));
            map.get(b).add(new Edge(a, 1.0 / val));
        }

        double[] ans = new double[q.size()];

        for (int i = 0; i < q.size(); i++) {
            String src = q.get(i).get(0);
            String dest = q.get(i).get(1);

            if (!map.containsKey(src) || !map.containsKey(dest)) {
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(src, dest, 1.0, new HashSet<>());
            }
        }

        return ans;
    }

    double dfs(String src, String dest, double curr, HashSet<String> vis) {

        if (src.equals(dest)) return curr;

        vis.add(src);

        for (Edge e : map.get(src)) {
            if (!vis.contains(e.node)) {
                double res = dfs(e.node, dest, curr * e.weight, vis);
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}



