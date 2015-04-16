package com.example.locationdetector;



import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView cityText;
	private double LAT,LON;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getLocation();
		
		
		cityText = (TextView) findViewById(R.id.cityText);
		cityText.setText("CITY"+ " " + "LAT " + LAT + " LON-" + LON);
	}

	
	

	public void getLocation() {
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		
		
		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {
				// Called when a new location is found by the network location
				// provider.
				// makeUseOfNewLocation(location,locationManager,locationListener);
				LAT = location.getLatitude();
				LON = location.getLongitude();

			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};

		// Register the listener with the Location Manager to receive location
		// updates
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

		String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or, use GPS location data:
		// String locationProvider = LocationManager.GPS_PROVIDER;

		locationManager.requestLocationUpdates(locationProvider, 0, 0,
				locationListener);

		// String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or use LocationManager.GPS_PROVIDER

		locationManager
				.getLastKnownLocation(locationProvider);

	}

	
	
}
