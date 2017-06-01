import static org.junit.Assert.*;

import org.junit.Test;

public class TestNavigator {
	/**
	 * Tests if whether a new Navigator object
	 * has default coordinates for Origin 
	 */
	@Test
	public void testNavigator1() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getOriginLatitude(), 0);
			assertEquals(0, n.getOriginLongitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests if whether a new Navigator object
	 * has default coordinates for Destination 
	 */
	@Test
	public void testNavigator2() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getDestinationLongitude(), 0);
			assertEquals(0, n.getDestinationLatitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	@Test
	public void testGetOrigin1(){
		try{
			Navigator n = new Navigator();
			CoordinatePoint p = n.getOrigin();
			assertEquals(0, p.getLongitude(), 0);
			assertEquals(0, p.getLatitude(), 0);	
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	@Test
	public void testGetDestination1(){
		try{
			Navigator n = new Navigator();
			CoordinatePoint p = n.getDestination();
			assertEquals(0, p.getLongitude(), 0);
			assertEquals(0, p.getLatitude(), 0);	
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests whether we can set the maximum positive longitude and latitude values for Origin
	 */
	@Test
	public void testSetOrigin1(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,90);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origins to max postive bounds resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the maximum negative longitude and latitude values for Origin
	 */
	@Test
	public void testSetOrigin2(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(-180,-90);
			assertEquals(-180, n.getOriginLongitude(), 0);
			assertEquals(-90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origins to max negative bounds resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown when the
	 * Origins longitude value is set just out of bounds, with latitude value at the bound.
	 */
	@Test
	public void testSetOrigin3(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(180.1,90);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown when the
	 * Origins longitude value is set just out of bounds, with latitude value at the bound.
	 */
	@Test
	public void testSetOrigin4(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(-180.1,90);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown when the
	 * Origins latitude value is set just out of bounds, with longitude value at the bound.
	 */
	@Test
	public void testSetOrigin5(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown when the
	 * Origins latitude value is set just out of bounds, with longitude value at the bound.
	 */
	@Test
	public void testSetOrigin6(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,-90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}
	/**
	 * Tests whether we can set the Origin values of longitude and latitude
	 * using CoordinatePoint object that is in longitude and latitude bounds.
	 */
	@Test
	public void testSetOrigin7(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests whether we can set the Origin values of longitude and latitude
	 * using CoordinatePoint object that is in longitude and latitude bounds.
	 */
	@Test
	public void testSetOrigin8(){
		try{
			CoordinatePoint p = new CoordinatePoint(-180,-90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(-180, n.getOriginLongitude(), 0);
			assertEquals(-90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests whether we get a LongitudeOutOfBoundsException when we give setOrigin() a 
	 * CoordinatePoint object, where longitude is set just out of bounds, with latitude at the bound. 
	 */
	@Test
	public void testSetOrigin9(){
		try{
			CoordinatePoint p = new CoordinatePoint(180.1,90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LongitudeOutOfBoundsException when we give setOrigin() a 
	 * CoordinatePoint object, where longitude is set just out of bounds, with latitude at the bound. 
	 */
	@Test
	public void testSetOrigin10(){
		try{
			CoordinatePoint p = new CoordinatePoint(-180.1,90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LatitudeOutOfBoundsException when we give setOrigin() a 
	 * CoordinatePoint object, where latitude is set just out of bounds, with longitude at the bound. 
	 */
	@Test
	public void testSetOrigin11(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,90.1);
			Navigator n = new Navigator();
			n.setOrigin(p);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LatitudeOutOfBoundsException when we give setOrigin() a 
	 * CoordinatePoint object, where latitude is set just out of bounds, with longitude at the bound. 
	 */
	@Test
	public void testSetOrigin12(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,-90.1);
			Navigator n = new Navigator();
			n.setOrigin(p);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}		
	/**
	 * Tests whether we can set the maximum positive longitude and latitude values for Destination
	 */
	@Test
	public void testSetDestination1(){
		try{
			Navigator n = new Navigator();
			n.setDestination(180,90);
			assertEquals(180, n.getDestinationLongitude(), 0);
			assertEquals(90, n.getDestinationLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origins to max postive bounds resulted in a CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the maximum negative longitude and latitude values for Destination
	 */
	@Test
	public void testSetDestination2(){
		try{
			Navigator n = new Navigator();
			n.setDestination(-180,-90);
			assertEquals(-180, n.getDestinationLongitude(), 0);
			assertEquals(-90, n.getDestinationLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origins to max negative bounds resulted in a CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown when the Destinations 
	 * longitude value is set just out of bounds, with latitude value at the bound.
	 */
	@Test
	public void testSetDestination3(){
		try{
			Navigator n = new Navigator();
			n.setDestination(180.1,90);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown when the Destinations 
	 * longitude value is set just out of bounds, with latitude value at the bound.
	 */
	@Test
	public void testSetDestination4(){
		try{
			Navigator n = new Navigator();
			n.setDestination(-180.1,90);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown when the Destinations 
	 * latitude value is set just out of bounds, with longitude value at the bound.
	 */
	@Test
	public void testSetDestination5(){
		try{
			Navigator n = new Navigator();
			n.setDestination(180,90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown when the Destinations 
	 * latitude value is set just out of bounds, with longitude value at the bound.
	 */
	@Test
	public void testSetDestination6(){
		try{
			Navigator n = new Navigator();
			n.setDestination(180,-90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}
	/**
	 * Tests whether we can set the Destination values of longitude and latitude
	 * using CoordinatePoint object that is in longitude and latitude bounds.
	 */
	@Test
	public void testSetDestination7(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests whether we can set the Destination values of longitude and latitude
	 * using CoordinatePoint object that is in longitude and latitude bounds.
	 */
	@Test
	public void testSetDestination8(){
		try{
			CoordinatePoint p = new CoordinatePoint(-180,-90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(-180, n.getOriginLongitude(), 0);
			assertEquals(-90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by Navigator constructor");}
	}
	/**
	 * Tests whether we get a LongitudeOutOfBoundsException when we give setDestination() a 
	 * CoordinatePoint object, where longitude is set just out of bounds, with latitude at the bound. 
	 */
	@Test
	public void testSetDestination9(){
		try{
			CoordinatePoint p = new CoordinatePoint(180.1,90);
			Navigator n = new Navigator();
			n.setDestination(p);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LongitudeOutOfBoundsException when we give setDestination() a 
	 * CoordinatePoint object, where longitude is set just out of bounds, with latitude at the bound. 
	 */
	@Test
	public void testSetDestination10(){
		try{
			CoordinatePoint p = new CoordinatePoint(-180.1,90);
			Navigator n = new Navigator();
			n.setDestination(p);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LatitudeOutOfBoundsException when we give setDestination() a 
	 * CoordinatePoint object, where latitude is set just out of bounds, with longitude at the bound. 
	 */
	@Test
	public void testSetDestination11(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,90.1);
			Navigator n = new Navigator();
			n.setDestination(p);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether we get a LatitudeOutOfBoundsException when we give setDestination() a 
	 * CoordinatePoint object, where latitude is set just out of bounds, with longitude at the bound. 
	 */
	@Test
	public void testSetDestination12(){
		try{
			CoordinatePoint p = new CoordinatePoint(180,-90.1);
			Navigator n = new Navigator();
			n.setDestination(p);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}	
	/**
	 * Tests whether we can set the maximum positive longitude for Origin
	 */
	@Test
	public void testSetOriginLongitude1(){
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(180);
			assertEquals(180, n.getOriginLongitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origins to max postive longitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the maximum negative longitude for Origin
	 */
	@Test
	public void testSetOriginLongitude2(){
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(-180);
			assertEquals(-180, n.getOriginLongitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origin to max negative longitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the origins longitude is set just out of bounds.
	 */
	@Test
	public void testSetOriginLongitude3(){
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(180.1);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the origins longitude is set just out of bounds.
	 */
	@Test
	public void testSetOriginLongitude4(){
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(-180.1);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether we can set the Origin to maximum positive latitude
	 */
	@Test
	public void testSetOriginLatitude1(){
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(90);
			assertEquals(90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origin to max postive latitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the Origin to maximum negative latitude
	 */
	@Test
	public void testSetOriginLatitude2(){
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(-90);
			assertEquals(-90, n.getOriginLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origin to max negative latitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the origins latitude is set just out of bounds.
	 */
	@Test
	public void testSetOriginLatitude3(){
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the origins latitude is set just out of bounds.
	 */
	@Test
	public void testSetOriginLatitude4(){
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(-90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}
	/**
	 * Tests whether we can set the Destination to maximum positive longitude
	 */
	@Test
	public void testSetDestinationLongitude1(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(180);
			assertEquals(180, n.getDestinationLongitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origin to max positive longitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the Destination to maximum negative longitude
	 */
	@Test
	public void testSetDestinationLongitiude2(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(-180);
			assertEquals(-180, n.getDestinationLongitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting origin to max negative longitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the destinations longitude is set just out of bounds.
	 */
	@Test
	public void testSetDestinationLongitude3(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(180.1);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());}
	}
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the destinations longitude is set just out of bounds.
	 */
	@Test
	public void testSetDestinationLongitude4(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(-180.1);
			fail("Should throw LongitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());}
	}
	/**
	 * Tests whether we can set the Destination to maximum positive latitude
	 */
	@Test
	public void testSetDestinationLatitude1(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(90);
			assertEquals(90, n.getDestinationLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting destination to max postive latitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether we can set the Destination to maximum negative latitude
	 */
	@Test
	public void testSetDestinationLatitude2(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(-90);
			assertEquals(-90, n.getDestinationLatitude(), 0);
		} catch(CoordinateOutOfBoundsException e) {
			fail("Setting destination to max negative latitude resulted in CoordinateOutOfBoundsException");}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the destinations latitude is set just out of bounds.
	 */
	@Test
	public void testSetDestinationLatitude3(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());}
	}
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the destinations latitude is set just out of bounds.
	 */
	@Test
	public void testSetDestinationLatitude4(){
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(-90.1);
			fail("Should throw LatitudeOutOfBoundsException");
		} catch(CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm1() {
		try{
			Navigator n1 = new Navigator();
			n1.setOriginLongitude(-180);
		    n1.setOriginLatitude(-90);
		    n1.setDestinationLongitude(180);
		    n1.setDestinationLatitude(90);
		    Navigator n2 = new Navigator();
		    n2.setOriginLongitude(180);
		    n2.setOriginLatitude(90);
		    n2.setDestinationLongitude(-180);
		    n2.setDestinationLatitude(-90);
		    assertEquals(20015.086796020572,n1.distanceInKm(),0);
		    assertEquals(20015.086796020572,n2.distanceInKm(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm2() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.sin(diffla2) * Math.sin(diffla2)
						+ Math.cos(la1)*Math.cos(la2) 
						* Math.sin(difflo2) * Math.sin(difflo2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm3() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.cos(diffla2) * Math.cos(diffla2)
						+ Math.sin(la1)*Math.sin(la2) 
						* Math.cos(difflo2) * Math.cos(difflo2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm4() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.sin(diffla2) * Math.sin(diffla2)
						+ Math.sin(la1)*Math.sin(la2) 
						* Math.sin(difflo2) * Math.sin(difflo2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm5() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.cos(diffla2) * Math.cos(diffla2)
						+ Math.cos(la1)*Math.cos(la2) 
						* Math.cos(difflo2) * Math.cos(difflo2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm6() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.cos(difflo2) * Math.cos(difflo2)
						+ Math.cos(la1)*Math.cos(la2) 
						* Math.cos(diffla2) * Math.cos(diffla2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm7() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(180,90);
			Navigator n2 = new Navigator();
			n2.setDestination(-180,-90);
			double lo1 = Math.PI*n1.getOriginLongitude()/180;
			double lo2 = Math.PI*n2.getDestinationLongitude()/180;
			double la1 = Math.PI*n1.getOriginLatitude()/180;
			double la2 = Math.PI*n2.getDestinationLatitude()/180;
			double difflo2 = (lo2-lo1)/2;
			double diffla2 = (la2-la1)/2;
			double x = 2*6371 * Math.asin(
					Math.sqrt(
						Math.cos(diffla2) * Math.cos(diffla2)
						- Math.cos(la1)*Math.cos(la2) 
						* Math.cos(difflo2) * Math.cos(difflo2)
							)
					);
			System.out.println(x);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm8() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(-180,-90);
		    n1.setDestination(180,90);
		    Navigator n2 = new Navigator();
		    n2.setOrigin(180,90);
		    n2.setDestination(-180,-90);
		    assertEquals(20015.086796020572,n1.distanceInKm(),0);
		    assertEquals(20015.086796020572,n2.distanceInKm(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(km) for a pair of Origin & Destination Coordinates is 20015.086796020572 km.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInKm9() {
		try{
			CoordinatePoint p1Origin = new CoordinatePoint(-180,-90);
			CoordinatePoint p1Destination = new CoordinatePoint(180,90);
			Navigator n1 = new Navigator();
			n1.setOrigin(p1Origin);
		    n1.setDestination(p1Destination);
		    CoordinatePoint p2Origin = new CoordinatePoint(180,90);
			CoordinatePoint p2Destination = new CoordinatePoint(-180,-90);
			Navigator n2 = new Navigator();
			n2.setOrigin(p2Origin);
		    n2.setDestination(p2Destination);
		    assertEquals(20015.086796020572,n1.distanceInKm(),0);
		    assertEquals(20015.086796020572,n2.distanceInKm(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test using the Haversine formula where the minimum distance between Origin and 
	 * Destination(km) is 0.0 km. Both Origin and Destination Coordinates are the same.
	 */
	@Test
	public void testDistanceInKm10() {
		try{
			Navigator n = new Navigator(); //creating a navigator object sets origin and destination points to 0, so are the same.
		    assertEquals(0,n.distanceInKm(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInkm() method");}
	}
	/**
	 * A Test where the maximum distance(NM) for a pair of Origin & Destination Coordinates is 10807.282287268126 nautical miles.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInNM1() {
		try{
			Navigator n1 = new Navigator();
			n1.setOriginLongitude(-180);
		    n1.setOriginLatitude(-90);
		    n1.setDestinationLongitude(180);
		    n1.setDestinationLatitude(90);
		    Navigator n2 = new Navigator();
		    n2.setOriginLongitude(180);
		    n2.setOriginLatitude(90);
		    n2.setDestinationLongitude(-180);
		    n2.setDestinationLatitude(-90);
		    assertEquals(10807.282287268126,n1.distanceInNM(),0);
		    assertEquals(10807.282287268126,n2.distanceInNM(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInNM() method");}
	}
	/**
	 * A Test where the maximum distance(NM) for a pair of Origin & Destination Coordinates is 10807.282287268126 nautical miles.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInNM2() {
		try{
			Navigator n1 = new Navigator();
			n1.setOrigin(-180,-90);
		    n1.setDestination(180,90);
		    Navigator n2 = new Navigator();
		    n2.setOrigin(180,90);
		    n2.setDestination(-180,-90);
		    assertEquals(10807.282287268126,n1.distanceInNM(),0);
		    assertEquals(10807.282287268126,n2.distanceInNM(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInNM() method");}
	}
	/**
	 * A Test where the maximum distance(NM) for a pair of Origin & Destination Coordinates is 10807.282287268126 nautical miles.
	 * One Coordinate pair must be at maximum positive bounds and the other Coordinate pair must be at maximum negative bounds.
	 */
	@Test
	public void testDistanceInNM3() {
		try{
			CoordinatePoint p1Origin = new CoordinatePoint(-180,-90);
			CoordinatePoint p1Destination = new CoordinatePoint(180,90);
			Navigator n1 = new Navigator();
			n1.setOrigin(p1Origin);
		    n1.setDestination(p1Destination);
		    CoordinatePoint p2Origin = new CoordinatePoint(180,90);
			CoordinatePoint p2Destination = new CoordinatePoint(-180,-90);
			Navigator n2 = new Navigator();
			n2.setOrigin(p2Origin);
		    n2.setDestination(p2Destination);
		    assertEquals(10807.282287268126,n1.distanceInNM(),0);
		    assertEquals(10807.282287268126,n2.distanceInNM(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInNM() method");}
	}
	/**
	 * A Test using the Haversine formula where the minimum distance between Origin and 
	 * Destination(NM) is 0.0 nautical miles. Both Origin and Destination Coordinates must be the same
	 */
	@Test
	public void testDistanceInNM4() {
		try{
			Navigator n = new Navigator(); //creating a navigator object sets origin and destination points to 0, so are the same.
		    assertEquals(0,n.distanceInKm(),0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown. Coordinates must be in bound before can invoke DistanceInNM() method");}
	}
}