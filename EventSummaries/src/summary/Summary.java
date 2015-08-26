package summary;

import java.util.ArrayList;
import java.util.List;

import summary.algo.*;

public class Summary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EventList> ta = new ArrayList<EventList>(); 
		ta.add(new EventList(1, 1, 2));
		
		DemoAlgo demo = new DemoAlgo();
		demo.getTimeAxis(ta);
		demo.calc();
		demo.printResult();
	}
}
