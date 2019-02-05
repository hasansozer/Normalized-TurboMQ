import java.util.ArrayList;

public class TurboMQ {

	public static void main(String[] args) {
		
		if(args.length != 2) {
    		System.out.println("usage:");
    		System.out.println("java -jar turbomq.jar dependency.rsf clustering.rsf");
    		return;
    	}
    	
		RSFParser parser = new RSFParser(args[1]);
		parser.parseDependencyInputFile(args[0]);
		
		ArrayList<ArrayList<String>> clusteredItems = parser.getClusteredItems();
		int count = clusteredItems.size();

		int interClusterDSM[][] = new int[count][count];
		for(int c1 = 0; c1 < count; c1++) {
			ArrayList<String> elements1 = clusteredItems.get(c1);
			for(int c2 = c1+1; c2 < count; c2++) {
				ArrayList<String> elements2 = clusteredItems.get(c2);
				int total = 0;
				for(int e1 = 0; e1 < elements1.size(); e1++) {
					for(int e2 = 0; e2 < elements2.size(); e2++) {
						total += parser.dependency(elements1.get(e1), elements2.get(e2));
					}
				}
				interClusterDSM[c1][c2] = interClusterDSM[c2][c1] = total;
			} 
		}
		
		double sum = 0;
		for (int i = 0; i < count; i++) {
			ArrayList<String> elements = clusteredItems.get(i); 
			int u = 0;
			for(int e1 = 0; e1 < elements.size(); e1++) {
				for(int e2 = e1+1; e2 < elements.size(); e2++) {
					u += parser.dependency(elements.get(e1), elements.get(e2));
				}
			}
			int exdep = 0;
			for(int j = 0; j < count; j++) {
				exdep += interClusterDSM[i][j];
			}
			double cf = u /(u + 0.5*exdep); 
			if(cf > 0)
				sum += cf;
		}
		System.out.println(sum/count);
	}
}
