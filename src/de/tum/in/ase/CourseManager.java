package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private @NonNull final Artemis artemis;
    private @NonNull List<Course> courses;

    public CourseManager(@NonNull Artemis artemis) {
        this.artemis = artemis;
        this.courses = new ArrayList<>();
    }

    /**
     * Loads courses from the passed Json data
     * @param json The Json data to parse
     */
    public void loadCourses(@NonNull String json) {
        // TODO: Task 3.3: implement loadCourses()
        courses.clear();

        JSONArray courseData = new JSONArray(json);

        int n = courseData.length();

        for (int i = 0; i < n; ++i) {
            JSONObject obj = courseData.getJSONObject(i);

            CourseAccess courseAccess = obj.getEnum(CourseAccess.class,"access");
            JSONArray participantArray = obj.getJSONArray("participantNames");

            UserManager userManager = artemis.getUserManager();
            List<User> userList = participantArray.toList().stream().map(user -> userManager.getUserByName(user.toString()).orElse(null)).toList();

            Course exampleCourse = new Course(obj.getString("name"), courseAccess, userList, obj.getString("description"));

            courses.add(exampleCourse);
        }
    }

    /**
     * Serializes the courses to Json
     * @return The course list represented in Json format
     */
    public @NonNull String serializeCourses() {
        // TODO: Task 3.3: implement serializeCourses()
        JSONArray jArray = new JSONArray();

        for (Course course : courses) {
            JSONObject jsonObj = new JSONObject();

            jsonObj.put("name", course.getName());
            jsonObj.put("access", course.getCourseAccess());
            jsonObj.put("description", course.getDescription());

            JSONArray pArray = new JSONArray();
            pArray.put(course.getParticipants());
            jsonObj.put("participantNames", pArray);

            jArray.put(jsonObj);
        }

        return jArray.toString();
    }

    public @NonNull List<Course> getCourses() {
        return courses;
    }

    public void setCourses(@NonNull List<Course> courses) {
        this.courses = courses;
    }
}
