package response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private String username;
    private String role;
    private String imageUrl;
    private String nikName;
    private boolean isActive;
    private String token;
}