// service/EmployeeService.java
public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO dto);
    EmployeeDTO get(Long id);
    List<EmployeeDTO> getAll(Optional<String> department);
    EmployeeDTO update(Long id, EmployeeDTO dto);
    void softDelete(Long id);
}
