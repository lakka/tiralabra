package md5crack;

import HashSet.Bytes;
import HashSet.HashSet;
import HashSet.HashSetIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class HashSetIteratorTest {

    private HashSetIterator hsi;

    public HashSetIteratorTest() {
    }

    @Before
    public void setUp() {
        HashSet hs = new HashSet(5000,3,5);
        // create 'hashset'
        for (byte i = 0; i < 120; i++) {
            byte[] bytes = {123,123,i};
            hs.insert(new Bytes(bytes));
        }
        hsi = new HashSetIterator(hs.getBytes(),120);
    }
    
    @Test
    public void hasNextFirst() {
        assertTrue(hsi.hasNext());
    }
    
   @Test
    public void hasNextLast() {
       for (int i = 0; i < 119; i++) {
           hsi.next();
       }
        assertTrue(hsi.hasNext());
    }
   
    @Test
    public void hasNextOverArray() {
       for (int i = 0; i < 120; i++) {
           hsi.next();
       }
        assertFalse(hsi.hasNext());
    }
    
    @Test
    public void nextFindsSomething() {
        assertNotNull(hsi.next());
    }
    
    @Test
    public void nextFindsFromLinkedList() {
        Bytes[] bs = new Bytes[2];
        byte[] bytes = {1,1,1};
        byte[] bytes2 = {1,1,2};
        Bytes b = new Bytes(bytes);
        b.next = new Bytes(bytes2);
        bs[1] = b;
        HashSetIterator hsi2 = new HashSetIterator(bs,2);
        assertArrayEquals(bytes,hsi2.next().getBytes());
        assertArrayEquals(bytes2,hsi2.next().getBytes());
    }
}