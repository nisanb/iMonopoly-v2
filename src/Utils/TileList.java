package Utils;

import java.util.ArrayList;
import java.util.Collection;


public class TileList<E> extends ArrayList<E> {
	/**
	 * 
	 */
	 public TileList (Collection<E> tokens) {
	        super(tokens);  
	    }
	 
	public TileList() {
	}

	private static final long serialVersionUID = 1L;

	public TileList<E> addItem (E e){
		super.add(e);
		return this;
	}

}
