package response;

public class UserResponse {
    private String username;
    private String role;
    private boolean isActive;
    private String token;

    public UserResponse() {
    }

    public UserResponse(String username, String role, boolean isActive, String token) {
        this.username = username;
        this.role = role;
        this.isActive = isActive;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}