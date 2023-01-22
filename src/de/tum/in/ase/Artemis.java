package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Artemis {

    private UserManager userManager;
    private CourseManager courseManager;

    public void setUserManager(@NonNull UserManager userManager) {
        this.userManager = userManager;
    }

    public void setCourseManager(@NonNull CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public @NonNull UserManager getUserManager() {
        return userManager;
    }

    public @NonNull CourseManager getCourseManager() {
        return courseManager;
    }

    public static void main(String[] args) {
        // You can test your code here
        User u = new User("metehan", "student");
        User u0 = new User("mary", "student");
        User u1 = new User("astrid", "student");
        User u2 = new User("ingrid", "student");
        User u3 = new User("irmi", "student");

        /*String s = "{\n"+
                "    \"name\": \"Maria Mustermann\",\n" +
                "    \"role\": \"admin\",\n" +
                "    \"profileDescription\": \"Hi, my name is Maria!\"\n" +
                "}";*/

        UserManager uM = new UserManager();

        uM.getUsers().add(u);
        uM.getUsers().add(u0);
        uM.getUsers().add(u1);
        uM.getUsers().add(u2);
        uM.getUsers().add(u3);

        //uM.serializeUsers();
        //uM.loadUsers(s);

    }

}
