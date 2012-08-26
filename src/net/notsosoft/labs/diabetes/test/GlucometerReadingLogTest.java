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
package net.notsosoft.labs.diabetes.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import net.notsosoft.labs.diabetes.entity.GlucometerReading;
import net.notsosoft.labs.diabetes.entity.GlucometerReading.GlucoseUnitOfMeasure;
import net.notsosoft.labs.diabetes.log.GlucometerReadingLog;
import net.notsosoft.labs.diabetes.log.LogStorageMechanism;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 * 
 */
public class GlucometerReadingLogTest {
	protected ArrayList<GlucometerReading> m_three_fixtures = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Nothing to do here yet
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Nothing to do here yet
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.m_three_fixtures = new ArrayList<GlucometerReading>();
		this.m_three_fixtures.add(new GlucometerReading(100.0,
				GlucoseUnitOfMeasure.MG_PER_DL, new Date()));
		this.m_three_fixtures.add(new GlucometerReading(110.0,
				GlucoseUnitOfMeasure.MG_PER_DL, new Date()));
		this.m_three_fixtures.add(new GlucometerReading(5.0,
				GlucoseUnitOfMeasure.MMOL_PER_L, new Date()));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.m_three_fixtures = null;
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#GlucometerReadingLog(java.util.ArrayList, net.notsosoft.labs.diabetes.log.LogStorageMechanism)}
	 * .
	 */
	@Test
	public void testGlucometerReadingLogArrayListOfGlucometerReadingLogStorageMechanism() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog(
				m_three_fixtures, LogStorageMechanism.STORAGE_TEXT_JSON);
		assertNotNull("Verify that we have an object...", sample1);
		assertTrue("Verify that it is an instance of GlucometerReadingLog...",
				sample1 instanceof GlucometerReadingLog);
		assertEquals("Verify that we have three entries...", 3, sample1
				.getEntries().size());
		assertEquals("Verify that we have a local storage mechanism...",
				LogStorageMechanism.STORAGE_TEXT_JSON,
				sample1.getLocalStorageMechanism());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#GlucometerReadingLog(java.util.ArrayList)}
	 * .
	 */
	@Test
	public void testGlucometerReadingLogArrayListOfGlucometerReading() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog(
				m_three_fixtures);
		assertNotNull("Verify that we have an object...", sample1);
		assertTrue("Verify that it is an instance of GlucometerReadingLog...",
				sample1 instanceof GlucometerReadingLog);
		assertEquals("Verify that we have three entries...", 3, sample1
				.getEntries().size());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#GlucometerReadingLog()}
	 * .
	 */
	@Test
	public void testGlucometerReadingLog() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog();
		assertNotNull("Verify that we have an object...", sample1);
		assertTrue("Verify that it is an instance of GlucometerReadingLog...",
				sample1 instanceof GlucometerReadingLog);
		assertEquals("Verify that we have no entries...", 0, sample1
				.getEntries().size());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#setLocalStorageMechanism(net.notsosoft.labs.diabetes.log.LogStorageMechanism)}
	 * .
	 */
	@Test
	public void testSetLocalStorageMechanism() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog();
		sample1.setLocalStorageMechanism(LogStorageMechanism.STORAGE_SQLITE_ANDROID);
		assertEquals("Verify we get back STORAGE_SQLITE_ANDROID...",
				LogStorageMechanism.STORAGE_SQLITE_ANDROID,
				sample1.getLocalStorageMechanism());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#setEntries(java.util.ArrayList)}
	 * .
	 */
	@Test
	public void testSetEntries() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog();
		assertEquals("Verify we first have no entries...", 0, sample1
				.getEntries().size());
		sample1.setEntries(m_three_fixtures);
		assertEquals("Verify we now have three entries...", 3, sample1
				.getEntries().size());
		assertTrue("Verify that the first entry has a mValue of 100.0...",
				100.0 == ((GlucometerReading) sample1.getEntries().get(0))
						.getValue());
		assertEquals("Verify that the last entry has a mUnit of MMOL_PER_L",
				GlucoseUnitOfMeasure.MMOL_PER_L, ((GlucometerReading) sample1
						.getEntries().get(2)).getUnit());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#countEntries()}
	 * .
	 */
	@Test
	public void testCountEntries() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog(
				m_three_fixtures);
		assertEquals("Verify we count three entries...", 3, sample1.countEntries());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#addEntry(java.lang.Object)}
	 * .
	 */
	@Test
	public void testAddEntry() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog();
		assertEquals("Verify we first have no entries...", 0, sample1
				.getEntries().size());

		// Grab an entry from fixtures...
		GlucometerReading single = m_three_fixtures.get(0);
		
		sample1.addEntry(single);
		assertEquals("Verify we now have one entry...", 1, sample1.getEntries().size());
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.log.GlucometerReadingLog#removeEntry(java.lang.Object)}
	 * .
	 */
	@Test
	public void testRemoveEntry() {
		GlucometerReadingLog sample1 = new GlucometerReadingLog(
				m_three_fixtures);
		assertEquals("Verify we have three entries...", 3, sample1.getEntries().size());

		// Grab an entry from fixtures...
		GlucometerReading single = m_three_fixtures.get(0);

		sample1.removeEntry(single);
		
		assertEquals("Verify we now have two entries...", 2, sample1.getEntries().size());
	}

}
