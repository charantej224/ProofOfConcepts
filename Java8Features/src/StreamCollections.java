import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollections {
	
	private static StreamCollections streamCollections = new StreamCollections();
	
	List<String> arrayList = new ArrayList<>();
	Map<String,String> stringMap = new HashMap<>();
	
	public StreamCollections() {
		// TODO Auto-generated constructor stub
		initCollections();
	} 
	
	private void initCollections() {
		// TODO Auto-generated method stub
		arrayList.add("Charan Tej Thota");
		arrayList.add("Sravya Krishna Thota");
		arrayList.add("Likitha Sree Thota");
		arrayList.add("Harsha Kantamneni");
		
		stringMap.put("name", "Charan Tej Thota");
		stringMap.put("spouse", "Krishna Sravya Thota");
		stringMap.put("Daughter", "Likitha Sree Thota");
		stringMap.put("bil", "Harsha Kantamneni");
	}

	public static void main(String[] args) {
		streamCollections.streamMap();
		streamCollections.forEachList();
	}


	private void forEachList() {
		// TODO Auto-generated method stub
		arrayList.forEach((n) -> {
			if(n.contains("Kantam")) {
				System.out.println(n);
			}
		});
		
		List<String> filteredData = arrayList.stream().filter( n -> n.contains("Thota")).collect(Collectors.toList());
				
		System.out.println("Filtered Data");
		filteredData.forEach(n -> {
			System.out.println(n);
		});
		
	}

	private void streamMap() {
		// TODO Auto-generated method stub
		stringMap.forEach((k,v) -> {
			if(v.contains("Thota")) {
				System.out.println("Key - " + k + " Value - " + v);
			}
		});
		Map<String,String> filteredMap = stringMap.entrySet().stream().filter(k -> k.getValue().contains("Thota")).collect(Collectors.toMap(k -> k.getKey(),k -> k.getValue()));
		System.out.println("Map Filtered Data");
		filteredMap.forEach((k,v) -> {
			System.out.println("Key - " + k + "Value - " + v);
		});
		
		
		
				
				
					
		
	}

}
