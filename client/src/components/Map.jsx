import React, { useState, useMemo } from 'react';
import { Sidebar, Tab } from 'react-leaflet-sidebarv2';
import { geoJSON } from 'leaflet';
import {
  MapContainer,
  TileLayer,
  ZoomControl,
  Popup,
  useMap,
  GeoJSON,
} from 'react-leaflet';
import Position from './Position';
import { center, zoom, bounds } from '../constants/map';
import StateSelect from './StatesSelect';

import MaryLandGEOJSON from '../constants/cb_2020_24_bg_500k.json';
import sample from '../constants/sample.json';

const GEOJSONLayer = ({ map }) => {
  geoJSON(MaryLandGEOJSON).addTo(map);
  return <div></div>;
};

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
      {map ? <GEOJSONLayer map={map} /> : null}
      {displayMap}
    </div>
  );
};

export default Map;
