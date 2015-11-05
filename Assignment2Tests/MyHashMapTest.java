import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    MyHashMap map;

    @Test
    public void put_returnsTheValueYouAddedIfItIsAdded() {
        map = new MyHashMap();
        assertEquals("kvalhornet", map.put("fjell", "kvalhornet"));
    }

    @Test
    public void put_addsTwoEntrysWithSameKeyButDifferentValue() {
        map = new MyHashMap();
        map.put("fjell", "kvalhornet");
        assertEquals("keiservarden", map.put("fjell", "keiservarden"));
    }

    @Test
    public void put_addsThreeElementsAndchecksThatTheOutComeOfMapIsTheSameAsItShould() {
        map = new MyHashMap();
        map.put("hilsen", "tjohei");
        map.put("hilsen", "hei");
        map.put("bil", "volvo");

        assertEquals("[[bil, [volvo]][hilsen, [tjohei, hei]]]", map.toString());
    }

    @Test
    public void get_addsForeKeysWithDifferentValues_getsTheFirstKey() {
        map = new MyHashMap();
        map.put("fjell", "kvalhornet");
        map.put("something", "random");
        map.put("fjell", "keiservarden");
        map.put("fjell", "hunstadtoppen");

        assertEquals("kvalhornet", map.get("fjell"));
    }

    @Test
    public void getAll_addThreeSimilarKeysAndOneDifferentAndValues_getsAllValuesWithKeyFjell() {
        map = new MyHashMap();
        map.put("fjell", "kvalhornet");
        map.put("something", "random");
        map.put("fjell", "keiservarden");
        map.put("fjell", "hunstadtoppen");

        assertEquals("[kvalhornet, keiservarden, hunstadtoppen]", map.getAll("fjell").toString());
    }

    @Test
    public void getAll_addsTwoTimesTwoEqualKeys_checksThatGetAllReturnsCorrectForBothOfthem() {
        map = new MyHashMap();
        map.put("fjell", "kvalhornet");
        map.put("something", "random");
        map.put("fjell", "keiservarden");
        map.put("something", "different");

        assertEquals("[kvalhornet, keiservarden]", map.getAll("fjell").toString());
        assertEquals("[random, different]", map.getAll("something").toString());
    }

    @Test
    public void getAll_addsKeysAndValuesOfBothStringAndInt_shouldReturnInTheCorrectOrder() {
        map = new MyHashMap();
        map.put("fjell", "kvalhornet");
        map.put("something", "random");
        map.put("fjell", "keiservarden");
        map.put(1, "800");
        map.put(2, "1000");
        map.put(1, "500");
        map.put(1, "200");
        map.put(1, "300");
        map.put(1, "400");
        map.put(1, "100");

        assertEquals("[100, 200, 300, 400, 500, 800]", map.getAll(1).toString());
    }
}