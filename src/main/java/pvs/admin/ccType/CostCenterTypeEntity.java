package pvs.admin.ccType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_costcentertype")
public class CostCenterTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cc_type")
	private String ccType;
	
	public CostCenterTypeEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCc_type() {
		return ccType;
	}

	public void setCc_type(String cc_type) {
		this.ccType = cc_type.substring(0,1).toUpperCase()+cc_type.substring(1).toLowerCase();
	}
	
	
	
}
