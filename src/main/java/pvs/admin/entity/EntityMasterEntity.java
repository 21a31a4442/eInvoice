package pvs.admin.entity;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pvs.admin.city.CityEntity;
import pvs.admin.country.CountryEntity;
import pvs.admin.state.StateEntity;
import pvs.admin.status.StatusEntity;

@Entity
@Table(name = "tbl_entity")
public class EntityMasterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "entity_name")
	private String entityName;
	
	@Column(name = "entity_code")
	private String entityCode;
	
	@Column(name = "cin")
	private String cin;
	
	@Column(name = "incorp_date")
	private LocalDate incorpDate;
	
	@Column(name = "gst_no")
	private String gstNo;
	
	@Column(name = "add1")
	private String address1;
	
	@Column(name = "add2")
	private String address2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country",referencedColumnName = "id")
	private CountryEntity country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state",referencedColumnName = "id")
	private StateEntity state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city",referencedColumnName = "id")
	private CityEntity city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status",referencedColumnName = "id")
	private StatusEntity status;
	
	@Column(name = "pincode")
	private Integer pincode;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "primary_contact",referencedColumnName = "id");
//	private ContactEntity primaryContact;
	
	public EntityMasterEntity() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public LocalDate getIncorpDate() {
		return incorpDate;
	}

	public void setIncorpDate(LocalDate incorpDate) {
		this.incorpDate = incorpDate;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	
	
}
