package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

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
        Artemis artemis = new Artemis();

        UserManager uM = new UserManager();
        CourseManager cM = new CourseManager(artemis);

        artemis.setUserManager(uM);
        artemis.setCourseManager(cM);

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

        uM.getUsers().add(u);
        uM.getUsers().add(u0);
        uM.getUsers().add(u1);
        uM.getUsers().add(u2);
        uM.getUsers().add(u3);

        uM.serializeUsers();
        //uM.loadUsers(s);

        List<User> participants = new ArrayList<>();
        participants.add(u);
        participants.add(u0);
        participants.add(u1);
        participants.add(u2);

        List<User> participants0 = new ArrayList<>();
        participants0.add(u1);
        participants0.add(u2);

        List<User> participants1 = new ArrayList<>();
        participants1.add(u);
        participants1.add(u2);
        participants1.add(u3);

        Course c0 = new Course("ITP", CourseAccess.PRIVATE, participants,"description 0.0");
        Course c1 = new Course("ILA", CourseAccess.PUBLIC, participants0,"description 0.1");
        Course c2 = new Course("IFA", CourseAccess.RESTRICTED, participants1,"description 0.2");
        Course c3 = new Course("INA", CourseAccess.PUBLIC, participants0,"description 0.3");
        Course c4 = new Course("RED", CourseAccess.PRIVATE, participants,"description 0.4");
        Course c5 = new Course("YELLOW", CourseAccess.RESTRICTED, participants1,"description 0.5");

        cM.getCourses().add(c0);
        cM.getCourses().add(c1);
        cM.getCourses().add(c2);
        cM.getCourses().add(c3);
        cM.getCourses().add(c4);
        cM.getCourses().add(c5);

        cM.serializeCourses();

    }

}
