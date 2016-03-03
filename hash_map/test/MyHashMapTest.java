import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyHashMapTest {
    @Test
    public void create_a_data_set() throws Exception {
        MyHashMap<Integer, String> h = new MyHashMap<Integer, String>();
        h.put(1,"string");
        h.put(2,"name");
        h.put(4,"mirror");
        String expected = "[4=mirror, 1=string, 2=name]";
        assertEquals(expected, h.toString());
    };

    @Test
    public void get_value_of_a_specific_key() throws Exception {
        MyHashMap<Integer, String> h = new MyHashMap<Integer, String>();
        h.put(1,"name");
        h.put(4,"roll_no");
        h.put(9,"address");
        assertEquals("roll_no",h.get(4));
    };

    @Test
    public void remove_value_of_a_specific_key() throws Exception {
        MyHashMap<Integer, String> h = new MyHashMap<Integer, String>();
        h = new MyHashMap(7);
        h.put(21, "pea-cock");
        h.put(1, "tiger");
        h.put(4, "dianausour");
        h.put(6, "monkey");
        h.remove(4);
        String expected = "[21=pea-cock, 1=tiger, 6=monkey, ]";
        assertEquals(expected, h.toString());
    };

    @Test
    public void should_give_null_if_value_is_not_exist() throws Exception {
        MyHashMap<Integer, String> h = new MyHashMap<Integer, String>();
        h.put(21, "pea-cock");
        h.put(1, "tiger");
        h.put(4, "dianausour");
        h.put(6, "monkey");

        assertEquals(null, h.get(100));
    };

    @Test
    public void create_data_set_for_string_key() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h = new MyHashMap(8);
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        h.put("s","salary");
        String expected = "[i=id, r=roll_no, s=salary, e=employee, ]";
        assertEquals(expected, h.toString());
    };

    @Test
    public void should_give_value_of_a_specific_string_key() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h = new MyHashMap(8);
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        h.put("s","salary");

        assertEquals("employee", h.get("e"));
    };

    @Test
    public void should_remove_value_of_a_specific_key() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h = new MyHashMap(8);
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        h.put("s","salary");
        h.remove("e");
        assertEquals(null, h.get("e"));
    };

    @Test
    public void should_give_exception_when_key_does_not_exist() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        boolean thrown = false;
        try{
            h.put(null, "empty");
        }catch (IllegalArgumentException ia){
            thrown = true;
        }
        assertTrue(thrown);
    };

    @Test
    public void should_contains_a_specific_key() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h = new MyHashMap(8);
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        h.put("s","salary");

        assertTrue(h.containsKey("e"));
    };

    @Test
    public void should_contains_a_specific_value() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h = new MyHashMap(8);
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        h.put("s","salary");
        assertTrue(h.containsValue("employee"));
    };

    @Test
    public void should_give_false_when_given_value_is_not_exist() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");

        assertFalse(h.containsValue("name"));
    };

    @Test
    public void should_give_false_when_given_value_is_null() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        assertFalse(h.containsValue(null));
    };

    @Test
    public void should_give_false_When_given_key_is_not_exist() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
    
        assertFalse(h.containsKey("n"));
    }

    @Test
    public void should_clear_all_mapped_element() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");
        
        h.clear();
        assertTrue(h.isEmpty());
    }

    @Test
    public void should_give_size_of_mapped_key() throws Exception {
        MyHashMap<String, String> h = new MyHashMap<String, String>();
        h.put("r","roll_no");
        h.put("e","employee");
        h.put("i","id");

        assertEquals(3, h.size());
    }
}
