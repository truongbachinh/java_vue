package server.jwt.lhtp.dto;

public class ProductDTO {

    private int id;
    private String ctgName;
    private String ctgDescription;
    private String ctgImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCtgName() {
        return ctgName;
    }

    public void setCtgName(String ctgName) {
        this.ctgName = ctgName;
    }

    public String getCtgDescription() {
        return ctgDescription;
    }

    public void setCtgDescription(String ctgDescription) {
        this.ctgDescription = ctgDescription;
    }

    public String getCtgImage() {
        return ctgImage;
    }

    public void setCtgImage(String ctgImage) {
        this.ctgImage = ctgImage;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", ctgName='" + ctgName + '\'' +
                ", ctgDescription='" + ctgDescription + '\'' +
                ", ctgImage='" + ctgImage + '\'' +
                '}';
    }
}
