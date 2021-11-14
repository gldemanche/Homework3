import java.util.LinkedList;
import java.util.Objects;

class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	LinkedList<Show> latenight;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
		this.latenight = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
	{
		this.daytime = daytime;
		this.primetime = primetime;
		this.latenight = latenight;
	}

	public boolean equals(Object obj){
		ShowSummary otherShow = (ShowSummary) obj;
		int count;
		int count2 =0;


		if(this.daytime.size() == otherShow.daytime.size() && this.primetime.size() == otherShow.primetime.size() && this.latenight.size() == otherShow.latenight.size()){
			if(this.daytime.isEmpty())
				count2++;

			if(this.primetime.isEmpty())
				count2++;

			if(this.latenight.isEmpty())
				count2++;

			count = 0;
			for (int i = 0; i < this.daytime.size() ; i++) {
				if(Objects.equals(this.daytime.get(i).title, otherShow.daytime.get(i).title) && this.daytime.get(i).broadcastTime == otherShow.daytime.get(i).broadcastTime){
					count++;
				}
				if(count == this.daytime.size())
					count2++;
			}
			count = 0;
			for (int i = 0; i < this.primetime.size() ; i++) {
				if(Objects.equals(this.primetime.get(i).title, otherShow.primetime.get(i).title) && this.primetime.get(i).broadcastTime == otherShow.primetime.get(i).broadcastTime){
					count++;
				}
				if (count == this.primetime.size())
					count2++;
			}
			count =0;
			for (int i = 0; i < this.latenight.size() ; i++) {
				if(Objects.equals(this.latenight.get(i).title, otherShow.latenight.get(i).title) && this.latenight.get(i).broadcastTime == otherShow.latenight.get(i).broadcastTime){
					count++;
				}
				if(count == this.primetime.size())
					count2++;
			}
		}
		return count2 == 3;
	}




}
