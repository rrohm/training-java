package org.meins.concurrency.bsp03_atomicInt;

/**
 *8.  Nonblocking algorithms
 *
 * Java 5.0 provides supports for additional atomic operations. This allows to
 * develop algorithm which are non-blocking algorithm, e.g. which do not require
 * synchronization, but are based on low-level atomic hardware primitives such
 * as compare-and-swap (CAS). A compare-and-swap operation check if the variable
 * has a certain value and if it has this value it will perform this operation.
 *
 * Non-blocking algorithm are usually much faster then blocking algorithms as
 * the synchronization of threads appears on a much finer level (hardware).
 *
 * For example this created a non-blocking counter which always increases.
 * This example is contained in the project
 * "de.vogella.concurrency.nonblocking.counter".
 *
 * @author Lars Vogel
 * @see http://www.vogella.de/articles/JavaConcurrency/article.html
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

  private AtomicInteger value = new AtomicInteger();

  public int getValue() {
    return value.get();
  }

  public int increment() {
    return value.incrementAndGet();
  }

  /*
   * The interesting part is how incrementAndGet() is implemented. It uses a CAS operation.

public final int incrementAndGet() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

   *
   *
   */


  // Alternative implementation as increment but just make the
  // implementation explicit
  public int incrementLongVersion() {
    int oldValue = value.get();
    while (!value.compareAndSet(oldValue, oldValue + 1)) {
      oldValue = value.get();
    }
    return oldValue + 1;
  }
}
