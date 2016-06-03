import java.util.*;
import java.util.stream.*;

public class TestPartitions {

  public static void main( String[] args ) {
    List<Integer> ints = new ArrayList<Integer>() {{
      //add(1);
      add(2);
      //add(3);
      add(4);
      add(5);
      add(6);
    }};

    Map<Boolean, List<Integer>> partitions = ints
      .stream()
      .collect( Collectors.groupingBy( i -> i % 2 == 0 ) );

    List<Integer> sorted = Stream.concat( 
        partitions.getOrDefault( true, Collections.emptyList() ).stream(),
        partitions.getOrDefault( false, Collections.emptyList() ).stream() )
      .collect( Collectors.toList() );
    
    System.out.format( "%s\n", sorted );
  }

}
