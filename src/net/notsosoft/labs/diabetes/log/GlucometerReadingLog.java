/*
Copyright (c) 2000-2012 Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package net.notsosoft.labs.diabetes.log;

import java.util.ArrayList;

import net.notsosoft.labs.diabetes.entity.GlucometerReading;

/**
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 *
 */
public class GlucometerReadingLog implements LogInterface {
	private LogStorageMechanism m_localStorage = LogStorageMechanism.STORAGE_TEXT_JSON;
	private ArrayList<GlucometerReading> m_entries = null;
	
	public GlucometerReadingLog(ArrayList<GlucometerReading> entries, LogStorageMechanism storageMechanism) {
		this.setLocalStorageMechanism(storageMechanism);
		this.setEntries(entries);
	}
	
	public GlucometerReadingLog(ArrayList<GlucometerReading> entries) {
		this(entries, null);
	}
	
	public GlucometerReadingLog() {
		this(null, null);
	}
	
	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#getLocalStorageMechanism()
	 */
	@Override
	public LogStorageMechanism getLocalStorageMechanism() {
		return this.m_localStorage;
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#setLocalStorageMechanism(net.notsosoft.labs.diabetes.log.LogStorageMechanism)
	 */
	@Override
	public void setLocalStorageMechanism(LogStorageMechanism lsm) {
		this.m_localStorage = lsm;
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#setEntries(java.util.ArrayList)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setEntries(ArrayList<?> entries) throws IllegalArgumentException {
		if (entries != null
				&& entries.isEmpty() == false
				&& entries.get(0) != null
				&& (entries.get(0) instanceof GlucometerReading) == false) {
			throw new IllegalArgumentException("GlucometerReadingLog entries must be instances of GlucometerReading");
		
		} else if (entries == null) {
			this.m_entries = new ArrayList<GlucometerReading>();
		
		} else {
			this.m_entries = (ArrayList<GlucometerReading>)entries;
		}
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#getEntries()
	 */
	@Override
	public ArrayList<?> getEntries() {
		return this.m_entries;
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#countEntries()
	 */
	@Override
	public int countEntries() {
		return this.m_entries.size();
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#addEntry(java.lang.Object)
	 */
	@Override
	public void addEntry(Object entry) {
		this.m_entries.add((GlucometerReading)entry);
	}

	/* (non-Javadoc)
	 * @see net.notsosoft.labs.diabetes.log.LogInterface#removeEntry(java.lang.Object)
	 */
	@Override
	public void removeEntry(Object entry) {
		this.m_entries.remove(entry);
	}

}
