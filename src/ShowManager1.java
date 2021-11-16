import java.util.LinkedList;
/**
Show manager 1 solution
@author Gabe_Demanchee and Chris_Chow
 */
class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Sorts a list of shows into a showSummary
	 * @param shows a unsorted list of shows
	 * @return a report of shows that hold the lists of daytime, primetime, and latenight shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows){
		ShowSummary report = new ShowSummary();
		for (int i = 0; i < shows.size(); i++) {
			if (!shows.get(i).isSpecial) {
				if (shows.get(i).broadcastTime >= 600 && shows.get(i).broadcastTime < 1700) {
					report.daytime.add(shows.get(i));
				}
				else if (shows.get(i).broadcastTime >= 1700 && shows.get(i).broadcastTime < 2200){
					report.primetime.add(shows.get(i));
				}
				else if ((shows.get(i).broadcastTime >= 0 && shows.get(i).broadcastTime < 100) || (shows.get(i).broadcastTime <= 2400 &&shows.get(i).broadcastTime >= 2200)){
					report.latenight.add(shows.get(i));
				}
			}
		}
		return report;
	}
}
