package jp.water_cell.android.lib;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * IDとタイトルだけを持つシンプルなPOJO
 * 
 * @author nakagawa
 * 
 */
public class SimpleListItem implements Parcelable {

	public static final String KEY = SimpleListItem.class.getName() + "_key";

	private String id;
	private String title;

	public SimpleListItem(String id, String title) {
		this.id = id;
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	private SimpleListItem(Parcel source) {
		this.id = source.readString();
		this.title = source.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<SimpleListItem> CREATOR = new Parcelable.Creator<SimpleListItem>() {

		@Override
		public SimpleListItem createFromParcel(Parcel source) {
			return new SimpleListItem(source);
		}

		@Override
		public SimpleListItem[] newArray(int size) {
			return new SimpleListItem[size];
		}

	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleListItem other = (SimpleListItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListItem [id=" + id + ", title=" + title + "]";
	}
}
