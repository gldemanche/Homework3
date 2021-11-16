import java.util.LinkedList;

/**
 * Show manager 2 solution
 * @author Gabe_Demanche & Chris_Chow
 */
class ShowManager2 {
	
	ShowManager2() {}

	/**
	 * Takes sorted data and makes a show summary
	 * @param shows an unsorted list to be sorted
	 * @return a show summary of sorted shows by their airtime
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		return new ShowSummary(dayClean(shows), primeClean(shows), lateClean(shows));
	}

	/**
	 * Sorts a list of shows
	 * @param shows unsorted list
	 * @return only daytime shows that are non special
	 */
	public LinkedList<Show> dayClean(LinkedList<Show> shows){
		LinkedList<Show> dayShows = new LinkedList<>();
		for(Show thisShow : shows){
			if(!thisShow.isSpecial){
				if(thisShow.broadcastTime >= 600 && thisShow.broadcastTime < 1700){
					dayShows.add(thisShow);
				}
			}
		}
		return dayShows;
	}
	/**
	 * Sorts a list of shows
	 * @param shows unsorted list
	 * @return only primetime shows that are non special
	 */
	public LinkedList<Show> primeClean(LinkedList<Show> shows){
		LinkedList<Show> primeShows = new LinkedList<>();
		for(Show thisShow : shows){
			if(!thisShow.isSpecial){
				if(thisShow.broadcastTime >= 1700 && thisShow.broadcastTime < 2200){
					primeShows.add(thisShow);
				}
			}
		}
		return primeShows;
	}
	/**
	 * Sorts a list of shows
	 * @param shows unsorted list
	 * @return only latenight shows that are non special
	 */
	public LinkedList<Show> lateClean(LinkedList<Show> shows){
		LinkedList<Show> lateShows = new LinkedList<>();
		for(Show thisShow : shows){
			if(!thisShow.isSpecial){
				if((thisShow.broadcastTime >= 0 && thisShow.broadcastTime < 100) || (thisShow.broadcastTime <= 2400 &&thisShow.broadcastTime >= 2200)){
					lateShows.add(thisShow);
				}
			}
		}
		return lateShows;
	}
	
}
