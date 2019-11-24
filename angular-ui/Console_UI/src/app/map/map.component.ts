import { Component, OnInit } from '@angular/core';
import * as mapboxgl from 'mapbox-gl';
import * as MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';
import * as forwardGeocoder from '@mapbox/mapbox-gl-geocoder';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  ngOnInit() {
    Object.getOwnPropertyDescriptor(mapboxgl, "accessToken")
    .set('pk.eyJ1Ijoic2F1cmFiaGJhZ2FkZSIsImEiOiJjazJ3eWcyajAwa3F4M3FvOXNkcXZsd2ljIn0.YeODOTRRyp6SDwFNMH-Xvg');
    var coordinates = document.getElementById('coordinates');
    let map = new mapboxgl.Map({
      container: 'map', // container id
      style: 'mapbox://styles/mapbox/streets-v11', // stylesheet location
      center: [77.3507367,12.954517], // starting position [lng, lat]
      zoom: 13 // starting zoom
  })
  
  // Bangalore center location = 12.954517,77.3507367 (from Google Maps)
  /*
    BBox Bound
    12.420498, 77.464691 South-west
    13.225842, 77.736004 North-east
  */

  var geoMarker = new mapboxgl.Marker({
      draggable: true,
    }).setLngLat([77.35,12.95])
    .addTo(map);


  var geocoder = new MapboxGeocoder({
    accessToken: mapboxgl.accessToken,
    // marker: {
    //   draggable: true,
    //   color: 'orange'
    // },
    marker: false,
    countries: 'in',
    bbox: [77.464691, 12.420498, 77.736004, 13.225842],
    filter: function (item) {
    // returns true if item contains Bangalore asa place
    return item.context.map(function (i) {
    // id is in the form {index}.{id} per https://github.com/mapbox/carmen/blob/master/carmen-geojson.md
    // this example attempts to find the `place` named 'Bangalore'
    return (i.id.split('.').shift() === 'place' && i.text === 'Bangalore');
    }).reduce(function (acc, cur) {
    return acc || cur;
    });
    },
    mapboxgl: mapboxgl
  });


  map.addControl(geocoder);

  function onDragEnd() {
    var lngLat = geoMarker.getLngLat();
    coordinates.style.display = 'block';
    coordinates.innerHTML = 'Longitude: ' + lngLat.lng + '<br />Latitude: ' + lngLat.lat;
    console.log('Longitude: ' + lngLat.lng + '<br />Latitude: ' + lngLat.lat);
  }

  geoMarker.on('dragend', onDragEnd);

  // geocoder.on('results', onDragEnd);

  // console.log(geocoder.accessToken);

  geocoder.on('results', function(results) {
      console.log(results.features[0].center);
      // console.log(results.features[0]);

      // var longitude = results.features[0].center[0] - 0.001;
      // var latitude = results.features[0].center[1]  - 0.001;

      geoMarker.setLngLat(results.features[0].center);
  });

  var geoLocate = new mapboxgl.GeolocateControl({
    positionOptions: {
    enableHighAccuracy: true
    },
    trackUserLocation: true
  });

  map.addControl(geoLocate);

  geoLocate.on('geolocate', function(Position) {
      console.log('User Longitude: ' + Position.coords.longitude + 
                  'User Latitude: ' + Position.coords.latitude);

      var geoMarker = new mapboxgl.Marker({
        draggable: true,
        color: "orange"
      }).setLngLat([Position.coords.longitude,Position.coords.latitude])
      .addTo(map);

  });


  }
}
