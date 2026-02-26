class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (String s : bank) set.add(s);

        if (!set.contains(endGene)) return -1;

        char[] genes = {'A','C','G','T'};
        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endGene)) return dist;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];

                    for (char g : genes) {
                        if (g == old) continue;

                        arr[j] = g;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            dist++;
        }
        return -1;
    }
}