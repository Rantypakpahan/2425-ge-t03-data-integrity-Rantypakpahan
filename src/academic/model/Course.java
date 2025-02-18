package academic.model;

/**
 * @author 12S23008 Ranty Insen Pakpahan
 * @author 12S23048 Grace Caldera Situmorang
 */
public class Course {

   private String code;
   private String courseName;
   private int kredit;
   private String grade;

   public Course(String code, String courseName, int kredit, String grade) {
       this.code = code;
       this.courseName = courseName;
       this.kredit = kredit;
       this.grade = grade;
   }

   public String getCode() {
       return code;
   }

   public void setCode(String code) {
       this.code = code;
   }

   public String getCourseName() {
       return courseName;
   }

   public void setCourseName(String courseName) {
       this.courseName = courseName;
   }

   public int getKredit() {
       return kredit;
   }

   public void setKredit(int kredit) {
       this.kredit = kredit;
   }

   public String getGrade() {
       return grade;
   }

   public void setGrade(String grade) {
       this.grade = grade;
   }

   @Override
   public String toString() {
       return code + "|" + courseName + "|" + kredit + "|" + grade;
   }
}
