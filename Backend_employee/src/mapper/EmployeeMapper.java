@Component
public class EmployeeMapper {
    public EmployeeDTO toDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment());
        dto.setEmail(employee.getEmail());
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setEmail(dto.getEmail());
        return emp;
    }
}
