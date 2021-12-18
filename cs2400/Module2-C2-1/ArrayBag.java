package arrayBag;

public class ArrayBag implements BagInterface {
    private static final int DEFAULT_MAX_SIZE = 50;
	private Object[] items;
    private int numItems;

    public  ArrayBag (){
    	items = new Object[DEFAULT_MAX_SIZE];  
    	numItems = 0 ;
    }

    public   ArrayBag (int maxSize )	{  
    	if (maxSize <= 0)
    		throw new IllegalArgumentException ("maxSize must be > 0");
    	items = new Object[maxSize];  
    	numItems = 0;
    }

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
	public boolean add(Object newItem) {
		// TODO Auto-generated method stub
		if(newItem == null)
			throw new IllegalArgumentException("Item object cannot be null");
		if(!this.isArrayFull())//add only if the array is not full
		{
			this.items[numItems]=newItem;
			++numItems;
			return true;
		}			
		else
			return false;		
	}

	@Override
	public Object remove() {

		if(this.isEmpty())
			return null;
		//remove the last element in the array
		Object returnVal = this.items[this.getCurrentSize()-1];
		this.items[this.getCurrentSize()-1] = null;
		--this.numItems;
		return returnVal;
	}

	@Override
	public boolean remove(Object anEntry) {
		// TODO Auto-generated method stub
		if(anEntry == null)
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
	public int getFrequencyOf(Object anEntry) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0; i< this.getCurrentSize(); ++i) {
			++count;
		}
		return count;
	}

	@Override
	public boolean contains(Object anEntry) {
		// TODO Auto-generated method stub
		for(int i=0; i< this.getCurrentSize(); ++i) {
			if(this.items[i].equals(anEntry))
				return true;
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			return null;
		Object [] retVal = new Object[this.numItems];
		for(int i=0; i< this.getCurrentSize(); ++i) {
			retVal[i]=this.items[i];
		}
		return retVal;
	}
	@Override
	public Object grab() {		
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
	
	
	

}
