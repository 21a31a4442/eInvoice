package pvs.admin.country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_country")
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "country")
	private String countryName;
	
	@Column(name = "code")
	private String countryCode;
	
	@Column(name = "currency")
	private String countryCurrency;
	
	public CountryEntity() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String country) {
		this.countryName = country.substring(0, 1).toUpperCase()+country.substring(1).toLowerCase();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String code) {
		this.countryCode = code.toUpperCase();
	}

	public String getCountryCurrency() {
		return countryCurrency;
	}

	public void setCountryCurrency(String currency) {
		this.countryCurrency = currency.toUpperCase();
	}
	
}
