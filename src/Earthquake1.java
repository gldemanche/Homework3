import java.util.LinkedList;

/*
input list of readings and dates
20151004 200 150 175 20151005 0.002 0.03 ...

public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month)

subtasks
get the date and data from the list
filter months
find max data point
return day and max data point
 */

/**
 * earthquake1 solution
 * @author Gabe Demanche & Chris Chow
 */
class Earthquake1 {
  int month;
  Earthquake1(){}

  /**
   * Extracts month from teh 8 digit code
   * @param dateNum the input 8 diget code
   * @return the month in the form mm
   */
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  /**
   * Separates the days into linked lists of the day and its respective data points
   * @param data A linked list of dates and data points
   * @return a linked list of linked lists where each linked list inside the linked list holds data about the date and the
   */
  public LinkedList<LinkedList<Double>> separateDays(LinkedList<Double> data){
    LinkedList<LinkedList<Double>> returnList = new LinkedList<LinkedList<Double>>();
    int counter = -1;
    for(int i = 0; i < data.size(); i++){
      if (data.get(i) >  1000000){
        counter++;
        returnList.add(new LinkedList<Double>());
        returnList.get(counter).add(data.get(i));
      }
      if (data.get(i) <  1000000){
        returnList.get(counter).add(data.get(i));
      }
    }
    return returnList;
  }

  /**
   * Gets the max data value for each day
   * @param day a given date
   * @return max, the maximum value of a given day
   */
  public double getDailyMax(LinkedList<Double> day){
    double max = 0.0;
    for(int i = 1; i < day.size(); i++){
      if (day.get(i) > max){
        max = day.get(i);
      }
    }
    return max;
  }

  /**
   * Finds the date at which the largest data point occurs in a given month and displays the date and the largest value
   * @param data Linked List of Doubles
   * @param month Integer representing the month of interest
   * @return MaxHzReport with the date and the max data pointy of that date
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> maxReport = new LinkedList<>();
    LinkedList<LinkedList<Double>> seperatedList = separateDays(data);
    double max = 0.0;
    double maxDate = 0.0;
    for(int i = 0; i < seperatedList.size(); i++){
      if (extractMonth(seperatedList.get(i).get(0)) == month && getDailyMax(seperatedList.get(i)) > max){
        max = getDailyMax(seperatedList.get(i));
        maxDate = seperatedList.get(i).get(0);
      }
    }
    if (!(max <= 0) && !(maxDate <= 0)) {
      maxReport.add(new MaxHzReport(maxDate, max));
    }
    return maxReport;
  }
}  

