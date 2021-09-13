import ReactMapboxGl, { Layer, Feature, MapContext } from 'react-mapbox-gl';
import React, {useState} from 'react'
import 'mapbox-gl/dist/mapbox-gl.css';

function App() {
  const [lng, setLng] = useState(-73.11623)
  const [lat, setLat] = useState(40.914224)

  const Map = ReactMapboxGl({
    accessToken:
      'pk.eyJ1IjoibGF3bGluIiwiYSI6ImNrdGZteHg0ZjA5cHIycHVlcXl6NXpwY2UifQ.twjM6PlmixzZFNcc7_XBsQ',
  });

  const sideBar = { 
    backgroundColor: 'rgba(35, 55, 75, 0.9)',
    color: '#fff',
    padding: '6px 12px',
    fontFamily: 'monospace',
    zIndex: 1,
    position: 'absolute',
    top: 0,
    left: 0,
    margin: '12px',
    borderRadius: '4px'
  }

  return (
    <div className='App'>
      <div style={sideBar}>
        Longitude: {lng} | Latitude: {lat}
      </div>
      <Map
        style='mapbox://styles/mapbox/streets-v11'
        containerStyle={{
          height: '100vh',
          width: '100vw',
        }}
        center={[lng, lat]} // SBU coordinates

        onMoveEnd={(event) => {
          if(!event.isStyleLoaded) return //wait for map to initialize
          console.log('yo something changed')
          setLng(event.getCenter().lng.toFixed(4))
          setLat(event.getCenter().lat.toFixed(4))
        }}
      >
        <Layer type='symbol' id='marker' layout={{ 'icon-image': 'marker-15' }}>
          <Feature coordinates={[-75.11623, 40.914224]} />
        </Layer>
      </Map>
    </div>
  );
}

export default App;
