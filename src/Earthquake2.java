import java.util.LinkedList;
/*
input list of readings and dates
20151004 200 150 175 20151005 0.002 0.03 ...

public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month)

subtasks
write date and data from list to list of lists
take each sub list and write it to a day
find the max reading of that day
return the date and max reading
 */
/**
 * earthquake2 solution
 * @author Gabe Demanche & Chris Chow
 */
class Earthquake2 {
  Earthquake2() {
  }
  /**
   * Separates the data into the day and its respective data points
   * @param data linked list of doubles
   * @return a list of the day and its respective data points
   */
  public LinkedList<Day> separateDays(LinkedList<Double> data) {
    LinkedList<Day> returnList = new LinkedList<Day>();
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) > 1000000) {
        Day temp = new Day(data.get(i));
        returnList.add(temp);
      } else {
        if (returnList.getLast().getValue() < data.get(i)) {
          returnList.getLast().setValue(data.get(i));
        }
      }
    }
    return returnList;
  }

  /**
   * takes in a list of data and a desired month
   * @param data list of data including 8 digit dates and data values
   * @param month Integer representing the month of interest
   * @return MaxHzReport with the date and the max data pointy of that date
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> maxReport = new LinkedList<>();
    LinkedList<Day> dayList = separateDays(data);
    double max = 0.0;
    double maxDate = 0.0;
    for (int i = 0; i < dayList.size(); i++) {
      if (dayList.get(i).getMonth() == month && dayList.get(i).getValue() > max) {
        max = dayList.get(i).getValue();
        maxDate = dayList.get(i).date;
      }

    }
    if (!(max <= 0) && !(maxDate <= 0)) {
      maxReport.add(new MaxHzReport(maxDate, max));
    }
    return maxReport;
  }
}