import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Code_690 {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Employee e = null;
        HashMap<Integer, Employee> employeeMap = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
            if (employee.id == id) {
                e = employee;
            }
        }

        if (e != null) {
            int importance = e.importance;
            LinkedList<Integer> subs = new LinkedList<>();
            subs.addAll(e.subordinates);
            while (!subs.isEmpty()) {
                Integer eid = subs.removeFirst();
                Employee sub = employeeMap.get(eid);
                importance += sub.importance;
                if (sub.subordinates != null && sub.subordinates.size() > 0) {
                    subs.addAll(sub.subordinates);
                }
            }
            return importance;
        }
        return 0;
    }
}
