package InnerClassAdditional;

import java.util.Iterator;

import SeparateClass.ListInterface;

public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>
{
   public Iterator<T> getIterator();
} // end ListWithIteratorInterface
