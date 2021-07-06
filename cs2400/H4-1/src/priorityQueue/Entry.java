package priorityQueue;


public class Entry<E, P extends Comparable<? super P>>
             implements Comparable<Entry<E, P>>
{
   private E theItem;
   private P thePriority;

   public Entry(E item, P priority)
   {
      theItem = item;
      thePriority = priority;
   } // end constructor

   public E getItem()
   {
      return theItem;
   } // end getItem

   public P getPriority()
   {
      return thePriority;
   } // end getPriority

   public int compareTo(Entry<E, P> other)
   {
      return thePriority.compareTo(other.thePriority);
   } // end compareTo

   public String toString()
   {
      return "item/priority <" + theItem + ", " + thePriority + ">";
   } // end toString
} // end Entry
