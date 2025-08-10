public class Employee {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private boolean deleted = false;

    // Getters and Setters
}
