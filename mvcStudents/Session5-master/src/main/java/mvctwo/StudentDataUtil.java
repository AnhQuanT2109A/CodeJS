package mvctwo;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
    public static List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("TH2108003","Nhat Anh", "Nguyen", "nhatanhn36@gmail.com"));
        studentList.add(new Student("TH2109067","Hoang Anh","Do", "hoanganhdo1803@gmail.com"));
        studentList.add(new Student("TH2208002","Hoai Nam", "Nguyen", "hoaiNam8002@gmail.com"));

        return studentList;
    }
}
