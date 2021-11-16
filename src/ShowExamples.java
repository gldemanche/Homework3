import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;

/**
 * show examples file
 * @author Gabe Demanche & Chris Chow
 */
/* Subtasks
	cleaning out specials
	sorting daytime, primetime, and latenight shows
	adding shows to the show summary in the correct field
	 */
public class ShowExamples
{
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2 = new ShowManager2();
	LinkedList<Show> shows = new LinkedList<>();
	ShowSummary report1 = new ShowSummary();


	Show startrek = new Show("Star Trek", 1800, 45.0, false);
	Show futurama = new Show("Futurama", 1900, 23.0, false);
	Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
	Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);

	//shows
	Show special = new Show("special", 1200, 20.2, true);
	Show daytime = new Show("daytime", 1200, 30.0, false);
	Show daytime2 = new Show("daytime2", 1000, 40.0, false);
	Show primetime = new Show("primetime", 1900, 60.0, false);
	Show primetime2 = new Show("primetime2", 2000, 60.0, false);
	Show latenight = new Show("latenigth", 2300, 30.0, false);
	Show latenight2 = new Show("latenight2", 0, 60.0, false);
	Show overnight = new Show("overnight", 400, 50.0, false);

	//list of shows
	LinkedList<Show> allSpecials = new LinkedList<>();
	LinkedList<Show> allDay = new LinkedList<>();
	LinkedList<Show> allPrime = new LinkedList<>();
	LinkedList<Show> allLate = new LinkedList<>();
	LinkedList<Show> allOver = new LinkedList<>();
	LinkedList<Show> mixedValid = new LinkedList<>();
	LinkedList<Show> mixedNonValid = new LinkedList<>();
	LinkedList<Show> multi = new LinkedList<>();

	//show summaries
	ShowSummary emptySum = new ShowSummary();
	ShowSummary allDaySum= new ShowSummary();
	ShowSummary primeSum = new ShowSummary();
	ShowSummary lateSum = new ShowSummary();
	ShowSummary mixedSum = new ShowSummary();
	ShowSummary multiSum = new ShowSummary();

	public ShowExamples()
	{
		shows.add(startrek);
		report1.primetime.add(startrek);
		shows.add(futurama);
		report1.primetime.add(futurama);
		shows.add(animaniacs);
		report1.daytime.add(animaniacs);
		shows.add(sesamestreet);
		report1.daytime.add(sesamestreet);
	}

	@Before
	public void setup(){
		//special only list
		allSpecials.add(special);

		//daytime only
		allDay.add(daytime);
		allDaySum.daytime.add(daytime);

		//primetime only
		allPrime.add(primetime);
		primeSum.primetime.add(primetime);

		//latenight only
		allLate.add(latenight);
		lateSum.latenight.add(latenight);

		//overnight only
		allOver.add(overnight);

		//mixed all valid
		mixedValid.add(daytime);
		mixedValid.add(primetime);
		mixedValid.add(latenight);
		mixedValid.add(daytime2);
		mixedValid.add(primetime2);
		mixedValid.add(latenight2);
		mixedSum.daytime.add(daytime);
		mixedSum.daytime.add(daytime2);
		mixedSum.primetime.add(primetime);
		mixedSum.primetime.add(primetime2);
		mixedSum.latenight.add(latenight);
		mixedSum.latenight.add(latenight2);

		//mixed not all valid
		mixedNonValid.add(daytime);
		mixedNonValid.add(primetime);
		mixedNonValid.add(overnight);
		mixedNonValid.add(latenight);
		mixedNonValid.add(daytime2);
		mixedNonValid.add(special);
		mixedNonValid.add(primetime2);
		mixedNonValid.add(latenight2);

		//all the same valid show
		multi.add(daytime);
		multi.add(daytime);
		multi.add(daytime);
		multiSum.daytime.add(daytime);
		multiSum.daytime.add(daytime);
		multiSum.daytime.add(daytime);

	}

	//multiple test
	@Test
	public void multiTest(){
		assertEquals(sm1.organizeShows(multi), multiSum);
	}
	//mixed valid and not
	@Test
	public void nonvalidMixed(){
		assertEquals(sm1.organizeShows(mixedNonValid), mixedSum);
	}
	//mixed all valid
	@Test
	public void validMixed(){
		assertEquals(sm1.organizeShows(mixedValid), mixedSum);
	}
	//empty test
	@Test
	public void emptyTest(){
		assertEquals(sm1.organizeShows(new LinkedList<>()), emptySum);
	}
	//overnight
	@Test
	public void overnightOnly(){
		assertEquals(sm1.organizeShows(allOver), emptySum);
	}
	//all late
	@Test
	public void lateOnly(){
		assertEquals(sm1.organizeShows(allLate), lateSum);
	}
	//all prime
	@Test
	public void primeOnly(){
		assertEquals(sm1.organizeShows(allPrime), primeSum);
	}

	//all daytime
	@Test
	public void dayOnly(){
		assertEquals(sm1.organizeShows(allDay), allDaySum);
	}

	//only specials
	@Test
	public void specialsOnly(){
		assertEquals(sm1.organizeShows(allSpecials), emptySum);
	}
	
	@Test
	public void instructorTestShowSummary_EmptyReport() {
		ShowSummary report2 = new ShowSummary();
		assertFalse(report1.equals(report2));
	}


	@Test
	public void instructorTestShowSummary_WrongOrder() {
		ShowSummary report2 = new ShowSummary();

		report2.primetime.add(futurama);
		report2.primetime.add(startrek);
		report2.daytime.add(animaniacs);
		report2.daytime.add(sesamestreet);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_DifferentInstances() {
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertTrue(report1.equals(report2));
	}

	@Test
	public void equals_allEmpty(){
		ShowSummary emptylist1 = new ShowSummary(new LinkedList<Show>(), new LinkedList<Show>(), new LinkedList<Show>());
		ShowSummary emptylist2 = new ShowSummary(new LinkedList<Show>(), new LinkedList<Show>(), new LinkedList<Show>());

		assertTrue(emptylist1.equals(emptylist2));

	}

	@Test
	public void equals_differentTitles(){
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trekkkk", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void equals_differentTimes(){
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1700, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void equals_differentLengths(){
		ShowSummary report2 = new ShowSummary();

		Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
		Show futurama2 = new Show("Futurama", 1900, 20.0, false);
		Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
		Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);
		Show sesamestreet3 = new Show("Sesame Street", 900, 55.0, false);

		report2.primetime.add(startrek2);
		report2.primetime.add(futurama2);
		report2.daytime.add(animaniacs2);
		report2.daytime.add(sesamestreet2);
		report2.latenight.add(sesamestreet3);

		assertFalse(report1.equals(report2));
	}

	@Test
	public void instructorTestShowSummary_SameInstances() {
		ShowSummary report2 = report1;
		assertTrue(report1.equals(report2));
	}


	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	@Test
	public void instructorTestOrganizeShows2()
	{
		ShowSummary report2 = sm2.organizeShows(shows);
		assertEquals(report1, report2);
	}
}
