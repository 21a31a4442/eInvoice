package pvs.admin.city;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pvs.admin.country.CountryEntity;
import pvs.admin.state.StateEntity;

@Entity(name = "tbl_city")
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "city")
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state",referencedColumnName = "id")
//	@Column(name = "state")
	private StateEntity state;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country",referencedColumnName = "id")
//	@Column(name = "country")
	private CountryEntity country;
	
	
	public CityEntity() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String city) {
		this.cityName = city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
	
	
}
