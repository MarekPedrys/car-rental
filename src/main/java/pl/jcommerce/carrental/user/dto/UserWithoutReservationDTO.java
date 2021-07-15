package pl.jcommerce.carrental.user.dto;

public class UserWithoutReservationDTO {

    private Long id;
    private String username;
    private String email;

    public UserWithoutReservationDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
