package org.gittner.osmbugs.bugs;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.gittner.osmbugs.R;
import org.gittner.osmbugs.statics.Drawings;
import org.osmdroid.util.GeoPoint;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class OpenstreetmapNote extends Bug {

	private long id_;
	
	public OpenstreetmapNote(double lat, double lon, String text, ArrayList<Comment> comments, long id, STATE state) {
		super("Openstreetmap Note", text, comments, new GeoPoint(lat, lon));
		
		setId(id);
		setState(state);
	}
	
	public OpenstreetmapNote(Parcel parcel) {
		super(parcel);
		id_ = parcel.readLong();
	}

	/* Get the Bugs Id */
	public long getId() {
		return id_;
	}
	
	/* Set the Bugs Id */
	public void setId(long id) {
		id_ = id;
	}

	@Override
	public boolean commit() {

		if(!commentAdded_ || comments_.size() == 0)
			return false;

		if(getState() != STATE.CLOSED){
			HttpClient client = new DefaultHttpClient();
			
			ArrayList<NameValuePair> arguments = new ArrayList<NameValuePair>();
			arguments.add(new BasicNameValuePair("text", comments_.get(comments_.size() - 1).getText()));
	
			HttpPost request = new HttpPost("http://api.openstreetmap.org/api/0.6/notes/" + id_ + "/comment?" + URLEncodedUtils.format(arguments, "utf-8"));
			
			try {		
				/* Execute commit */
				HttpResponse response = client.execute(request);
				
				/* Check result for Success*/
				if(response.getStatusLine().getStatusCode() != 200)
					return false;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		else{
			HttpClient client = new DefaultHttpClient();
			
			ArrayList<NameValuePair> arguments = new ArrayList<NameValuePair>();
			arguments.add(new BasicNameValuePair("text", comments_.get(comments_.size() - 1).getText()));
	
			//TODO: Currently not Working probably due to OSM API Bugs
			HttpPut request = new HttpPut("http://api.openstreetmap.org/api/0.6/notes/" + id_ + "/close?" + URLEncodedUtils.format(arguments, "utf-8"));
			
			try {		
				/* Execute commit */
				HttpResponse response = client.execute(request);
				
				Log.w("", response.getStatusLine().getStatusCode() + "");
				/* Check result for Success*/
				if(response.getStatusLine().getStatusCode() != 200)
					return false;
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}

	/* Openstreetmap Notes can be commented */
	@Override
	public boolean isCommentable() {
		return true;
	}

	/* Openstreetmap Notes cannot be ignored */
	@Override
	public boolean isIgnorable() {
		return false;
	}
	
	/* Openstreetmap Notes cannot be reopened */
	@Override
	public boolean isReopenable() {
		return false;
	}
	
	@Override
	public Drawable getMarker(int bitset) {
		if(getState() == Bug.STATE.CLOSED)
			return Drawings.OpenstreetmapNotesClosed;
		
		return Drawings.OpenstreetmapNotesOpen;
	}

	@Override
	public boolean addNew() {
		if(comments_.size() == 0)
			return false;
		
		if(comments_.get(comments_.size() - 1).getText().equals(""))
			return false;
		
		HttpClient client = new DefaultHttpClient();
		
		ArrayList<NameValuePair> arguments = new ArrayList<NameValuePair>();
		arguments.add(new BasicNameValuePair("lat", String.valueOf(getPoint().getLatitudeE6() / 1000000.0)));
		arguments.add(new BasicNameValuePair("lon", String.valueOf(getPoint().getLongitudeE6() / 1000000.0)));
		arguments.add(new BasicNameValuePair("text", comments_.get(comments_.size() - 1).getText()));

		HttpPost request = new HttpPost("http://api.openstreetmap.org/api/0.6/notes?" + URLEncodedUtils.format(arguments, "utf-8"));
				
		try {		
			/* Execute commit */
			HttpResponse response = client.execute(request);
			
			/* Check result for Success*/
			if(response.getStatusLine().getStatusCode() != 200)
				return false;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/* Parcelable interface */
	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		super.writeToParcel(parcel, flags);
		
		parcel.writeLong(id_);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<OpenstreetmapNote> CREATOR = new Parcelable.Creator<OpenstreetmapNote>() {

		@Override
		public OpenstreetmapNote createFromParcel(Parcel source) {
			return new OpenstreetmapNote(source);
		}

		@Override
		public OpenstreetmapNote[] newArray(int size) {
			return new OpenstreetmapNote[size];
		}    	
    };

	@Override
	public ArrayList<String> getStateNames(Context context) {
		ArrayList<String> states = new ArrayList<String>();
		states.add(context.getString(R.string.open));
		states.add(context.getString(R.string.closed));
		
		return states;
	}
}
