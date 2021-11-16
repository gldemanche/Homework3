import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
/**
 * earthquake examples
 * @author Gabe Demanche & Chris Chow
 */
public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<LinkedList<Double>> workingDataList = new LinkedList<>();
  LinkedList<Double> negativeData = new LinkedList<Double>();
  LinkedList<Double> zeroData = new LinkedList<Double>();
  LinkedList<Double> equalList = new LinkedList<Double>();
  LinkedList<Double> zeroList = new LinkedList<Double>();
  LinkedList<Double> validList = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();
  LinkedList<Double> thirdDates = new LinkedList<Double>();
  LinkedList<Double> secondDates = new LinkedList<Double>();
  LinkedList<Double> oneDates = new LinkedList<Double>();
  LinkedList<MaxHzReport> noReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> negativeDataReports = new LinkedList<>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);

    negativeData.add(20151013.0);
    negativeData.add(-1.0);
    negativeData.add(20151014.0);
    negativeData.add(-14.0);
    zeroData.add(20151013.0);
    zeroData.add(0.0);
    zeroData.add(20151014.0);
    zeroData.add(0.0);
    equalList.add(1.0);
    equalList.add(1.0);
    equalList.add(1.0);
    zeroList.add(0.0);
    zeroList.add(0.0);
    validList.add(3.0);
    validList.add(4.0);
    validList.add(6.0);

    oneDates.add(20151013.0);
    oneDates.add(10.0);
    oneDates.add(5.0);
    secondDates.add(20151020.0);
    secondDates.add(40.0);
    secondDates.add(50.0);
    secondDates.add(45.0);
    thirdDates.add(20151101.0);
    thirdDates.add(6.0);
    workingDataList.add(oneDates);
    workingDataList.add(secondDates);
    workingDataList.add(thirdDates);

    negativeDataReports.add(new MaxHzReport(20151101.0,6.0));
    OctReports.add(new MaxHzReport(20151020.0,50.0));
    NovReports.add(new MaxHzReport(20151101.0,6.0));

  }

  //tests for dailyMaxForMonth
  // no data
  // negative data
  // zero data
  // no month
  // specific month has a smaller value than others
  // greatest value is chosen

  @Test
  public void emptyData() {
    assertEquals(noReports, E1.dailyMaxForMonth(noData, 10));
  }
  @Test
  public void negativeData() {
    assertEquals(noReports, E1.dailyMaxForMonth(negativeData, 10));
  }
  @Test
  public void zeroData() {
    assertEquals(noReports, E1.dailyMaxForMonth(zeroData, 11));
  }
  @Test
  public void noMonth() {
    assertEquals(noReports, E1.dailyMaxForMonth(threeDates, 9));
  }
  @Test
  public void monthGreater() {
    assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void dataGreater() {
    assertEquals(OctReports, E1.dailyMaxForMonth(threeDates, 10));
  }

  //tests getDailyMax
  //empty list
  //all equal
  //zero
  //valid
  @Test
  public void emptyList(){
    assertEquals(0.0, E1.getDailyMax(noData), 0.0001);
  }
  @Test
  public void equalList(){
    assertEquals(1.0, E1.getDailyMax(equalList), 0.0001);
  }
  @Test
  public void zeroList(){
    assertEquals(0.0, E1.getDailyMax(zeroList), 0.0001);
  }
  @Test
  public void validList(){
    assertEquals(6.0, E1.getDailyMax(validList), 0.0001);
  }


  //test separateDays
  //empty list
  //working
  @Test
  public void emptyDays(){
    assertEquals(noData, E1.separateDays(noData));
  }
  @Test
  public void noData(){
    assertEquals(workingDataList, E1.separateDays(threeDates));
  }

}
/*
Subtasks
-separate list of data and dates into individual lists of one date and its data
-retrieve month from the date value
-separate dates not in the given month
-find the highest data value for the given month
-return the highest data value and its date in a MaxHzReport
 */