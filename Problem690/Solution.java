/**
 * @author tgorthi
 * @since Jun 2020
 */

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution
{
    public int getImportance(List<Employee> employees, int id)
    {
        return _getImportance(employees.stream().collect(Collectors.toMap((Employee e) -> e.id, Function.identity()))
                , id);
    }

    private int _getImportance(Map<Integer, Employee> employeeById, int id)
    {
        return employeeById.get(id).importance + employeeById.get(id).subordinates.stream().mapToInt(subId -> _getImportance(employeeById, subId)).sum();
    }

    class Employee
    {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}