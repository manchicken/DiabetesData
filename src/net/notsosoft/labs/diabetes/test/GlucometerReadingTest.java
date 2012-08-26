/**
 * 
 */
package net.notsosoft.labs.diabetes.test;

import static org.junit.Assert.*;

import java.util.Date;

import net.notsosoft.labs.diabetes.entity.GlucometerReading;
import net.notsosoft.labs.diabetes.entity.GlucometerReading.GlucoseUnitOfMeasure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael D. Stemle, Jr. (manchicken -AT- notsosoft.net)
 * 
 */
public class GlucometerReadingTest {
	protected GlucometerReading subject = null;
	protected Date testTime = new Date();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.subject = new GlucometerReading(89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, testTime);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.subject = null;
		this.testTime = null;
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#GlucometerReading(double, net.notsosoft.labs.diabetes.entity.GlucometerReading.GlucoseUnitOfMeasure, java.util.Date)}
	 * .
	 */
	@Test
	public void testGlucometerReadingDoubleGlucoseUnitOfMeasureDate() {
		GlucometerReading dummy = new GlucometerReading(89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, new Date());

		assertTrue("Verify that the instance came out properly...",
				(dummy instanceof GlucometerReading));
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#GlucometerReading()}
	 * .
	 */
	@Test
	public void testGlucometerReading() {
		GlucometerReading dummy = new GlucometerReading();

		assertTrue("Verify that the instance came out properly...",
				(dummy instanceof GlucometerReading));
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#setValue(double)}
	 * .
	 */
	@Test
	public void testSetValue() {
		double oldValue = this.subject.getValue();

		this.subject.setValue(oldValue + 4);
		assertEquals("Verify that we set the mValue properly...", oldValue + 4,
				this.subject.getValue(), 0.0);

		this.subject.setValue(oldValue);
		assertEquals("Verify that we set the mValue properly...", oldValue,
				this.subject.getValue(), 0.0);
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertEquals("Verify that we get the mValue properly...", 89.0,
				this.subject.getValue(), 0.0);
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#setUnit(net.notsosoft.labs.diabetes.entity.GlucometerReading.GlucoseUnitOfMeasure)}
	 * .
	 */
	@Test
	public void testSetUnit() {
		this.subject.setUnit(GlucoseUnitOfMeasure.MMOL_PER_L);
		assertTrue("Verify we set it to mmol/L...",
				(this.subject.getUnit() == GlucoseUnitOfMeasure.MMOL_PER_L));
		this.subject.setUnit(GlucoseUnitOfMeasure.MG_PER_DL);
		assertTrue("Verify we set it to mg/dL...",
				(this.subject.getUnit() == GlucoseUnitOfMeasure.MG_PER_DL));
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#getUnit()}.
	 */
	@Test
	public void testGetUnit() {
		assertTrue("Verify we get mg/dL...",
				(this.subject.getUnit() == GlucoseUnitOfMeasure.MG_PER_DL));
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#setTimestamp(java.util.Date)}
	 * .
	 */
	@Test
	public void testSetTimestamp() {
		this.subject.setTimestamp(new Date(this.testTime.getTime() + 100));
		assertTrue("Verify the times are different...",
				(this.subject.getTimestamp() != this.testTime));
		this.subject.setTimestamp(this.testTime);
		assertTrue("Verify the times are not different...",
				(this.subject.getTimestamp() == this.testTime));
	}

	/**
	 * Test method for
	 * {@link net.notsosoft.labs.diabetes.entity.GlucometerReading#getTimestamp()}
	 * .
	 */
	@Test
	public void testGetTimestamp() {
		assertTrue("Verify the times are not different...",
				(this.subject.getTimestamp() == this.testTime));
	}

	@Test
	public void testEquals() {
		Date sameDate = new Date();
		Date differentDate = new Date(sameDate.getTime() + 5000);

		GlucometerReading sample1 = new GlucometerReading(89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading sameAs_sample1 = new GlucometerReading(89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading differentFrom_sample1 = new GlucometerReading(100.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		assertTrue("Verify that 1 == 1", sample1.equals(sameAs_sample1));
		assertFalse("Verify that 1 != !1",
				sample1.equals(differentFrom_sample1));

		// Now with IDs
		GlucometerReading sample2 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading sameAs_sample2 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading differentFrom_sample2 = new GlucometerReading(2,
				89.0, GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		assertTrue("Verify that 1 == 1", sample2.equals(sameAs_sample2));
		assertFalse("Verify that 1 != !1",
				sample2.equals(differentFrom_sample2));

		// Now with dates
		GlucometerReading sample3 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading sameAs_sample3 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading differentFrom_sample3 = new GlucometerReading(1,
				89.0, GlucoseUnitOfMeasure.MG_PER_DL, differentDate);
		assertTrue("Verify that 1 == 1", sample3.equals(sameAs_sample3));
		assertFalse("Verify that 1 != !1",
				sample3.equals(differentFrom_sample3));

		// Now with units
		GlucometerReading sample4 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading sameAs_sample4 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate);
		GlucometerReading differentFrom_sample4 = new GlucometerReading(1,
				89.0, GlucoseUnitOfMeasure.MMOL_PER_L, sameDate);
		assertTrue("Verify that 1 == 1", sample4.equals(sameAs_sample4));
		assertFalse("Verify that 1 != !1",
				sample4.equals(differentFrom_sample4));
		
		// Now with Event Labels
		GlucometerReading sample5 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate, "Same");
		GlucometerReading sameAs_sample5 = new GlucometerReading(1, 89.0,
				GlucoseUnitOfMeasure.MG_PER_DL, sameDate, "Same");
		GlucometerReading differentFrom_sample5 = new GlucometerReading(1,
				89.0, GlucoseUnitOfMeasure.MG_PER_DL, sameDate, "Different!");
		assertTrue("Verify that 1 == 1", sample5.equals(sample5));
		assertTrue("Verify that 1 == 1", sample5.equals(sameAs_sample5));
		assertFalse("Verify that 1 != !1",
				sample5.equals(differentFrom_sample5));
	}
}
