package pvs.admin.status;


import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;

@Entity(name = "tbl_status")
public class StatusEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "code")
	private String statusCode;
	
	@Column(name = "status")
	private String statusName;

	@Column(name = "module")
	private String statusModule;
	
	public StatusEntity() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode.toUpperCase();
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName.substring(0,1).toUpperCase()+statusName.substring(1).toLowerCase();
	}

	public String getStatusModule() {
		return statusModule;
	}

	public void setStatusModule(String statusModule) {
		this.statusModule = statusModule.toUpperCase();
	}
	
	
	
}
