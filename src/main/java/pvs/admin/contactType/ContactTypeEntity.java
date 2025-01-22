package pvs.admin.contactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pvs.admin.status.StatusEntity;

@Entity(name = "tbl_contacttype")
public class ContactTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", referencedColumnName = "id") // Assuming 'status' stores the status_id
	private StatusEntity status;

	public ContactTypeEntity() {

	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

//	public Integer getStatus() {
//		return status;
//	}

//	public void setStatus(Integer status) {
//		this.status = status;
//	}

}
