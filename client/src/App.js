import ReactMapboxGl, { Layer, Feature } from 'react-mapbox-gl';
import 'mapbox-gl/dist/mapbox-gl.css';

function App() {
  const Map = ReactMapboxGl({
    accessToken:
      'pk.eyJ1IjoibGF3bGluIiwiYSI6ImNrdGZteHg0ZjA5cHIycHVlcXl6NXpwY2UifQ.twjM6PlmixzZFNcc7_XBsQ',
  });

  return (
    <div className='App'>
      <Map
        style='mapbox://styles/mapbox/streets-v11'
        containerStyle={{
          height: '100vh',
          width: '100vw',
        }}
        center={[-73.11623, 40.914224]} // SBU coordinates
      >
        <Layer type='symbol' id='marker' layout={{ 'icon-image': 'marker-15' }}>
          <Feature coordinates={[40.914224, -73.11623]} />
        </Layer>
      </Map>
      ;
    </div>
  );
}

export default App;
