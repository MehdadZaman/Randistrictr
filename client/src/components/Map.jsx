import React, { useState, useMemo } from 'react';
import { Sidebar, Tab } from 'react-leaflet-sidebarv2';
import { MapContainer, TileLayer, ZoomControl } from 'react-leaflet';
import Position from './Position';
import { center, zoom, bounds } from '../constants/map';
import StateSelect from './StatesSelect';

const Map = () => {
  const [map, setMap] = useState(null);

  const displayMap = useMemo(
    () => (
      <MapContainer
        className='sidebar-map'
        style={{ height: '100vh', zIndex: 0 }}
        center={center}
        zoom={zoom}
        scrollWheelZoom={false}
        whenCreated={setMap}
        boundsOptions={bounds}
        maxBounds={bounds}
        minZoom={5}
        zoomControl={false}
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
      <aside></aside>
      <div></div>
      {map ? <StateSelect map={map} /> : null}
      {map ? <Position map={map} /> : null}
      <Sidebar id='sidebar'>
        <Tab>s</Tab>
      </Sidebar>
      {displayMap}
    </div>
  );
};

export default Map;
