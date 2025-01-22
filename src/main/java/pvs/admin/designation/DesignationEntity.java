package pvs.admin.designation;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pvs.admin.status.StatusEntity;

@Entity(name = "tbl_designation")
public class DesignationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String desnName;
	
	@Column(name = "code")
	private String desnCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", referencedColumnName = "id")
//	@Column(name = "status")
	private StatusEntity status;
	
	@CreationTimestamp
	@Column(name = "created_datetime",updatable = false)
	private LocalDateTime created_timestamp;
	
	@UpdateTimestamp
	@Column(name = "last_updatedDatetime",updatable = true)
	private LocalDateTime updated_timestamp;
	
	public DesignationEntity() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesnName() {
		return desnName;
	}

	public void setDesnName(String desn_name) {
		this.desnName = desn_name.substring(0,1).toUpperCase()+desn_name.substring(1);
	}

	public String getDesnCode() {
		return desnCode;
	}

	public void setDesnCode(String desn_code) {
		this.desnCode = desn_code.toUpperCase();
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public LocalDateTime getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(LocalDateTime created_timestamp) {
		this.created_timestamp = created_timestamp;
	}

	public LocalDateTime getUpdated_timestamp() {
		return updated_timestamp;
	}

	public void setUpdated_timestamp(LocalDateTime updated_timestamp) {
		this.updated_timestamp = updated_timestamp;
	}
	
	
	
}


