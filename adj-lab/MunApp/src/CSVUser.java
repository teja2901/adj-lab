import com.opencsv.bean.CsvBindByName;

public class CSVUser {
	
	@CsvBindByName
	String category;
	@CsvBindByName
	String year;
	@CsvBindByName
	String  exp;
	@CsvBindByName
	String rev;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getRev() {
		return rev;
	}
	public void setRev(String rev) {
		this.rev = rev;
	}
		
	
}