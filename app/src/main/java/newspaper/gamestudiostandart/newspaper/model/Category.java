package newspaper.gamestudiostandart.newspaper.model;

import android.os.Parcel;
import android.os.Parcelable;

public enum Category implements Parcelable {

    STARRED, POPULAR, TEHNOLOGY, SPORT, BUSINESS, OTHER;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(ordinal());
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(final Parcel source) {
            return Category.values()[source.readInt()];
        }

        @Override
        public Category[] newArray(final int size) {
            return new Category[size];
        }
    };
}