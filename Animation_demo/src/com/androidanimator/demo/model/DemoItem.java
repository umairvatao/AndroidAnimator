package com.androidanimator.demo.model;

import java.util.ArrayList;
import java.util.List;

import android.util.SparseArray;

/**
 * This class is a helper class for providing sample content for user interfaces
 * created by Android template wizards.
 */
public class DemoItem {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static SparseArray<DummyItem> ITEM_MAP = new SparseArray<>();

	static {
		addItem(new DummyItem(1, "Blind"));
		addItem(new DummyItem(2, "Blink"));
		addItem(new DummyItem(3, "Bounce"));
		addItem(new DummyItem(4, "Explode"));
		addItem(new DummyItem(5, "Fade In"));
		addItem(new DummyItem(6, "Fade Out"));
		addItem(new DummyItem(7, "Flip Horizontal"));
		addItem(new DummyItem(8, "Flip Horizontal To"));
		addItem(new DummyItem(9, "Flip Vertical"));
		addItem(new DummyItem(10, "Flip Vertical To"));
		addItem(new DummyItem(11, "Fold"));
		addItem(new DummyItem(12, "Highlight"));
		addItem(new DummyItem(13, "Path"));
		addItem(new DummyItem(14, "Puff In"));
		addItem(new DummyItem(15, "Puff Out"));
		addItem(new DummyItem(16, "Rotate"));
		addItem(new DummyItem(17, "Scale In"));
		addItem(new DummyItem(18, "Scale Out"));
		addItem(new DummyItem(19, "Shake"));
		addItem(new DummyItem(20, "Slide In"));
		addItem(new DummyItem(21, "Slide In Underneath"));
		addItem(new DummyItem(22, "Slide Out"));
		addItem(new DummyItem(23, "Slide Out Underneath"));
		addItem(new DummyItem(24, "Transfer"));
		addItem(new DummyItem(25, "Parallel Animator"));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public int id;
		public String content;

		public DummyItem(int id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
