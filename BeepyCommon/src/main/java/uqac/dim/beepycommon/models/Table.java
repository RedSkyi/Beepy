package uqac.dim.beepycommon.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;

public class Table implements Parcelable {

    public static final String TABLE_EXTRA = "table";

    private String id;
    private String name;
    private boolean called;
    private Timestamp callTime;

    public Table() { }

    public Table(String id, String name, boolean called, Timestamp callTime) {
        this.id = id;
        this.name = name;
        this.called = called;
        this.callTime = callTime;
    }

    protected Table(Parcel in) {
        id = in.readString();
        name = in.readString();
        called = in.readBoolean();
        callTime = in.readParcelable(Timestamp.class.getClassLoader());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCalled() {
        return called;
    }

    public void setCalled(boolean called) {
        this.called = called;
    }

    public Timestamp getCallTime() {
        return callTime;
    }

    public void setCallTime(Timestamp callTime) {
        this.callTime = callTime;
    }

    public void call() {
        called = true;
        callTime = Timestamp.now();
    }

    public void uncall() {
        called = false;
        callTime = null;
    }

    public static final Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel in) {
            return new Table(in);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeBoolean(called);
        parcel.writeParcelable(callTime, 0);
    }
}
