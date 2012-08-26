/**
 * 
 */
package net.notsosoft.labs.diabetes.entity;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import net.notsosoft.tools.json.JSONable;

/**
 * Hold data about a glucometer reading.
 * 
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 */
public class GlucometerReading implements JSONable {
	private static final String json_keyId = "GlucometerReading_instance.id";
	private static final String json_keyValue = "GlucometerReading_instance.value";
	private static final String json_keyUnit = "GlucometerReading_instance.unit";
	private static final String json_keyTimestamp = "GlucometerReading_instance.timestamp";
	private static final String json_keyEventLabel = "GlucometerReading_instance.eventLabel";
	private static final String json_keyNotes = "GlucometerReading_instance.notes";
	private static final String MG_PER_DL = "MG_PER_DL";
	private static final String MMOL_PER_L = "MMOL_PER_L";
	private static final int UNSET_ID_VALUE = -1;

	/**
	 * Are we using mmol/L or are we using mg/dL?
	 * 
	 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
	 */
	public enum GlucoseUnitOfMeasure {
		MMOL_PER_L, MG_PER_DL
	};

	protected int mId;
	protected double mValue;
	protected GlucoseUnitOfMeasure mUnit;
	protected Date mTimestamp;
	protected String mEventLabel;
	protected String mNotes;

	/**
	 * Create an instance of the GlucometerReading class, with initial values.
	 * 
	 * @param id
	 *            The ID value for the reading
	 * @param value
	 *            The value of the reading
	 * @param unit
	 *            The unit of measure, as a {@link GlucoseUnitOfMeasure}
	 * @param timestamp
	 *            The timestamp to assign to the reading, as a {@link Date}
	 * @param eventLabel
	 *            The event label for the reading
	 * @param notes
	 *            The notes for the reading
	 */
	public GlucometerReading(int id, double value, GlucoseUnitOfMeasure unit,
			Date timestamp, String eventLabel, String notes) {
		super();
		this.mId = id;
		this.setValue(value);
		this.setUnit(unit);
		this.setTimestamp(timestamp);
		this.setEventLabel(eventLabel);
		this.setNotes(notes);
	}

	/**
	 * @return the notes
	 */
	public synchronized String getNotes() {
		return mNotes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public synchronized void setNotes(String notes) {
		this.mNotes = notes;
	}

	public GlucometerReading(int id, double value, GlucoseUnitOfMeasure unit,
			Date timestamp, String eventLabel) {
		this(id, value, unit, timestamp, eventLabel, null);
	}

	public GlucometerReading(int id, double value, GlucoseUnitOfMeasure unit,
			Date timestamp) {
		this(id, value, unit, timestamp, null);
	}

	public GlucometerReading(double value, GlucoseUnitOfMeasure unit,
			Date timestamp) {
		this(UNSET_ID_VALUE, value, unit, timestamp);
	}

	/**
	 * Sets reading to 0.0, no mUnit or mTimestamp defined.
	 */
	public GlucometerReading() {
		this(UNSET_ID_VALUE, 0.0, null, null);
	}

	/**
	 * @return The ID value for the instance
	 */
	public long getId() {
		return this.mId;
	}

	/**
	 * Set the mValue of the glucometer reading
	 * 
	 * @param mValue
	 *            The value of the reading
	 */
	public void setValue(double value) {
		this.mValue = value;
	}

	/**
	 * Get the mValue of a glucometer reading.
	 * 
	 * @return Returns the value of the reading
	 */
	public double getValue() {
		return this.mValue;
	}

	/**
	 * Set the unit of measure for the glucometer reading
	 * 
	 * @param mUnit
	 *            The unit to use, in {@link GlucoseUnitOfMeasure}
	 */
	public void setUnit(GlucoseUnitOfMeasure unit) {
		this.mUnit = unit;
	}

	/**
	 * Get the unit of measure for the glucometer reading.
	 * 
	 * @return Returns the unit of measure, in {@link GlucoseUnitOfMeasure}
	 */
	public GlucoseUnitOfMeasure getUnit() {
		return this.mUnit;
	}

	/**
	 * Set the timestamp for this reading.
	 * 
	 * @param mTimestamp
	 *            The timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.mTimestamp = timestamp;
	}

	/**
	 * Get the timestamp on the reading.
	 * 
	 * @return Returns the timestamp in a {@link Date} object
	 */
	public Date getTimestamp() {
		return this.mTimestamp;
	}

	/**
	 * @return the Event label (e.g. after breakfast)
	 */
	public String getEventLabel() {
		return mEventLabel;
	}

	/**
	 * @param mEventLabel
	 *            The event label to set
	 */
	public void setEventLabel(String mEventLabel) {
		this.mEventLabel = mEventLabel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.notsosoft.tools.json.JSONable#toJsonObject()
	 */
	@Override
	public JSONObject toJsonObject() throws JSONException {
		JSONObject toReturn = new JSONObject();

		toReturn.put(json_keyId, this.getId());
		toReturn.put(json_keyValue, this.getValue());

		// Let's convert this to a string
		switch (this.getUnit()) {
		case MG_PER_DL:
			toReturn.put(json_keyUnit, MG_PER_DL);
			break;

		default:
			toReturn.put(json_keyUnit, MMOL_PER_L);
		}

		// Timestamp!
		toReturn.put(json_keyTimestamp, this.getTimestamp().getTime());
		toReturn.put(json_keyEventLabel, this.getEventLabel());
		toReturn.put(json_keyNotes, this.getNotes());

		return toReturn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.notsosoft.tools.json.JSONable#fromJsonObject(org.json.JSONObject)
	 */
	@Override
	public void fromJsonObject(JSONObject source) throws JSONException {
		this.mId = source.getInt(json_keyId);
		this.setValue(source.getDouble(json_keyValue));
		this.setTimestamp(new Date(source.getLong(json_keyTimestamp)));

		String unitValue = source.getString(json_keyUnit);
		if (unitValue.equals(MG_PER_DL)) {
			this.setUnit(GlucoseUnitOfMeasure.MG_PER_DL);
		} else {
			this.setUnit(GlucoseUnitOfMeasure.MMOL_PER_L);
		}
		this.setEventLabel(source.getString(json_keyEventLabel));
		this.setNotes(source.getString(json_keyNotes));
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
		int mIdHashcode = ((mId == UNSET_ID_VALUE) ? 0 : Integer.valueOf(mId)
				.hashCode());
		result = prime * result + mIdHashcode;
		result = prime * result
				+ ((mTimestamp == null) ? 0 : mTimestamp.hashCode());
		result = prime * result + ((mUnit == null) ? 0 : mUnit.hashCode());
		result = prime
				* result
				+ ((mEventLabel == null || mEventLabel.isEmpty() == true) ? 0
						: mEventLabel.hashCode());
		result = prime
				* result
				+ ((mNotes == null || mNotes.isEmpty() == true) ? 0 : mNotes
						.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof GlucometerReading)) {
			return false;
		}

		// Let's just grab a simple copy
		GlucometerReading other = (GlucometerReading) obj;

		if (!this.getTimestamp().equals(other.getTimestamp())) {
			return false;
		}

		if (this.getUnit() != other.getUnit()) {
			return false;
		}

		if (Double.doubleToLongBits(this.getValue()) != Double
				.doubleToLongBits(other.getValue())) {
			return false;
		}

		if (other.getId() != this.getId()) {
			return false;
		}

		// Why am I going through all of this trouble? Well, that's easy! I
		// don't know whether I have nulls!
		if (
		// Handle fun with nulls
		((this.getEventLabel() == null || other.getEventLabel() == null) && this
				.getEventLabel() != other.getEventLabel()) ||
		// Do a comparison...
				(this.getEventLabel() != null && this.getEventLabel().equals(
						other.getEventLabel()) == false)) {
			return false;
		}

		if (
		// Handle fun with nulls
		((this.getNotes() == null || other.getNotes() == null) && this
				.getNotes() != other.getNotes()) ||
		// Do a comparison...
				(this.getNotes() != null && this.getNotes().equals(
						other.getNotes()) == false)) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GlucometerReading [mId=" + mId + ", mValue=" + mValue
				+ ", mUnit=" + mUnit + ", mTimestamp=" + mTimestamp
				+ ", mEventLabel=" + mEventLabel + "]";
	}

	public String id;
}
