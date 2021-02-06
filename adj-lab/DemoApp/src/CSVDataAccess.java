import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


public class CSVDataAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader	fileReader = new BufferedReader(new FileReader("./customer.csv"));

			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(fileReader)
					.withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			List<CSVUser> csvUsers = csvToBean.parse();

			for (CSVUser csvUser : csvUsers) {
				System.out.println("Name : " + csvUser.getName());
				System.out.println("Email : " + csvUser.getEmail());
				System.out.println("PhoneNo : " + csvUser.getMobile());
				System.out.println("Country : " + csvUser.getCountry());
				System.out.println("---------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}