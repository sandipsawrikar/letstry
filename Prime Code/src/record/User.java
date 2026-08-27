package record;

import java.util.List;

public record User(String name, List<String> roles) {
    public User {
        // Creates an unmodifiable copy of the passed list
        roles = List.copyOf(roles);
    }
}