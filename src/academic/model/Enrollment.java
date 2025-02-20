package academic.model;

/**
 * @author 12S23008 Ranty Insen Pakpahan
 * @author 12S23048 Grace Caldera Situmorang
 */
public class Enrollment {
    private String nim;
    private String kodeMatkul;
    private String tahunAjaran;
    private String semester;
    private String status = "None";

    public Enrollment(String kodeMatkul, String nim, String tahunAjaran, String semester) {
        this.nim = nim;
        this.kodeMatkul = kodeMatkul;
        this.tahunAjaran = tahunAjaran;
        this.semester = semester;
    }

    public String getNim() {
        return nim;
    }


    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }
 
    public String getSemester() {
        return semester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return kodeMatkul + "|" + nim + "|" + tahunAjaran + "|" + semester + "|" + status;
    }
}
