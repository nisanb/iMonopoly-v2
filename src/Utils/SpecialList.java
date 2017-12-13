package Utils;

import java.util.ArrayList;
import java.util.Collection;

import View.Game.Controller.PlayerUI;


public class SpecialList<E> extends ArrayList<E> {
	/**
	 * 
	 */
	 public SpecialList (Collection<E> tokens) {
	        super(tokens);  
	    }
	 
	public SpecialList() {
	}

	private static final long serialVersionUID = 1L;

	public SpecialList<E> addItem (E e){
		super.add(e);
		return this;
	}

	public E get(String str) {
		return super.get(indexOf(new PlayerUI(str)));
	}

}
