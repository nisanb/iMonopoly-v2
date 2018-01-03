package Utils;

import java.util.ArrayList;
import java.util.Collection;

import View.Game.Controller.PlayerUI;

public class SpecialList<E> extends ArrayList<E> {
	/**
	 *
	 */
	public SpecialList(Collection<E> tokens) {
		super(tokens);
	}

	public SpecialList() {
	}

	private static final long serialVersionUID = 1L;

	public SpecialList<E> addItem(E e) {
		super.add(e);
		return this;
	}

	public E get(String str) {
		return super.get(indexOf(new PlayerUI(str)));
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return super.indexOf(o);
	}

	public Integer indexOf(String str) {
		return super.indexOf(new PlayerUI(str));
	}
}
