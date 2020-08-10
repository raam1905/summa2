package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Event {
	String teamName;
	String empName;
	Integer time;
	String eventCode;
	Integer eventOrder;
	String additionalTime;
	String secEmpName;

	static Integer getEventOrder(String eventCode) {
		if ("G".equals(eventCode))
			return 0;
		if ("Y".equals(eventCode))
			return 1;
		if ("R".equals(eventCode))
			return 2;
		if ("S".equals(eventCode))
			return 3;
		
		return 4;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getAdditionalTime() {
		return additionalTime;
	}

	public void setAdditionalTime(String additionalTime) {
		this.additionalTime = additionalTime;
	}

	public String getSecEmpName() {
		return secEmpName;
	}

	public void setSecEmpName(String secEmpName) {
		this.secEmpName = secEmpName;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public Integer getEventOrder() {
		return eventOrder;
	}

	public void setEventOrder(Integer eventOrder) {
		this.eventOrder = eventOrder;
	}

	@Override
	public String toString() {
		if ("S".equals(eventCode))
			return teamName + " " + empName + " " + time + additionalTime + " " + eventCode + " " + secEmpName;
		else
			return teamName + " " + empName + " " + time + additionalTime + " " + eventCode;
	}

}

public class SortEvents_withClass {

	public static List<Event> convertToListOfEventObjects(String teamName, String[] teamEvents) {
		List<Event> eventsList = new ArrayList<>();
		for (String t : Arrays.asList(teamEvents)) {
			Event eventObj = new Event();
			eventObj.setTeamName(teamName);
			int partition = 0;

			String[] values = t.split(" ");

			for (String s : values) {
				if (Character.isDigit(s.charAt(0))) {
					if (s.contains("+")) {
						eventObj.setTime(Integer.parseInt(s.substring(0, s.indexOf("+"))));
						eventObj.setAdditionalTime(s.substring(s.indexOf("+")));
					} else {
						eventObj.setTime(Integer.parseInt(s));
						eventObj.setAdditionalTime("");
					}
					partition = 1;

				} else {
					if (partition == 0) {
						if (eventObj.getEmpName() == null)
							eventObj.setEmpName(s);
						else
							eventObj.setEmpName(eventObj.getEmpName() + " " + s);
					} else if (partition == 1) {
						partition++;
						eventObj.setEventCode(s);
						eventObj.setEventOrder(Event.getEventOrder(s));
					} else if (partition == 2)
						if (eventObj.getSecEmpName() == null)
							eventObj.setSecEmpName(s);
						else
							eventObj.setSecEmpName(eventObj.getSecEmpName() + " " + s);

				}
			}

			eventsList.add(eventObj);

		}
		return eventsList;
	}

	public static List<String> getEventsOrder(String team1, String team2, String[] events1, String[] events2) {
		List<Event> eventsList = new ArrayList<>();

		eventsList.addAll(convertToListOfEventObjects(team1, events1));
		eventsList.addAll(convertToListOfEventObjects(team2, events2));
		Comparator<Event> customSortOrder = Comparator.comparing(Event::getTime).thenComparing(Event::getEventOrder)
				.thenComparing(Event::getTeamName).thenComparing(Event::getEmpName);
		// Collections.sort(eventsList, customSortOrder);

		return eventsList.stream().sorted(customSortOrder).map((e) -> e.toString()).collect(Collectors.toList());

	}

	public static void main(String[] args) {

		/*
		 * String t1= "abc"; String t2="cba";
		 * 
		 * String[] e1= {"mo sa 45+2 Y","a 13 G"}; String[] e2= {"d 23 S f",
		 * "z 46 G"};
		 */
		String t1 = "nolh";
		String t2 = "uzrddrc slcpx";

		String[] e1 = { "inmuucz jzbkica 70 Y", "ton wfnt 10 S inmuucz jzbkica", "ecya kgvgy 20 S fkfk fuiyb senmofw" };
		String[] e2 = { "mysior pqfcz bxlnpn 49 G", "mysior pqfcz bxlnpn 18 G", "enc otagavd oevfg 68 Y",
				"zummy name 18 G"};

		getEventsOrder(t1, t2, e1, e2).forEach(System.out::println);

	}

}
