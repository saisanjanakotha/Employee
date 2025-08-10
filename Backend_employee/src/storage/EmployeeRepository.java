// storage/EmployeeRepository.java
@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idGenerator.incrementAndGet());
        }
        storage.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Employee> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(Long id) {
        storage.remove(id);
    }
}
