package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {

    private @NonNull List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Creates a Json backup containing all users
     *
     * @return The user list represented in Json format
     */
    public @NonNull String serializeUsers() {
        // TODO: Task 2.2: implement serializeUsers()
        JSONArray jArray = new JSONArray();

        for (User user : users) {
            JSONObject jsonObject = new JSONObject();

            if (user.getProfileDescription() != null) {
                jsonObject.put("profileDescription", user.getProfileDescription());
            }

            jsonObject.put("role", user.getRole());
            jsonObject.put("name", user.getName());

            jArray.put(jsonObject);
        }


        return jArray.toString();

    }

    /**
     * Loads users from the passed Json data
     *
     * @param json The Json data to parse
     */
    public void loadUsers(@NonNull String json) {
        // TODO: Task 2.4: implement loadUsers()
    }

    /**
     * Gets the user object to the respective name
     *
     * @param name The users name
     * @return The respective user
     */
    public @NonNull Optional<User> getUserByName(@NonNull String name) {
        return users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst();
    }

    public @NonNull List<User> getUsers() {
        return users;
    }

    public void setUsers(@NonNull List<User> users) {
        this.users = users;
    }
}
