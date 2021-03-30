package students;

public class Student {

    StudyJava studyJava;

    public void setStudyJava(StudyJava studyJava) {
        this.studyJava = studyJava;
    }

    public void doIt(double talent, int time) {
        studyJava.timeStudy(talent, time);
    }
}
