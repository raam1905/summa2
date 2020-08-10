package smallPrograms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

class TransactionInfo {
	String transactionId;
	String acctId;
	LocalDate postedDate;
	Double amount;

	TransactionInfo(String[] fieldData) {
		setTransactionId(fieldData[0]);
		setAcctId(fieldData[1]);
		setPostedDate(fieldData[2]);
		setAmount(Double.parseDouble(fieldData[3]));
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		this.postedDate = LocalDate.parse(postedDate, dt);
		;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}

public class Sumaoruclass {

	/*public static void firstRepeatingCharacter(List<String> inputList) {
		List<Character> result = new ArrayList<>();

		inputList.stream().forEach((s) -> {
			for (int i = 0; i < s.length(); i++) {
				Character c = s.charAt(i);

				if (s.indexOf(c) != s.lastIndexOf(c)) {
					result.add(c);
					break;
				}
			}
		});
		System.out.println(result);
	}
*/
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void reconcileData() {
		Path xPath = Paths.get("c://temp/X.txt");
		Path yPath = Paths.get("c://temp/Y.txt");
		List<String> xList = new ArrayList<>();
		List<String> yList = new ArrayList<>();
		
		List<TransactionInfo> xTranList = new ArrayList<>();
		List<TransactionInfo> yTranList = new ArrayList<>();
		
		List<String> exactMatch = new ArrayList<>();
		List<String> weakMatch = new ArrayList<>();

		String xbreak;
		String ybreak;
		try {
			xList = Files.readAllLines(xPath);
			yList = Files.readAllLines(yPath);

			int xIndex = 0;
			int yIndex = 0;
			int tempYIndexFlag = -1;
			
			for (int i = 0; i < xList.size(); i++) {
				TransactionInfo tran = new TransactionInfo(xList.get(i).split("; "));
				xTranList.add(tran);

				tran = new TransactionInfo(yList.get(i).split("; "));
				yTranList.add(tran);
			}
			
			
			while (xIndex < xList.size() && yIndex < yList.size()) {
				String[] xRecord = xList.get(xIndex).split("; ");
				String[] yRecord = yList.get(yIndex).split("; ");

				DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
				LocalDate xDate = LocalDate.parse(xRecord[2], dt);
				LocalDate yDate = LocalDate.parse(yRecord[2], dt);

				int daysDifference = Math.abs(Period.between(xDate, yDate).getDays());
				String amountDifference = df2
						.format(Math.abs(Float.parseFloat(xRecord[3]) - Float.parseFloat(yRecord[3])));
				if (daysDifference == 4 && xDate.getDayOfWeek() == DayOfWeek.FRIDAY
						&& yDate.getDayOfWeek() == DayOfWeek.MONDAY) {
					daysDifference = 1;
				}
				if (xRecord[1].equals(yRecord[1]) && daysDifference <= 1
						&& (amountDifference.equals("0") || amountDifference.equals("0.01"))) {
					if (daysDifference == 0 && xRecord[3].equals(yRecord[3])) {
						exactMatch.add(xRecord[0] + yRecord[0]);
						xList.set(xIndex, null);
						yList.set(yIndex, null);
						xIndex++;
						yIndex++;
					} else /*if (daysDifference == 1 || (amountDifference.equals("0.01"))) */{
						weakMatch.add(xRecord[0] + yRecord[0]);
						xList.set(xIndex, null);
						yList.set(yIndex, null);
						xIndex++;
						yIndex++;
					} /*else {
						if (yList.get(yIndex).indexOf(xRecord[1]) == -1) {
							if (tempYIndexFlag == -1)
								tempYIndexFlag = yIndex;
							yIndex++;
						} else {
							yIndex = tempYIndexFlag;
							tempYIndexFlag = -1;
							xIndex++;
						}
					}*/

				} else {
					if (yList.get(yIndex).indexOf(xRecord[1]) != -1) {
						if (tempYIndexFlag == -1)
							tempYIndexFlag = yIndex;
						yIndex++;
					} else {
						yIndex = tempYIndexFlag;
						tempYIndexFlag = -1;
						xIndex++;
					}
					//xIndex++;
				}

				System.out.println("");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(xList.size());
	}

	public static void main(String args[]) {
		/*
		 * distinctsubstrings("aabc",2); distinctsubstrings("aab",2);
		 * distinctsubstrings("abc",1); distinctsubstrings("aaabbbcc",2);
		 */
		/*
		 * List<String> input = new ArrayList<>(); input.add("array");
		 * input.add("apple"); input.add("rat");
		 * 
		 * 
		 * firstRepeatingCharacter(input);
		 */
		reconcileData();
	}

	public static void distinctsubstrings(String str, int length) {
		Set<String> result = new HashSet<>();
		/*
		 * for(int i=0;i<str.length()-1;i++){ for(int j=i+1;j<str.length();j++){
		 * result.add(str.charAt(i)+""+str.charAt(j)); } }
		 */
		for (int i = 0; i < str.length(); i++) {
			if (i + length > str.length())
				break;
			result.add(str.substring(i, i + length));
		}
		System.out.println(result);
	}
}
