// service/EmployeeServiceImpl.java
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired private EmployeeRepository repository;
    @Autowired private EmployeeMapper mapper;

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee employee = mapper.toEntity(dto);
        Employee saved = repository.save(employee);
        return mapper.toDto(saved);
    }

    @Override
    public EmployeeDTO get(Long id) {
        Employee emp = repository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
        return mapper.toDto(emp);
    }

    @Override
    public List<EmployeeDTO> getAll(Optional<String> department) {
        return repository.findAll().stream()
            .filter(emp -> !emp.isDeleted())
            .filter(emp -> department.map(d -> d.equalsIgnoreCase(emp.getDepartment())).orElse(true))
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existing = repository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
        existing.setName(dto.getName());
        existing.setDepartment(dto.getDepartment());
        existing.setEmail(dto.getEmail());
        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void softDelete(Long id) {
        Employee emp = repository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
        emp.setDeleted(true);
        repository.save(emp);
    }
}
