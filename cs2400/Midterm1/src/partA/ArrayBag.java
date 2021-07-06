package partA;

public class ArrayBag<T> implements BagInterface<T> {
    private static final int DEFAULT_MAX_SIZE = 50;
    private static final int DEFAULT_INCREASE_FACTOR = 10;
    private int increaseFactor;
	private T[] items;
    private int numItems;

    @SuppressWarnings("unchecked")
	public  ArrayBag (){
    	this.items = (T[])new Object[ArrayBag.DEFAULT_MAX_SIZE];
    	this.increaseFactor=ArrayBag.DEFAULT_INCREASE_FACTOR;
    	this.numItems = 0 ;
    }

    @SuppressWarnings("unchecked")
	public   ArrayBag (int maxSize)	{  
    	if (maxSize <= 0)
    		throw new IllegalArgumentException ("maxSize must be > 0");
    	this.items = (T[])new Object[maxSize];
    	this.increaseFactor=ArrayBag.DEFAULT_INCREASE_FACTOR;
    	this.numItems = 0;
    }
    
    public   ArrayBag (int maxSize, int increase)	{  
    	if (maxSize <= 0)
    		throw new IllegalArgumentException ("maxSize must be > 0");
    	this.items = (T[])new Object[maxSize];
    	if (increase < 1) 
    		throw new IllegalArgumentException ("Array increase factor must be > 0");
    	this.increaseFactor=increase;
    	this.numItems = 0;
    }

    
    /* ******************
	 * 
	 * Part A Problem A2 
	 * 
	 * *******************
	 * */
    
     private boolean isTooBig() {
    	return true;//placeholder
    }
    
     
	private void reduceArray() {
    	
     }
     
     /*************************
 	 * 
 	 * End of  Problem A2 
 	 * 
 	 * *******************
 	 * */
    																				
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return this.numItems;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.getCurrentSize() > 0)
			return false;
		else				
			return true;
	}

	@Override
	public boolean add(T newItem) {
		// TODO Auto-generated method stub
		if(newItem == null)
			throw new IllegalArgumentException("Item object cannot be null");
		if(this.isArrayFull())//add only if the array is not full
		{
			//resize the array
			this.resize();
		}
		this.items[numItems]=newItem;
		++numItems;
		return true;		
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		// TODO Auto-generated method stub
		T[] tmp = this.items;
		this.items = (T[])new Object[this.getCurrentSize() + this.increaseFactor];
		for(int i=0; i<this.getCurrentSize();++i) {
			this.items[i] = tmp[i];
		}
		
	}

	@Override
	public T remove() {

		if(this.isEmpty())
			return null;
		//remove the last element in the array
		T returnVal = this.items[this.getCurrentSize()-1];
		this.items[this.getCurrentSize()-1] = null;
		--this.numItems;
		
		return returnVal;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return false;
		for(int i=0; i<this.getCurrentSize();++i)
		{
			if(this.items[i].equals(anEntry)) {
				this.items[i]=null;				
				//take care of a possible hole in the array
				if(i < this.getCurrentSize()-1) {
					this.items[i] = this.items[this.getCurrentSize()-1];
					this.items[this.getCurrentSize()-1]=null;
				}
				--this.numItems;			
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0; i<this.getCurrentSize();++i)
		{
			this.items[i]= null;
		}
		this.numItems=0;

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0; i< this.getCurrentSize(); ++i) {
			++count;
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		for(int i=0; i< this.getCurrentSize(); ++i) {
			if(this.items[i].equals(anEntry))
				return true;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		@SuppressWarnings("unchecked")
		T[] retVal = (T[])new Object[this.numItems];
		for(int i=0; i< this.getCurrentSize(); ++i) {
			retVal[i]=this.items[i];
		}
		return retVal;
	}
	@Override
	public T grab() {		
		// TODO Auto-generated method stub
		// formula for using the random function: (Math.random() * (max - min)) + min)
		if(this.isEmpty())
			return null;
		int selectedIndex = (int) (Math.random() * (this.getCurrentSize()-1));
		return this.items[selectedIndex];		
	}	
	
	//additional helper method
	private boolean isArrayFull() {
		if(this.getCurrentSize() < this.items.length-1)
			return false;
		else
			return true;
	}
	
	/**Additional method created to return the overall size of the array.(For testing)
	 * @return
	 */
	public int getTotalBagSize() {
		return this.items.length;
	}
	
	/** Method to check for array integrity (caused by deletion of items)
	 * 
	 */
	public void checkHoles() {
		System.out.println("The number of items: "+ this.getCurrentSize());
		boolean flag = true;
		for(int i=0; i<this.getCurrentSize(); ++i) {
			if(this.items[i]==null) {
				System.out.println("Hole at position:" + i);
			}
		}
		for(int i=this.getCurrentSize(); i< this.items.length; ++i) {
			if(this.items[i]!=null) {
				System.out.println("Objects found at position:" + i);
			}
		}
		if (flag) System.out.println("Bag integrity has been maintained");		
	}
}
