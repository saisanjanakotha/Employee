// controller/EmployeeController.java
@RestController
@RequestMapping("/api/employees")
@Validated
@Tag(name = "Employee API", description = "Operations related to Employees")
public class EmployeeController {
    @Autowired private EmployeeService service;

    @PostMapping
    @Operation(summary = "Create employee")
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID")
    public ResponseEntity<EmployeeDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    @Operation(summary = "Get all employees (filter by department)")
    public List<EmployeeDTO> getAll(@RequestParam Optional<String> department) {
        return service.getAll(department);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update employee")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Soft delete employee")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
