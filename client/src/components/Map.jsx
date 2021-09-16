import React, { useState, useMemo, useCallback } from 'react';
import {
  MapContainer,
  TileLayer,
  ZoomControl,
  Popup,
  useMap,
} from 'react-leaflet';
import states from '../constants/states';
import Position from './Position';
import StatesSelect from './StatesSelect';

const center = [41.650833, -94.059747];
const zoom = 5;
const bounds = [
  [36.935487, -114.183315],
  [48.128666, -74.063806],
];

const SetStateBounds = ({ map }) => {
  const handleStateSelect = useCallback(
    (stateName) => {
      try {
        const state = states.find((state) => state.name === stateName);
        console.log('stateName', stateName);
        console.log('state', state);
        map.fitBounds(state.bounds);
      } catch {
        console.log('invalid state!');
      }
    },
    [map]
  );

  return <StatesSelect onChange={handleStateSelect} />;
};

const Map = () => {
  const [map, setMap] = useState(null);

  const displayMap = useMemo(
    () => (
      <MapContainer
        style={{ height: '100vh', zIndex: 0 }}
        center={center}
        zoom={zoom}
        scrollWheelZoom={false}
        whenCreated={setMap}
        boundsOptions={bounds}
        maxBounds={bounds}
        minZoom={5}
        zoom
      >
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
        />
        <ZoomControl position='bottomright' />
      </MapContainer>
    ),
    []
  );

  return (
    <div>
      {map ? <SetStateBounds map={map} /> : null}
      {map ? <Position map={map} /> : null}
      {displayMap}
    </div>
  );
};

export default Map;
