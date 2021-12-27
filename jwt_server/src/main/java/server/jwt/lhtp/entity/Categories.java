package server.jwt.lhtp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(max = 125)
    private String ctgName;

    @NotBlank
    @Size(max = 256)
    private String ctgDescription;

    @NotBlank
    @Size(max = 256)
    private String ctgImage;

    @OneToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Collection<Products> products;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date create_time;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


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

    public Collection<Products> getProducts() {
        return products;
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }
}
