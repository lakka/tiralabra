

package HashSet;

import java.util.Iterator;


/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
    public class HashSetIterator implements Iterator<Bytes> {
        
        private int position;
        private int size;
        private int iterations;
        private Bytes currentBytes;
        private Bytes[] bytestable;

        public HashSetIterator(Bytes[] bytestable, int size) {
            this.bytestable = bytestable;
            this.size = size;
            this.position = -1;
        }

        @Override
        public boolean hasNext() {
            return iterations < size;
        }

        @Override
        public Bytes next() {
            if (currentBytes == null || currentBytes.next == null) {
                while (bytestable[++position] == null);
                currentBytes = bytestable[position];
            } else {
                currentBytes = currentBytes.next;
            }
            iterations++;
            return currentBytes;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    

