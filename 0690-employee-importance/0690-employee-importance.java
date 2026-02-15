/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {


        HashMap<Integer,Employee> map = new HashMap<>();

        for(Employee e: employees){
            map.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        int n = employees.size(); 
        for(int i=0;i<n;i++){
            if(employees.get(i).id == id){
                q.add(employees.get(i).id);
                break;
            }
        }

        int sum = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int e = q.poll();
                Employee data = map.get(e);
                sum+=data.importance;
                for(int x:data.subordinates){
                    q.add(x);
                }
            }
        }

        return sum;
    }
}