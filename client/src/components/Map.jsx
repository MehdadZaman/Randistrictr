import React, { useState, useMemo } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import Position from './Position';

const center = [40.914224, -73.11623];
const zoom = 15;

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
      >
        <TileLayer
          attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
          url='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
        />
      </MapContainer>
    ),
    []
  );

  return (
    <div>
      {map ? <Position map={map} /> : null}
      {displayMap}
    </div>
  );
};

export default Map;
