package pe.ggonzales.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
    
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
    
    
}
