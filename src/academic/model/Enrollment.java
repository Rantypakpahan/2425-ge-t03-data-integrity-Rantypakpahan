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
    private String status;

    public Enrollment(String nim, String kodeMatkul, String tahunAjaran, String semester, String status) {
        this.nim = nim;
        this.kodeMatkul = kodeMatkul;
        this.tahunAjaran = tahunAjaran;
        this.semester = semester;
        this.status = status;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }
 
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nim + "|" + kodeMatkul + "|" + tahunAjaran + "|" + semester + "|" + status;
    }
}
