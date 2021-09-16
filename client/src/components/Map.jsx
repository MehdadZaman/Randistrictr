import React, { useState, useMemo } from 'react';
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
import Sidebar from './Sidebar';
import MaryLandGEOJSON from '../constants/cb_2020_24_bg_500k.json';
import sample from '../constants/sample.json';

const Map = () => {
  const [map, setMap] = useState(null);

  const displayMap = useMemo(
    () => (
      <MapContainer
        className='sidebar-map'
        style={{ height: '95vh', zIndex: 0, minHeight: 390, minWidth: 768 }}
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
        <GeoJSON data={MaryLandGEOJSON} />
        <ZoomControl position='bottomright' />
      </MapContainer>
    ),
    []
  );

  return (
    <div>
      {map ? <Sidebar map={map} /> : null}

      <div></div>

      {map ? <Position map={map} /> : null}
      {/* <Sidebar id='sidebar'>
        <Tab>s</Tab>
      </Sidebar> */}

      {displayMap}
    </div>
  );
};

export default Map;
