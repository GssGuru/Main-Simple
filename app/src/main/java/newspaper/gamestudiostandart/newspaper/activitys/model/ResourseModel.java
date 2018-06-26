package newspaper.gamestudiostandart.newspaper.activitys.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/*Model for creating a list of fragments by category*/
public class ResourseModel implements Parcelable {

    private String name;
    private String url;
    private boolean check = false;

    protected ResourseModel(Parcel in) {
        name = in.readString();
        url = in.readString();
        check = in.readByte() != 0;
    }

    public static final Creator<ResourseModel> CREATOR = new Creator<ResourseModel>() {
        @Override
        public ResourseModel createFromParcel(Parcel in) {
            return new ResourseModel(in);
        }

        @Override
        public ResourseModel[] newArray(int size) {
            return new ResourseModel[size];
        }
    };

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public ResourseModel(String name, String url, boolean check) {
        this.name = name;
        this.url = url;
        this.check = check;
    }

    public ResourseModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url);
        parcel.writeByte((byte) (check ? 1 : 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourseModel that = (ResourseModel) o;
        return check == that.check &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, check);
    }
}