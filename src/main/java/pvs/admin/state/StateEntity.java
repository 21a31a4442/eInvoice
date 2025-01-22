package pvs.admin.state;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pvs.admin.country.CountryEntity;

@Entity(name = "tbl_state")
public class StateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "state")
	private String stateName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country",referencedColumnName = "id")
//	@Column(name = "country")
	private CountryEntity country;
	
	
	public StateEntity() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String state) {
		this.stateName = state.substring(0,1).toUpperCase()+state.substring(1).toLowerCase();
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
	
	
}
